package com.sept01.model;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import com.sept01.utility.ErrorLog;
public class OpenWeatherMap implements Forecaster {
	
	private final String APIKEY = "2a8527d22267d97306e806834e6d992a";
	private static final Logger log= Logger.getLogger("com.sept01.model.OpenWeatherMap");
	
	public HashMap<String, Object> getHourly(){
		
		   Logger.getLogger("com.sept01.model.OpenWeatherMap").setLevel(Level.ALL);
		   log.log(Level.INFO,"Getting data");
		   
			JSONObject tempObj = callApi("7839805");
			JSONArray tempArr = new JSONArray();
			
			//Logging
			log.log(Level.INFO,tempObj.toString());
			
			tempArr = (JSONArray) tempObj.get("list");
			String summary = (String) tempObj.get("not sure what goes here");
			
			log.log(Level.INFO, summary);
			HashMap<String, Object> hourly = new HashMap<>();
			
			hourly.put("summary", summary);
			hourly.put("data", tempObj.get("data"));
			JSONArray ta = (JSONArray) hourly.get("data");
			tempObj = (JSONObject) ta.get(0);
			
			return hourly;	
	}
	
	private JSONObject callApi(String cityID)
	{
	   
	   String doc = null;
	   String url = "http://api.openweathermap.org/data/2.5/forecast?id=" + cityID + "&APPID=" + APIKEY;
	   
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
		System.out.println("OPENWEATHER API!!!");
		JSONObject ret = new JSONObject(doc);
		log.log(Level.INFO,ret.toString());
		return ret;
	}

	
}
