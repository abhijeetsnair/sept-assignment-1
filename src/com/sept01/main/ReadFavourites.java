package com.sept01.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFavourites {
	/**
	* Write a description of class InRead here.
	* 
	* @author (your name) 
	* @version (a version number or a date)
	*/	
	private String station;
	public ReadFavourites()
	{	
		
		String fileName = "Fav/fav.txt";

	    try{
	        FileReader fr= new FileReader(fileName);
	        BufferedReader br= new BufferedReader(fr);
	        System.out.println("--------");
	    while ((station=br.readLine()) != null){		
	    	Favourites fav =new Favourites();	
	    	fav.setStation (new WeatherStation(station,station));
	    	Singleton.getInstance().getApplication().addFav(fav);
	    System.out.println("Fav Area read from the file : "+ fav);
	        }
	        br.close();

	    }catch (IOException e){	
	    	System.out.println("Reading has issues");
	    }
	}

}
