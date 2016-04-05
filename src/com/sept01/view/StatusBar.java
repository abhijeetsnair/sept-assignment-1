package com.sept01.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	public StatusBar(MainView mainView) {
		
		
	// The status bar just contains the WIS APPLICATION TITLE	
	this.setSize(getMaximumSize());
		JLabel label =new JLabel("WIS APPLICATION");
		this.add(label);
	
	}

}
