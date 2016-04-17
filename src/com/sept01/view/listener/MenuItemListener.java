package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuItemListener implements ActionListener
{
	
	/*
	 * DISPLAYS THE VERSION INFORMATION OF THE APPLICATION ON 
	 * THE CLICK AND THE LIECENSING INFORMATION
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Shows the version information about the application
		final ImageIcon icon = new ImageIcon("images/WISVersion.png");
        JOptionPane.showMessageDialog(null, "", "About", JOptionPane.INFORMATION_MESSAGE, icon);
		
		
		
	}

}
