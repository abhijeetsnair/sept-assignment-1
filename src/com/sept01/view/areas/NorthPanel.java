package com.sept01.view.areas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sept01.view.MainView;

public class NorthPanel extends JPanel {
	
	public NorthPanel(MainView mainView) {
			
		JLabel label =new JLabel("Weather Information Management System");
		label.setForeground(Color.WHITE);
		 add(label);
		 setBackground(Color.DARK_GRAY);
		
		
		}

}
