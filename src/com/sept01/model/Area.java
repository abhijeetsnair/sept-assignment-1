package com.sept01.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <p>
 * The Area Class which represents an idea of an 'Area', regarding a generalised
 * location group, such as "Melbourne".
 * </p>
 * <p>
 * This can be considered a child of "State", where {@link State} would contain
 * many Areas..
 * </p>
 * 
 * @version 1.0
 * @see State
 */
public class Area {

	// Initial variables
	private String name;
	private String id;
	Elements weatherStationTable;
	private ArrayList<WeatherStation> weatherStations = new ArrayList<>();

	/**
	 * Main constructor
	 * 
	 * @param name
	 *            Name of the area
	 * @param id
	 *            ID of the area
	 * @param table
	 *            Reference to the elements table required
	 */
	public Area(String name, String id, Elements table) {
		this.name = name;
		this.id = id;
		// strip the table and get just the links
		weatherStationTable = table.select("a[href]");
		Iterator<Element> titr = ((Elements) weatherStationTable).iterator();
		// Load all the weather station objects - no data apart from name
		while (titr.hasNext()) {
			Element e = titr.next();
			getWeatherStations().add(new WeatherStation(e.attr("abs:href"), e.text()));

		}
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public ArrayList<WeatherStation> getWeatherStations() {
		return weatherStations;
	}

	public void setWeatherStations(ArrayList<WeatherStation> weatherStations) {
		this.weatherStations = weatherStations;
	}

}
