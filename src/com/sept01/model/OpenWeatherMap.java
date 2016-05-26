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
		//System.out.println("OPENWEATHER API!!!");
		
		JSONObject ret = new JSONObject(doc);
		log.log(Level.INFO,ret.toString());
		return ret;
	}
	
	public JSONObject getForecast(double lat, double lon){
		//JSONObject newData = callApi(-37.783817, 100.934818); //test call of the API
		JSONObject data = callApi(lat, lon); //call the API to get the raw data
		JSONObject newData = formatJSON(data); //format the JSON
		return newData; //return 5d 3h data

	}
	
	private JSONObject formatJSON(JSONObject data){
		int numForecasts = 10;
		JSONObject newData = new JSONObject();
		JSONObject currData = new JSONObject();
		
		//data accessors
		JSONObject dataCity = data.getJSONObject("city");
		JSONObject cityCoord = dataCity.getJSONObject("coord");
		JSONArray dataList = data.getJSONArray("list");
		
		JSONObject currListMain;
		JSONArray currListWeather;
		JSONObject currListClouds;
		JSONObject currListWind;
		JSONObject currListRain;
		JSONObject tempObject = new JSONObject();
		JSONObject tempWeatherObj = new JSONObject();
		
		//contents of the data structures
		JSONObject city = new JSONObject();
		String name; //name of the city
		JSONObject coord = new JSONObject();
		double lon; //lon position
		double lat; //lat position
		
		JSONArray forecast = new JSONArray();
		String description; //description of the weather
		int dateTime; //date time in unix format
		double temp; //tempreature forcast
		int humidity; //humidity forecase
		double speed; //wind speed
		double winddeg; //??
		double pressure; //??
		int cloud; //if it's cloudy
		
		//get the data
		name = dataCity.getString("name");
		lon = cityCoord.getDouble("lon");
		lat = cityCoord.getDouble("lat");
		
		//format the data (put into new JSON object)
		
		//for loop over the number of forecast objects!
		for(int i = 0; i < dataList.length(); i++){
			
			tempObject = dataList.getJSONObject(i);
			currListMain = tempObject.getJSONObject("main");
			currListWeather = tempObject.getJSONArray("weather");
			currListClouds = tempObject.getJSONObject("clouds");
			currListWind = tempObject.getJSONObject("wind");
//			currListRain = tempObject.getJSONObject("rain");
			
			tempWeatherObj = currListWeather.getJSONObject(0);
					
			//FORECAST LIST
			description = tempWeatherObj.getString("description");
			dateTime = tempObject.getInt("dt");
			humidity = currListMain.getInt("humidity");
			speed = currListWind.getDouble("speed");
			winddeg = currListWind.getDouble("deg");
			pressure = currListMain.getDouble("pressure");
			cloud = currListClouds.getInt("all");
			temp = currListMain.getDouble("temp");
			
			//fill currData
			currData.put("description", description);
			currData.put("dateTime", dateTime);
			currData.put("humidity", humidity);
			currData.put("speed", speed);
			currData.put("winddeg", winddeg);
			currData.put("pressure", pressure);
			currData.put("cloud", cloud);
			
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

