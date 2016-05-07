/**
 * 
 */
package com.sept01.model;

/**
 * @author wolf
 *
 */
public class ForecasterFactory {
	
	public static Forecaster getForecaster(String forecaster){
		Forecaster forecastApi = null;
		switch(forecaster.toLowerCase()){
		case "forecastio": 	forecastApi = new ForecastIO();
							break;
		case "openweathermap":	forecastApi = new OpenWeatherMap();
								break;
		}
		
		return forecastApi;
		
	}

}
