package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sept01.model.Favourites;
import com.sept01.model.Singleton;
import com.sept01.model.WeatherStation;

/*
 * SIMPLY ADDS
 * FAVORIATES TO THE FAVORIATES LIST IN THE 
 * APPLICATION
 * SO THAT THE WHOLE APPLICATION HAS ACCESS TO THE FAVORIATES
 */
public class AddtoFavListener implements ActionListener {
	String weather_station;
	WeatherStation weatherStation;

	public AddtoFavListener(String station, WeatherStation weatherStation) {
		this.weather_station = station;
		this.weatherStation = weatherStation;
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
		Singleton.getInstance().getApplication().addFav(fav);
		Singleton.getInstance().getEastPanel().addFavourites();
		Singleton.getInstance().getEastPanel().repaint();
		Singleton.getInstance().getEastPanel().revalidate();

	}

}
