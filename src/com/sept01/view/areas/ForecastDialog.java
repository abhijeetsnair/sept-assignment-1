package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sept01.view.listener.ForecastGraphSelector;

/*DISPLAYS THE FORECAST DIALOG TO THE USER
 * THE FORECAST DIALOG CLASS IS  COMMON TO 
 * BOTH THE FORECAST IO AND OPENWEATHER IO
 * THE FORECAST USES AN FACTORY INSTANCES SUCH THAT 
 * THE ELEMENTS COMMON TO BOTH FORECASTIO AND OPENWEATHER 
 * GET DISPLAYED
 */

public class ForecastDialog extends JDialog {

	// Implements Java logger
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger("com.sept01.areas.ForecastDialog");
	JSONObject forecast;
	String currentData[][];
	String dailyData[][];
	private String[] coloumns = { "Parameter", "Value" };
	JTable jt;
	ImageIcon icon;
	JTabbedPane tabbedPane;
	String weatherStation;

	@SuppressWarnings("serial")
	public ForecastDialog(JSONObject forecast, String weather_station) {
		this.forecast = forecast;
		this.weatherStation = weather_station;
		// Displaying current forecast on the tab
		this.setLayout(new GridLayout(1, 1));
		tabbedPane = new JTabbedPane();
		icon = createImageIcon("images/icon.png");
		log.log(Level.INFO, "Displaying the hourly forecast for " + weatherStation);
		JComponent panel1 = makeTextPanel("Hourly Forecast for " + weatherStation);
		tabbedPane.addTab("Display Forecast Data", icon, panel1, "Displays forecast information for 48 hours ,past the current hour");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		currentData = displayForecastDataonTab1(panel1, currentData);
		this.setTitle("Weather forecast for " + weather_station);
		setBackground(new Color(32, 32, 40));
		tabbedPane.setBackground(new Color(32, 32, 40));
		tabbedPane.setForeground(new Color(32, 32, 40));
		panel1.setBackground(new Color(64, 64, 72));
		panel1.setForeground(Color.LIGHT_GRAY);

		jt = new JTable(currentData, coloumns);
		jt.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				c.setBackground(new Color(32, 32, 40));
				c.setForeground(Color.ORANGE);
				return c;
			}
		});

		jt.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				c.setBackground(row % 9 == 0 ? new Color(64, 64, 72) : new Color(92, 92, 100));
				c.setForeground(row % 9 == 0 ? Color.ORANGE : Color.LIGHT_GRAY);
				return c;
			}
		});

		JScrollPane jps = new JScrollPane(jt);
		panel1.add(jps);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 1));
		JButton button = new JButton("Show Hourly Graphs");
		buttonPanel.add(button);
		panel1.add(buttonPanel);

		// DISPLAYS GRAPHS ON A NEW TAB THE USER CAN SELECT GRAPHS THEY WANT TO
		// SEE
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGraphs();
			}

		});
		// adds the tabbed pane to the view
		add(tabbedPane);
		// sets the tabbbed pane to do the follows
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		setLocationRelativeTo(null);
		// Standard screen dimensions, even the smallest screen size will be
		// able to accomodate for the screen
		setSize(new Dimension(720, 720));

	}

	public String getWeatherStation() {
		return weatherStation;
	}

	public void setWeatherStation(String weatherStation) {
		this.weatherStation = weatherStation;
	}

	/*
	 * DISPLAYS THE FORECAST DATA IN THE FORM OF THE DATA ON THE FIRST TAB. THE
	 * USER IS CONFRONTED WILL ALL THE DATA UNTILL 48 HOURS FROM THE CURRENT
	 * TIME THE USER FROM THERE CAN NAVIGATE TO SEE GRAPHS
	 */
	private String[][] displayForecastDataonTab1(JComponent panel1, String[][] data) {
		int i = 0;

		// creates a data array such that its length is the same as that of all
		// the elements in the
		// object multiplied by the number of elements in the JSON array. It
		// will have a width of 2
		// since we use a simple table to display elements and its values
		data = new String[forecast.getJSONArray("forecast").length()
				* forecast.getJSONArray("forecast").getJSONObject(0).length()][2];
		JSONArray forecasts = forecast.getJSONArray("forecast");

		// Looping through all the forecast objects present in the array
		for (Object fob : forecasts) {
			JSONObject fore = (JSONObject) fob;
			@SuppressWarnings("rawtypes")
			Set keys = fore.keySet();
			@SuppressWarnings("rawtypes")
			Iterator a = keys.iterator();
			// Loops through the keys using the iterator
			// this avoids the need to fetch using key.get("description")
			while (a.hasNext()) {
				String key = (String) a.next();
				// loop to get the dynamic key
				String value = fore.get(key).toString();

				log.log(Level.INFO, key);
				log.log(Level.INFO, value);

				if (key == "dateTime") {
					Date date = new Date(Long.parseLong(value) * 1000);
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
					String formatted = format.format(date);
					// displaying formatted date and time
					log.log(Level.INFO, formatted);
					data[i][0] = "Forecast date and time ";
					data[i][1] = formatted;
					i++;
				} else {
					data[i][0] = key;
					data[i][1] = value;
					i++;
				}
			}

		}

		return data;

	}

	/*
	 * DISPLAYS THE GRAPHS TO THE USER, THE SHOW GRAPHS METHOD ALLOWS THE USER
	 * TO SELECT FROM A LIST OF ALL POSSIBLE VALUE OF GRPAHS. THE USER CAN
	 * CHOOSE A FIELD AND GRAPH THAT FIELD
	 */
	public void showGraphs() {
		JComboBox<String> comboLanguage = new JComboBox<String>();
		JComponent graph_panel = makeGraphPanel();
		tabbedPane.addTab("Show Graphs", icon, graph_panel, "Shows Hourly Graphs");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		JPanel selector_panel = new JPanel();
		JPanel selector_holder = new JPanel();

		comboLanguage.setBackground(new Color(64, 64, 72));
		comboLanguage.setForeground(Color.ORANGE);

		selector_panel.setLayout(new BoxLayout(selector_panel, BoxLayout.Y_AXIS));
		JSONArray forecasts = forecast.getJSONArray("forecast");
		JSONObject object = forecasts.getJSONObject(0);

		log.log(Level.INFO, "Graph data showing graphs");

		@SuppressWarnings("rawtypes")
		Set keys = object.keySet();
		@SuppressWarnings("rawtypes")
		Iterator a = keys.iterator();
		while (a.hasNext()) {
			String key = (String) a.next();
			// loop to get the dynamic key
			String value = object.get(key).toString();
			if (key.compareToIgnoreCase("dateTime") != 0 && key.compareToIgnoreCase("description") != 0) {
				comboLanguage.addItem(key);
				log.log(Level.INFO, key);
				log.log(Level.INFO, value);
			}

		}
		selector_holder.add(comboLanguage);
		selector_panel.add(selector_holder);
		graph_panel.add(selector_panel);

		graph_panel.setBackground(new Color(64, 64, 72));
		selector_panel.setBackground(new Color(64, 64, 72));
		selector_holder.setBackground(new Color(64, 64, 72));

		comboLanguage.addActionListener(new ForecastGraphSelector(comboLanguage, forecast, selector_panel));

	}

	/*
	 * CUSTOMISES A TEXT PANEL TO DISPLAY THE TABLE. IT SETS THE LAYOUT SO BOX
	 * LAYOUT SO THAT A TABLE USING BOX LAYOUT CAN BE EASILY DISPLAYED ON THE
	 * FIRST TAB
	 */
	protected JComponent makeTextPanel(String text) {

		// Creates a text panel to display table
		log.log(Level.INFO, "Creating a text panel to display table");
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel filler = new JLabel(text, JLabel.CENTER);
		panel.add(filler);
		filler.setForeground(Color.LIGHT_GRAY);

		panel.setBackground(new Color(32, 32, 40));
		return panel;
	}

	/*
	 * THE MAKE GRAPH METHOD MAKES A COMPONENT TO DISPLAY THE GRAPHS ON. THE
	 * GRAPH IS THEN DISPLAYED ON THIS PANEL THE GRAPH HAS ITS LAYOUT SET TO
	 */
	protected JComponent makeGraphPanel() {

		// Makes a graph panel to display graphs
		log.log(Level.INFO, "Creating a graph panel to display graphs");
		// Creates a panel to display graph
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		// Creates a banner to display the layout on the view
		JPanel banner = new JPanel();
		banner.setLayout(new BorderLayout());
		// Creates a JPanel whose layout is border layout
		JPanel customise = new JPanel();
		customise.setLayout(new BorderLayout());
		// Label to show hourly graphs for the station
		JLabel filler = new JLabel("Show Hourly Graphs for " + weatherStation, JLabel.CENTER);
		customise.add(filler, BorderLayout.CENTER);
		// Closes the graph display tab
		JButton button = new JButton("X");
		customise.add(button, BorderLayout.EAST);
		customise.setBackground(new Color(32, 32, 40));
		panel.setBackground(new Color(32, 32, 40));
		filler.setBackground(new Color(32, 32, 40));
		filler.setForeground(Color.LIGHT_GRAY);
		// Removes a tab from the pane
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				log.log(Level.INFO, "Removing the tab from the tab pane");
				tabbedPane.remove(1);
			}
		});

		banner.add(customise, BorderLayout.PAGE_START);
		panel.add(banner);
		return banner;
	}

	/*
	 * CREATES AN IMAGE ICON FOR THE TAB. THE TAB DISPLAYS THE ICON FOR HOURLY
	 * DATA AND THE DISPLAY GRAPHS TAB.
	 */
	protected static ImageIcon createImageIcon(String path) {
		log.log(Level.INFO, "Creates the icon for the tab display");
		Image imgURL = Toolkit.getDefaultToolkit().getImage("images/icon.png");
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}

	}
	
	
}
