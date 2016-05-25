
package com.sept01.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import com.sept01.utility.ErrorLog;

public class ForecastIO implements Forecaster {
	private static final Logger log = Logger.getLogger("com.sept01.model.ForecastIO");

	private final String APIKEY = "699838f9a5ee6e0e948b3579477efdc0";

	public JSONObject getForecast(double lat, double lon){

		JSONObject data = new JSONObject();
		JSONObject cityInfo = new JSONObject();
		JSONObject coords = new JSONObject();
		coords.append("lon", 0);
		coords.append("lat", 0);
		JSONArray forecast = new JSONArray();
		cityInfo.append("name", "");
		// data.append("city",);
		Logger.getLogger("com.sept01.model.ForecastIO").setLevel(Level.ALL);
		log.log(Level.INFO, "Getting data");
		JSONObject temp = callApi(lat, lon);
		cityInfo.put("name", "Forecast IO cannot get the area name at this time!");
		coords.put("lat", temp.get("latitude"));
		coords.put("lon", temp.get("longitude"));
		cityInfo.put("coords", coords);
		data.put("city", cityInfo);
		data.put("forecast", forecast);
		temp = (JSONObject) temp.get("hourly");
		JSONArray ta = temp.getJSONArray("data");
		temp = (JSONObject) ta.get(0);
		// System.out.println(temp.get("windSpeed"));
		// System.out.println(hourly.get("data"));

		System.out.println(ta.length());
		for (Object Ob : ta) {
			JSONObject JSOb = (JSONObject) Ob;
			JSONObject FJSOb = new JSONObject();
			FJSOb.put("description", JSOb.get("summary"));
			FJSOb.put("dateTime", JSOb.get("time"));
			FJSOb.put("temp", JSOb.get("temperature"));
			FJSOb.put("humidity", JSOb.get("humidity"));
			FJSOb.put("speed", JSOb.get("windSpeed"));
			FJSOb.put("winddeg", JSOb.get("windBearing"));
			FJSOb.put("pressure", JSOb.get("pressure"));
			FJSOb.put("cloud", JSOb.get("cloudCover"));
			data.getJSONArray("forecast").put(FJSOb);

		}
		// System.out.println(data.toString());
		// temp = (JSONObject) ta.get(0);
		// System.out.println(temp.get("windSpeed"));
		// System.out.println(hourly.get("data"));
		log.log(Level.INFO, data.toString());
		return data;
	}

	private JSONObject callApi(double lat, double lon) {
		String doc = null;
		String url = "https://api.forecast.io/forecast/" + APIKEY + "/" + lat + "," + lon;
		try {
			// connect and download the json
			log.log(Level.INFO, "aJSON URL " + url);
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
		log.log(Level.INFO, ret.toString());
		return ret;
	}
}
