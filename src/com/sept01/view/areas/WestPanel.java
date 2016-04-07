package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sept01.controller.StateButtonHoverListener;
import com.sept01.view.MainView;

@SuppressWarnings("serial")
public class WestPanel extends JPanel {
	private MainView view;
	public WestPanel(MainView mainView) {
		this.setView(mainView);
		this.setLayout(new BorderLayout());
		JPanel TextPanel = new JPanel();

		GridLayout layout = new GridLayout(9, 1, 5, 5);
		TextPanel.setLayout(layout);

		JButton NSW = new JButton("NSW");
		JButton VIC = new JButton("VIC");
		JButton QLD = new JButton("QLD");
		JButton WA = new JButton("WA");
		JButton SA = new JButton("SA");
		JButton TAS = new JButton("TAS");
		JButton ACT = new JButton("ACT");
		JButton NT = new JButton("NT");
		JButton ANTARTICA = new JButton("ANTARTICA");

		// Adding Listeners to the button
		NSW.addMouseListener(new StateButtonHoverListener(this, NSW));
		VIC.addMouseListener(new StateButtonHoverListener(this, VIC));
		QLD.addMouseListener(new StateButtonHoverListener(this, QLD));
		WA.addMouseListener(new StateButtonHoverListener(this, WA));
		SA.addMouseListener(new StateButtonHoverListener(this, SA));
		TAS.addMouseListener(new StateButtonHoverListener(this, TAS));
		ACT.addMouseListener(new StateButtonHoverListener(this, ACT));
		NT.addMouseListener(new StateButtonHoverListener(this, NT));
		ANTARTICA.addMouseListener(new StateButtonHoverListener(this, ANTARTICA));

		TextPanel.add(NSW);
		TextPanel.add(VIC);
		TextPanel.add(QLD);
		TextPanel.add(WA);
		TextPanel.add(SA);
		TextPanel.add(TAS);
		TextPanel.add(ACT);
		TextPanel.add(NT);
		TextPanel.add(ANTARTICA);

		this.add(TextPanel);

		Border blackline;

		blackline = BorderFactory.createLineBorder(Color.black);
		TextPanel.setBorder(blackline);

		setBackground(Color.DARK_GRAY);

	}

	public MainView getView() {
		return view;
	}

	public void setView(MainView view) {
		this.view = view;
	}

}
