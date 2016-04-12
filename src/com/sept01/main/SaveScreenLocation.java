package com.sept01.main;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveScreenLocation {

	private String fileName = "Fav/loc.txt";
		
		
	//Stores the location to the correct point co ordinates
	public SaveScreenLocation(Point loc) {
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Note that write() does not automatically
			// append a newline character.

				bufferedWriter.write(""+(int)loc.getX());
	            bufferedWriter.newLine();
				bufferedWriter.write(""+(int)loc.getY());
			// Always close files.
			bufferedWriter.close();
		} catch (IOException ex) {
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}
}
