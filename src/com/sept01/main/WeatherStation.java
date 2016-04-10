/*
 * Weather station class
 * This class hold all weather data for a weather station
 * Also this object will scrap the json data for the object
 */
package com.sept01.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.json.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import com.jaunt.Element;
//import com.jaunt.Elements;
//import com.jaunt.NotFound;
//import com.jaunt.ResponseException;
//import com.jaunt.UserAgent;

import sun.misc.IOUtils;

public class WeatherStation {

	public String getName() {
		return name;
	}

	public String getStateName() {
		return stateName;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
	String stateName;
	String url;
	String jsonUrl = null;
	JSONObject json;
	JSONArray data;
	HashMap[] dataMap;

	public WeatherStation(String url, String name) {
		this.url = url;
		this.name = name;

	}

	public void loadData() {
		Document doc = null;
		if (jsonUrl == null) {

			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Elements elements = doc.select("a[href]");
			for (Element e : elements) {
				if (e.attr("abs:href").contains("json")) {
					jsonUrl = e.attr("abs:href").toString();
					break;

				}
			}

		}
		String jsonString = null;
		try {
			jsonString = Jsoup.connect(jsonUrl).ignoreContentType(true).execute().body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		json = new JSONObject(jsonString);
		json = json.getJSONObject("observations");

		data = json.getJSONArray("data");
		JSONObject temp = (JSONObject) json.getJSONArray("header").get(0);
		name = temp.getString("name");
		stateName = temp.getString("state");

	}

	public HashMap[] getData() {
		// Loads data from JSON URL
		loadData();
		// creates HASHMAP for storing data
		dataMap = new HashMap[data.length()];
		for (int i = 0; i < data.length(); i++) {
			HashMap<String, String> pairs = new HashMap<String, String>();
			JSONObject j = data.optJSONObject(i);
			Iterator it = j.keys();
			while (it.hasNext()) {
				String n = (String) it.next();

				if (j.get(n).getClass().getName() == "java.lang.Double") {
					pairs.put(n, Double.toString((double) j.get(n)));
				} else if (j.get(n).getClass().getName() == "java.lang.Integer") {
					pairs.put(n, Integer.toString((int) (j.get(n))));
				} else if (j.get(n).getClass().getName() == "org.json.JSONObject$Null") {
					pairs.put(n, "null");
				} else {
					pairs.put(n, (String) j.get(n));
				}
			}
			// Add hashmap pairs to array
			dataMap[i] = pairs;
		}
		// return array of hashmaps
		return dataMap;

	}
}
