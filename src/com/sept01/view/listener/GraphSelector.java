package com.sept01.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ForeCastIOLib.FIODaily;
import ForeCastIOLib.ForecastIO;

public class GraphSelector implements ActionListener {
	JComboBox<String> comboLanguage;
	private ForecastIO fio;
	JComponent panel;
	ChartPanel chartpanel;

	public GraphSelector(JComboBox<String> comboLanguage, ForecastIO fio, JComponent panel3) {
		this.comboLanguage = comboLanguage;
		this.fio = fio;
		this.panel = panel3;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String item = comboLanguage.getSelectedItem().toString();
		System.out.println("This is the selected Item" + item);
		if (item.toLowerCase().compareTo("apparenttemperaturemintime") == 0) {
			updateapparenttemperaturemintime("apparenttemperaturemintime");
		}
		if (item.toLowerCase().compareTo("temperaturemax") == 0)

		{
			updatetemperaturemax("temperaturemax");
		}

		if (item.toLowerCase().compareTo("icon") == 0)

		{
			updateicon();
		}

		if (item.toLowerCase().compareTo("precipintensitymax") == 0)

		{
			updateprecipintensitymax("precipintensitymax");
		}

		if (item.toLowerCase().compareTo("windbearing") == 0)

		{
			updatewindbearing("windbearing");
		}

		if (item.toLowerCase().compareTo("ozone") == 0)

		{
			updateozone();
		}

		if (item.toLowerCase().compareTo("temperaturemaxtime") == 0) {
			updatetemperaturemaxtime("temperaturemaxtime");
		}

		if (item.toLowerCase().compareToIgnoreCase("apparenttemperaturemin") == 0)

		{
			updateapparenttemperaturemin("apparenttemperaturemin");
		}
		
		if (item.compareToIgnoreCase("sunsetTime") == 0)
		{
			updatesunsetTime("sunsetTime");
		}
		
		if (item.toLowerCase().compareToIgnoreCase("preciptime") == 0)
		{
			updatepreciptime("preciptime");
		}
		if (item.toLowerCase().compareToIgnoreCase("humidity") == 0)
		{
			updatehumidity("humidity");
		}
		if (item.toLowerCase().compareToIgnoreCase("moonPhase") == 0)
		{
			updatemoonPhase("moonPhase");
		}
		if (item.toLowerCase().compareToIgnoreCase("windSpeed") == 0)
		{
			updatewindSpeed("windSpeed");
		}
		if (item.toLowerCase().compareToIgnoreCase("sunriseTime") == 0)
		{
			updatesunriseTime("sunriseTime");
		}
		if (item.toLowerCase().compareToIgnoreCase("precipprobability") == 0)
		{
			updateprecipprobability("precipprobability");
		}
		if (item.toLowerCase().compareToIgnoreCase("visibility") == 0)
		{
			updatevisibility("visibility");
		}
		
		if (item.toLowerCase().compareToIgnoreCase("precipIntensity") == 0)
		{
			updateprecipIntensity("precipIntensity");
		}

		if (item.toLowerCase().compareToIgnoreCase("cloudcover") == 0)
		{
			updatecloudcover("cloudcover");
		}
		
		if (item.toLowerCase().compareToIgnoreCase("temperatureMin") == 0)
		{
			updatetemperatureMin("temperatureMin");
		}
		
		
		
	}

