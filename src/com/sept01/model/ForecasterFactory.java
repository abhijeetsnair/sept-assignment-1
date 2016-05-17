/**
 * 
 */
package com.sept01.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wolf
 *
 */
public class ForecasterFactory {
   private static final Logger log= Logger.getLogger("ForecastFactory");
	public static Forecaster getForecaster(String forecaster){
		Forecaster forecastApi = null;
		switch(forecaster.toLowerCase()){
		case "forecastio": 	forecastApi = new ForecastIO();
		log.log(Level.INFO,"Loading ForecastIO");
							break;
		case "openweathermap":	forecastApi = new OpenWeatherMap();
		log.log(Level.INFO,"Loading openweathermap");
								break;
		}
		
		return forecastApi;
		
	}

}
