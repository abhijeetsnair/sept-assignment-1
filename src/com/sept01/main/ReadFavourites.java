package com.sept01.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

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
	    	String[] token = null;
	    	System.out.println(station);
	    	String line = station;
	    	token = line.split("-");
//	    	System.out.println(token[1]);
	    	fav.setStation (new WeatherStation(token[1],token[0]));
	    	Singleton.getInstance().getApplication().addFav(fav);
	    System.out.println("Fav Area read from the file : "+ fav);
	        }
	        br.close();

	    }catch (IOException e){	
	    	System.out.println("Reading has issues");
	    }
	}

}
