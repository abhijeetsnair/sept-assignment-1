package com.sept01.view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sept01.view.listener.MenuItemListener;

@SuppressWarnings("serial")
public class OptionMenu extends JMenuBar {
	public OptionMenu() {

		// create a menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar = this;
		// create menus
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		final JMenu aboutMenu = new JMenu("About");
		final JMenu linkMenu = new JMenu("Links");

		// create menu items
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setActionCommand("New");
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.setActionCommand("Open");

		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setActionCommand("Save");

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setActionCommand("Exit");

		JMenuItem cutMenuItem = new JMenuItem("Cut");
		cutMenuItem.setActionCommand("Cut");

		JMenuItem copyMenuItem = new JMenuItem("Copy");
		copyMenuItem.setActionCommand("Copy");

		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		pasteMenuItem.setActionCommand("Paste");
			
		JMenuItem  version= new JMenuItem("Verison");
		version.setActionCommand("Version");
		
		
		
		MenuItemListener menuItemListener = new MenuItemListener();

	      newMenuItem.addActionListener(menuItemListener);
	      openMenuItem.addActionListener(menuItemListener);
	      saveMenuItem.addActionListener(menuItemListener);
	      exitMenuItem.addActionListener(menuItemListener);
	      cutMenuItem.addActionListener(menuItemListener);
	      copyMenuItem.addActionListener(menuItemListener);
	      pasteMenuItem.addActionListener(menuItemListener);	
			
		
		// add menu items to menus
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.addSeparator();
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);

		// add menu to menubar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		menuBar.add(linkMenu);
		aboutMenu.add(version);
		// add menubar to the frame
	}

}
