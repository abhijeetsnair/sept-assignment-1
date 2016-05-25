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
	/*
	public HashMap<String, Object> getHourly(){
		
		   Logger.getLogger("com.sept01.model.OpenWeatherMap").setLevel(Level.ALL);
		   log.log(Level.INFO,"Getting data");
		   //melbourne ID 7839805
		   //set up some objects
			JSONObject tempObj = callApi(-37.783817, 100.934818);
			JSONArray list = new JSONArray();
			JSONObject main = new JSONObject();
			
			//Logging
			log.log(Level.INFO,tempObj.toString());
			
			//get the JSONArray "list"
			list = (JSONArray) tempObj.get("list");
			
			//get the main information, temp ect
			main = (JSONObject) list.getJSONObject(1);
			
			//get the description of the weather
			
			String summary = "NULL";
			log.log(Level.INFO, summary);
			HashMap<String, Object> hourly = new HashMap<>();
			
			hourly.put("summary", summary);
			hourly.put("data", tempObj.get("data"));
			JSONArray ta = (JSONArray) hourly.get("data");
			tempObj = (JSONObject) ta.get(0);
			
			return hourly;	
	}
	*/
	private JSONObject callApi(double lat, double lon)
	{
	   
	   String doc = null;
	   String url = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon +  "&APPID=" + APIKEY;
	   
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
	
	public void getForecast(){
		JSONObject newData = callApi(-37.783817, 100.934818); //call the API to get the raw data
		formatJSON(newData); //format the JSON
		checkData();
		return;// newData; //return 5d 3h data

	}
	
	private void checkData(){
		//print the data
		return;
	}
	
	private JSONObject formatJSON(JSONObject data){
		int numForecasts = 10;
		JSONObject newData = new JSONObject();
		JSONObject currData = new JSONObject();
		
		//contents of the data structures
		JSONObject city = new JSONObject();
		String name; //name of the city
		JSONObject coord = new JSONObject();
		double lon; //lon position
		double lat; //lat position
		
		JSONArray forecast = new JSONArray();
		String description; //description of the weather
		int dateTime; //date time in unix format
		int temp; //tempreature forcast
		int humidity; //humidity forecase
		float speed; //wind speed
		float winddeg; //??
		float pressure; //??
		int cloud; //if it's cloudy
		
		//get the data EXAMPLE DATA
		name = "Melbourne";
		lon = 4.0;
		lat = 3.0;
		
		//FORECAST LIST
		description = "very windy!";
		dateTime = 1;
		humidity = 99;
		speed = 40.5f;
		winddeg = 4.3f;
		pressure = 54.5f;
		cloud = 0;
		
		//example currData
		currData.put("description", description);
		currData.put("dateTime", dateTime);
		currData.put("humidity", humidity);
		currData.put("speed", speed);
		currData.put("winddeg", winddeg);
		currData.put("pressure", pressure);
		currData.put("cloud", cloud);
		
		//format the data (put into new JSON object)
		
		//for loop over the number of forecast objects!
		for(int i = 0; i < numForecasts; i++){
			forecast.put(currData);
		}
		
		coord.put("lon", lon);
		coord.put("lat", lat);
		city.put("name", name);
		city.put("coord", coord);
		
		newData.put("city", city);
		newData.put("forecast", forecast);
		
		
		log.log(Level.INFO,newData.toString());
		return newData;
		
	}

	
}
