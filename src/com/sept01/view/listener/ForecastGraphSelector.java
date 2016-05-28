package com.sept01.view.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 *ALLOWS THE USER TO SELECT GRAPHS BASED ON THE THIER CHOICE OF FILEDS 
 * THE USER SELECTS THE GRAPH TYPE AND THIS IS DISPLAYED ON THE SCREEN
 * THE UI UPDATES TO DISPLAY GRAPHS ON DIFFERENT DATA SUCH AS 
 * RAIN, TEMPERATURE,HUMIDITY,ETC 
 */

public class ForecastGraphSelector implements ActionListener {
	JComboBox<String> comboLanguage;
	JComponent display_panel;
	JSONObject forecast;
	ChartPanel chartpanel;
	// JPanel panel3;
	JScrollPane pane;
	JLabel x_infolabel;
	JLabel y_infolabel;
	int i = 0;
	JPanel displayUnits;
	DefaultCategoryDataset dataset;
	// Implements logging for graph selector
	private static final Logger log = Logger.getLogger("com.sept01.view.listener.GraphSelector");

	public ForecastGraphSelector(JComboBox<String> comboLanguage, JSONObject forecast, JComponent display_panel) {
		this.comboLanguage = comboLanguage;
		this.forecast = forecast;
		this.display_panel = display_panel;

	}

	/*
	 * DETECTS THE SELECTION AND UPDATES THE UI TO SHOW THE PARTICULAR TYPE OF
	 * CHART. THE CHART TYPES GETS UPDATED EACH TIME THE USER CHOOSES A
	 * PARTICULAR TYPE THE UI SHOWS 48 VALUES FROM THE CURRENT HOUR.
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * IF CHART PANEL EXISTS ON THE UI THE IT WILL REMOVE THE EXISTING PANEL
		 * IF THE UNITS PANEL EXISTS ON THE UI THEN IT WILL REMOVE THE EXISTING
		 * UNITS REPLACE THE EXISTING UNITS WITH THE NEW DISPLAY OF UNITS
		 */

		if (chartpanel != null)
			display_panel.remove(chartpanel);
		if (displayUnits != null)
			display_panel.remove(displayUnits);

		String item = comboLanguage.getSelectedItem().toString();
		log.log(Level.INFO, "Selected Item to display Graph :" + item);
		System.out.println("This is the selected Item" + item);
		{

			displayUnits = new JPanel();
			displayUnits.setLayout(new BoxLayout(displayUnits, BoxLayout.Y_AXIS));
			String Xinfo = "X-label : Displays forecast information for number of hours ,past the current hour for upto 48 hours";
			String Yinfo = "Y-label : Displays values of selected fields";

			x_infolabel = new JLabel(Xinfo);
			y_infolabel = new JLabel(Yinfo);

			displayUnits.add(x_infolabel);
			displayUnits.add(y_infolabel);
			display_panel.add(displayUnits);

			/*
			 * CREATES A DATASET TO DISPLAY THE FORECAST DATA THE DATA UPDATES
			 * DYNAMICALLY IRERESSPECTIVE OF THE SOURCE WHERETHER OPENWEATHER OR
			 * FORECAST IO
			 */
			i = 0;
			dataset = new DefaultCategoryDataset();
			dataset.clear();
			JSONArray forecasts = forecast.getJSONArray("forecast");
			for (Object fob : forecasts) {
				JSONObject fore = (JSONObject) fob;

				// Supresses the iterator warnings to the rawtypes
				@SuppressWarnings("rawtypes")
				Set keys = fore.keySet();
				@SuppressWarnings("rawtypes")
				Iterator a = keys.iterator();
				while (a.hasNext()) {
					String key = (String) a.next();
					// loop to get the dynamic key
					String value = fore.get(key).toString();
					log.log(Level.INFO, key);
					log.log(Level.INFO, value);

					if (key.compareToIgnoreCase(item) == 0) {
						dataset.addValue(Double.parseDouble(value), key, "" + (i + 1));
						i++;
					}
				}

			}
			/*
			 * FREE LINE CHARTS TO DISPLAY THE VALUE OF GRAPHS IT DISPLAYS THE
			 * NO OF HOURS ON THE X AXIS IT DISPLAYS THE VALUES ON THE Y AXIS
			 */
			JFreeChart lineChart = ChartFactory.createLineChart(item, "Hours past the current hour", "Values", dataset,
					PlotOrientation.VERTICAL, true, true, false);
			chartpanel = new ChartPanel(lineChart);

			// The minimum drawable width is 1000 as any values lower than 1000
			// will be shrink
			// the values above 1000 will cause the graph to expand
			chartpanel.setMinimumDrawWidth(1000);
			// Chart Panel is scalable
			chartpanel.addComponentListener(new ScaleChartListener(chartpanel));
			display_panel.add(chartpanel);
			display_panel.repaint();
			display_panel.revalidate();

		}

	}

}
