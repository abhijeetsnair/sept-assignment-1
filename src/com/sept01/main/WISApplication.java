package com.sept01.main;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sept01.view.MainView;
/**
 * I changed it
 * 
 * 
 * @author samsung
 *
 */
public class WISApplication {
	static Weather weather;
	private ArrayList<Favourites> fav = new ArrayList<Favourites>();

	public ArrayList<Favourites> getFav() {
		return fav;
	}

	public void setFav(ArrayList<Favourites> fav) {
		this.fav = fav;
	}

	public WISApplication() {
		Singleton.getInstance().setApplication(this);
	}

	
	public static void main(String[] args) {
			
		/**
		 * Changes the look and feel of the application to the nimbus look and feel
		 * 
		 * 	 changeLookAndFeel();	

		 */
		
		
		//changeLookAndFeel();	
		new WISApplication();
		System.out.println("Hello");
		System.out.println(" :D ");
		System.setProperty("awt.useSystemAAFontSettings","on");
		System.setProperty("swing.aatext", "true");
		initializeWeather();
		// Weather instance saved to singleton class
		Singleton.getInstance().setWeather(weather);
		MainView view = new MainView();
		//view.show();
		view.setVisible(true);
		
	}

	private static void changeLookAndFeel() {
		/*
		 * Makes the UI  look more beautiful and appealing
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

	private void getUser() {
		return;
	}

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
		//	fav.saveNewFavourite(fav);
		}
		

	}
	

	
	public void testFav() {

		for (int i = 0; i < fav.size(); i++) {
		 System.out.println(fav.get(i).getStation().getName()+"    "+ fav.get(i).getStation().url);
		}

	}

	public void removeFav(Favourites fav) {
		for (int i = 0; i < getFav().size(); i++) {
			if (getFav().get(i).getStation().getName().compareTo(fav.getStation().getName()) == 0) {
				System.out.println("----------Removing this guy :" +fav.getStation().getName());
				this.fav.remove(i);
			}
		}
		
	}
}
