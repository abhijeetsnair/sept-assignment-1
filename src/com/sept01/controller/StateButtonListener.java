package com.sept01.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*NOTE:
 *STATE BUTTON LISTENER IMPLEMENTS THE MOUSLISTENER CLASS WHERE ALL THE ACTIONS OF THE MOUSE OVER A PARTICULAR STATE
 *GETS TRACKED THE IN THE LISTENER THE COLOR OF THE BUTTON OVER THE CHANGES.
 *THE LISTENER ALSO SETS COLORS OVER THE BUTTONS SO THAT THEY LOOK 
 *APPEALING TO THE USER AND UI LOOKS FANCY.
 */
/**
 * A {@link JButton} Listener that implements {@link MouseListener} . To be used
 * for State Button related functions in the {@link WestPanel}
 * 
 * @version 1.0
 * @see JButton
 * @see WestPanel
 */
public class StateButtonListener implements MouseListener {

	JPanel[] jPanel;
	JButton jButton;

	Color backColorDef;// = new Color(0, 0, 8, (int) (256 * 0.6f));
	Color backColorHover;// = new Color(64, 64, 64, (int) (256 * 0.6f));

	boolean noAlpha;

	/**
	 * Main Constructor
	 * 
	 * @param jPanel
	 *            the JPanels array that we will call repaint() on
	 * @param jButton
	 *            The affected JButton of this listener
	 * @param noAlpha
	 */
	public StateButtonListener(JPanel[] jPanel, JButton jButton, boolean noAlpha) {
		this.jPanel = jPanel;
		this.jButton = jButton;
		this.noAlpha = noAlpha;

		jButton.setForeground(Color.ORANGE);

		jButton.setFont(new Font("Verdana", Font.PLAIN, 40));

		jButton.setFocusPainted(false);
		jButton.setFocusable(false);

		if (noAlpha) {
			backColorDef = new Color(0, 0, 8);
			backColorHover = new Color(64, 64, 64);
		} else {
			backColorDef = new Color(0, 0, 8, (int) (256 * 0.6f));
			backColorHover = new Color(64, 64, 64, (int) (256 * 0.6f));
		}

		jButton.setBackground(backColorDef);

		// jButton.setOpaque(true);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}
	}

	public StateButtonListener(JPanel[] jPanel, JButton jButton, boolean noAlpha, int size) {
		this.jPanel = jPanel;
		this.jButton = jButton;
		this.noAlpha = noAlpha;

		jButton.setForeground(Color.ORANGE);

		jButton.setFont(new Font("Verdana", Font.PLAIN, size));

		jButton.setFocusPainted(false);
		jButton.setFocusable(false);

		if (noAlpha) {
			backColorDef = new Color(64, 64, 72);
			backColorHover = new Color(128, 128, 128);
		} else {
			backColorDef = new Color(0, 0, 8, (int) (256 * 0.6f));
			backColorHover = new Color(64, 64, 64, (int) (256 * 0.6f));
		}

		jButton.setBackground(backColorDef);

		// jButton.setOpaque(true);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}
	}

	// THE MOUSE CLICK REPONDS TO THE MOUSEEVENT
	@Override
	public void mouseClicked(MouseEvent e) {
		jButton.setForeground(Color.ORANGE);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}
	}

	// GETS TRIGGERED WHEN THE MOUSE IS PRESSED
	@Override
	public void mousePressed(MouseEvent e) {
		jButton.setForeground(Color.WHITE);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}
	}

	// GETS TRIGGERED WHEN THE MOUSE IS RELEASED
	@Override
	public void mouseReleased(MouseEvent e) {
		jButton.setForeground(Color.ORANGE);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}
	}

	// GETS TRIGGERED WHEN THE MOUSE IS ENTERED
	@Override
	public void mouseEntered(MouseEvent e) {
		jButton.setForeground(Color.WHITE);
		jButton.setBackground(backColorHover);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}

	}

	// GETS TRIGGERED WHEN THE MOUSE IS EXITED
	@Override
	public void mouseExited(MouseEvent e) {
		jButton.setForeground(Color.ORANGE);
		jButton.setBackground(backColorDef);

		jButton.repaint();
		for (JPanel panel : jPanel) {
			panel.repaint();
		}
	}

}
