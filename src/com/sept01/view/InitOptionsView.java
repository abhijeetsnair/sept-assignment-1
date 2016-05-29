package com.sept01.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sept01.model.Singleton;

public class InitOptionsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InitOptionsView view;

	/**
	 * Create the application.
	 */
	public InitOptionsView() {
		view = this;
		initialize();
	}

	/**
	 * Initialize the contents of the
	 */
	private void initialize() {
		setResizable(false);
		setBounds(200, 200, 700, 350);

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(64, 64, 72));
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblSelectSource = new JLabel("Select source");
		lblSelectSource.setForeground(Color.ORANGE);
		lblSelectSource.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblSelectSource);

		BackGLabel panelButtons = new BackGLabel();
		panelButtons.setBackground(new Color(64, 64, 72));
		getContentPane().add(panelButtons, BorderLayout.CENTER);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		@SuppressWarnings("unused")
		ImageIcon myImage = new ImageIcon("images/myImage.jpg");

		JButton buttonLeft = new JButton(new ImageIcon("images/forecast.png"));
		buttonLeft.setOpaque(false);
		buttonLeft.setContentAreaFilled(false);
		buttonLeft.setBorderPainted(false);
		buttonLeft.setFocusPainted(false);
		buttonLeft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				MainView view = new MainView();
				view.setVisible(true);
				Singleton.getInstance().source = 0;
				close();
			}
		});

		panelButtons.add(buttonLeft);

		JButton buttonRight = new JButton(new ImageIcon("images/openweather.png"));
		buttonRight.setOpaque(false);
		buttonRight.setContentAreaFilled(false);
		buttonRight.setBorderPainted(false);
		buttonRight.setFocusPainted(false);
		panelButtons.add(buttonRight);

		buttonRight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Execute when button is pressed
				MainView view = new MainView();
				view.setVisible(true);
				Singleton.getInstance().source = 1;
				close();
			}
		});
	}

	public void close() {
		dispose();
	}
}
