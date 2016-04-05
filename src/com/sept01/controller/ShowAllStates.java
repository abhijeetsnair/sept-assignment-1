package com.sept01.controller;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sept01.main.Singleton;
import com.sept01.view.areas.CenterPanel;

public class ShowAllStates {
	JScrollPane scrollFrame;
	private Singleton data;

	public ShowAllStates() {

	}

	public ShowAllStates(CenterPanel centrePanel, String state) {

		JPanel slidebar = new JPanel();
		slidebar.setLayout(new BoxLayout(slidebar, BoxLayout.Y_AXIS));
		// States present in Melbourne
		// NSW VIC QLD WA SA TAS ACT NT

		// Ensure you remove components on the UI before you add newer
		// components on the layout

		data = Singleton.getInstance();

		data.initialiseStates();
		centrePanel.removeAll();
		centrePanel.revalidate();
		centrePanel.repaint();

		for (int i = 0; i < data.getStates().size(); i++) {

			if (data.getStates().get(i).getName() == state) {
				for (int j = 0; j < data.getStates().get(i).getCities().size(); j++) {
					System.out.println("state : " + data.getStates().get(i).getCities().get(j).getName());
					String city = data.getStates().get(i).getCities().get(j).getName();
					JButton cities = new JButton(city);
					cities.addActionListener(new CityClickListener());
					slidebar.add(cities);
				}
				scrollFrame = new JScrollPane(slidebar);
				slidebar.setAutoscrolls(true);
				centrePanel.add(scrollFrame, BorderLayout.WEST);
			}

		}

	}

	// Initializes states with new cities

	public void initaliseCities() {

	}

}
