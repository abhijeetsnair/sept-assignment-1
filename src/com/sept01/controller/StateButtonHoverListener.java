package com.sept01.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.sept01.view.areas.CenterPanel;
import com.sept01.view.areas.WestPanel;

public class StateButtonHoverListener implements MouseListener {
	WestPanel panel;
	JButton button;

	public StateButtonHoverListener(WestPanel westPanel, JButton selButton) {
		panel = westPanel;
		button = selButton;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		CenterPanel centrePanel = panel.getView().getCenter();
		String State = ((JButton) arg0.getSource()).getText();
//		JOptionPane.showMessageDialog(panel, State);
		new ShowAllStates(centrePanel, State);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		String buttonText = ((JButton) arg0.getSource()).getText();
		button.setBackground(Color.white);
		panel.getView().getCenter().setBackgroundLocation(buttonText);
		panel.getView().getCenter().repaint();
		panel.getView().getCenter().revalidate();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
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
