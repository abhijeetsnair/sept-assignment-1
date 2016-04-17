package com.sept01.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *NOTE :-
 * THE SCREEN LOCATION MUST   STORE THE X AND Y CO ORDINATES OF THE
 * SCREEN SO THAT THE NEXT TIME THE SCREEN POPUS UP IT POPS UP AT THE
 * SAME LOCATION IN WHICH IT WAS CLOSED.IN THIS WAY IT IS SIMPLE FOR THE USER
 * TO VIEW INFORMATION CONSISTENTLY ESPECIALLY IF THE SCREEN USED BY THE USER
 * IS A SMALL SCREEN.
 */
public class ReadScreenLoc {
	int i = 0;

	public ReadScreenLoc() {
		// file name where it stores the screen location
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
}
