package com.sept01.main;

import java.util.ArrayList;
import java.util.Iterator;

import com.jaunt.Element;
import com.jaunt.Elements;

public class Area {
private String name;
private String id;
Element weatherStationTable;
private ArrayList<WeatherStation> weatherStations = new ArrayList<>();
   public Area(String name, String id,Element table){
      this.name = name;
      this.id = id;
      //strip the table and get just the links
      weatherStationTable =  table.findEvery("<a href>");;
      
      //loop just to test that we are getting just the stations for this area remove it to tidy up
 	 Iterator<Element> titr = ((Elements) weatherStationTable).iterator();
 	 while(titr.hasNext()){	
 		 Element e = titr.next();
 		 System.out.println(e.innerHTML());
		 getWeatherStations().add(new WeatherStation(e.getAtString("href"),e.innerHTML()));
		 
	 }
   }
   public String getName(){
      return name;
   }
   public String getId(){
      return id;
   }
public ArrayList<WeatherStation> getWeatherStations() {
	return weatherStations;
}
public void setWeatherStations(ArrayList<WeatherStation> weatherStations) {
	this.weatherStations = weatherStations;
}
  

}
