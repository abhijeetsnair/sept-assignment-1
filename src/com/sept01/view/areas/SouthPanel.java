package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.sept01.view.MainView;
import com.sun.org.apache.bcel.internal.generic.FLOAD;

public class SouthPanel extends JPanel {
	private JLabel clock;

	public SouthPanel(MainView mainView) {

		setLayout(new BorderLayout());
		JLabel label = new JLabel("WIS Applications 2016");
		this.add(label, BorderLayout.WEST);
		

		clock = new JLabel();
		clock.setHorizontalAlignment(JLabel.RIGHT);

		tickTock();

		add(clock,BorderLayout.EAST);

		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tickTock();
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
	}

	public void tickTock() {
		clock.setText("Date | Time :"+DateFormat.getDateTimeInstance().format(new Date()));
	}
}
