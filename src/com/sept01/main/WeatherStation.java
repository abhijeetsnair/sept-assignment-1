package com.sept01.main;

import java.util.HashMap;
import java.util.Iterator;

import org.json.*;
import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class WeatherStation {
	HashMap<String, String> pairs = new HashMap<String, String>();
	String name;
	String url;
	String jsonUrl = null;
	JSONObject json;
	JSONArray data;
	HashMap[] dataMap;
	public WeatherStation(String url) {
		this.url = url;
	}

	public void loadData() {
		UserAgent userAgent = new UserAgent();
		if (jsonUrl == null) {
			try {
				userAgent.visit(url);
				Elements elements = userAgent.doc.findEvery("<a href>");
				for (Element e : elements) {
					if (e.getAtString("href").contains("json")) {
						jsonUrl = e.getAtString("href");
						break;

					}
				}

			} catch (ResponseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			userAgent.sendGET(jsonUrl);
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			json = new JSONObject(userAgent.json.get("observations").toString());
		} catch (NotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = json.getJSONArray("data");
		JSONObject temp = (JSONObject) json.getJSONArray("header").get(0);
		name = temp.getString("name");

	}

	public HashMap[] getData() {
		//Loads data from JSON URL
		loadData();
		//creates HASHMAP for storing data
		dataMap = new HashMap[data.length()];
		for (int i = 0; i < data.length(); i++) {
			JSONObject j = data.optJSONObject(i);
			Iterator it = j.keys();
			while (it.hasNext()) {
				String n = (String) it.next();
				
				if (j.get(n).getClass().getName() == "java.lang.Double") {
					pairs.put(n, Double.toString((double) j.get(n)));
				}else if( j.get(n).getClass().getName() == "java.lang.Integer"){
					pairs.put(n, Integer.toString((int) ( j.get(n))));
				}else if( j.get(n).getClass().getName() == "org.json.JSONObject$Null"){
					pairs.put(n, "null");
				}else {
					pairs.put(n, (String) j.get(n));
				}
			}
			//Add hashmap pairs to array
			dataMap[i] = pairs;
		}
		//return array of hashmaps
		return dataMap;

	}
}
