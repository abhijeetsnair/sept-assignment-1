package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import com.sept01.controller.AreaButtonListener;
import com.sept01.controller.CityClickListener;
import com.sept01.main.Favourites;
import com.sept01.main.Singleton;
import com.sept01.view.MainView;
import com.sept01.view.Metrics;

/**
 * The {@link JPanel} Class that refers to the eastern-most Panel in the GUI, which is
 * the Favourites Bar, containing Favourite stations.
 * @see Favourites
 */
public class EastPanel extends JPanel {
	/**
	 * Serial version ID long.
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel TextPanel = new JPanel();
	
	/**
	 * List of favourite stations added.
	 */
	private ArrayList<Favourites> favAdded = new ArrayList<Favourites>();
	private JPanel favAreas = new JPanel();
	private JScrollPane pane = new JScrollPane(favAreas);
	private Border blackline;

	/**
	 * Main Constructor.
	 * @param mainView Reference to the Main View
	 */
	public EastPanel(MainView mainView) {
		blackline = BorderFactory.createLineBorder(Color.black);
		// Adding Registering information
		this.setLayout(new BorderLayout());
		// JPanel infoPanel = new JPanel();
		// this.add(infoPanel, BorderLayout.NORTH);

		TextPanel.setLayout(new BoxLayout(TextPanel, BoxLayout.Y_AXIS));
		JLabel fav = new JLabel("Favourites", JLabel.CENTER);
		//fav.setBorder(blackline);
		TextPanel.add(fav, BorderLayout.CENTER);
	
		//TextPanel.setBorder(blackline);
		
		TextPanel.setBackground(new Color(32, 32, 32));

	

		
		fav.setBorder(null);
		fav.setBackground(new Color(32, 32, 32));
    fav.setForeground(new Color(192, 192, 192));
    fav.setOpaque(true);
    

		this.add(TextPanel, BorderLayout.NORTH);

		// Set border to a textPanel
		//TextPanel.setBorder(blackline);
		//setBackground(Color.WHITE);
		
		setBackground(new Color(64, 64, 72));
		//setBackground(new Color(32, 32, 32));
		setPreferredSize(new Dimension(200, Metrics.centerPanelY));
		
		setBorder(null);
		
		// Set layout of favorites
		favAreas.setLayout(new BoxLayout(favAreas, BoxLayout.Y_AXIS));
		favAreas.setBorder(null);
		
		addFavourites();
		TextPanel.add(pane);
		TextPanel.setBorder(null);
		
		pane.setBorder(null);
		
		
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
	}

	public void addFavourites() {
		System.out.println("Does it come here");
		for (int i = 0; i < Singleton.getInstance().getApplication().getFav().size(); i++) {

			if (checkifFavExists(
					Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()) == false) {
				JPanel buttonPanel = new JPanel();
				
				buttonPanel.setBorder(null);
				
				
				buttonPanel.setLayout(new GridLayout(1, 2));
				JButton weather_station = new JButton(
						Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
				Singleton.getInstance().getApplication().getFav().get(i).getStation().getData();	
				
				CityClickListener listener = new CityClickListener(
						Singleton.getInstance().getApplication().getFav().get(i).getStation().getStateAbv()
						.toLowerCase(),
				Singleton.getInstance().getApplication().getFav().get(i).getStation());
				weather_station	.addActionListener(listener);
				weather_station.setFocusPainted(false);
				weather_station.setFocusable(false);
				weather_station.setBorder(null);
				
				listener.setFavFlag(true);
				System.out.println(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
				buttonPanel.add(weather_station);
				
				weather_station.addMouseListener(new AreaButtonListener(new JPanel[] {buttonPanel}, weather_station));
				
				
				favAreas.add(buttonPanel);
				favAdded.add(Singleton.getInstance().getApplication().getFav().get(i));
			}
		}

	}
	
	public void updateFav(){	
		favAreas.removeAll();
		TextPanel.remove(favAreas);
		favAdded.clear();
		addFavourites();
		
	}
		
	
	// public void addFavoriates() {
	//
	// System.out.println("Size of favouriates " +
	// Singleton.getInstance().getFav().size());
	//
	// for (int i = 0; i < Singleton.getInstance().getFav().size(); i++) {
	//
	//// if
	// (checkifFavExists(Singleton.getInstance().getFav().get(i).getArea().getName())
	// == false) {
	//// JButton areas = new
	// JButton(Singleton.getInstance().getFav().get(i).getArea().getName());
	//// System.out
	//// .println("This is the area name" +
	// Singleton.getInstance().getFav().get(i).getArea().getName());
	//// favAreas.add(areas);
	//// favAdded.add(Singleton.getInstance().getFav().get(i));
	//// }
	// }
	// TextPanel.add(favAreas);
	// }

	public boolean checkifFavExists(String area) {

		for (int i = 0; i < favAdded.size(); i++) {
			if (favAdded.get(i).getStation().getName() == area) {
				return true;
			}
		}
		return false;
	}

}
