/**
 * 
 */
package com.sept01.model;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author wolf
 *
 */
public interface Forecaster {
	public default HashMap<String, Object> getHourly(){
		return null;
	};
	
	public default JSONObject getForecast(){
		return null;
	};

}
