package com.sept01.main;

import java.util.ArrayList;

public class Area {
private String name;
private String id;
ArrayList<WeatherStation> weatherStations = new ArrayList<>();
   public Area(String name, String id){
      this.name = name;
      this.id = id;
      
   }
   public String getName(){
      return name;
   }
   public String getId(){
      return id;
   }
  

}
