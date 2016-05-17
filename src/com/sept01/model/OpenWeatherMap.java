package com.sept01.model;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.jsoup.Jsoup;
public class OpenWeatherMap implements Forecaster {
	private final String APIKEY = "2a8527d22267d97306e806834e6d992a";
	private static final Logger log= Logger.getLogger("com.sept01.model.OpenWeatherMap");
	private JSONObject callApi(double lat, double lon)
	{
	   log.log(Level.INFO,"lat " + lat + "lon" + lon);
      return null;
	   
	}
}
