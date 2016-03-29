/*
 * State class
 * This class scrapes the basic information its state including 
 * area names and the references to tables for the areas
 * it then creates objects for objects for the areas and passes their table to them
 *
 */
package com.sept01.main;
import java.util.*;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
public class State {
String name;
ArrayList<Area> areas = new ArrayList<>();
	public State(String name){
		this.name = name;
		updateWeather();
	}
	
	protected boolean updateWeather(){
		try{
			UserAgent userAgent = new UserAgent();
			 userAgent.visit("http://www.bom.gov.au/"+name+"/observations/"+name+"all.shtml"); 
			 Elements elements = userAgent.doc.findEvery("<h2>");
			 Elements tElements = userAgent.doc.findEvery("<table>");
			 Iterator<Element> itr = elements.iterator();
			 int x = 0;
			 while(itr.hasNext()){

			    if(elements.getElement(x).innerText().toUpperCase().compareTo("WEATHER STATION INFORMATION") != 0){

			       areas.add(new Area(elements.getElement(x).innerText(), "t"+ elements.getElement(x).getAtString("id"),userAgent.doc.findEvery("<table id="+"t"+ elements.getElement(x).getAtString("id")+">")));
				 }
				 itr.next();
				 x++;
			 }

		}catch(JauntException e){
			 System.err.println(e);
		}
		
		
		return false;
		
		
	}
	
	

}
