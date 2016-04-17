package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

	public JDialogListener(Dialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String buttonType = ((JButton) arg0.getSource()).getText();
		// CHECKS TO SEE IF CLICKED BY THE CLOSE ME BUTTON
		if (buttonType.compareTo("Close me") == 0) {
			System.out.println("disposing the window..");
			dialog.dispose();
		}

	}

}
