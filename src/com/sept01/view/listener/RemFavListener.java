package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sept01.model.Favourites;
import com.sept01.model.Singleton;
import com.sept01.model.WeatherStation;
/*
 * SIMPLY REMOVES
 * FAVORIATES FROM THE FAVORIATES LIST IN THE 
 * APPLICATION
 * SO THAT THE WHOLE APPLICATION HAS ACCESS TO THE FAVORIATES
 */
public class RemFavListener implements ActionListener {
	String weather_station;
	WeatherStation weatherStation;
	public RemFavListener(String station, WeatherStation weatherStation) {
		this.weather_station =station;
		this.weatherStation=weatherStation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Favourites fav = new Favourites();
		WeatherStation fav_station = weatherStation;
		fav_station.setName(weather_station);

		/*
		 * 
		 * Adds the favorites to the WIS Application
		 */
		fav.setStation(fav_station);
		Singleton.getInstance().getApplication().removeFav(fav);
		Singleton.getInstance().getEastPanel().updateFav();
		Singleton.getInstance().getEastPanel().repaint();
		Singleton.getInstance().getEastPanel().revalidate();
	}

}
