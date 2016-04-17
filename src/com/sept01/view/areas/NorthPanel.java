package com.sept01.view.areas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sept01.view.MainView;

/*
 * Displays the panel on the North with
 * the label WIS management system
 * which is the name of weather management programe
 * 
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
    //ok

	}

}
