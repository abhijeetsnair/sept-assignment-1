package com.sept01.main;

import java.util.HashMap;

public class WISApplication {
	static Weather weather;

	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println(" :D ");
		initializeWeather();
		State state = weather.getStateWeather("vic");

		for (int x = 0; x < state.areas.size(); x++) {
			for (int i = 0; i < state.areas.get(x).weatherStations.size(); i++) {

				HashMap[] weatherD = state.areas.get(x).weatherStations.get(i).getData();
				System.out.println(weatherD[0].get("local_date_time")+" "
						+ state.areas.get(x).weatherStations.get(i).stateName + " Weather station "
						+ weatherD[0].get("name") + " Wind speed: " + weatherD[0].get("wind_spd_kmh") + "kmh");
			}
		}

	}

	public static void initializeWeather() {

		weather = new Weather();

		// System.out.println(weather.states[0].areas.get(1).getName());
		// for(int i = 0; i < weather.states.length ; i++){
		// System.out.println(weather.states[i].name);
		// }

	}

	public void showInfo() {
		return;
	}

	public void storeFav() {
		return;
	}

	public void updateView() {
		return;
	}

	public void refreshView() {
		return;
	}

	public void adjustWindow() {
		return;
	}

	public void reportError() {

	}

	private void getUser() {
		return;
	}

	private void getInto(State state) {
		return;
	}

}
