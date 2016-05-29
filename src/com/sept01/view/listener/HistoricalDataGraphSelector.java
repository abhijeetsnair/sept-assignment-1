package com.sept01.view.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

// ALLOWS THE USER TO SELECT APPROPRIATE GRAPH VALUES
public class HistoricalDataGraphSelector implements ActionListener {
	JComboBox<Object> fields_list;
	DefaultCategoryDataset dataset;
	String data[][];
	String[] fields;
	ChartPanel chartpanel;
	JFreeChart lineChart;
	JPanel tempgraphs;
	String weatherStation;
	private static final Logger log = Logger.getLogger("com.sept01.view.listener.HistoricalDataGraphSelector");

	public HistoricalDataGraphSelector(JComboBox<Object> fields_list, DefaultCategoryDataset dataset, String data[][],
			String[] fields, JPanel tempgraphs, String weather_station) {
		this.fields_list = fields_list;
		this.dataset = dataset;
		this.data = data;
		this.fields = fields;
		this.tempgraphs = tempgraphs;
		this.weatherStation = weather_station;
	}

	/*
	 * GRAPH DISPLAY FOR HISTORICAL DATA DISPLAY GRAPHS FOR 9 AM AND 3PM
	 * TEMPERATURES FOR EVERY SELECTABLE VALUE OF DATA THIS INCLUDES BUT IS NOT
	 * LIMITED TO : 1) AIR TEMPERATURE 2)APPARENT TEMPERATURE 3) DEW POINT 4)
	 * RELATIVE HUMIDITY 5) WIND SPD 6)GUST_KMPH 7)WIND SPD 8)RAIN TRACE
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

	// Date class is deprecated however the functions are available and easier
	// to
	// work with
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] fields = { "air_temp", "apparent_t", "dewpt", "rel_hum", "delta_t", "wind_spd_kmh", "gust_kmh",
				"wind_spd_kt", "gust_kt", "rain_trace" };

		/*
		 * RETRIEVE THE SELECTED COMBOBOX AND THEN MANUPULATE THE VIEW TO
		 * ACCOMODATE FOR THE CHOICE OF THE USER SELECTED ITEM GETS MODIFIED
		 * EACH TIME A CHOICE IS MADE
		 */
		String selected_field = (String) fields_list.getSelectedItem();
		if (selected_field.equalsIgnoreCase(fields[0])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE AIR TEMPERATURE DATA FOR 9 AM AND 3PM
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][1]), fields[0], data[i][0]);

			}
		}

		if (selected_field.equalsIgnoreCase(fields[1])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE APPARENT TEMPERATURE DATA FOR 9 AM AND 3PM
				log.log(Level.INFO, data[i][2]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][2]), fields[1], data[i][0]);
			}
		}
		if (selected_field.equalsIgnoreCase(fields[2])) {
			// DISPLAYS THE DEW POINT TEMPERATURE DATA FOR 9 AM AND 3PM
			for (int i = 0; i < data.length; i++) {
				log.log(Level.INFO, data[i][3]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][3]), fields[2], data[i][0]);

			}
		}
		if (selected_field.equalsIgnoreCase(fields[3])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE RELATIVE HUMIDITY
				log.log(Level.INFO, data[i][4]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][4]), fields[3], data[i][0]);

			}
		}
		if (selected_field.equalsIgnoreCase(fields[4])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE DELTA TEMPERATURE
				log.log(Level.INFO, data[i][5]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][5]), fields[4], data[i][0]);

			}
		}
		if (selected_field.equalsIgnoreCase(fields[5])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE WIND SPEED IN KILOMETERS PER HOUR
				log.log(Level.INFO, data[i][6]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][7]), fields[5], data[i][0]);

			}
		}
		if (selected_field.equalsIgnoreCase(fields[6])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE GUST TEMPERATURE IN KILOMETERS PER HOUR
				log.log(Level.INFO, data[i][7]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][8]), fields[6], data[i][0]);
			}
		}
		if (selected_field.equalsIgnoreCase(fields[7])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLYS THE WIND SPEED IN KILOMETERS PER HOUR
				log.log(Level.INFO, data[i][8]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][9]), fields[7], data[i][0]);

			}
		}
		if (selected_field.equalsIgnoreCase(fields[8])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE GUST_KT TEMPERATURE
				log.log(Level.INFO, data[i][9]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][10]), fields[8], data[i][0]);

			}
		}
		if (selected_field.equalsIgnoreCase(fields[9])) {
			for (int i = 0; i < data.length; i++) {
				// DISPLAYS THE RAIN TRACE DATA FOR 9 AM AND 3PM
				log.log(Level.INFO,data[i][10]);
				if ((data[i][0].contains(new Date().getDate() + "/09:00am"))
						|| (data[i][0].contains(new Date().getDate() + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 1) + "/03:00pm"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/09:00am"))
						|| (data[i][0].contains((new Date().getDate() - 2) + "/03:00pm")))
					dataset.addValue(Double.parseDouble(data[i][13]), fields[9], data[i][0]);

			}
		}

		// INITIALSES THE LINE CHART TO THE APPROPRIATE VALUES
		lineChart = ChartFactory.createLineChart("Weather Data for " + weatherStation, "Time", "Values", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		// REMOVES THE PANEL FROM THE UI IF THE PANEL ALREADY EXISTS
		if (chartpanel != null) {
			tempgraphs.remove(chartpanel);
		}
		chartpanel = new ChartPanel(lineChart);
		chartpanel.setMinimumDrawWidth(600);
		// MAKES THE DISPLAY LOOK INTUITIVE AND LOOK GOOD
		// ADDS COLORS TO THE DISPLAY
		StandardChartTheme theme = new StandardChartTheme("name");
		// theme.setBac
		theme.setChartBackgroundPaint(Color.decode("#3d3f47"));
		theme.setAxisLabelPaint(Color.orange);
		theme.setDomainGridlinePaint(Color.orange);
		theme.setBaselinePaint(Color.orange);
		theme.setItemLabelPaint(Color.orange);
		theme.setPlotOutlinePaint(Color.orange);
		theme.setCrosshairPaint(Color.orange);
		theme.setLabelLinkPaint(Color.orange);
		theme.setThermometerPaint(Color.orange);
		theme.setTitlePaint(Color.orange);
		theme.setRangeGridlinePaint(Color.orange);
		theme.setPlotBackgroundPaint(Color.decode("#444444"));
		theme.setSubtitlePaint(Color.orange);
		theme.setTickLabelPaint(Color.orange);
		theme.setLegendItemPaint(Color.orange);
		theme.setLegendBackgroundPaint(Color.decode("#444455"));

		// SETS THE THEME TO THE CHART THEME
		ChartFactory.setChartTheme(theme);
		// APPLIES THE CURRENT THEME TO THE LINE CHART
		// SETS THE DIMENSIONS TO THE APPROPRIATE VALUES
		ChartUtilities.applyCurrentTheme(lineChart);
		chartpanel.setPreferredSize(new java.awt.Dimension(580, 400));
		tempgraphs.add(chartpanel);
		tempgraphs.repaint();
		tempgraphs.revalidate();
		log.log(Level.INFO, "Finished Rendering the Graph display");
	}

}
