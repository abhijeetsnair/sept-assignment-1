package com.sept01.view.areas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sept01.AreaController.AreaButtonListener;
import com.sept01.model.Favourites;
import com.sept01.model.Singleton;
import com.sept01.view.MainView;
import com.sept01.view.Metrics;
import com.sept01.view.listener.CityClickListener;

/**
 * The {@link JPanel} Class that refers to the eastern-most Panel in the GUI,
 * which is the Favourites Bar, containing Favourite stations.
 * 
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

	/**
	 * Main Constructor.
	 * 
	 * @param mainView
	 *            Reference to the Main View
	 */
	public EastPanel(MainView mainView) {
		// Adding Registering information
		this.setLayout(new BorderLayout());
		// JPanel infoPanel = new JPanel();
		// this.add(infoPanel, BorderLayout.NORTH);

		TextPanel.setLayout(new BoxLayout(TextPanel, BoxLayout.Y_AXIS));
		JLabel fav = new JLabel("Favourites", JLabel.CENTER);
		// fav.setBorder(blackline);
		TextPanel.add(fav, BorderLayout.CENTER);
		// TextPanel.setBorder(blackline);
		TextPanel.setBackground(new Color(32, 32, 32));

		fav.setBorder(null);
		fav.setBackground(new Color(32, 32, 32));
		fav.setForeground(new Color(192, 192, 192));
		fav.setOpaque(true);
		this.add(TextPanel, BorderLayout.NORTH);
		setBackground(new Color(64, 64, 72));
		// setBackground(new Color(32, 32, 32));
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

	// Adds favorites as buttons to the list of favorites on the UI
	public void addFavourites() {
		for (int i = 0; i < Singleton.getInstance().getApplication().getFav().size(); i++) {
			// check if the fav exists on the panel
			if (checkifFavExists(
					Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()) == false) {
				JPanel buttonPanel = new JPanel();

				buttonPanel.setBorder(null);

				buttonPanel.setLayout(new GridLayout(1, 2));
				JButton weather_station = new JButton(
						Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
				Singleton.getInstance().getApplication().getFav().get(i).getStation().getData();

				CityClickListener listener = new CityClickListener(Singleton.getInstance().getApplication().getFav()
						.get(i).getStation().getStateAbv().toLowerCase(),
						Singleton.getInstance().getApplication().getFav().get(i).getStation());
				weather_station.addActionListener(listener);
				weather_station.setFocusPainted(false);
				weather_station.setFocusable(false);
				weather_station.setBorder(null);

				listener.setFavFlag(true);
				System.out.println(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
				buttonPanel.add(weather_station);

				weather_station.addMouseListener(new AreaButtonListener(new JPanel[] { buttonPanel }, weather_station));
				// add it to the UI
				favAreas.add(buttonPanel);
				favAdded.add(Singleton.getInstance().getApplication().getFav().get(i));
			}
		}

	}

	// update the favorites list
	public void updateFav() {
		favAreas.removeAll();
		TextPanel.remove(favAreas);
		favAdded.clear();
		addFavourites();

	}

	// Check if favorites exist already on the UI if they exist then do not
	// re add them to the UI
	public boolean checkifFavExists(String area) {

		for (int i = 0; i < favAdded.size(); i++) {
			if (favAdded.get(i).getStation().getName() == area) {
				return true;
			}
		}
		return false;
	}

}
