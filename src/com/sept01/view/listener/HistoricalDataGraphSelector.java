package com.sept01.view.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistoricalDataGraphSelector implements ActionListener {
	JComboBox<Object> fields_list;
	DefaultCategoryDataset dataset;
	String data[][];
	String[] fields;
	ChartPanel chartpanel;
	JFreeChart lineChart;
	JPanel tempgraphs;
	String weatherStation;

	public HistoricalDataGraphSelector(JComboBox<Object> fields_list, DefaultCategoryDataset dataset, String data[][],
			String[] fields, JPanel tempgraphs, String weather_station) {
		this.fields_list = fields_list;
		this.dataset = dataset;
		this.data = data;
		this.fields = fields;
		this.tempgraphs = tempgraphs;
		this.weatherStation = weather_station;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String selectedBook = (String) fields_list.getSelectedItem();
		if (selectedBook.equalsIgnoreCase(fields[0])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][1]);
				dataset.addValue(Double.parseDouble(data[i][1]), fields[0], Integer.toString(i));

			}
		}

		if (selectedBook.equalsIgnoreCase(fields[1])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][2]);

				dataset.addValue(Double.parseDouble(data[i][2]), fields[1], Integer.toString(i));
			}
		}
		if (selectedBook.equalsIgnoreCase(fields[2])) {

			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][3]);
				dataset.addValue(Double.parseDouble(data[i][3]), fields[2], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[3])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][4]);
				dataset.addValue(Double.parseDouble(data[i][4]), fields[3], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[4])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][5]);
				dataset.addValue(Double.parseDouble(data[i][5]), fields[4], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[5])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][6]);
				dataset.addValue(Double.parseDouble(data[i][6]), fields[5], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[6])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][7]);
				dataset.addValue(Double.parseDouble(data[i][7]), fields[6], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[7])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][8]);
				dataset.addValue(Double.parseDouble(data[i][8]), fields[7], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[8])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][9]);
				dataset.addValue(Double.parseDouble(data[i][9]), fields[8], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[9])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][10]);
				dataset.addValue(Double.parseDouble(data[i][10]), fields[9], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[10])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][11]);
				dataset.addValue(Double.parseDouble(data[i][11]), fields[10], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[11])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][12]);
				dataset.addValue(Double.parseDouble(data[i][12]), fields[11], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[12])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][13]);
				dataset.addValue(Double.parseDouble(data[i][13]), fields[12], Integer.toString(i));

			}
		}

		if (selectedBook.equalsIgnoreCase(fields[13])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][14]);
				dataset.addValue(Double.parseDouble(data[i][14]), fields[13], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[14])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][15]);
				dataset.addValue(Double.parseDouble(data[i][15]), fields[14], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[15])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][16]);
				dataset.addValue(Double.parseDouble(data[i][16]), fields[15], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[16])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][17]);
				dataset.addValue(Double.parseDouble(data[i][17]), fields[16], Integer.toString(i));

			}
		}
		if (selectedBook.equalsIgnoreCase(fields[17])) {
			for (int i = 0; i < data.length; i++) {

				System.out.println(data[i][18]);
				dataset.addValue(Double.parseDouble(data[i][18]), fields[17], Integer.toString(i));

			}
		}

		lineChart = ChartFactory.createLineChart("Weather Data for " + weatherStation, "Points",
				"Values", dataset, PlotOrientation.VERTICAL, true, true, false);

		if (chartpanel != null) {
			tempgraphs.remove(chartpanel);
		}
		chartpanel = new ChartPanel(lineChart);

		// lineChartObject.

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

		// theme.setCrosshairPaint(Color.white);
		theme.setPlotBackgroundPaint(Color.decode("#444444"));
		theme.setSubtitlePaint(Color.orange);
		// theme.setChartBackgroundPaint(Color.decode("#000000"));

		theme.setTickLabelPaint(Color.orange);

		theme.setLegendItemPaint(Color.orange);
		theme.setLegendBackgroundPaint(Color.decode("#444455"));

		// theme.setDomainGridlinePaint(paint);

		// theme.setRegularFont();

		ChartFactory.setChartTheme(theme);

		ChartUtilities.applyCurrentTheme(lineChart);
		chartpanel.setPreferredSize(new java.awt.Dimension(560, 367));
		tempgraphs.add(chartpanel);
		tempgraphs.repaint();
		tempgraphs.revalidate();

	}

}
