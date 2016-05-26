package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;

public class GraphSelector implements ActionListener {
	JComboBox<String> comboLanguage;
	JComponent panel;
	JSONObject forecast;
	ChartPanel chartpanel;
	int i = 0;
	DefaultCategoryDataset dataset;

	public GraphSelector(JComboBox<String> comboLanguage, JSONObject forecast, JComponent panel3) {
		this.comboLanguage = comboLanguage;
		this.forecast = forecast;
		this.panel = panel3;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(chartpanel!=null)
			panel.remove(chartpanel);
		
		String item = comboLanguage.getSelectedItem().toString();
		System.out.println("This is the selected Item" + item);
		{	
			i = 0;
			dataset = new DefaultCategoryDataset();
			dataset.clear();
			JSONArray forecasts = forecast.getJSONArray("forecast");
			for (Object fob : forecasts) {
				JSONObject fore = (JSONObject) fob;
				Set keys = fore.keySet();
				Iterator a = keys.iterator();
				while (a.hasNext()) {
					String key = (String) a.next();
					// loop to get the dynamic key
					String value = fore.get(key).toString();
					System.out.print("key : " + key);
					System.out.println(" value :" + value);
					if (key.compareToIgnoreCase(item) == 0) {
						dataset.addValue(Double.parseDouble(value), key, "" + (i + 1));
						i++;
					}
				}

			}
			JFreeChart lineChart = ChartFactory.createLineChart(item, "Day", "Time", dataset, PlotOrientation.VERTICAL,
					true, true, false);
			chartpanel = new ChartPanel(lineChart);
			panel.add(chartpanel);
			System.out.println("\n");

		}

		// private void updatetemperatureMin(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatecloudcover(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updateprecipIntensity(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatevisibility(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updateprecipprobability(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatesunriseTime(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatewindSpeed(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatemoonPhase(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatehumidity(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatepreciptime(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatesunsetTime(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		// }
		//
		// private void updateapparenttemperaturemintime(String field) {
		//
		// // FIODaily daily = new FIODaily(fio);
		// // // In case there is no daily data available
		// // if (daily.days() < 0) {
		// // JLabel label = new JLabel("No daily data.");
		// // } else {
		// // JLabel label = new JLabel("Daily Weather Data.");
		// // }
		// // // Print daily data
		// //
		// // for (int i = 0; i < daily.days(); i++) {
		// // String[] h = daily.getDay(i).getFieldsArray();
		// // System.out.println("Day #" + (i + 1));
		// // for (int j = 0; j < h.length; j++) {
		// // if (h[j].compareToIgnoreCase(field) == 0) {
		// // System.out.println(h[j] + " : " + daily.getDay(i).getByKey(h[j]));
		// // }
		// //
		// // }
		// //
		// // System.out.println("\n");
		// // }
		// // Updatde code
		//
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(field) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), field, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(field, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updateapparenttemperaturemin(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updatetemperaturemaxtime(String string) {
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		// }
		//
		// private void updateozone() {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// private void updatewindbearing(String string) {
		//
		//
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		//
		//
		//
		//
		// }
		//
		// private void updateprecipintensitymax(String string) {
		//
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		//
		//
		//
		//
		// }
		//
		// private void updateicon() {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// private void updatetemperaturemax(String string) {
		// /*
		// * Displays graph on updates on temperature apparent temperature min
		// * times
		// *
		// */
		//
		//
		//
		// if(chartpanel!=null)
		// panel.remove(chartpanel);
		//
		//
		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(string) == 0) {
		//
		// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		// dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i +
		// 1));
		// System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
		// }
		//
		// }
		// }
		//
		// JFreeChart lineChart = ChartFactory.createLineChart(string, "Day",
		// "Time", dataset,
		// PlotOrientation.VERTICAL, true, true, false);
		// chartpanel = new ChartPanel(lineChart);
		// panel.add(chartpanel);
		// System.out.println("\n");
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//// FIODaily daily = new FIODaily(fio);
		//// // In case there is no daily data available
		//// if (daily.days() < 0) {
		//// JLabel label = new JLabel("No daily data.");
		//// } else {
		//// JLabel label = new JLabel("Daily Weather Data.");
		//// }
		//// // Print daily data
		//// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		////
		//// for (int i = 0; i < daily.days(); i++) {
		//// String[] h = daily.getDay(i).getFieldsArray();
		//// System.out.println("Day #" + (i + 1));
		//// for (int j = 0; j < h.length; j++) {
		////
		//// System.out.println(h[j] + " : " + daily.getDay(i).getByKey(h[j]));
		//// String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
		//// dataset.addValue(Double.parseDouble(temp[0]), string, h[j]);
		//// }
		////
		//// JFreeChart lineChart = ChartFactory.createLineChart(string,
		// "Degrees", "Day", dataset,
		//// PlotOrientation.VERTICAL, true, true, false);
		////
		//// ChartPanel chartPanel = new ChartPanel(lineChart);
		//// chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		//// panel.add(chartPanel);
		//// panel.repaint();
		//// panel.revalidate();
		////
		//// System.out.println("\n");
		//// }
		//
		//

	}

}
