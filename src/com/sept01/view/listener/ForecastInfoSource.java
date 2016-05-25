package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sept01.view.areas.ForeCastIODialog;
import com.sept01.view.areas.OpenWeatherDialog;

public class ForecastInfoSource implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonType = ((JButton) e.getSource()).getText();
		// CHECKS TO SEE IF CLICKED BY THE CLOSE ME BUTTON
		if (buttonType.compareTo("ForecastIO.org") == 0) {
		ForeCastIODialog dialog = new ForeCastIODialog();
		dialog.show();
	}
		else if (buttonType.compareTo("OpenWeatherIO.org") == 0) {
			OpenWeatherDialog openDialog = new OpenWeatherDialog();
	}


}
}
