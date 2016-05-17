package com.sept01.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jfree.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.experimental.theories.Theories;

import com.sept01.utility.ErrorLog;



public class ForecastIO implements Forecaster {
   private static final Logger log= Logger.getLogger("com.sept01.model.ForecastIO");
   
   private final String APIKEY = "699838f9a5ee6e0e948b3579477efdc0";
	
	public HashMap<String, Object> getHourly(){
	   Logger.getLogger("com.sept01.model.ForecastIO").setLevel(Level.ALL);
	   log.log(Level.INFO,"Getting data");
		JSONObject temp = callApi(-37.783817, 100.934818);
		log.log(Level.INFO,temp.toString());
		temp = (JSONObject) temp.get("hourly");
		String summary = (String) temp.get("summary");
		log.log(Level.INFO, summary);
		HashMap<String, Object> hourly = new HashMap<>();
		
		hourly.put("summary", summary);
		hourly.put("data", temp.get("data"));
		JSONArray ta = (JSONArray) hourly.get("data");
		temp = (JSONObject) ta.get(0);
//		System.out.println(temp.get("windSpeed"));
//		System.out.println(hourly.get("data"));
		return hourly;
		
	}
	private JSONObject callApi(double lat, double lon) {
		String doc = null;
		String url = "https://api.forecast.io/forecast/" + APIKEY + "/" + lat + "," + lon;
		try {
			// connect and download the json
		   log.log(Level.INFO,"JSON URL "+ url);
			doc = Jsoup.connect(url).ignoreContentType(true).execute().body();

		} catch (IOException e1) {
			try {
				Thread.sleep(1000);
				doc = Jsoup.connect(url).ignoreContentType(true).execute().body();
			} catch (InterruptedException | IOException e2) {
				ErrorLog.createErrorPopup(e2);
				log.log(Level.SEVERE, e2.getMessage());
			}
			ErrorLog.createErrorPopup(e1);
			log.log(Level.SEVERE, e1.getMessage());
		}
		System.out.println(doc);
		JSONObject ret = new JSONObject(doc);
		log.log(Level.INFO,ret.toString());
		return ret;
	}
}
