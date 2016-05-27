package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
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

import org.json.JSONArray;
import org.json.JSONObject;

import com.sept01.view.listener.GraphSelector;

/*DISPLAYS THE FORECAST DIALOG TO THE USER
 * THE FORECAST DIALOG CLASS IS  COMMON TO 
 * BOTH THE FORECAST IO AND OPENWEATHER IO
 * THE FORECAST USES AN FACTORY INSTANCES SUCH THAT 
 * THE ELEMENTS COMMON TO BOTH FORECASTIO AND OPENWEATHER 
 * GET DISPLAYED
 */

public class ForecastDialog extends JDialog {
	private static final Logger log = Logger.getLogger("com.sept01.areas.ForecastDialog");

	private static final long serialVersionUID = 1L;
	JSONObject forecast;
	String currentData[][];
	String dailyData[][];
	private String[] coloumns = { "Parameter", "Value" };
	JTable jt;
	ImageIcon icon;
	JTabbedPane tabbedPane;

	public ForecastDialog(JSONObject forecast) {
		this.forecast = forecast;

		// Displaying current forecast on the tab
		this.setLayout(new GridLayout(1, 1));
		tabbedPane = new JTabbedPane();
		icon = createImageIcon("images/icon.png");
		log.log(Level.INFO, "Displaying the hourly forecast");
		JComponent panel1 = makeTextPanel("Hourly Forecast");
		tabbedPane.addTab("Tab 1", icon, panel1, "Displays forecast information for 48 hours ,past the current hour");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		currentData = displayForecastDataonTab1(panel1, currentData);
		Color background = Color.decode("#3d3f47");
		Color foreground = Color.orange;
		jt = new JTable(currentData, coloumns);
		JScrollPane jps = new JScrollPane(jt);
		panel1.add(jps);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 1));
		JButton button = new JButton("Show Hourly Graphs");
		buttonPanel.add(button);
		panel1.add(buttonPanel);

		
		// DISPLAYS GRAPHS ON A NEW TAB THE USER CAN SELECT GRAPHS THEY WANT TO SEE
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showGraphs();
			}

		});

		add(tabbedPane);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		setLocationRelativeTo(null);
		setSize(new Dimension(720, 720));

	}
/*
 * DISPLAYS THE FORECAST DATA IN THE FORM OF THE DATA ON THE
 * FIRST TAB. THE USER IS CONFRONTED WILL ALL THE DATA
 * UNTILL 48 HOURS FROM THE CURRENT TIME
 * THE USER FROM THERE CAN NAVIGATE TO SEE GRAPHS
 */
	private String[][] displayForecastDataonTab1(JComponent panel1, String[][] data) {
		int i = 0;
		data = new String[forecast.getJSONArray("forecast").length()
				* forecast.getJSONArray("forecast").getJSONObject(0).length()][2];
		JSONArray forecasts = forecast.getJSONArray("forecast");

		for (Object fob : forecasts) {
			JSONObject fore = (JSONObject) fob;
			Set keys = fore.keySet();
			Iterator a = keys.iterator();
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
	 * DISPLAYS THE GRAPHS TO THE USER, THE SHOW GRAPHS METHOD
	 * ALLOWS THE USER TO SELECT FROM A LIST OF ALL POSSIBLE VALUE
	 * OF GRPAHS. THE USER CAN CHOOSE A FIELD AND GRAPH THAT FIELD
	 */
	public void showGraphs() {
		JComboBox<String> comboLanguage = new JComboBox<String>();
		JComponent panel4 = makeGraphPanel();
		tabbedPane.addTab("Tab 2", icon, panel4, "Shows Hourly Graphs");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		JPanel panel2 = new JPanel();
		JSONArray forecasts = forecast.getJSONArray("forecast");
		JSONObject object = forecasts.getJSONObject(0);

		log.log(Level.INFO, "Graph data showing graphs");
		Set keys = object.keySet();
		Iterator a = keys.iterator();
		while (a.hasNext()) {
			String key = (String) a.next();
			// loop to get the dynamic key
			String value = object.get(key).toString();
			comboLanguage.addItem(key);
			log.log(Level.INFO, key);
			log.log(Level.INFO, value);

		}
		comboLanguage.addActionListener(new GraphSelector(comboLanguage, forecast, panel4));
		panel2.add(comboLanguage);
		panel4.add(panel2);
	}

/*
 * CUSTOMISES A TEXT PANEL TO DISPLAY THE TABLE.
 * IT SETS THE LAYOUT SO BOX LAYOUT SO THAT A TABLE USING BOX LAYOUT
 * CAN BE EASILY DISPLAYED ON THE FIRST TAB
 */
	protected JComponent makeTextPanel(String text) {

		// Creates a text panel to display table
		log.log(Level.INFO, "Creating a text panel to display table");
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel filler = new JLabel(text, JLabel.CENTER);
		panel.add(filler);
		return panel;
	}
/* THE MAKE GRAPH METHOD MAKES A COMPONENT TO DISPLAY THE 
 * GRAPHS ON. THE GRAPH IS THEN DISPLAYED ON THIS PANEL
 * THE GRAPH HAS ITS LAYOUT SET TO 
 * 
 */
	protected JComponent makeGraphPanel() {

		// Makes a graph panel to display graphs
		log.log(Level.INFO, "Creating a graph panel to display graphs");
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel banner = new JPanel();
		JPanel customise = new JPanel();
		customise.setLayout(new BorderLayout());

		JLabel filler = new JLabel("Show Hourly Forecast", JLabel.CENTER);
		customise.add(filler, BorderLayout.CENTER);
		JButton button = new JButton("X");
		customise.add(button, BorderLayout.EAST);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				log.log(Level.INFO, "Removing the tab from the tab pane");
				tabbedPane.remove(1);

			}
		});

		banner.add(customise);
		banner.setMinimumSize(getMinimumSize());

		panel.add(banner);
		return panel;
	}
/*
 * CREATES AN IMAGE ICON FOR THE TAB. THE TAB DISPLAYS THE ICON
 * FOR HOURLY DATA AND THE DISPLAY GRAPHS TAB.
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
