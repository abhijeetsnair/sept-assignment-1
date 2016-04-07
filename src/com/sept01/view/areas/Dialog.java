package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.sept01.controller.JDialogListener;
import com.sept01.main.Singleton;
import com.sept01.main.State;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable jt;
	private String state_name;
	private HashMap[] weatherD;

	public Dialog(JFrame parent, String weather_station, String message,String state_name) {
		super(parent, weather_station);
		this.state_name =state_name;
			
	
	State state  = Singleton.getInstance().getWeather().getStateWeather(state_name);		
		/**
		 * I need more functionality from the data side
		 * i should simply be able to obtain all the data pertaining to a particular state
		 * directly by having done state.getArea(" ").getData()
		 * 
		 * 
		 */
	
	for (int x = 0; x < state.getAreas().size(); x++) {
		for (int i = 0; i < state.getAreas().get(x).getWeatherStations().size(); i++) {
					
				if(state.getAreas().get(x).getWeatherStations().get(i).getName().compareTo(weather_station)==0)
					{
						weatherD = state.getAreas().get(x).getWeatherStations().get(i).getData();
						for(int j=0;j<weatherD.length;j++)
						{
							
							System.out.println(weatherD[j].get("local_date_time") + " "
									+ state.getAreas().get(x).getName() + " Weather station "
									+ weatherD[j].get("name") + " dewpt: " + weatherD[j].get("dewpt") + "kmh" + "Name :"
									+ weatherD[j].get("name"));
						}
					}
				
		}
	}	
		
	System.out.println("This is the length of weatherdata present in length"+weatherD.length) ;	
	
		String[] coloumns = { "Date", "Temp", "App Temp", "Dew Point", "Rel Hum", "Delta-T", "D/r", "Spd", "Gust",
				"Spd", "Gust", "QNH", "MSL", "Rain" };
		String data[][] = new String[14][14];

		for (int i = 0; i < data.length; i++) {

			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = i + " " + j;
				data[i][j] = i + " " + j;
				System.out.println("This is the data " + i + j + "    " + data[i][j]);
			}

		}

		
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jt = new JTable(data, coloumns);
		jt.setPreferredScrollableViewportSize(new Dimension(600, 200));
		jt.setFillsViewportHeight(true);

		// Panel to show graph and Display Message
		JPanel showGraph = new JPanel();
		JButton showGraphButton = new JButton("Show Graph");
		showGraphButton.addActionListener(new JDialogListener(this));
		showGraph.setLayout(new FlowLayout());
		showGraph.add(new JLabel(message));
		showGraph.add(showGraphButton);

		// Create a button
		JPanel buttonPane = new JPanel();
		buttonPane.add(showGraph);
		JScrollPane jps = new JScrollPane(jt);
		buttonPane.add(jps);

		JPanel CloseMe = new JPanel();
		JButton closeMe = new JButton("Close me");
		CloseMe.add(closeMe);

		// set action listener on the button
		closeMe.addActionListener(new JDialogListener(this));

		getContentPane().add(buttonPane);
		getContentPane().add(CloseMe, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

}