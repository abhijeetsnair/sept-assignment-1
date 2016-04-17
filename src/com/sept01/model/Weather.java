/*
 * MAIN weather class
 * this class its the access point for all weather data
 * when a weather object is created it will create object for all states,area and
 * weather stations.
 * 
 */

package com.sept01.model;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;

import com.sept01.main.WISApplication;

import sun.swing.SwingUtilities2;

/**
 * <p>
 * The Weather Class, which is responsible for mining the data on the government
 * website and then compiling the data into a usable format for the
 * WISApplication.
 * </p>
 * <p>
 * Data obtained from: http://www.bom.gov.au
 * </p>
 * 
 * @see WISApplication
 * @author wolf
 */
public class Weather {
	// abbreviations for BOM web scraping
	private String[] statesAbv = { "vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant", "act" };
	private HashMap<String, State> states = new HashMap<String, State>();

	// Array of state objects
	public Weather() {
		initialize(states);
	}

	public boolean checkConnection(String url) {
		try {
			Jsoup.connect(url).get();
			return true;
		} catch (IOException e) {
			try {
				Thread.sleep(5000);
				try {
					Jsoup.connect(url).get();
					return true;
				} catch (IOException e1) {

					// TODO Auto-generated catch block
					return false;
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return true;

	}

	/**
	 * Attempts to check the connection of the website.
	 * 
	 * @param url
	 *            Url of the website to check.
	 * @param Loading_label
	 *            Label
	 * @return True or false wheteher we could connect or not.
	 * @author wolf
	 */
	public boolean checkConnection(String url, JLabel Loading_label) {
		try {
			Jsoup.connect(url).get();
			return true;
		} catch (IOException e) {
			Loading_label.setText("Cannot connect to " + url + " retrying");
			try {
				Thread.sleep(5000);
				try {
					Jsoup.connect(url).get();
					return true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Loading_label.setText("Cannot connect to " + url + " quiting");
					return false;
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return true;

	}

	protected String[] getStateNames() {

		return statesAbv;
	}

	public State getStateWeather(String state) {
		return states.get(state);

	}

	/**
	 * Initialise function that initialises the functionality of obtaining data
	 * from the given website.
	 * 
	 * @param states
	 *            A reference to a HashMap that holds the states. It should be
	 *            empty and it will be filled with the pulled data.
	 * @return True or false whether this function has succeeded in obtaining
	 *         data.
	 * 
	 * @author wolf
	 */
	private boolean initialize(HashMap<String, State> states) {
		// initialize states with abbreviations as name
		int perDone;
		System.out.println("Loading classes please wait");

		// LOADING SCREEN
		JWindow window = new JWindow();
		window.getContentPane().setBackground(Color.decode("#3d3f47"));
		JLabel Loading_label = new JLabel("LOADING", SwingConstants.CENTER);
		Loading_label.setFont(new Font("Verdana", Font.BOLD, 16));
		Loading_label.setForeground(Color.WHITE);
		window.getContentPane().add(Loading_label);
		window.setBounds(500, 150, 300, 200);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		// Checks if BOM is online if not quit application
		if (!checkConnection("http://www.bom.gov.au/", Loading_label)) {
			System.exit(0);
			return false;
		}
		// populate states
		// this will create all classes for the data
		for (int i = 0; i < statesAbv.length; i++) {

			states.put(statesAbv[i], new State(statesAbv[i]));
			perDone = (int) (((float) i) / ((float) statesAbv.length) * 100);
			System.out.println(perDone + "% done");
			Loading_label.setText("LOADING: " + perDone + "%");
		}

		System.out.println(100 + "% done");
		window.setVisible(false);
		window.dispose();

		return true;

	}

}
