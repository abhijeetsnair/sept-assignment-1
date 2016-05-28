package com.sept01.model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sept01.main.WISApplication;
import com.sept01.view.MainView;
import com.sept01.view.areas.WestPanel;
/*
 * NOTE:
 * SAVES ALL THE INSTANCES OF 
 * MAINVIEW
 * WISAPPLICATION
 * EASTPANEL
 * WESTPANEL
 * NORTHPANEL
 * SOUTHPANEL
 * SUCH THAT THEY CAN BE ACESSED FROM ANYWHERE WITHIN THE APPLICATION AND 
 * SAME INSTANCES GET MODIFIED. MODIFICATIONS GET REFLECTED ON THE SAME
 * INSTANCE OF THE PROGRAM
 */
/**
 * The main Singleton Class of the application. It is used to reference global variables, for whatever needs possible.
 */
public class Singleton {
	private MainView MainView;
	private int xloc;
	private int yloc;
	private com.sept01.view.areas.EastPanel EastPanel;
	private WestPanel WestPanel;
	private com.sept01.view.areas.CenterPanel CenterPanel;
	private com.sept01.view.areas.NorthPanel NorthPanel;
	private com.sept01.view.areas.SouthPanel SouthPanel;
	private static WISApplication application;
	
	public int source = -1;

	private Weather weather;

	public void setApplication(WISApplication app) {
		Singleton.application = app;
	}

	public WISApplication getApplication() {
		return application;
	}

	public Weather getWeather() {
		return weather;
	}

	private ArrayList<Favourites> fav = new ArrayList<Favourites>();
	ArrayList<State> states = new ArrayList<State>();
	// Create all the states
//	State NSW = new State("NSW");
//	State VIC = new State("VIC");
//	State QLD = new State("QLD");
//	State WA = new State("WA");
//	State SA = new State("SA");
//	State TAS = new State("TAS");
//	State ACT = new State("ACT");
//	State NT = new State("NT");
//	State ANTARTICA = new State("ANT");

	public JFrame getMainView() {
		return MainView;
	}

	public ArrayList<Favourites> getFav() {
		return fav;
	}

	public void setFav(ArrayList<Favourites> fav) {
		this.fav = fav;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public void setMainView(MainView mainView) {
		MainView = mainView;
	}

	public com.sept01.view.areas.EastPanel getEastPanel() {
		return EastPanel;
	}

	public void setEastPanel(com.sept01.view.areas.EastPanel eastPanel) {
		EastPanel = eastPanel;
	}

	public JPanel getWestPanel() {
		return WestPanel;
	}

	public void setWestPanel(com.sept01.view.areas.WestPanel westPanel) {
		WestPanel = westPanel;
	}

	public JPanel getCenterPanel() {
		return CenterPanel;
	}

	public void setCenterPanel(com.sept01.view.areas.CenterPanel centerPanel) {
		CenterPanel = centerPanel;
	}

	public JPanel getNorthPanel() {
		return NorthPanel;
	}

	public void setNorthPanel(com.sept01.view.areas.NorthPanel northPanel) {
		NorthPanel = northPanel;
	}

	public JPanel getSouthPanel() {
		return SouthPanel;
	}

	public void setSouthPanel(com.sept01.view.areas.SouthPanel southPanel) {
		SouthPanel = southPanel;
	}

	public static Singleton getSingleton() {
		return singleton;
	}

	public static void setSingleton(Singleton singleton) {
		Singleton.singleton = singleton;
	}

	private static Singleton singleton = new Singleton();

	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private Singleton() {
	}

	/* Static 'instance' method */
	public static Singleton getInstance() {
		return singleton;
	}

	/* Other methods protected by singleton-ness */
	protected static void demoMethod() {
		if(WISApplication.debug == true){
			System.out.println("demoMethod for singleton");
		}
	}

	// public State getState(String state) {
	// for (int i = 0; i < states.size(); i++) {
	// if (states.get(i).getName().compareTo(state) == 0) {
	// return states.get(i);
	// }
	// }
	// return null;
	// }

	public void setWeather(Weather w) {
		this.weather = w;
	}

	public Area getArea(String area) {
		for (int i = 0; i < states.size(); i++) {
			for (int j = 0; j < states.size(); j++) {

				if (states.get(i).getAreas().get(j).getName() == area) {
					if(WISApplication.debug == true){
						System.out.println("This is it" + states.get(i).getAreas().get(j));
					}
					return states.get(i).getAreas().get(j);
				}
			}

		}
		return null;
	}

	public void addFav(Favourites favoriate) {
		// Adds to the favorites list and updates the view
		fav.add(favoriate);
	}

	// public void remFav(Favourites favourite) {
	//
	// for (int i = 0; i < fav.size(); i++) {
	// if
	// (fav.get(i).getArea().getName().compareTo(favourite.getArea().getName())
	// == 0) {
	// fav.remove(i);
	// }
	// }
	// }

	public int getXloc() {
		return xloc;
	}

	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public void setYloc(int yloc) {
		this.yloc = yloc;
	}



}