package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sept01.view.MainView;

/**
 * <p>
 * Displays the panel with Date and time information 
 * on the panel.Acts as a south or a task panel for the
 * WIS application
 * </p>
 * 
 * @author Joshua
 */
public class SouthPanel extends JPanel {

	private static final long serialVersionUID = 427142991179292828L;
	private JLabel clock;

	public SouthPanel(MainView mainView) {

		setLayout(new BorderLayout());
		JLabel label = new JLabel("WIS Applications 2016");
		this.add(label, BorderLayout.WEST);
		
		label.setForeground(Color.white);
		
		setBackground(new Color(64, 64, 72));

		clock = new JLabel();
		clock.setHorizontalAlignment(JLabel.RIGHT);
		
		clock.setForeground(Color.white);

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
