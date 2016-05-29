package com.sept01.view.areas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sept01.AreaController.AreaButtonListener;
import com.sept01.main.WISApplication;
import com.sept01.model.Singleton;
import com.sept01.model.State;
import com.sept01.model.WeatherStation;
import com.sept01.view.listener.AddtoFavListener;
import com.sept01.view.listener.ForecastClickListener;
import com.sept01.view.listener.HistoricalDataGraphSelector;
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
	@SuppressWarnings("unused")
	private ChartPanel chartPanel;
	@SuppressWarnings("rawtypes")
	private HashMap[] weatherD;
	private boolean addorRemoveFav = false;
	String weather_station, message;
	WeatherStation weatherStation;
	DefaultCategoryDataset dataset;
	String lat, lon;
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
		Color background = Color.decode("#3d3f47");
		Color foreground = Color.orange;
		// Adding a Table to display the weather information
		jt = new JTable(data, coloumns);
		jt.setBackground(background);
		jt.setForeground(foreground);
		jt.setFont(new Font("Verdana", Font.PLAIN, 12));
		jt.getTableHeader().setBackground(background);
		jt.getTableHeader().setForeground(foreground);
		jt.setPreferredScrollableViewportSize(new Dimension(900, 500));
		jt.setFillsViewportHeight(true);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane jps = new JScrollPane(jt);
		jps.setBackground(background);
		jps.setForeground(foreground);
		jps.getVerticalScrollBar().setBackground(background.brighter());
		jps.getHorizontalScrollBar().setBackground(background.brighter());

		setLocationRelativeTo(null);
		setSize(new Dimension(720, 720));

		/**
		 * Checks if the particular station is already present in the favorite
		 * list
		 */
		addorRemoveFav = CheckifPresentinFav(weather_station);
		// Main Panel
		JPanel showInfo = new JPanel();
		showInfo.setBackground(background);
		showInfo.setForeground(foreground);
		showInfo.setLayout(new BoxLayout(showInfo, BoxLayout.Y_AXIS));
		// Adding a scroll pane to the JPanel
		// Displaying the Message Label and hide label
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		JLabel msgLabel = new JLabel(message, JLabel.CENTER);
		msgLabel.setForeground(foreground);
		msgLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		messagePanel.add(msgLabel, BorderLayout.CENTER);
		messagePanel.setBackground(background);
		messagePanel.setForeground(foreground);
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(background);

		/***
		 * THE REFRESH BUTTON ENABLES THE USER TO REFERSH THE PAGE TO SHOW THE
		 * LATEST INFORMATION ABOUT THE APPLICATION
		 */

		/* Assignment 2 addition */
		/**
		 * ENABLES THE USER TO SELECT FORECAST INFORMATION BY CLICKING THE
		 * FORECAST INFO BUTTON THE BUTTON DISPLAYS FORECAST VALUES FOR A
		 * LOCATION
		 */
		JButton forecastInfo = new JButton("Forecast Info");
		labelPanel.add(forecastInfo);
		forecastInfo.setBackground(background.brighter());
		forecastInfo.setForeground(foreground);
		forecastInfo.setFont(new Font("Verdana", Font.PLAIN, 12));
		forecastInfo.addActionListener(new ForecastClickListener(lat, lon, this, weather_station));
		forecastInfo.setBorder(null);

		JButton refresh = new JButton("Refresh");
		labelPanel.add(refresh);
		refresh.setBackground(background.brighter());
		refresh.setForeground(foreground);
		refresh.setFont(new Font("Verdana", Font.PLAIN, 12));
		refresh.addActionListener(e -> DataRefresh(refresh));
		refresh.addMouseListener(new AreaButtonListener(new JPanel[] { labelPanel }, refresh));
		refresh.setBorder(null);

		/***
		 * THE ADD TO FAVORIATES OR REMOVE FAVORIATES OPENS UP DEPENDING ON
		 * WEATHER THE APPLICATION HAS ALREADY BEEN SELECTED TO BE A FAVORIATE
		 * OR IS NOT A FAVORIATE DEPENDING UPON THE ADD OR REMOVEFAV FLAG
		 */

		if (addorRemoveFav == false) {
			JButton add = new JButton("+ Add Favourites");
			add.addActionListener(new AddtoFavListener(weather_station, weatherStation));
			add.addMouseListener(new AreaButtonListener(new JPanel[] { labelPanel }, add));
			add.setBackground(background.brighter());
			add.setForeground(foreground);
			add.setBorder(null);
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
			remove.addMouseListener(new AreaButtonListener(new JPanel[] { labelPanel }, remove));
			remove.setBackground(background.brighter());
			remove.setForeground(foreground);
			remove.setBorder(null);
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
		infoPane.setBackground(background);
		infoPane.setForeground(foreground);

		// Graph Pane to display graph information
		JPanel showGraph = new JPanel();
		showGraph.setLayout(new BorderLayout());
		showGraph.setBackground(background);
		showGraph.setForeground(foreground);

		JPanel labelNGraph = new JPanel();
		labelNGraph.setLayout(new BoxLayout(labelNGraph, BoxLayout.Y_AXIS));
		labelNGraph.setBackground(background);
		labelNGraph.setForeground(foreground);
		JPanel graphLabel = new JPanel();
		graphLabel.setLayout(new BorderLayout());
		JLabel label = new JLabel("Choose Graph to Display", JLabel.CENTER);
		label.setForeground(foreground);
		graphLabel.add(label);
		graphLabel.setBackground(background);
		graphLabel.setForeground(foreground);

		JPanel tempgraphs = new JPanel();
		tempgraphs.setLayout(new BoxLayout(tempgraphs, BoxLayout.Y_AXIS));
		// Getting rid of maximum and minimum temperatures
		displayRemoveablegraphs(tempgraphs, data);

		// show9pm3pmGraph(tempgraphs, data);
		// showMaxMinGraph(tempgraphs, data);

		labelNGraph.add(graphLabel);
		labelNGraph.add(tempgraphs);
		showGraph.add(labelNGraph, BorderLayout.NORTH);

		JPanel clear = new JPanel();
		JButton closeMe = new JButton("clear");
		closeMe.addMouseListener(new AreaButtonListener(new JPanel[] { clear }, closeMe));
		closeMe.setBorder(null);
		clear.add(closeMe);

		clear.setBackground(new Color(64, 64, 72));

		// set action listener on the button
		closeMe.addActionListener(new JDialogListener(this, dataset));

		JSplitPane splitPaneV = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneV.setOneTouchExpandable(true);
		splitPaneV.setLeftComponent(infoPane);
		splitPaneV.setDividerLocation(500);
		splitPaneV.setRightComponent(showGraph);
		getContentPane().add(splitPaneV);
		getContentPane().add(clear, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));

		// updates the data at 10 second intervals
		Thread updateThread = new Thread() {
			public void run() {
				Boolean run = true;
				while (run) {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						if (WISApplication.debug == true) {
							System.out.println("END THREAD");
						}
						run = false;
					}
					DataRefresh(refresh);

				}
			}
		};

		updateThread.start();
		// closes thread on window close
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				updateThread.interrupt();
			}

			@Override
			public void windowClosed(java.awt.event.WindowEvent e) {

			}

			@Override
			public void windowActivated(java.awt.event.WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowOpened(WindowEvent e) {

			}

		});
	}
	
	//Adds a graph that can be removed from the display panel
	private void displayRemoveablegraphs(JPanel tempgraphs, String data[][]) {

		String[] fields = { "air_temp", "apparent_t", "dewpt", "rel_hum", "delta_t", "wind_spd_kmh", "gust_kmh",
				"wind_spd_kt", "gust_kt", "rain_trace" };
		// Create the combo box, select item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		JComboBox<Object> fields_list = new JComboBox<Object>(fields);
		dataset = new DefaultCategoryDataset();
		tempgraphs.add(fields_list);
		fields_list.addActionListener(
				new HistoricalDataGraphSelector(fields_list, dataset, data, fields, tempgraphs, weather_station));

	}

	/**
	 * Gets data from the weather station and puts in into 2d array for the
	 * graph
	 **/
	private String[][] getTData(String data[][]) {
		State state = Singleton.getInstance().getWeather().getStateWeather(state_name);
		for (int x = 0; x < state.getAreas().size(); x++) {
			for (int i = 0; i < state.getAreas().get(x).getWeatherStations().size(); i++) {

				if (state.getAreas().get(x).getWeatherStations().get(i).getName().compareTo(weather_station) == 0) {
					weatherD = state.getAreas().get(x).getWeatherStations().get(i).getData();
					for (int j = 0; j < weatherD.length; j++) {

						if (WISApplication.debug == true) {
							System.out.println(
									weatherD[j].get("local_date_time") + " " + state.getAreas().get(x).getName()
											+ " Weather station " + weatherD[j].get("name") + " dewpt: "
											+ weatherD[j].get("dewpt") + "kmh" + "Name :" + weatherD[j].get("name"));
						}
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
			lat = (String) weatherD[i].get("lat");
			lon = (String) weatherD[i].get("lon");

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
		if (WISApplication.debug == true) {
			System.out.println("This is Checkin Fav " + weather_station);
		}
		for (int i = 0; i < Singleton.getInstance().getApplication().getFav().size(); i++) {
			if (weather_station
					.compareTo(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()) == 0) {
				if (WISApplication.debug == true) {
					System.out.println("This is Checkin Fav " + weather_station + " with "
							+ Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
				}

				return true;
			}

		}
		return false;
	}

	
}