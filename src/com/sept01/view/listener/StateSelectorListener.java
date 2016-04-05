package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class StateSelectorListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
        String petName = (String)cb.getSelectedItem();

        JOptionPane.showInputDialog(e.getSource(),
                "you clicked this + " );
            System.exit(0);
          }
	}
		
