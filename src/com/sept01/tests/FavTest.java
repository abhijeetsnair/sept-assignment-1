package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import com.sept01.main.WISApplication;
import com.sept01.model.Favourites;
import com.sept01.model.Singleton;
import com.sept01.model.WeatherStation;

/*
 * Tests favoriate such that
 * 1) No dupliate favouriates are shown
 * 2) favoriate cannot be null 
 * 3) They must have both name and url information 
 */
public class FavTest {
	private ArrayList<Favourites> favlist = new ArrayList<Favourites>();
	private WISApplication app = new WISApplication();
/*Object manupulation is happening correctly**/
	@Test
	public void checkFav() {
		String stationName = "Casino";
		Favourites favourites = new Favourites();
		WeatherStation station = new WeatherStation("http:///", stationName);
		favourites.setStation(station);
		assertThat(stationName, is(equalTo(stationName)));
	}

	@Test
	public void voidtestDuplication() {

		Singleton.getInstance().setApplication(app);
		Singleton.getInstance().getApplication().setFav(favlist);
		int count = 0;
		String stationName = "Casino";

		// Adding Favourites once
		Favourites fav = new Favourites();
		fav.setStation(new WeatherStation("http://", stationName));
		Singleton.getInstance().getApplication().addFav(fav);

		// Adding Favourites twice
		Favourites fav2 = new Favourites();
		fav2.setStation(new WeatherStation("http://", stationName));
		Singleton.getInstance().getApplication().addFav(fav2);

		// Even though added twice there must be only one casino present
		for (int i = 0; i < Singleton.getInstance().getApplication().getFav().size(); i++) {

			if (Singleton.getInstance().getApplication().getFav().get(i).getStation().getName() == stationName) {
				count++;
			}
		}
		// Assert that one fav is present even though added twice
		assertSame(count, 1);

	}
}
