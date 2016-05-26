package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;
import com.sept01.view.areas.Dialog;
import com.sept01.view.areas.ForecastDialog;
import com.sept01.view.areas.ForecastOptionDialog;


public class ForecastClickListener implements ActionListener{
	String lat;
	String lon;
	Dialog dialog;
	
	public ForecastClickListener(String lat, String lon, Dialog dialog) {
		this.lat =lat;
		this.lon=lon;
		this.dialog=dialog;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
		final String[] forecast_opt = {"ForecastIO", "OpenWeather"};

		    String chosen_source = (String) JOptionPane.showInputDialog(dialog, 
		    		"Select forecast source",
		        "Forecast Source",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        forecast_opt, 
		        forecast_opt[0]);
		    
		    if(chosen_source.compareTo("ForecastIO")==0)
		    {	
		    	
		    	Forecaster fio = ForecasterFactory.getForecaster("forecastio");
				JSONObject forecast =  fio.getForecast(Double.parseDouble(lat),Double.parseDouble(lon));	
		    	ForecastDialog dialog= new ForecastDialog(forecast);
		     	dialog.setVisible(true);
		    }
		    	
		    if(chosen_source.compareTo("OpenWeather")==0)
		    {	
		    	Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
				JSONObject forecast = owm.getForecast(Double.parseDouble(lat),Double.parseDouble(lon));	
		       	ForecastDialog dialog= new ForecastDialog(forecast);
		       	dialog.setVisible(true);
		    }
		    	
		     
		
		
		
		
	 
	 
	}

}
