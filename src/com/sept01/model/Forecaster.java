/**
 * 
 */
package com.sept01.model;

import java.util.HashMap;

import org.json.JSONArray;

/**
 * @author wolf
 *
 */
public interface Forecaster {
	public default HashMap<String, Object> getHourly(){
		return null;
	};

}
