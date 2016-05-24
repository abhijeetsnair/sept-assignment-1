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
	private JSONObject callApi(double lat, double lon)
	{
	   //log.log(Level.INFO,"lat " + lat + "lon" + lon);
	   
	   String doc = null;
	   String url = "https://api.openweathermap.org/data/2.5/forecast?id=7839805&APPID="+APIKEY;
	   
	   try {
			// connect and download the json
		   log.log(Level.INFO,"JSON URL "+ url);
		   doc = Jsoup.connect(url).ignoreContentType(true).execute().body();

		} catch (IOException e1) {
			try {
				Thread.sleep(1000);
				doc = Jsoup.connect(url).ignoreContentType(true).execute().body();
			} catch (InterruptedException | IOException e2) {
				//ErrorLog.createErrorPopup(e2);
				//log.log(Level.SEVERE, e2.getMessage());
			}
			//ErrorLog.createErrorPopup(e1);
			//log.log(Level.SEVERE, e1.getMessage());
		}
		System.out.println(doc);
		System.out.println("OPENWEATHER API!!!");
		JSONObject ret = new JSONObject(doc);
		log.log(Level.INFO,ret.toString());
		return ret;
	   
	   
	}
	
	
	public HashMap<String, Object> getHourly(){
			callApi(3,4);
			HashMap<String, Object> hourly = new HashMap<>();
			return hourly;	
	}
	
}
