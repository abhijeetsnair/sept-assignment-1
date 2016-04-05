package com.sept01.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.sept01.view.areas.Dialog;

public class JDialogListener implements ActionListener {
	
	Dialog dialog;	
	
	public JDialogListener(Dialog dialog) {
	this.dialog =dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String buttonType =((JButton) arg0.getSource()).getText();
		if(buttonType.compareTo("Close me")==0)
		{
			System.out.println("disposing the window..");
		dialog.dispose();
		}
			
		if(buttonType.compareTo("Show Graph")==0)
		{	
			 final ImageIcon icon = new ImageIcon("histogram.PNG");
		        JOptionPane.showMessageDialog(null, "Blah blah blah", "About", JOptionPane.INFORMATION_MESSAGE, icon);	
		}
	}

}
