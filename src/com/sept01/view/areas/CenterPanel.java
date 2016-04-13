package com.sept01.view.areas;

import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sept01.controller.CenterViewListener;
import com.sept01.view.MainView;
import com.sept01.view.Metrics;

public class CenterPanel extends JPanel {
	private Image bg;

	public CenterPanel(MainView mainView) {
		// TODO Auto-generated constructor stub
		JPanel dataPanel = new JPanel();
		bg = new ImageIcon("images/background.png").getImage();

		this.setLayout(new BorderLayout());

		setSize(Metrics.centerPanelX, Metrics.centerPanelY);
		
		dataPanel.setOpaque(false);
		this.add(dataPanel, BorderLayout.CENTER);
		
		// Add a mouse listener to this Center Panel
		this.addMouseListener(new CenterViewListener(mainView.getWest(), mainView));

	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}

	public void setBackgroundLocation(String location) {

		if (location.compareTo("NSW") == 0) {
			bg = new ImageIcon("images/NSW.PNG").getImage();
			System.out.println(this.getWidth());
		}

		if (location.compareTo("VIC") == 0) {
			bg = new ImageIcon("images/VIC.PNG").getImage();
		}

		if (location.compareTo("QLD") == 0) {
			bg = new ImageIcon("images/QLD.PNG").getImage();
		}

		if (location.compareTo("WA") == 0) {
			bg = new ImageIcon("images/WA.PNG").getImage();
		}

		if (location.compareTo("SA") == 0) {
			bg = new ImageIcon("images/SA.PNG").getImage();
		}
		if (location.compareTo("TAS") == 0) {
			bg = new ImageIcon("images/TAS.PNG").getImage();
		}
		if (location.compareTo("ACT") == 0) {
			bg = new ImageIcon("images/ACT.PNG").getImage();
		}

		if (location.compareTo("NT") == 0) {
			bg = new ImageIcon("images/NT.PNG").getImage();
		}
		if (location.compareTo("ANT") == 0) {
			bg = new ImageIcon("images/ANTARTICA.PNG").getImage();
		}	
			
		if (location.compareTo("Default") == 0) {
			bg = new ImageIcon("images/background.png").getImage();
		}	
			//getScaledInstance(this.getHeight(), this.getWidth(),java.awt.Image.SCALE_SMOOTH)
		
	}

}
