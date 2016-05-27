/**
 * 
 */
package com.sept01.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wolf
 * USES A FACTORY IMPLEMENTATION TO DYNAMICALLY  DECIDE AND SET THE SOURCE OF INFORMATION
 * TO FORECASTIO OR OPENWEATHER.AS THE INSTANCE OF THE FACTORY IS DECIDED THE IMPLEMENTATION 
 * AUTOMATICALLY CREATES A FORECAST FACTORY OBEJECT OR OPENWEATHERMAP OBJECT
 */
public class ForecasterFactory {
   private static final Logger log= Logger.getLogger("ForecastFactory");
	public static Forecaster getForecaster(String forecaster){
		Forecaster forecastApi = null;
		/*CHECKS FOR THE INSTANCE OF FORECAST*/
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

