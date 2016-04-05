package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sept01.controller.JDialogListener;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable jt;

	public Dialog(JFrame parent, String title, String message) {
		super(parent, title);
		String[] coloumns = { "Date", "Temp", "App Temp", "Dew Point", "Rel Hum", "Delta-T", "D/r", "Spd", "Gust",
				"Spd", "Gust", "QNH", "MSL", "Rain" };
		String data[][] = new String[14][14];

		for (int i = 0; i < data.length; i++) {

			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = i + " " + j;
				data[i][j] = i + " " + j;
				System.out.println("This is the data " + i + j + "    " + data[i][j]);
			}

		}

		jt = new JTable(data, coloumns);
		jt.setPreferredScrollableViewportSize(new Dimension(600, 200));
		jt.setFillsViewportHeight(true);

		// Panel to show graph and Display Message
		JPanel showGraph = new JPanel();
		JButton showGraphButton = new JButton("Show Graph");
		showGraphButton.addActionListener(new JDialogListener(this));
		showGraph.setLayout(new FlowLayout());
		showGraph.add(new JLabel(message));
		showGraph.add(showGraphButton);

		// Create a button
		JPanel buttonPane = new JPanel();
		buttonPane.add(showGraph);
		JScrollPane jps = new JScrollPane(jt);
		buttonPane.add(jps);

		JPanel CloseMe = new JPanel();
		JButton closeMe = new JButton("Close me");
		CloseMe.add(closeMe);

		// set action listener on the button
		closeMe.addActionListener(new JDialogListener(this));

		getContentPane().add(buttonPane);
		getContentPane().add(CloseMe, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

}