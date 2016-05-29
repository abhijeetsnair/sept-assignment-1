package com.sept01.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import com.sept01.utility.ErrorLog;

public class ForecastIO implements Forecaster {
	// IMPLEMENTS LOGGING TO FILE FOR THE CLASS FORECASTIO
	private static final Logger log = Logger.getLogger("com.sept01.model.ForecastIO");

	// API KEY FOR THE CALL TO THE WEB SERVICE
	private final String APIKEY = "699838f9a5ee6e0e948b3579477efdc0";

	// RETRIEVES THE FORECAST INFORMATION BASED ON THE LAT AND LONG PROVIDED TO
	// THE WEBSERVICE
	/**
	 * @author wolfz
	 * @param latatude and longitude 
	 * @return JSONObject contain formatted data
	 * **/
	public JSONObject getForecast(double lat, double lon) {
		Logger.getLogger("com.sept01.model.ForecastIO").setLevel(Level.ALL);
		log.log(Level.INFO, "Getting data");

		JSONObject data = new JSONObject();
		JSONObject cityInfo = new JSONObject();
		JSONObject coords = new JSONObject();

		coords.append("lon", 0);
		coords.append("lat", 0);
		JSONArray forecast = new JSONArray();
		cityInfo.append("name", "");

		/**
		 * Call the API. and store in a json object
		 */
		JSONObject temp = callApi(lat, lon);

		/**
		 * Put items into the formatted json objects
		 **/
		cityInfo.put("name", Geocoder.getName(lat, lon));
		coords.put("lat", temp.get("latitude"));
		coords.put("lon", temp.get("longitude"));
		cityInfo.put("coords", coords);
		data.put("city", cityInfo);
		data.put("forecast", forecast);

		/**
		 * Get the hourly data from the raw json from the api
		 **/
		temp = (JSONObject) temp.get("hourly");
		JSONArray ta = temp.getJSONArray("data");
		log.log(Level.INFO, temp.toString());

		/**
		 * Load up the forcast json objects into the forecast array
		 **/
		for (Object Ob : ta) {
			JSONObject JSOb = (JSONObject) Ob;
			JSONObject FJSOb = new JSONObject();
			FJSOb.put("description", JSOb.get("summary"));
			FJSOb.put("dateTime", JSOb.get("time"));
			FJSOb.put("temp", ((JSOb.getDouble("temperature") - 32.00) * 5) / 9);
			FJSOb.put("humidity", JSOb.get("humidity"));
			FJSOb.put("speed", JSOb.get("windSpeed"));
			FJSOb.put("winddeg", JSOb.get("windBearing"));
			FJSOb.put("pressure", JSOb.get("pressure"));
			FJSOb.put("cloud", JSOb.get("cloudCover"));
			FJSOb.put("rain", JSOb.get("precipProbability"));
			data.getJSONArray("forecast").put(FJSOb);

		}

		log.log(Level.INFO, data.toString());
		return data;
	}

	// MAKES A DYNAMIC CALL TO THE API WITH ELEMENTS APPENDED TO THE STRING
	private JSONObject callApi(double lat, double lon) {
		String doc = null;
		String url = "https://api.forecast.io/forecast/" + APIKEY + "/" + lat + "," + lon;
		try {
			// connect and download the json
			log.log(Level.INFO, "JSON URL " + url);
			doc = Jsoup.connect(url).ignoreContentType(true).execute().body();

		} catch (IOException e1) {
			try {
				Thread.sleep(1000);
				doc = Jsoup.connect(url).ignoreContentType(true).execute().body();
			} catch (InterruptedException | IOException e2) {
				ErrorLog.createErrorPopup(e2);
				log.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
			// REPORTS AN ERROR IF PROBLEMS CONNECTING TO THE API
			ErrorLog.createErrorPopup(e1);
			log.log(Level.SEVERE, e1.getMessage());
		}
		JSONObject ret = new JSONObject(doc);
		return ret;
	}
}
