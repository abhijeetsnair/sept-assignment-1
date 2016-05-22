package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sept01.view.areas.ForecastOptionDialog;


public class ForecastClickListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		ForecastOptionDialog option= new ForecastOptionDialog();
		option.show();
	}

}
