package com.sept01.model;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.*;
import java.net.*;

import com.sept01.utility.ErrorLog;

public class Geocoder {
	private static final Logger log = Logger.getLogger("geocoder");
	
	public static JSONObject getName(double lat, double lon){
		String url = "https://maps.google.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key=AIzaSyDveZ8e-JyrtProLFiKY0V2Ytqjbl4Kw6k";
		return null;
		
	}
	
	/**
	 * @author wolfz
	 * @return JSONObject with keys lat and lng
	 * **/
	public static JSONObject getCoOrds(String address){
		
		Logger.getLogger("geocoder").setLevel(Level.ALL);
		String url = "https://maps.google.com/maps/api/geocode/json?address="+address+"&key=AIzaSyDveZ8e-JyrtProLFiKY0V2Ytqjbl4Kw6k";
		try {
			url = new URL(url).toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = callAPI(url);
		json = json.getJSONObject("geometry");
		json = json.getJSONObject("location");
		
		
		return json;
		}
	/**
	 * 
	 * @author wolfz
	 * @return returns top JSON object from geocoding api
	 * **/
	private static JSONObject callAPI(String URL){
		String doc = "";
		try {
			// connect and download the json
			log.log(Level.INFO, "JSON URL " + URL);
			doc = Jsoup.connect(URL).ignoreContentType(true).execute().body();

		} catch (IOException e1) {
			try {
				Thread.sleep(1000);
				doc = Jsoup.connect(URL).ignoreContentType(true).execute().body();
			} catch (InterruptedException | IOException e2) {
				ErrorLog.createErrorPopup(e2);
				log.log(Level.SEVERE, e2.getMessage());
				e2.printStackTrace();
			}
			ErrorLog.createErrorPopup(e1);
			log.log(Level.SEVERE, e1.getMessage());
		}
		JSONObject ret = new JSONObject(doc);
		JSONArray res = ret.getJSONArray("results");
		ret = res.getJSONObject(0);
		return ret;
		
		
		
	}

}
