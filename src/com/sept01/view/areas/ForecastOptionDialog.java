package com.sept01.view.areas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.sept01.view.listener.ForecastInfoSource;

@SuppressWarnings("serial")
public class ForecastOptionDialog extends JDialog {

	public ForecastOptionDialog() {

		GridLayout layout = new GridLayout(0, 2);

		JPanel panel = new JPanel();
		JButton forecastIO = new JButton("ForecastIO.org");	
		JButton openWeatherIO =new JButton("OpenWeatherIO.org");
		forecastIO.addActionListener(new ForecastInfoSource());
		openWeatherIO.addActionListener(new ForecastInfoSource());
		panel.add(forecastIO);
		panel.add(openWeatherIO);
		panel.setLayout(layout);
		this.setTitle("Choose Forecast Source :");
		this.add(panel);
	}

}
