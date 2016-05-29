package com.sept01.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sept01.model.Singleton;

public class InitOptionsView extends JFrame {

	/**
	 * INTI OPTION VIEW INITIALISES THE VIEW SO THAT THE USER CAN CHOOSE BETWEEN
	 * FORECAST IO OR OPENWEATHER THIS CHOICE THEN PERSISTS TILLTHE TIME THE
	 * APPLICATION RUNS THE CHOICE MADE BY THE USER IS REMEMBERED THROUGHOUT THE
	 * APPLICATION
	 */
	private static final long serialVersionUID = 1L;
	InitOptionsView view;

	/**
	 * Create the application.
	 */
	public InitOptionsView() {
		view = this;
		initialize();
	}

	/**
	 * Initialize the contents of the
	 */
	private void initialize() {
		setResizable(false);

		setBounds(200, 200, 700, 350);

		getContentPane().setLayout(new BorderLayout(0, 0));

		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
		setTitle("WISApplication");
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(64, 64, 72));
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblSelectSource = new JLabel("Select source");
		lblSelectSource.setForeground(Color.ORANGE);
		lblSelectSource.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblSelectSource);

		/*
		 * THE DISPLAY HAS TWO BUTTONS FORECASTIO BUTTON AND OPENWEATHER.PNG
		 * BUTTON. THE USER CAN CHOOSE BETWEEN THE TWO THE CHOICE MADE BY THE
		 * USER IS THEN STORED IN THE SINGLETON
		 */
		BackGLabel panelButtons = new BackGLabel();
		panelButtons.setBackground(new Color(64, 64, 72));
		getContentPane().add(panelButtons, BorderLayout.CENTER);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		@SuppressWarnings("unused")
		ImageIcon myImage = new ImageIcon("images/myImage.jpg");
		// UI COMPONENTS TO SELECT FORECAST.IO
		JButton buttonLeft = new JButton(new ImageIcon("images/forecast.png"));
		buttonLeft.setOpaque(false);
		buttonLeft.setContentAreaFilled(false);
		buttonLeft.setBorderPainted(false);
		buttonLeft.setFocusPainted(false);
		buttonLeft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				MainView view = new MainView();
				view.setVisible(true);
				Singleton.getInstance().source = 0;
				close();
			}
		});

		panelButtons.add(buttonLeft);
		//UI COMPONENTS TO SELECT OPENWEATHER.ORG
		JButton buttonRight = new JButton(new ImageIcon("images/openweather.png"));
		buttonRight.setOpaque(false);
		buttonRight.setContentAreaFilled(false);
		buttonRight.setBorderPainted(false);
		buttonRight.setFocusPainted(false);
		panelButtons.add(buttonRight);

		buttonRight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				MainView view = new MainView();
				view.setVisible(true);
				Singleton.getInstance().source = 1;
				close();
			}
		});
	}
// CLOSES THE DISPLAY
	public void close() {
		dispose();
	}
}
