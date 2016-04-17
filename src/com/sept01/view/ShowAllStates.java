package com.sept01.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sept01.AreaController.AreaButtonListener;
import com.sept01.main.WISApplication;
import com.sept01.model.Area;
import com.sept01.model.Singleton;
import com.sept01.model.State;
import com.sept01.view.areas.CenterPanel;
import com.sept01.view.areas.WestPanel;
import com.sept01.view.listener.CityClickListener;
/*NOTE:
 *SHOW ALL STATES CLASS ENSURES THAT ALL THE STATES ARE SHOWN ON THE 
 *SLIDEBAR PANEL WHICH IS A CLICKABLE PANEL.THE PANEL IS SHOWN WHEN 
 *A PARTICULAR STATE IS CLICKED. ALL THE CITIES/STATIONS PRESENT IN
 *THE PARTICULAR STATE ARE SHOWN ON THE SIDEPANEL. 
 * THE SIDEPANEL CAN BE COLLAPSED BY CLICKING ON THE CENTERPANEL.
 */
/**
 * A Class that initialises all the states at the start, thereby creating a
 * button for each state.
 */
public class ShowAllStates {
	JScrollPane scrollFrame;
	static State state;

	public ShowAllStates() {

	}

	public ShowAllStates(CenterPanel centrePanel, String clked_state, WestPanel westPanel) {
		/*
		 * slidebar is the bar on which all the cities(button elements gets
		 * added)
		 **/
		JPanel slidebar = new JPanel();
		slidebar.setLayout(new BoxLayout(slidebar, BoxLayout.Y_AXIS));

		slidebar.setBorder(null);
		slidebar.setBackground(new Color(32, 32, 32));
		slidebar.setForeground(Color.WHITE);
		slidebar.setOpaque(true);

		// States present in Melbourne
		// NSW VIC QLD WA SA TAS ACT NT
		// Set the current state panel for west panel (related to center panel
		// clicking - removal of west panel)
		westPanel.setCurrentStatePanel(slidebar);
		// Ensure you remove components on the UI before you add newer
		// components on the layout
		Singleton.getInstance();
		centrePanel.removeAll();
		centrePanel.revalidate();
		centrePanel.repaint();

		/*
		 * Displays all the weather stations Get all the weather stations
		 * present in a particular state and display it
		 */
		state = Singleton.getInstance().getWeather().getStateWeather(clked_state.toLowerCase());
		for (int x = 0; x < state.getAreas().size(); x++) {

			/**
			 * Displays the area in a particular state as a JLabel under which
			 * it displays the weather stations present in that area
			 **/

			Area area = state.getAreas().get(x);
			JLabel area_label = new JLabel(area.getName());
			area_label.setForeground(new Color(192, 192, 192));

			slidebar.add(area_label);

			/**
			 * Displays the weather stations present in the area and attaches a
			 * click listener to the button so that button click event can be
			 * captured
			 */

			for (int i = 0; i < state.getAreas().get(x).getWeatherStations().size(); i++) {
				JPanel buttonPanel = new JPanel();
				// Setting the layout of the button panel
				buttonPanel.setLayout(new GridLayout(1, 2));
				buttonPanel.setBorder(null);
				buttonPanel.setFocusable(false);
				buttonPanel.setBackground(null);
				buttonPanel.setOpaque(true);
				if(WISApplication.debug == true){
					System.out.println(state.getAreas().get(x).getWeatherStations().get(i).getName());
				}
				String name = (String) state.getAreas().get(x).getWeatherStations().get(i).getName();
				//Adds the states/stations to the slidebar panel
				JButton stations = new JButton(name);
				stations.addActionListener(new CityClickListener(clked_state.toLowerCase(),
						state.getAreas().get(x).getWeatherStations().get(i)));
				buttonPanel.add(stations);
				slidebar.add(buttonPanel);
				stations.setBorder(null);
				stations.setFocusable(false);
				stations.addMouseListener(new AreaButtonListener(new JPanel[] { buttonPanel, slidebar }, stations));
			}
			
			// Makes the pane scrollable
			scrollFrame = new JScrollPane(slidebar);
			slidebar.setAutoscrolls(true);
			centrePanel.add(scrollFrame, BorderLayout.WEST);

		}

	}

}
