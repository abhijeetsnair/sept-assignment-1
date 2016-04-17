/*
 * Weather station class
 * This class hold all weather data for a weather station
 * Also this object will scrap the json data for the object
 */
package com.sept01.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sept01.utility.ErrorLog;

/**
 * <p>
 * The Weather Station Class which holds data about the weather station and its
 * related information such as the weather.
 * </p>
 * <p>
 * In the heirarchy, it is in the lowest level, being that Area will have
 * multiple Weather Stations, and State will have multiple Areas.
 * </p>
 * 
 * @see Area
 * 
 * @version 1.0
 */
public class WeatherStation {

	String name;

	String stateName;

	public String url;

	String jsonUrl = null;
	String stateAbv;
	JSONObject json;
	JSONArray data;
	@SuppressWarnings("rawtypes")
	HashMap[] dataMap;

	private String timeZone;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss zzz");

	public WeatherStation(String url, String name) {
		this.url = url;
		this.name = name;

	}

	/**
	 * Obtains data from the JSON URL and stores it into a hashmap of data
	 * 
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public HashMap<String,String>[] getData() {
		// Loads data from JSON URL
		loadData();
		// creates HASHMAP for storing data
		dataMap = new HashMap[data.length()];
		for (int i = 0; i < data.length(); i++) {
			HashMap<String, String> pairs = new HashMap<String, String>();
			JSONObject j = data.optJSONObject(i);
			Iterator<String> it = j.keys();
			while (it.hasNext()) {
				String n = (String) it.next();
				if (n.compareTo("local_date_time_full") == 0) {
					String timeString = (String) j.get(n);
					timeString = new StringBuilder(timeString).insert(4, ":").toString();
					timeString = new StringBuilder(timeString).insert(7, ":").toString();
					timeString = new StringBuilder(timeString).insert(10, " ").toString();
					timeString = new StringBuilder(timeString).insert(13, ":").toString();
					timeString = new StringBuilder(timeString).insert(16, ":").toString();
					timeString = new StringBuilder(timeString).append(" A" + timeZone).toString();

					j.put(n, timeString);
				}
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
			// Add hash map pairs to array
			dataMap[i] = pairs;
		}
		// return array of hash maps

		return dataMap;

	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public String getName() {
		return name;
	}

	public String getStateAbv() {
		return stateAbv;
	}

	public String getStateName() {
		return stateName;
	}

	/**
	 * Load and pull data from the website, obtaining data from a JSON source
	 */
	public void loadData() {
		Document doc = null;
		if (jsonUrl == null) {

			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e1) {
				try {
					Thread.sleep(1000);
					doc = Jsoup.connect(url).get();
				} catch (InterruptedException | IOException e2) {
					ErrorLog.createErrorPopup(e2);
				}
				ErrorLog.createErrorPopup(e1);
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
			try {
				Thread.sleep(1000);
				jsonString = Jsoup.connect(jsonUrl).ignoreContentType(true).execute().body();
			} catch (IOException | InterruptedException e1) {
				ErrorLog.createErrorPopup(e1);
				e1.printStackTrace();
			}
		}
		json = new JSONObject(jsonString);
		json = json.getJSONObject("observations");
		data = json.getJSONArray("data");
		JSONObject temp = (JSONObject) json.getJSONArray("header").get(0);
		name = temp.getString("name");
		stateName = temp.getString("state");
		timeZone = temp.getString("time_zone");
		stateAbv = temp.getString("state_time_zone");
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void setName(String name) {
		this.name = name;
	}
}
