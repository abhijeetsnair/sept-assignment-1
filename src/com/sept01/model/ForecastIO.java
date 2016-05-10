package com.sept01.model;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.sept01.utility.ErrorLog;



public class ForecastIO implements Forecaster {
	private final String APIKEY = "699838f9a5ee6e0e948b3579477efdc0";
	
	
	public HashMap<String, Object> getHourly(){
		JSONObject temp = callApi(-37.783817, 100.934818);
		System.out.println(temp.toString());
		temp = (JSONObject) temp.get("hourly");
		String summary = (String) temp.get("summary");
		System.out.println(summary);
		HashMap<String, Object> hourly = new HashMap<>();
		
		hourly.put("summary", summary);
		hourly.put("data", temp.get("data"));
		JSONArray ta = (JSONArray) hourly.get("data");
		temp = (JSONObject) ta.get(0);
		System.out.println(temp.get("windSpeed"));
		System.out.println(hourly.get("data"));
		return hourly;
		
	}
	private JSONObject callApi(double lat, double lon) {
		String doc = null;
		String url = "https://api.forecast.io/forecast/" + APIKEY + "/" + lat + "," + lon;
		try {
			// connect and download the json
			System.out.println(url);
			doc = Jsoup.connect(url).ignoreContentType(true).execute().body();

		} catch (IOException e1) {
			try {
				Thread.sleep(1000);
				doc = Jsoup.connect(url).ignoreContentType(true).execute().body();
			} catch (InterruptedException | IOException e2) {
				ErrorLog.createErrorPopup(e2);
			}
			ErrorLog.createErrorPopup(e1);
			
		}
		System.out.println(doc);
		JSONObject ret = new JSONObject(doc);
		System.out.println(ret);
		return ret;
	}
}
