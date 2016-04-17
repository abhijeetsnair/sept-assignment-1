package com.sept01.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sept01.main.WISApplication;
import com.sept01.model.Singleton;
import com.sept01.view.areas.CenterPanel;
import com.sept01.view.areas.EastPanel;
import com.sept01.view.areas.NorthPanel;
import com.sept01.view.areas.SouthPanel;
import com.sept01.view.areas.WestPanel;
import com.sept01.view.listener.MainViewWindowListener;

/**
 * The main {@link JFrame} class of the GUI. This central Frame contains almost
 * most of what the user sees in the GUI, such as the central image, and the
 * buttons to the side of that.
 *
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {

	private EastPanel east;
	private NorthPanel north;
	private SouthPanel south;
	private WestPanel west;
	private CenterPanel center;

	/**
	 * Main constructor
	 */
	public MainView() {

		// Main UI frame for the Program
		initUI();
	}

	/**
	 * Initialises the UI.
	 */
	private void initUI() {
		/**
		 * BLOCK OF CODE WORKS AT IMPROVOVES THE LOOK AND FEEL MAY OR MAYNOT BE
		 * ACTIVATED NOT MANDATORY FOR THE PROGRAM TO RUN. THE PROGRAM DOES NOT
		 * GET AFFECTED
		 */
		// try {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
		setTitle("WISApplication");
		// setSize(800, 600);
		//setSize(Metrics.defaultApplicationSizeX, Metrics.defaultApplicationSizeY);
		setSize(getRelativeSizeX(), getRelativeSizeY());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.setForeground(Color.ORANGE);
		

		/** SET THE MENU BAR OF THE PANEL */
		this.setJMenuBar(new OptionMenu());
		this.addWindowListener(new MainViewWindowListener(this));
		if(WISApplication.debug == true){
			System.out.println("This " + Singleton.getInstance().getXloc() + " " + Singleton.getInstance().getYloc());
		}
		this.setLocation(new Point(Singleton.getInstance().getXloc(), Singleton.getInstance().getYloc()));
		east = new EastPanel(this);
		north = new NorthPanel(this);
		south = new SouthPanel(this);
		west = new WestPanel(this);
		center = new CenterPanel(this);

		/** SET THE EAST WEST NORTH AND SOUTH COMPONENTS OF THE PANEL */
		Singleton data = Singleton.getInstance();
		data.setCenterPanel(center);
		data.setEastPanel(east);
		data.setNorthPanel(north);
		data.setWestPanel(west);
		data.setSouthPanel(south);
		data.setMainView(this);

		add(north, BorderLayout.NORTH);
		JScrollPane pane = new JScrollPane(east);
		add(pane, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);
		// FORCE 16:9
		// this.addComponentListener(new ComponentAdapter() {
		// @Override
		// public void componentResized(ComponentEvent arg0) {
		// int W = 16;
		// int H = 9;
		// Rectangle b = arg0.getComponent().getBounds();
		// arg0.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);
		//
		// }
		//
		// });

	}
	
	public int getRelativeSizeX(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		width = (int) (width * 0.6f);
		return width;
	}

	public int getRelativeSizeY(){
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int height = gd.getDisplayMode().getHeight();
		height = (int) (height * 0.6f);
		return height;
	}
	
	public EastPanel getEast() {
		return east;
	}

	public WestPanel getWest() {
		return west;
	}

	public NorthPanel getNorth() {
		return north;
	}

	public SouthPanel getSouth() {
		return south;
	}

	public CenterPanel getCenter() {
		return center;
	}

	public void setEast(EastPanel east) {
		this.east = east;
	}

	public void updateFav() {
		new EastPanel(this);
	}

}