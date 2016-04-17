package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sept01.model.Singleton;
import com.sept01.model.State;
import com.sept01.model.WeatherStation;
import com.sept01.view.listener.AddtoFavListener;
import com.sept01.view.listener.JDialogListener;
import com.sept01.view.listener.RemFavListener;

public class Dialog extends JDialog {
	/**
	 * DIALOG SHOWS INFORMATION IN THE FORM OF 1) TABLE 2) CHART TABLE SHOWS
	 * INFORMATON ABOUT DATE,AIR,TEMP,ETC ALL THE IMPORTANT WEATHER INFORMATION
	 * PERTAINING TO LOCATION
	 */
	private static final long serialVersionUID = 1L;
	private JTable jt;
	private String state_name;
	@SuppressWarnings("rawtypes")
	private HashMap[] weatherD;
	private boolean addorRemoveFav = false;
	String weather_station, message;
	WeatherStation weatherStation;
	String data[][];
	private String[] coloumns = { "Date", "Air Temp", "App Temp", "Dew Point", "Rel Hum", "Delta-T", "Wind Dir",
			"Spd kmh", "Gust kmh", "Spd kt", "Gust kt", "QNH", "MSL", "Rain since 9am", "Cloud", "Cloud Base M",
			"Cloud Oktas", "Cloud Type", "Vis km" };

