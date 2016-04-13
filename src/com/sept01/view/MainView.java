package com.sept01.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.sept01.main.Singleton;
import com.sept01.view.areas.CenterPanel;
import com.sept01.view.areas.EastPanel;
import com.sept01.view.areas.NorthPanel;
import com.sept01.view.areas.SouthPanel;
import com.sept01.view.areas.WestPanel;
import com.sept01.view.listener.MainViewWindowListener;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	private DropDownBox dialogArea = new DropDownBox(this);
	private TopArea topArea = new TopArea(this);
	private StatusBar statusBar = new StatusBar(this);
	private LMSModel model = new LMSFacade();
	private Image img;
	private EastPanel east;
	private NorthPanel north;
	private SouthPanel south;
	private WestPanel west;
	private CenterPanel center;

	public MainView() {

		// Main UI frame for the Program
		initUI();
	}

	private void initUI() {
//		try { 
//		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
	   setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
		setTitle("WISApplication");
		//setSize(800, 600);
		setSize(Metrics.defaultApplicationSizeX, Metrics.defaultApplicationSizeY);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new BorderLayout(5, 10));
		this.setJMenuBar(new OptionMenu());

		this.addWindowListener(new MainViewWindowListener(this));
		System.out.println("This " + Singleton.getInstance().getXloc() + " " + Singleton.getInstance().getYloc());
		this.setLocation(new Point(Singleton.getInstance().getXloc(), Singleton.getInstance().getYloc()));
		east = new EastPanel(this);
		north = new NorthPanel(this);
		south = new SouthPanel(this);
		west = new WestPanel(this);
		center = new CenterPanel(this);

		Singleton data = Singleton.getInstance();
		data.setCenterPanel(center);
		data.setEastPanel(east);
		data.setNorthPanel(north);
		data.setWestPanel(west);
		data.setSouthPanel(south);
		data.setMainView(this);

		add(north, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);
//		FORCE 16:9
//		this.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent arg0) {
//			    int W = 16;  
//			    int H = 9;  
//			    Rectangle b = arg0.getComponent().getBounds();
//			    arg0.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);
//
//			}
//			
//		});

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