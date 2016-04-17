package com.sept01.utility;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.sept01.model.Favourites;
import com.sept01.model.Singleton;
import com.sept01.model.WeatherStation;

public class Preferences {

	public void readFavourites() {
		String fileName = "Fav/fav.txt";
		String station;

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("--------");
			while ((station = br.readLine()) != null) {
				Favourites fav = new Favourites();
				String[] token = null;
				System.out.println(station);
				String line = station;
				token = line.split("-");
				fav.setStation(new WeatherStation(token[1], token[0]));
				Singleton.getInstance().getApplication().addFav(fav);
				System.out.println("Fav Area read from the file : " + fav);
			}
			br.close();

		} catch (IOException e) {
			System.out.println("Reading has issues");
		}
	}

	public void readScreenLocation() {
		
		// file name where it stores the screen location
		int i = 0;
		String fileName = "Fav/loc.txt";
		String loc;
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("--------");
			// reads the x and y coodinates one by one and stores it in the
			// program
			while ((loc = br.readLine()) != null) {

				++i;
				if (i == 1) {
					Singleton.getInstance().setXloc(Integer.parseInt(loc));

				} else {
					Singleton.getInstance().setYloc(Integer.parseInt(loc));
				}

				System.out.println(loc);

			}
			System.out.println(Singleton.getInstance().getXloc() + " sdsds" + Singleton.getInstance().getYloc());
			br.close();

		} catch (IOException e) {
			System.out.println("Reading has issues");
		}
		
	}

	public void saveFavourite() {
		String fileName = "Fav/fav.txt";
	    try {
	        // Assume default encoding.
	        FileWriter fileWriter =
	            new FileWriter(fileName);

	        // Always wrap FileWriter in BufferedWriter.
	        BufferedWriter bufferedWriter =
	            new BufferedWriter(fileWriter);

	        // Note that write() does not automatically
	        // append a newline character.	
	        	
	        for(int i=0;i<Singleton.getInstance().getApplication().getFav().size();i++)
	        {	
	        		
	            bufferedWriter.write(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()+"-"+Singleton.getInstance().getApplication().getFav().get(i).getStation().url);
		        //	        bufferedWriter.append(fav.getStation().getName()+"-"+fav.getStation().url);
		        bufferedWriter.newLine();	
	        }
	        // Always close files.
	        bufferedWriter.close();
	    }
	    catch(IOException ex) {
	        System.out.println(
	            "Error writing to file '"
	            + fileName + "'");
	        // Or we could just do this:
	        // ex.printStackTrace();
	    }
	}

	public void saveScreenLocation(Point loc) {
		String fileName = "Fav/loc.txt";
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.

			bufferedWriter.write("" + (int) loc.getX());
			bufferedWriter.newLine();
			bufferedWriter.write("" + (int) loc.getY());
			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			// Or we could just do this:
			// ex.printStackTrace();
		}
		
	}

}
