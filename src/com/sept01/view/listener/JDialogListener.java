package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.jfree.data.category.DefaultCategoryDataset;

import com.sept01.main.WISApplication;
import com.sept01.view.areas.Dialog;

/*
 *NOTE:-
 *LISTENER FOR THE DIALOG IN THE DIALOG 
 * WHICH SHOWS CITY INFORMATION
 * THE LISTENER LISTENS TO A CLOSE ME BUTTON
 * WHEREIN IT DISPOSES THE DIALOG ON CLICKING THE
 * CLOSE ME BUTTON
 *
 */
public class JDialogListener implements ActionListener {

	Dialog dialog;
	DefaultCategoryDataset dataset;
	public JDialogListener(Dialog dialog, DefaultCategoryDataset dataset) {
		this.dialog = dialog;
		this.dataset=dataset;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String buttonType = ((JButton) arg0.getSource()).getText();
		// CHECKS TO SEE IF CLICKED BY THE CLOSE ME BUTTON
		if (buttonType.compareTo("clear") == 0) {
			if(WISApplication.debug == true){
				System.out.println("disposing the window..");
			}
			dataset.clear();
		}

	}

}
