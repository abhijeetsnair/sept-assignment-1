package com.sept01.main;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sept01.model.Favourites;
import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;
import com.sept01.model.OpenWeatherMap;
import com.sept01.model.Singleton;
import com.sept01.model.State;
import com.sept01.model.Weather;
import com.sept01.utility.ErrorLog;
import com.sept01.utility.Preferences;
import com.sept01.view.MainView;

/**
 * <p>
 * The Main Client Class for the application.
 * </p>
 */
public class WISApplication {
	public static boolean debug = false;
	public static Weather weather;
	
	private ArrayList<Favourites> fav = new ArrayList<Favourites>();

	public ArrayList<Favourites> getFav() {
		return fav;
	}

	public void setFav(ArrayList<Favourites> fav) {
		this.fav = fav;
	}

	/**
	 * Initialise singleton pattern creation
	 */
	public WISApplication() {
		Forecaster forecaster = ForecasterFactory.getForecaster("forecastio");
		forecaster.getHourly();
		Singleton.getInstance().setApplication(this);
		
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		owm.getHourly();
	}

	/**
	 * Starting main() method
	 * 
	 * @param args
	 *            args
	 */
	public static void main(String[] args) {
		
		/**
		 * Changes the look and feel of the application to the nimbus look and
		 * feel
		 * 
		 * changeLookAndFeel();
		 * 
		 */
		// changeLookAndFeel();

		new WISApplication();
		if(debug){		
			System.out.println("Hello");
			System.out.println(" :D ");
		}

		System.setProperty("awt.useSystemAAFontSettings", "on");
		System.setProperty("swing.aatext", "true");
		initializeWeather();
		Preferences prefs = new Preferences();
		prefs.readFavourites();
		// Weather instance saved to singleton class
		Singleton.getInstance().setWeather(weather);
		MainView view = new MainView();
		// view.show();
		view.setVisible(true);

	}

	@SuppressWarnings("unused")
	private static void changeLookAndFeel() {
		/*
		 * Makes the UI look more beautiful and appealing
		 */
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, fall back to cross-platform
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception ex) {
				ErrorLog.createErrorPopup(ex);
			}
		}

	}

	/**
	 * Initialises a new Weather instance, which handles information gathering
	 * regarding external Data, that will be displayed in the GUI format.
	 */
	public static void initializeWeather() {
		weather = new Weather();
	}

	public void showInfo() {
		return;
	}

	public void updateView() {
		return;
	}

	public void refreshView() {
		return;
	}

	public void adjustWindow() {
		return;
	}

	public void reportError() {

	}

	@SuppressWarnings("unused")
	private void getUser() {
		return;
	}

	@SuppressWarnings("unused")
	private void getInto(State state) {
		return;
	}

	public void addFav(Favourites fav) {
		boolean fav_exists = false;

		for (int i = 0; i < getFav().size(); i++) {
			if (getFav().get(i).getStation().getName().compareTo(fav.getStation().getName()) == 0) {
				fav_exists = true;
			}
		}

		if (fav_exists == false) {
			this.fav.add(fav);
			// fav.saveNewFavourite(fav);
		}

	}

	public void testFav() {

		for (int i = 0; i < fav.size(); i++) {
			if(debug){
				System.out.println(fav.get(i).getStation().getName() + "    " + fav.get(i).getStation().url);
			}
		}

	}

	public void removeFav(Favourites fav) {
		for (int i = 0; i < getFav().size(); i++) {
			if (getFav().get(i).getStation().getName().compareTo(fav.getStation().getName()) == 0) {
				if(debug) {
					if(debug){
						System.out.println("----------Removing this guy :" + fav.getStation().getName());
					}
				}
				this.fav.remove(i);
			}
		}

	}
}
