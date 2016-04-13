package com.sept01.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Favourites {

	WeatherStation station;
	
	public WeatherStation getStation() {
		return station;
	}

	public void setStation(WeatherStation station) {
		this.station = station;
	}
	
	public void saveNewFavourite(Favourites fav){
		//append favourite to file	
		String fileName = "Fav/fav.txt";
	    try {
	    	Path path = Paths.get(fileName);
	    	
	    	FileWriter fileWriter =
	        new FileWriter(fileName, true);

	        // Always wrap FileWriter in BufferedWriter.
	        BufferedWriter bufferedWriter =
	        new BufferedWriter(fileWriter);

	        // Note that write() does not automatically
	        // append a newline character.	
	        bufferedWriter.append(fav.getStation().getName()+"-"+fav.getStation().url);
	        bufferedWriter.newLine();
             
	        // Always close files.
	        bufferedWriter.close();
	    }
	    catch(IOException ex) {
	        System.out.println(
	            "Error writing to file '"
	            + fileName + "'");
	        ErrorLog.createErrorPopup(ex);
	        // Or we could just do this:
	        // ex.printStackTrace();
	    }
		return;
	}
	
	
}
