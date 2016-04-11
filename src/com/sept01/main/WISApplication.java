package com.sept01.main;

import java.util.ArrayList;
import com.sept01.view.MainView;

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
		this.fav.add(fav);

	}
	public void testFav() {

		for (int i = 0; i < fav.size(); i++) {
		 System.out.println(fav.get(i).getStation().getName());
		}

	}
}
