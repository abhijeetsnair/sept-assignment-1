package com.sept01.view.listener;

import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import com.sept01.utility.Preferences;
import com.sept01.view.MainView;

/*	
 *ACTS A MAIN WINDOW LISTENER TO THE 
 * ENTIRE UI OF THE WISAPLICATION ON STARTING THE APPLICATION 
 * THE LISTENER READS ALL OF THE FAVORIATES AND LOCATION TO THE APPLICATION 
 * WHEREAS ON CLOSING THE APPLICAION IT SAVES ALL OF THE FAVORIATES TO THE TEXT FILE 
 */
public class MainViewWindowListener implements WindowListener {
	
	Preferences prefs = new Preferences();
	
	public MainViewWindowListener(MainView mainView) {
		prefs.readScreenLocation();
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Point loc = arg0.getWindow().getLocationOnScreen();
		prefs.saveScreenLocation(loc);
		prefs.saveFavourite();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
