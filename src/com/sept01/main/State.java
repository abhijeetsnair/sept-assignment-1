package com.sept01.main;
import java.util.*;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
public class State {
String name;
//Currently only holding strings to weather station pages
ArrayList<Object> areaNames = new ArrayList<>();
ArrayList<Area> areas = new ArrayList<>();
	public State(String name){
		this.name = name;
		updateWeather();
	}
	
	//update weather for entire state
	protected boolean updateWeather(){
		try{
			UserAgent userAgent = new UserAgent();
			 userAgent.visit("http://www.bom.gov.au/"+name+"/observations/"+name+"all.shtml");                        //visit a url  
//			 Elements elements = userAgent.doc.findEvery("<a href>");
			 Elements elements = userAgent.doc.findEvery("<h2>");
			 Elements tElements = userAgent.doc.findEvery("<table>");
			 Iterator<Element> itr = elements.iterator();
			 Iterator<Element> titr = tElements.iterator();
			 int x = 0;
			 while(itr.hasNext()){
//				 if(elements.getElement(x).getAtString("href").contains("product")){
			    if(elements.getElement(x).innerText().toUpperCase().compareTo("WEATHER STATION INFORMATION") != 0){
					 //System.out.println("weather station: "+elements.getElement(x).getAtString("href")); 
//					 weatherStations.add(elements.getElement(x).getAtString("href"));
			    	
			       areas.add(new Area(elements.getElement(x).innerText(), "t"+ elements.getElement(x).getAtString("id"),userAgent.doc.findEvery("<table id="+"t"+ elements.getElement(x).getAtString("id")+">")));
			       areaNames.add(elements.getElement(x).innerText());
				 }
				 itr.next();
				 x++;
			 }
//			 while(titr.hasNext()){
//				 Elements aElements = tElements.findEvery("<a href>");
//				 System.out.println(titr.next().getAtString("id"));
//				 for(Element element : aElements){
//				 //System.out.println("weather station: "+element.getAtString("href"));
//			 }
//				 
//			 }
		}catch(JauntException e){
			 System.err.println(e);
		}
		
		
		return false;
		
		
	}
	
	

}
