package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sept01.main.Favourites;
import com.sept01.main.Singleton;
import com.sept01.main.WeatherStation;

public class AddtoFavListener implements ActionListener {
	String weather_station;
	WeatherStation weatherStation;
	
	public AddtoFavListener(String station, WeatherStation weatherStation) {
	this.weather_station =station;
	this.weatherStation=weatherStation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Favourites fav = new Favourites();
		WeatherStation fav_station = weatherStation;
				//new WeatherStation(weather_station_clicked,weather_station_clicked);
		fav_station.setName(weather_station);

		/*
		 * 
		 * Adds the favorites to the WIS Application
		 */
		fav.setStation(fav_station);
		Singleton.getInstance().getApplication().addFav(fav);
		Singleton.getInstance().getEastPanel().addFavourites();
		Singleton.getInstance().getEastPanel().repaint();
		Singleton.getInstance().getEastPanel().revalidate();

	}

}
