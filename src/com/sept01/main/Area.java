package com.sept01.main;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Area {
	private String name;
	private String id;
	Elements weatherStationTable;
	private ArrayList<WeatherStation> weatherStations = new ArrayList<>();

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
