package com.sept01.model;
import java.util.HashMap;
import org.json.JSONObject;

/**
 * @author wolf
 */
/* THE FORECASTER INTERFACE IS IMPLEMENTED BY BASE CLASSES FORECASTIO AND
 * OPENWEATHER. BOTH OF THE TWO USE getForecast(double lat, double lon) to
 * RETRIEVE FORECAST INFORMATION
 * THE getHourly() METHOD IS ALSO COMMON TO THE TWO IMPLMENTATIONS
 * 
 */

public interface Forecaster {
	//Retrives the hourly data for 48 hours
	public default HashMap<String, Object> getHourly(){
		return null;
	};
	// Gets the forecast from the relevant API
	public default JSONObject getForecast(double lat, double lon){
		return null;
	};

}