	private void updatetemperatureMin(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatecloudcover(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updateprecipIntensity(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatevisibility(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updateprecipprobability(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatesunriseTime(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatewindSpeed(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatemoonPhase(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatehumidity(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatepreciptime(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
	}

	private void updatesunsetTime(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
				
	}

	private void updateapparenttemperaturemintime(String field) {

		// FIODaily daily = new FIODaily(fio);
		// // In case there is no daily data available
		// if (daily.days() < 0) {
		// JLabel label = new JLabel("No daily data.");
		// } else {
		// JLabel label = new JLabel("Daily Weather Data.");
		// }
		// // Print daily data
		//
		// for (int i = 0; i < daily.days(); i++) {
		// String[] h = daily.getDay(i).getFieldsArray();
		// System.out.println("Day #" + (i + 1));
		// for (int j = 0; j < h.length; j++) {
		// if (h[j].compareToIgnoreCase(field) == 0) {
		// System.out.println(h[j] + " : " + daily.getDay(i).getByKey(h[j]));
		// }
		//
		// }
		//
		// System.out.println("\n");
		// }
		// Updatde code

		if(chartpanel!=null)
		panel.remove(chartpanel);
		
		
		
		FIODaily daily = new FIODaily(fio);
		// In case there is no daily data available
		if (daily.days() < 0) {
			JLabel label = new JLabel("No daily data.");
		} else {
			JLabel label = new JLabel("Daily Weather Data.");
		}
		// Print daily data
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < daily.days(); i++) {
			String[] h = daily.getDay(i).getFieldsArray();
			System.out.println("Day #" + (i + 1));
			for (int j = 0; j < h.length; j++) {
				if (h[j].compareToIgnoreCase(field) == 0) {
					
					String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
					dataset.addValue(Double.parseDouble(temp[0]), field, "Day #" + (i + 1));
					System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
				}

			}
		}
			
		JFreeChart lineChart = ChartFactory.createLineChart(field, "Day", "Time", dataset,
					PlotOrientation.VERTICAL, true, true, false);
			 chartpanel = new ChartPanel(lineChart);
			panel.add(chartpanel);
			System.out.println("\n");
		

	}

	private void updateapparenttemperaturemin(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		

	}

	private void updatetemperaturemaxtime(String string) {
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		

	}

	private void updateozone() {
		// TODO Auto-generated method stub

	}

	private void updatewindbearing(String string) {


		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
		
		
		

	}

	private void updateprecipintensitymax(String string) {

		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
		
		
		

	}

	private void updateicon() {
		// TODO Auto-generated method stub

	}

	private void updatetemperaturemax(String string) {
		/*
		 * Displays graph on updates on temperature apparent temperature min
		 * times
		 * 
		 */

		
		
		if(chartpanel!=null)
			panel.remove(chartpanel);
			
			
			FIODaily daily = new FIODaily(fio);
			// In case there is no daily data available
			if (daily.days() < 0) {
				JLabel label = new JLabel("No daily data.");
			} else {
				JLabel label = new JLabel("Daily Weather Data.");
			}
			// Print daily data
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < daily.days(); i++) {
				String[] h = daily.getDay(i).getFieldsArray();
				System.out.println("Day #" + (i + 1));
				for (int j = 0; j < h.length; j++) {
					if (h[j].compareToIgnoreCase(string) == 0) {
						
						String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
						dataset.addValue(Double.parseDouble(temp[0]), string, "Day #" + (i + 1));
						System.out.println(h[j] + " : " + Double.parseDouble(temp[0]));
					}

				}
			}
				
			JFreeChart lineChart = ChartFactory.createLineChart(string, "Day", "Time", dataset,
						PlotOrientation.VERTICAL, true, true, false);
				 chartpanel = new ChartPanel(lineChart);
				panel.add(chartpanel);
				System.out.println("\n");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		FIODaily daily = new FIODaily(fio);
//		// In case there is no daily data available
//		if (daily.days() < 0) {
//			JLabel label = new JLabel("No daily data.");
//		} else {
//			JLabel label = new JLabel("Daily Weather Data.");
//		}
//		// Print daily data
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//		for (int i = 0; i < daily.days(); i++) {
//			String[] h = daily.getDay(i).getFieldsArray();
//			System.out.println("Day #" + (i + 1));
//			for (int j = 0; j < h.length; j++) {
//
//				System.out.println(h[j] + " : " + daily.getDay(i).getByKey(h[j]));
//				String temp[] = daily.getDay(i).getByKey(h[j]).split(":");
//				dataset.addValue(Double.parseDouble(temp[0]), string, h[j]);
//			}
//
//			JFreeChart lineChart = ChartFactory.createLineChart(string, "Degrees", "Day", dataset,
//					PlotOrientation.VERTICAL, true, true, false);
//
//			ChartPanel chartPanel = new ChartPanel(lineChart);
//			chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
//			panel.add(chartPanel);
//			panel.repaint();
//			panel.revalidate();
//
//			System.out.println("\n");
//		}

		
		
		
		
		
		
		
		
		
		
		
	}

}
