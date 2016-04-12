package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.sept01.controller.JDialogListener;
import com.sept01.main.Singleton;
import com.sept01.main.State;

public class Dialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable jt;
	@SuppressWarnings("unused")
	private String state_name;
	@SuppressWarnings("rawtypes")
	private HashMap[] weatherD;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss zzz");

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
							
//							System.out.println(weatherD[j].get("local_date_time") + " "
//									+ state.getAreas().get(x).getName() + " Weather station "
//									+ weatherD[j].get("name") + " dewpt: " + weatherD[j].get("dewpt") + "kmh" + "Name :"
//									+ weatherD[j].get("name"));
						}
					}
				
		}
	}	
		
	System.out.println("This is the length of weatherdata present in length"+weatherD.length) ;	
	
		String[] coloumns = { "Date/Time", "Temp °C", "App Temp °C", "Dew Point", "Rel Hum %", "Delta-T °C", "Wind Dir", "Wind Spd km/h", "Wind Gust km/h",
				"Wind Spd kts", "Wind Gust kts", "Press QNH hPa", "Press MSL hPa", "Rain since 9am mm" };
		String data[][] = new String[weatherD.length][14];
		
		for(int i = 0 ; i < weatherD.length; i++){
				
				try {
					data[i][0] = (String) dateFormat.parse((String) weatherD[i].get("local_date_time_full")).toLocaleString();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					data[i][0] = (String) weatherD[i].get("local_date_time_full");
				}
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
		
//		for (int i = 0; i < data.length; i++) {
//
//			for (int j = 0; j < data[i].length; j++) {
//				data[i][j] = i + " " + j;
//				data[i][j] = i + " " + j;
//				System.out.println("This is the data " + i + j + "    " + data[i][j]);
//			}
//
//		}

		
		 

		
		
		
		
		jt = new JTable(data, coloumns);
//		{
//			public Component prepareRenderer(TableCellRenderer renderer, int row,int column) {
//					Component component = super.prepareRenderer(renderer, row, column);
//					int rendererWidth = component.getPreferredSize().width;
//					TableColumn tableColumn = getColumnModel().getColumn(column);
//					tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width,tableColumn.getPreferredWidth()));
//					return component;}};
//					
	TableColumn Tc= jt.getColumnModel().getColumn(0);
	Tc.setPreferredWidth(Tc.getWidth()+100);
	
	jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	jt.setPreferredScrollableViewportSize(new Dimension(600,200));jt.setFillsViewportHeight(true);



	// Panel to show graph and Display Message
	JPanel showGraph = new JPanel();
	JButton showGraphButton = new JButton(
			"Show Graph");showGraphButton.addActionListener(new JDialogListener(this));showGraph.setLayout(new FlowLayout());showGraph.add(new JLabel(message));showGraph.add(showGraphButton);

	// Create a button
	JPanel buttonPane = new JPanel();buttonPane.add(showGraph);
	JScrollPane jps = new JScrollPane(jt);buttonPane.add(jps);

	JPanel CloseMe = new JPanel();
	JButton closeMe = new JButton("Close me");CloseMe.add(closeMe);

	// set action listener on the button
	closeMe.addActionListener(new JDialogListener(this));

	getContentPane().add(buttonPane);
		getContentPane().add(CloseMe, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

}