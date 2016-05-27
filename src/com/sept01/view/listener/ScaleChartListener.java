package com.sept01.view.listener;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import org.jfree.chart.ChartPanel;

public class ScaleChartListener implements ComponentListener{
	ChartPanel panel;
	public ScaleChartListener(ChartPanel chartpanel) {

	this.panel=chartpanel;
	
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		panel.setMaximumDrawHeight(e.getComponent().getHeight());
        panel.setMaximumDrawWidth(e.getComponent().getWidth());
        panel.setMinimumDrawWidth(1000);
        panel.setMinimumDrawHeight(e.getComponent().getHeight());
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
