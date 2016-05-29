package com.sept01.view.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;
import com.sept01.model.Singleton;
import com.sept01.view.areas.Dialog;
import com.sept01.view.areas.ForecastDialog;
/*
 * FORECAST CLICK LISTENER ALLOWS THE USER TO CHOOSE BETWEEN FORECAST.IO AND OPENWEATHER
 * ON SELECTING EITHER OF THE TWO  IT OPENS UP A DIALOG WHICH DISPLAYS USER VALUES OF 
 * WEATHER ON A PANEL BASED ON THE USER CHOICE AND PREFERENCE
 * 
 * FORECAST CLICK LISTENER USES THE LATITUDE AND LONGITUDE VALUES TO OBATAIN THE WEATHER INFORMATION
 * FOR THE LOCATION. THE LATITUDE AND LONGITUDE VALUES GET PASSED FROM THE BOM WEBSITE DATA.
 */

public class ForecastClickListener implements ActionListener {
	String lat;
	String lon;
	Dialog dialog;
	String weather_station;
	// Implements Java logger
	private static final Logger log = Logger.getLogger("com.sept01.areas.ForecastDialog");

	public ForecastClickListener(String lat, String lon, Dialog dialog, String weather_station) {
		this.lat = lat;
		this.lon = lon;
		this.dialog = dialog;
		this.weather_station=weather_station;
	}
	
	 @Override
	  public void actionPerformed(ActionEvent arg0) {

	    /*
	     * IF USER DECIDED TO CANCEL THE CHOICE GETS INITIALISED TO NULL
	     */
	      // IF THE USER CHOOSES FORECAST_IO AT RUNTIME
	      if (Singleton.getInstance().source == 0) {
	        log.log(Level.INFO, "ForecastIO selected as source for weather information");
	        Forecaster fio = ForecasterFactory.getForecaster("forecastio");
	        // TRIGGERS AN INSTANCE OF FORECASTIO
	        JSONObject forecast = fio.getForecast(Double.parseDouble(lat), Double.parseDouble(lon));
	        log.log(Level.INFO, "ForecastIO forecast Information :" + forecast.toString());
	        ForecastDialog dialog = new ForecastDialog(forecast,weather_station);
	        dialog.setVisible(true);
	      }
	      // IF THE USER CHOOSES OPENWEATHER_IO AT RUNTIME
	      if (Singleton.getInstance().source == 1) {
	        //log choices
	        log.log(Level.INFO, "OpenWeather selected as source for weather information");
	        Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
	        //TRIGGERS AN INSTANCE OF OPENWEATHER
	        JSONObject forecast = owm.getForecast(Double.parseDouble(lat), Double.parseDouble(lon));
	        log.log(Level.INFO, "OpenWeather forecast Information :" + forecast.toString());
	        ForecastDialog dialog = new ForecastDialog(forecast,weather_station);
	        dialog.setVisible(true);
	      }

	    

	  }


}
