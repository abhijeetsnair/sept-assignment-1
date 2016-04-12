package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sept01.view.areas.Dialog;

public class FavClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String weather_station_clicked = ((JButton) arg0.getSource()).getText();
//		Dialog dialog = new Dialog(new JFrame(), weather_station_clicked,
//				"Latest Weather Observation for " + weather_station_clicked,state);
//		// set the size of the window
//		dialog.setSize(900, 400);

	}

}
