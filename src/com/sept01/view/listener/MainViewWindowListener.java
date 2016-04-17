package com.sept01.view.listener;

import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import com.sept01.utility.ReadScreenLoc;
import com.sept01.utility.SaveFavourite;
import com.sept01.utility.SaveScreenLocation;
import com.sept01.view.MainView;

/*	
 *ACTS A MAIN WINDOW LISTENER TO THE 
 * ENTIRE UI OF THE WISAPLICATION ON STARTING THE APPLICATION 
 * THE LISTENER READS ALL OF THE FAVORIATES AND LOCATION TO THE APPLICATION 
 * WHEREAS ON CLOSING THE APPLICAION IT SAVES ALL OF THE FAVORIATES TO THE TEXT FILE 
 */
public class MainViewWindowListener implements WindowListener {

	public MainViewWindowListener(MainView mainView) {
		new ReadScreenLoc();
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
		new SaveScreenLocation(loc);
		new SaveFavourite();

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
