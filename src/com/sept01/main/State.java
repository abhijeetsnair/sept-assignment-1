/*
 * State class
 * This class scrapes the basic information its state including 
 * area names and the references to tables for the areas
 * it then creates objects for objects for the areas and passes their table to them
 *
 */
package com.sept01.main;

import java.io.IOException;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class State {
	String name;
	private ArrayList<Area> areas = new ArrayList<>();

	public State(String name) {
		this.name = name.toLowerCase();
		try {
			updateWeather();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	protected boolean updateWeather() throws IOException {
			//visit webpage
			//find all header 2 which will have our area names
			Document doc = Jsoup.connect("http://www.bom.gov.au/" + name + "/observations/" + name + "all.shtml").get();
			Elements elements = doc.select("h2");
			Iterator<Element> itr = elements.iterator(); // create an iterator
			//Loop through webpage to get all area names
			while (itr.hasNext()) {
				Element e = itr.next();
				//find the heading element we want
				if (e.text().toUpperCase().compareTo("WEATHER STATION INFORMATION") != 0) {
					//create area and also pass the table with all the weather station links
					getAreas().add(new Area(e.text(), "t" + e.attr("id"),
							doc.select("table[id=" + "t" + e.attr("id")+"]" )));
				}

			}

		

		return false;

	}

	public ArrayList<Area> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<Area> areas) {
		this.areas = areas;
	}

}
