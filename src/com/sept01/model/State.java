/*
 * State class
 * This class scrapes the basic information its state including 
 * area names and the references to tables for the areas
 * it then creates objects for objects for the areas and passes their table to them
 *
 */
package com.sept01.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sept01.utility.ErrorLog;

/**
 * NOTE: STATE STORES ALL THE INFORMATION PERTAINING TO THE STATE THE INSTANCES
 * OF THE STATE GETS STORED IN A LIST SO THAT THEY CAN BE ACCESSED BY THE
 * APPLICATION TO GET THE STATE INFORMATION.
 * 
 * <p>
 * A Class that represents a State (territory) of Australia.
 * </p>
 * <p>
 * This is the highest in the heirarchy, as a State will contain Areas, which
 * will contain Weather Stations.
 * </p>
 * 
 * @see WeatherStation
 * @see Area
 * @version 1.0
 */
public class State {
	String name;
	private ArrayList<Area> areas = new ArrayList<>();

	/**
	 * Main constructor
	 * 
	 * @param name
	 *            Name of the State
	 */
	public State(String name) {
		this.name = name.toLowerCase();
		try {
			updateWeather();
		} catch (Exception e) {
			ErrorLog.createErrorPopup(e);
		}
	}

	public ArrayList<Area> getAreas() {
		return areas;
	}

	public String getName() {
		return name;
	}

	public void setAreas(ArrayList<Area> areas) {
		this.areas = areas;
	}
	/**
	 * Attempts to get obtain the state data for this state object
	 * 
	 * @author wolf
	 *
	 * **/
	protected void updateWeather() throws IOException {
		/**Set up document to store the webpage in and the connect and download the webpage**/
		Document doc;
		if (name == "act") {
			doc = Jsoup.connect("http://www.bom.gov.au/" + name + "/observations/canberra.shtml").get();
		} else {
			doc = Jsoup.connect("http://www.bom.gov.au/" + name + "/observations/" + name + "all.shtml").get();
		}
		/**Extract the headings that contain the area names**/
		Elements elements = doc.select("h2");
		Iterator<Element> itr = elements.iterator(); // create an iterator
		
		// Loop through webpage to get all area names
		while (itr.hasNext()) {
			Element e = itr.next();
			// find the heading element we want
			if (e.text().toUpperCase().compareTo("WEATHER STATION INFORMATION") != 0) {
				// create area and also pass the table with all the weather
				// station links
				getAreas().add(
						new Area(e.text(), "t" + e.attr("id"), doc.select("table[id=" + "t" + e.attr("id") + "]")));
			}

		}

		

	}

}
