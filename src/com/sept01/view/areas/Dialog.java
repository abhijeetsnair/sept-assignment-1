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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sept01.controller.JDialogListener;
import com.sept01.main.Singleton;
import com.sept01.main.State;
import com.sept01.main.WeatherStation;
import com.sept01.view.listener.AddtoFavListener;
import com.sept01.view.listener.RemFavListener;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable jt;
	@SuppressWarnings("unused")
	private String state_name;
	@SuppressWarnings("rawtypes")
	private HashMap[] weatherD;
	private boolean addorRemoveFav=false;

	public Dialog(JFrame parent, String weather_station, String message, String state_name, WeatherStation weatherStation) {
		super(parent, weather_station);
		this.state_name = state_name;

		State state = Singleton.getInstance().getWeather().getStateWeather(state_name);
		/**
		 * I need more functionality from the data side i should simply be able
		 * to obtain all the data pertaining to a particular state directly by
		 * having done state.getArea(" ").getData()
		 * 
		 * 
		 */
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

		System.out.println("This is the length of weatherdata present in length" + weatherD.length);

		String[] coloumns = { "Date", "Temp", "App Temp", "Dew Point", "Rel Hum", "Delta-T", "Wind Dir", "Spd", "Gust",
				"Spd", "Gust", "QNH", "MSL", "Rain" };
		String data[][] = new String[weatherD.length][14];

		for (int i = 0; i < weatherD.length; i++) {

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

		}
		// Splitting the Panel into two vertical sections

		addorRemoveFav =CheckifPresentinFav(weather_station);
		
		
		
		
		// Main Panel
		JPanel showInfo = new JPanel();
		showInfo.setLayout(new BoxLayout(showInfo, BoxLayout.Y_AXIS));
		// Adding a scroll pane to the JPanel
		JScrollPane panelPane = new JScrollPane(showInfo);

		// Displaying the Message Label and hide label
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout());
		JLabel msgLabel = new JLabel(message, JLabel.CENTER);
		messagePanel.add(msgLabel, BorderLayout.CENTER);
		JPanel labelPanel = new JPanel();
		
		JButton refresh = new JButton("Refresh");
		labelPanel.add(refresh);	
		if(addorRemoveFav==false){
		JButton add = new JButton("+ Add Favourites");
		add.addActionListener(new AddtoFavListener(weather_station,weatherStation));
		labelPanel.add(add);
		}
		
		else if(addorRemoveFav==true)
		{
		JButton remove = new JButton("- Remove Favourites");
		remove.addActionListener(new RemFavListener(weather_station,weatherStation));
		labelPanel.add(remove);
		}
		messagePanel.add(labelPanel, BorderLayout.EAST);
		showInfo.add(messagePanel);

		// Create an Pane to display the table information
		JPanel infoPane = new JPanel();
		infoPane.setLayout(new BoxLayout(infoPane, BoxLayout.Y_AXIS));
		// Adding a Table to display the weather information
		jt = new JTable(data, coloumns);
		jt.setPreferredScrollableViewportSize(new Dimension(900, 500));
		jt.setFillsViewportHeight(true);
		jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
		JScrollPane jps = new JScrollPane(jt);
		infoPane.add(messagePanel);
		infoPane.add(jps, BorderLayout.WEST);
		showInfo.add(infoPane);

		JPanel graphLabel = new JPanel();
		graphLabel.setLayout(new BorderLayout());
		JLabel label = new JLabel("Temperature graphs for 9 am,3pm,max and min", JLabel.CENTER);
		graphLabel.add(label, BorderLayout.NORTH);

		// Graph Pane to display graph information
		JPanel showGraph = new JPanel();
		showGraph.setLayout(new BoxLayout(showGraph, BoxLayout.Y_AXIS));

		showGraph.add(graphLabel);
		JPanel tempgraphs = new JPanel();
		show9pm3pmGraph(tempgraphs, data);
		showMaxMinGraph(tempgraphs, data);
		showGraph.add(tempgraphs);

		JPanel CloseMe = new JPanel();
		JButton closeMe = new JButton("Close me");
		CloseMe.add(closeMe);

		// set action listener on the button
		closeMe.addActionListener(new JDialogListener(this));

		JSplitPane splitPaneV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneV.setOneTouchExpandable(true);
		splitPaneV.setLeftComponent(infoPane);
		splitPaneV.setDividerLocation(500);
		// infoPane.setMinimumSize(new Dimension(900, 500));
		splitPaneV.setRightComponent(showGraph);
		getContentPane().add(splitPaneV);

		// getContentPane().add(panelPane);
		getContentPane().add(CloseMe, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/*
	 * 
	 * Shows the 9 am and 3 pm temperatures
	 * 
	 * 
	 */

	private boolean CheckifPresentinFav(String weather_station) {
		System.out.println("This is Checkin Fav "+ weather_station);
		for(int i=0;i<Singleton.getInstance().getApplication().getFav().size();i++)
		{	
			if(weather_station .compareTo(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName())==0)
			{	
				System.out.println("This is Checkin Fav "+ weather_station+" with "+Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());	
				
				return true;
			}
				
		}
		return false;
	}

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

		JFreeChart lineChartObject = ChartFactory.createLineChart("Temperature Vs Time", "Time", " Temperature",
				line_chart_dataset, PlotOrientation.VERTICAL, true, true, false);

		int width = 640;
		int height = 480;

		ChartPanel panel = new ChartPanel(lineChartObject);
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new java.awt.Dimension(600, 300));
		showInfo.add(panel);

	}

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