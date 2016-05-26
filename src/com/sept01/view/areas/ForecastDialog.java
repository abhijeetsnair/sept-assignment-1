package com.sept01.view.areas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

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

public class ForecastDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	JSONObject forecast;
	String currentData[][];
	String dailyData[][];
	private String[] coloumns = { "Parameter", "Value" };
	JTable jt;
	ImageIcon icon;
	JTabbedPane tabbedPane;

	public ForecastDialog(JSONObject forecast) {
	 this.forecast =forecast;

		// Displaying current forecast on the tab
		this.setLayout(new GridLayout(1, 1));
		tabbedPane = new JTabbedPane();
		icon = createImageIcon("images/icon.png");

		JComponent panel1 = makeTextPanel("Hourly Forecast");
		tabbedPane.addTab("Tab 1", icon, panel1, "Shows Hourly Forecast");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		currentData = displayForecastDataonTab1(panel1, currentData);
		Color background = Color.decode("#3d3f47");
		Color foreground = Color.orange;
		jt = new JTable(currentData, coloumns);
		JScrollPane jps = new JScrollPane(jt);
		panel1.add(jps);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 1));
		JButton button = new JButton("Show Daily Forecast");
		buttonPanel.add(button);
		panel1.add(buttonPanel);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showGraphs();

			}

		});

		// JComponent panel2 = makeTextPanel("Panel #2");
		// tabbedPane.addTab("Tab 2", icon, panel2,
		// "Does twice as much nothing");
		// tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		//
		// JComponent panel3 = makeTextPanel("Panel #3");
		// tabbedPane.addTab("Tab 3", icon, panel3,
		// "Still does nothing");
		// tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		//
		// JComponent panel4 = makeTextPanel(
		// "Panel #4 (has a preferred size of 410 x 50).");
		// panel4.setPreferredSize(new Dimension(410, 50));
		// tabbedPane.addTab("Tab 4", icon, panel4,
		// "Does nothing at all");
		// tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		// Showing the data on the Panel

		setLocationRelativeTo(null);
		setSize(new Dimension(720, 720));

	}

	//
	//
	//
	// private String[][] getTData(String data[][]) {
	//
	// FIOCurrently currently = new FIOCurrently(fio);
	// //Print currently data
	// System.out.println("\nCurrently\n");
	//
	// String [] f = currently.get().getFieldsArray();
	// data = new String[f.length][19];
	// for(int i = 0; i<f.length;i++){
	// data[i][0 ]= currently.get().getByKey(f[i]);
	//
	// }
	// return data;
	//
	// }
	//
	//
	
	private String[][] displayForecastDataonTab1(JComponent panel1, String[][] data) {
		int i=0;
		data = new String[forecast .getJSONArray("forecast").length()* forecast .getJSONArray("forecast").getJSONObject(0).length()][2];
		JSONArray forecasts = forecast .getJSONArray("forecast");
		
		
		for(Object fob : forecasts){
			JSONObject fore = (JSONObject) fob;
			Set keys = fore.keySet();
		    Iterator a = keys.iterator();
		    while(a.hasNext()) {
		    	String key = (String)a.next();
		        // loop to get the dynamic key
		        String value =  fore.get(key).toString();
		        System.out.print("key : "+key);
		        System.out.println(" value :"+value);
				data[i][0] = key;
				data[i][1] = value;
		        i++;
		        
		    }
			
			
		}
		
		
		

		return data;

	}

//	private String[][] displayForecastDataonTab2(JComponent panel2, String[][] data) {
//
//		// fio = new ForecastIO("5370c63bf884c9970205d009908f1575");
//
//		System.out.println("Latitude: " + fio.getLatitude());
//		System.out.println("Longitude: " + fio.getLongitude());
//		System.out.println("Timezone: " + fio.getTimezone());
//		System.out.println("Offset: " + fio.offset());
//
//		// FIOCurrently currently = new FIOCurrently(fio);
//		// // Print currently data
//		// System.out.println("\nCurrently\n");
//		// String[] f = currently.get().getFieldsArray();
//		// data = new String[f.length][2];
//		// for (int i = 0; i < f.length; i++) {
//		// System.out.println("Displays" + f[i]);
//		// System.out.println("Displays" + currently.get().getByKey(f[i]));
//		// data[i][0] = f[i];
//		// data[i][1] = currently.get().getByKey(f[i]);
//		// }
//
//		// This is the daily report we need for the assignment
//		FIODaily daily = new FIODaily(fio);
//		// In case there is no daily data available
//		if (daily.days() < 0) {
//			JLabel label = new JLabel("No daily data.");
//		} else {
//			JLabel label = new JLabel("Daily Weather Data.");
//		}
//		int d = 0;
//		// Print daily data
//
//		data = new String[daily.days() * daily.getDay(1).getFieldsArray().length][2];
//		for (int i = 0; i < daily.days(); i++) {
//			String[] h = daily.getDay(i).getFieldsArray();
//			data[d][0] = "Day #" + (i + 1);
//			data[d][1] = "28/07/2014";
//			d++;
//			System.out.println("Day #" + (i + 1));
//			for (int j = 0; j < h.length; j++) {
//				data[d][0] = h[j];
//				data[d][1] = daily.getDay(i).getByKey(h[j]);
//				d++;
//			}
//
//			System.out.println("\n");
//		}
//
//		return data;
//
//	}
//
//	public void showDailyForecast() {
//
//		JComponent panel2 = makeTextPanel("Daily Forecast");
//		dailyData = displayForecastDataonTab2(panel2, dailyData);
//		tabbedPane.addTab("Tab 2", icon, panel2, "Does twice as much nothing");
//
//		String[] coloumns = { "Parameter", "Value" };
//		Color background = Color.decode("#3d3f47");
//		Color foreground = Color.orange;
//		jt = new JTable(dailyData, coloumns);
//		JScrollPane jps = new JScrollPane(jt);
//		panel2.add(jps);
//
//		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//	}
//
	public void showGraphs() {

		JComboBox<String> comboLanguage = new JComboBox<String>();
		JComponent panel3 = makeTextPanel("Shows Hourly Graphs");
		tabbedPane.addTab("Tab 2", icon, panel3, "Shows Hourly Graphs");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		JPanel panel2 = new JPanel();
	
		JSONArray forecasts = forecast .getJSONArray("forecast");
		
		JSONObject object  = forecasts.getJSONObject(0);
		
			Set keys = object.keySet();
		    Iterator a = keys.iterator();
		    while(a.hasNext()) {
		    	String key = (String)a.next();
		        // loop to get the dynamic key
		        String value =  object.get(key).toString();
		        comboLanguage.addItem(key);
		        
		    }
 
		comboLanguage.addActionListener(new GraphSelector(comboLanguage,forecast, panel3));
		panel2.add(comboLanguage);
		panel3.add(panel2);

	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel filler = new JLabel(text);
		panel.add(filler);
		return panel;
	}

	protected static ImageIcon createImageIcon(String path) {

		Image imgURL = Toolkit.getDefaultToolkit().getImage("images/icon.png");
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}



	
	
	
	
