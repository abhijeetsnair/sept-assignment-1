package com.sept01.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sept01.main.Favourites;
import com.sept01.main.Singleton;
import com.sept01.main.WeatherStation;
import com.sept01.view.areas.Dialog;

public class CityClickListener implements ActionListener {
	private ShowAllStates states = new ShowAllStates();	
	private String state;

	public CityClickListener(String State) {
		 this.state =State;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String weather_station_clicked = ((JButton) arg0.getSource()).getText();

		/*
		 * Opening a dialog window to display information of the weather station
		 * clicked
		 */
		Dialog dialog = new Dialog(new JFrame(), weather_station_clicked,
				"Latest Weather Observation for " + weather_station_clicked,state);
		// set the size of the window
		dialog.setSize(300, 150);

		/*
		 * Storing favorite as the application launches the application
		 */
		Favourites fav = new Favourites();
		WeatherStation fav_station = new WeatherStation(weather_station_clicked,weather_station_clicked);
		fav_station.setName(weather_station_clicked);

		/*
		 * 
		 * Adds the favorites to the WIS Application
		 */
		fav.setStation(fav_station);
		Singleton.getInstance().getApplication().addFav(fav);
		Singleton.getInstance().getEastPanel().addFavoriates();
		Singleton.getInstance().getEastPanel().repaint();
		Singleton.getInstance().getEastPanel().revalidate();
		// System.out.println("Button Clickeed :" + buttonClicked);
		//
		// Area areaclicked = Singleton.getInstance().getArea(buttonClicked);
		// System.out.println("Name of the area " + areaclicked.getName());
		//
		// //fav.setArea(areaclicked);
		// Singleton.getInstance().addFav(fav);
		//
		// // Attempting to see if the change in data gets reflected over
		// // favouriates
		// Singleton data = Singleton.getInstance();
		// data.getEastPanel().addFavoriates();
		// data.getEastPanel().repaint();
		// data.getEastPanel().revalidate();
		//
		// System.out.println("-------");
		//
		// for (int i = 0; i < Singleton.getInstance().getFav().size(); i++) {
		// //System.out.println("Favoriates" +
		// Singleton.getInstance().getFav().get(i).getArea().getName());
		// }

		// System.out.println("Comes here on clicks");
		// JFrame frame = new JFrame();
		// frame.setTitle("Charlton-Temperature");
		// frame.setSize(800, 400);
		// frame.setLocationRelativeTo(null);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
