package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sept01.model.WeatherStation;
import com.sept01.view.MainView;
import com.sept01.view.areas.Dialog;
/*NOTE :
 * CITY CLICK LISTENER GETS CALLED WHEN A CITY IS CLICKED
 * AFTER CHOOSING A PARTICULAR STATE TO DISPLAY INFORMATION
 * THE CITY CLICK LISTENER SIMPLY TRIGGERS A DIALOG TO DISPLAY 
 * INFORMATION ABOUT THAT PARTICULAR CITY OR WEATHER STATION
 */
public class CityClickListener implements ActionListener {
	private String state;
	private WeatherStation weatherStation;
	private boolean favflag;
	private float relativePercentageW = 0.7f;
	private float relativePercentageH = 0.8f;
	private int w;
	private int h;
	
	public CityClickListener(String State, WeatherStation weatherStation) {
		 this.state =State;
		 this.weatherStation = weatherStation;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String weather_station_clicked = ((JButton) arg0.getSource()).getText();

		/*
		 * Opening a dialog window to display information of the weather station
		 * clicked
		 */
		Dialog dialog = new Dialog(new JFrame(), weather_station_clicked,
				"Latest Weather Observation for " + weather_station_clicked,state,weatherStation);

		/*set the size of the Dialog window*/
		MainView mv = new MainView();
		w = (int) (mv.getRelativeSizeX() * relativePercentageW);
		h = (int) (mv.getRelativeSizeY() * relativePercentageH);
		dialog.setSize(w,h);

	}
	
	/*Sets the fav flag on a favorite object*/
	public void setFavFlag(boolean b) {
		this.setFavflag(b);
		
	}

	public boolean isFavflag() {
		return favflag;
	}

	public void setFavflag(boolean favflag) {
		this.favflag = favflag;
	}

}