	public Dialog(JFrame parent, String weather_station, String message, String state_name,
			WeatherStation weatherStation) {
		super(parent, weather_station);
		this.state_name = state_name;
		this.weather_station = weather_station;
		this.message = message;
		this.weatherStation = weatherStation;
		// Fetch the data for the table
		data = getTData(data);

		// Adding a Table to display the weather information
		jt = new JTable(data, coloumns);
		jt.setPreferredScrollableViewportSize(new Dimension(900, 500));
		jt.setFillsViewportHeight(true);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jps = new JScrollPane(jt);
		/**
		 * Checks if the particular station is already present in the favorite
		 * list
		 */
		addorRemoveFav = CheckifPresentinFav(weather_station);
		// Main Panel
		JPanel showInfo = new JPanel();
		showInfo.setLayout(new BoxLayout(showInfo, BoxLayout.Y_AXIS));
		// Adding a scroll pane to the JPanel
		// Displaying the Message Label and hide label
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		JLabel msgLabel = new JLabel(message, JLabel.CENTER);
		messagePanel.add(msgLabel, BorderLayout.CENTER);
		JPanel labelPanel = new JPanel();

		/***
		 * THE REFRESH BUTTON ENABLES THE USER TO REFERSH THE PAGE TO SHOW THE
		 * LATEST INFORMATION ABOUT THE APPLICATION
		 */
		JButton refresh = new JButton("Refresh");
		labelPanel.add(refresh);
		refresh.addActionListener(e -> DataRefresh(refresh));

		/***
		 * THE ADD TO FAVORIATES OR REMOVE FAVORIATES OPENS UP DEPENDING ON
		 * WEATHER THE APPLICATION HAS ALREADY BEEN SELECTED TO BE A FAVORIATE
		 * OR IS NOT A FAVORIATE DEPENDING UPON THE ADD OR REMOVEFAV FLAG
		 */

		if (addorRemoveFav == false) {
			JButton add = new JButton("+ Add Favourites");
			add.addActionListener(new AddtoFavListener(weather_station, weatherStation));
			labelPanel.add(add);
		}

		/***
		 * IF THE FLAG IS TRUE THEN WE SHOW THEM THE REMOVE FAVORIATE BUTTON
		 * WHICH WHEN THEY CLICK TRIGGERS A LISTENER THAT REMOVES THE FAVORIATES
		 * FROM THE LIST
		 */
		else if (addorRemoveFav == true) {
			JButton remove = new JButton("- Remove Favourites");
			remove.addActionListener(new RemFavListener(weather_station, weatherStation));
			labelPanel.add(remove);
		}
		messagePanel.add(labelPanel, BorderLayout.EAST);
		showInfo.add(messagePanel);

		// Create an Pane to display the table information
		JPanel infoPane = new JPanel();
		infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.Y_AXIS));

		infoPane.add(messagePanel);
		infoPane.add(jps, BorderLayout.WEST);
		showInfo.add(infoPane);

		// Graph Pane to display graph information
		JPanel showGraph = new JPanel();
		showGraph.setLayout(new BorderLayout());

		JPanel labelNGraph = new JPanel();
		labelNGraph.setLayout(new BoxLayout(labelNGraph, BoxLayout.Y_AXIS));

		JPanel graphLabel = new JPanel();
		graphLabel.setLayout(new BorderLayout());
		JLabel label = new JLabel("Temperature graphs for 9 am,3pm,max and min", JLabel.CENTER);
		graphLabel.add(label);

		JPanel tempgraphs = new JPanel();
		tempgraphs.setLayout(new BoxLayout(tempgraphs, BoxLayout.X_AXIS));
		show9pm3pmGraph(tempgraphs, data);
		showMaxMinGraph(tempgraphs, data);

		labelNGraph.add(graphLabel);
		labelNGraph.add(tempgraphs);
		showGraph.add(labelNGraph, BorderLayout.NORTH);

		JPanel CloseMe = new JPanel();
		JButton closeMe = new JButton("Close me");
		CloseMe.add(closeMe);

		// set action listener on the button
		closeMe.addActionListener(new JDialogListener(this));

		JSplitPane splitPaneV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneV.setOneTouchExpandable(true);
		splitPaneV.setLeftComponent(infoPane);
		splitPaneV.setDividerLocation(500);
		splitPaneV.setRightComponent(showGraph);
		getContentPane().add(splitPaneV);
		getContentPane().add(CloseMe, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * Gets data from the weather station and puts in into 2d array for the
	 * graph
	 **/
	private String[][] getTData(String data[][]) {
		State state = Singleton.getInstance().getWeather().getStateWeather(state_name);
		System.out.println("asdasdasd: " + state_name);
		for (int x = 0; x < state.getAreas().size(); x++) {
			for (int i = 0; i < state.getAreas().get(x).getWeatherStations().size(); i++) {

				if (state.getAreas().get(x).getWeatherStations().get(i).getName().compareTo(weather_station) == 0) {
					weatherD = state.getAreas().get(x).getWeatherStations().get(i).getData();
					for (int j = 0; j < weatherD.length; j++) {

						System.out.println(weatherD[j].get("local_date_time") + " " + state.getAreas().get(x).getName()
								+ " Weather station " + weatherD[j].get("name") + " dewpt: " + weatherD[j].get("dewpt")
								+ "kmh" + "Name :" + weatherD[j].get("name"));
					}
				}

			}
		}

		data = new String[weatherD.length][19];

		for (int i = 0; i < weatherD.length; i++) {
			// Puts the appropriate key elements in the table
			data[i][0] = weatherD[i].get("local_date_time").toString();
			data[i][1] = (String) weatherD[i].get("air_temp");
			data[i][2] = (String) weatherD[i].get("apparent_t");
			data[i][3] = (String) weatherD[i].get("dewpt");
			data[i][4] = (String) weatherD[i].get("rel_hum");
			data[i][5] = (String) weatherD[i].get("delta_t");
			data[i][6] = (String) weatherD[i].get("wind_dir");
			data[i][7] = (String) weatherD[i].get("wind_spd_kmh");
			data[i][8] = (String) weatherD[i].get("gust_kmh");
			data[i][9] = (String) weatherD[i].get("wind_spd_kt");
			data[i][10] = (String) weatherD[i].get("gust_kt");
			data[i][11] = (String) weatherD[i].get("press_qnh");
			data[i][12] = (String) weatherD[i].get("press_msl");
			data[i][13] = (String) weatherD[i].get("rain_trace");
			data[i][14] = (String) weatherD[i].get("cloud");
			data[i][15] = (String) weatherD[i].get("cloud_base_m");
			data[i][16] = (String) weatherD[i].get("cloud_oktas");
			data[i][17] = (String) weatherD[i].get("cloud_type");
			data[i][18] = (String) weatherD[i].get("vis_km");

		}
		return data;

	}

	// Gets new data and updates the tables data source
	private void DataRefresh(JButton refresh) {
		String oldTitle = this.getTitle();
		this.setTitle(oldTitle + " Getting data");

		data = getTData(data);
		DefaultTableModel model = new DefaultTableModel(data, coloumns);
		jt.setModel(model);
		model.fireTableDataChanged();
		
		this.setTitle(oldTitle + " Done");
		this.setTitle(oldTitle);
	}

	/*
	 * Checks if the Weather station is already present in the favoriates list
	 * if is it present then returns true otherwise returns false
	 */
	private boolean CheckifPresentinFav(String weather_station) {
		System.out.println("This is Checkin Fav " + weather_station);
		for (int i = 0; i < Singleton.getInstance().getApplication().getFav().size(); i++) {
			if (weather_station
					.compareTo(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()) == 0) {
				System.out.println("This is Checkin Fav " + weather_station + " with "
						+ Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());

				return true;
			}

		}
		return false;
	}

	/*
	 * Displays the 9 am pm temperatures by locating the 9 am and 3pm
	 * temeratures from the list the 9 am and 3pm temperatures are then plotted
	 * on the graph which uses Jfreecharts as the plotting tool
	 */
	@SuppressWarnings("deprecation")
	private void show9pm3pmGraph(JPanel showInfo, String[][] data) {
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		for (int i = 0; i < data.length; i++) {
			System.out.println(
					data[i][0] + data[i][1] + "Matches with " + data[i][0].contains(new Date().getDate() + "/09:00am")
							+ data[i][0].contains(new Date().getDate() + "/03:00pm"));

			if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
					|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
					|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
					|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
					|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
					|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm"))) {
				line_chart_dataset.addValue((int) Double.parseDouble(data[i][1]), "temp", data[i][0]);
			}
		}
		JFreeChart lineChartObject = ChartFactory.createLineChart("9am,3pm Temperatures", "Time", " Temperature",
				line_chart_dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(lineChartObject);
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new java.awt.Dimension(600, 300));
		showInfo.add(panel);

	}

	/*
	 * Displays the Maximum and minimum temperatures for the day by locating the
	 * max and min temeratures from the list the max and min temperatures are
	 * then plotted on the graph which uses Jfreecharts as the plotting tool
	 */
	@SuppressWarnings("deprecation")
	private void showMaxMinGraph(JPanel showInfo, String[][] data) {
		int current_h = 0, current_l = 200;
		int previous_h = 0, previous_l = 200;
		int day_before_h = 0, day_before_l = 200;

		String today_h = null, today_l = null;
		String prev_h = null, prev_l = null;
		String day_bef_h = null, day_bef_l = null;

		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data.length; i++) {
			String segments[] = data[i][0].split("/");
			String date = segments[0];
			System.out.println("Substring" + date);
			// Current highest Temperature
			if ((data[i][0].toLowerCase()).contains(("" + new Date().getDate()).toLowerCase())) {

				if ((int) Double.parseDouble(data[i][1]) > current_h) {
					current_h = (int) Double.parseDouble(data[i][1]);
					today_h = data[i][0];
				}
				if ((int) Double.parseDouble(data[i][1]) < current_l) {
					current_l = (int) Double.parseDouble(data[i][1]);
					today_l = data[i][0];
				}

			}
			// Previous days highest temperature
			if ((data[i][0].toLowerCase()).contains(("" + (new Date().getDate() - 1)).toLowerCase())) {

				if ((int) Double.parseDouble(data[i][1]) > previous_h) {
					previous_h = (int) Double.parseDouble(data[i][1]);
					prev_h = data[i][0];
				}
				if ((int) Double.parseDouble(data[i][1]) < previous_l) {
					previous_l = (int) Double.parseDouble(data[i][1]);
					prev_l = data[i][0];

				}
			}
			if ((data[i][0].toLowerCase()).contains(("" + (new Date().getDate() - 2)).toLowerCase())) {

				if ((int) Double.parseDouble(data[i][1]) > day_before_h) {
					day_before_h = (int) Double.parseDouble(data[i][1]);
					day_bef_h = data[i][0];

				}
				if ((int) Double.parseDouble(data[i][1]) < day_before_l) {
					day_before_l = (int) Double.parseDouble(data[i][1]);
					day_bef_l = data[i][0];
				}
			}

		}
		System.out.println(today_h + current_h + " " + today_l + current_l);
		System.out.println(prev_h + previous_h + " " + prev_l + previous_l);
		System.out.println(day_bef_h + day_before_h + " " + day_bef_l + day_before_l);
		System.out.println(" Previous " + previous_h + " " + previous_l);
		JFreeChart lineChartObject = ChartFactory.createLineChart("Maximum vs Minimum", "Time", " Temperature",
				line_chart_dataset, PlotOrientation.VERTICAL, true, true, false);

		/* Check if current days data is available */

		if (current_h != 0 && today_h != null)
			line_chart_dataset.addValue((current_h), "temp", today_h);

		if (current_l != 200 && today_l != null)
			line_chart_dataset.addValue((current_l), "temp", today_l);

		if (previous_h != 0 && prev_h != null)
			line_chart_dataset.addValue((previous_h), "temp", prev_h);

		if (previous_l != 200 && prev_l != null)
			line_chart_dataset.addValue((previous_l), "temp", prev_l);

		if (day_before_h != 0 && day_bef_h != null)
			line_chart_dataset.addValue((day_before_h), "temp", day_bef_h);

		if (day_before_l != 200 && day_bef_l != null)
			line_chart_dataset.addValue((day_before_l), "temp", day_bef_l);

		ChartPanel panel = new ChartPanel(lineChartObject);
		panel.setPreferredSize(new java.awt.Dimension(600, 300));
		showInfo.add(panel);

	}

}