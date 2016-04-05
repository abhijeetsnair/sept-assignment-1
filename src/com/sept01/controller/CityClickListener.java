package com.sept01.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sept01.main.Area;
import com.sept01.main.Favourites;
import com.sept01.main.Singleton;
import com.sept01.main.User;
import com.sept01.main.WISApplication;
import com.sept01.view.areas.Dialog;

public class CityClickListener implements ActionListener {
	private ShowAllStates states = new ShowAllStates();

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String buttonClicked = ((JButton) arg0.getSource()).getText();
		String title = "Location: " + ((JButton) arg0.getSource()).getText();
		Dialog dialog = new Dialog(new JFrame(), title, "Latest Weather Observation for " +buttonClicked);	
		
		// set the size of the window
		dialog.setSize(300, 150);
		WISApplication application = new WISApplication();

		Favourites fav = new Favourites();
		//fav.setUser(new User("Anonnymous", "0415397357", "He"));

		System.out.println("Button Clickeed :" + buttonClicked);

		Area areaclicked = Singleton.getInstance().getArea(buttonClicked);
		System.out.println("Name of the area " + areaclicked.getName());

		//fav.setArea(areaclicked);
		Singleton.getInstance().addFav(fav);

		// Attempting to see if the change in data gets reflected over
		// favouriates
		Singleton data = Singleton.getInstance();
		data.getEastPanel().addFavoriates();
		data.getEastPanel().repaint();
		data.getEastPanel().revalidate();

		System.out.println("-------");

		for (int i = 0; i < Singleton.getInstance().getFav().size(); i++) {
			//System.out.println("Favoriates" + Singleton.getInstance().getFav().get(i).getArea().getName());
		}

		// System.out.println("Comes here on clicks");
		// JFrame frame = new JFrame();
		// frame.setTitle("Charlton-Temperature");
		// frame.setSize(800, 400);
		// frame.setLocationRelativeTo(null);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
