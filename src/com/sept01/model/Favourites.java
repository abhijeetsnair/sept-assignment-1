package com.sept01.model;

/**
 * <p>
 * A generalised Class that Handles and stores data regarding "Favourite"
 * stations which are stored Stations.
 * </p>
 * 
 * @see WeatherStation
 * @version 1.0
 */
public class Favourites {

	WeatherStation station;

	/**
	 * Main constructor
	 * 
	 * @return
	 */

	// Retrives the weather station
	public WeatherStation getStation() {
		return station;
	}

	// Sets the weather station to the appropriate station
	// passed
	public void setStation(WeatherStation station) {
		this.station = station;
	}

}
