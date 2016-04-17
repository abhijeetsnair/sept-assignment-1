package com.sept01.view.areas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sept01.view.MainView;

/**
 * <p>
 * Displays the panel on the North with
 * the label WIS management system
 * which is the name of weather management programe
 * </p>
 * 
 * @version 1.0
 */
public class NorthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NorthPanel(MainView mainView) {

		JLabel label = new JLabel("Weather Information Management System");
		label.setForeground(Color.ORANGE);
		add(label);
		setBackground(new Color(64, 64, 72));

	}

}
