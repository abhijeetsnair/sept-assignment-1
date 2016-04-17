package com.sept01.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

import com.sept01.view.areas.CenterPanel;
import com.sept01.view.areas.WestPanel;

/*NOTE:-
 * THE STATE BUTTON HOVER LISTENER GETS TRIGGERED WHEN THE 
 * WE HOVER OVER DIFFERENT STATES CAUSING THE STATE 
 * INFORMATION TO CHANGE.HOVERING OVER DIFFERENT STATES
 * CAUSES THE BACKGROUND OF THE CENTRE PANEL TO CHANGE
 * SUCH THAT THE NEW BACKGROUND SHOWS THE STATES HIGHLIGHTED
 */
public class StateButtonHoverListener implements MouseListener {
	WestPanel panel;
	JButton button;

	public StateButtonHoverListener(WestPanel westPanel, JButton selButton) {
		panel = westPanel;
		button = selButton;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		/*
		 * When we click the button on the panel we must obtain information
		 * regarding the stations of the particular location Show all states
		 * essentially shows all the states present in the particular state
		 */
		CenterPanel centrePanel = panel.getView().getCenter();
		String State = ((JButton) arg0.getSource()).getText();
		// JOptionPane.showMessageDialog(panel, State);
		new ShowAllStates(centrePanel, State, panel);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		/*
		 * The function changes the image of the main panel to change it to the
		 * picture of the specified location. Each time we hover over an image
		 * the image of the center panel gets changed to the location we hover
		 * over.
		 */
		String buttonText = ((JButton) arg0.getSource()).getText();
		button.setBackground(Color.white);
		panel.getView().getCenter().setBackgroundLocation(buttonText);
		panel.getView().getCenter().repaint();
		panel.getView().getCenter().revalidate();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		/*
		 * Once we exit the button the panel needs to be rechanged to the
		 * default image which the image of all the states present in the
		 * location
		 */
		button.setBackground(null);
		panel.getView().getCenter().setBackgroundLocation("Default");
		panel.getView().getCenter().repaint();
		panel.getView().getCenter().revalidate();
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
