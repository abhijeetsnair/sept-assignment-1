package com.sept01.view.areas;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sept01.controller.JDialogListener;
import com.sept01.main.Singleton;
import com.sept01.main.State;
import com.sun.swing.internal.plaf.basic.resources.basic;

import javafx.scene.shape.Box;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable jt;
	@SuppressWarnings("unused")
	private String state_name;
	@SuppressWarnings("rawtypes")
	private HashMap[] weatherD;

	public Dialog(JFrame parent, String weather_station, String message, String state_name) {
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

		String[] coloumns = { "Date", "Temp", "App Temp", "Dew Point", "Rel Hum", "Delta-T", "D/r", "Spd", "Gust",
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

		// for (int i = 0; i < data.length; i++) {
		//
		// for (int j = 0; j < data[i].length; j++) {
		// data[i][j] = i + " " + j;
		// data[i][j] = i + " " + j;
		// System.out.println("This is the data " + i + j + " " + data[i][j]);
		// }
		//
		// }

		JPanel showInfo = new JPanel();
		jt = new JTable(data, coloumns);
		// jt.setPreferredScrollableViewportSize(new Dimension(600, 200));
		jt.setFillsViewportHeight(true);

		jt.setAutoResizeMode(jt.AUTO_RESIZE_OFF);
		// Panel to show graph and Display Message

		showInfo.setLayout(new FlowLayout());
		showInfo.add(new JLabel(message));

		// Create a button

		JPanel infoPane = new JPanel();
		infoPane.setLayout(new FlowLayout());

		JScrollPane jps = new JScrollPane(jt);
		infoPane.add(jps);
		showGraph(infoPane, data);
		showInfo.add(infoPane);

		JPanel CloseMe = new JPanel();
		JButton closeMe = new JButton("Close me");
		CloseMe.add(closeMe);

		// set action listener on the button
		closeMe.addActionListener(new JDialogListener(this));
		
		getContentPane().add(showInfo);
		getContentPane().add(CloseMe, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void showGraph(JPanel showInfo, String[][] data) {

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

		// int width =640;
		// int height=480;

		ChartPanel panel = new ChartPanel(lineChartObject);
		panel.setLayout(new FlowLayout());
		
//		panel.setMaximumSize(getMaximumSize());
		showInfo.add(panel);

	}

}