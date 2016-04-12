package com.sept01.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.sept01.view.areas.Dialog;

public class JDialogListener implements ActionListener {

	Dialog dialog;
	String data[][];
		
	
	public JDialogListener(Dialog dialog) {
		this.dialog = dialog;
	}

	public JDialogListener(Dialog dialog2, String[][] data) {
		// TODO Auto-generated constructor stub
	this.data=data;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String buttonType = ((JButton) arg0.getSource()).getText();

		// We first manipulate the data to show the graph
		
	
		
			
		if (buttonType.compareTo("Close me") == 0) {
			System.out.println("disposing the window..");
			dialog.dispose();
		}

		if (buttonType.compareTo("Show Graph") == 0) {	
				
			System.out.println("TEST");
			showGraph(data);
			final ImageIcon icon = new ImageIcon("LineChart.jpeg");
			JOptionPane.showMessageDialog(null, "LineChart.jpeg", "About", JOptionPane.INFORMATION_MESSAGE, icon);
		}
	}

	@SuppressWarnings("deprecation")
	private void showGraph(String[][] data) {
		
		
		DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
			for(int i =0;i<data.length; i++){
				System.out.println(data[i][0] + data[i][1] +"Matches with "+ data[i][0].contains(new Date().getDate()+"/09:00am")+data[i][0].contains(new Date().getDate()+"/03:00pm") );			

				if((data[i][0].contains(new Date().getDate()+"/09:00am")) || (data[i][0].contains(new Date().getDate()+"/03:00pm"))||(data[i][0].contains((new Date().getDate()-1)+"/09:00am")) || (data[i][0].contains((new Date().getDate()-1)+"/03:00pm"))||(data[i][0].contains((new Date().getDate()-2)+"/09:00am")) || (data[i][0].contains((new Date().getDate()-2)+"/03:00pm")))
				{
					line_chart_dataset.addValue((int)Double.parseDouble(data[i][1]) , "temp" ,data[i][0]);
				}
			}
		

		      JFreeChart lineChartObject = ChartFactory.createLineChart(
				         "Temperature Vs Time","Time",
				         " Temperature",
				         line_chart_dataset,PlotOrientation.VERTICAL,
				         true,true,false);
				      
				      	int width =640;	
				      	int height=480;
				      		
				      ChartPanel panel =new ChartPanel(lineChartObject);	
				      panel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
				     
				      	JPanel jpanel =new JPanel();	
				      	jpanel.add(panel);
				      	
				      	
//				      int width = 640; /* Width of the image */
//				      int height = 480; /* Height of the image */ 
				      File lineChart = new File( "LineChart.jpeg" ); 
				      try {
						ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      
//		      JFreeChart lineChartObject = ChartFactory.createLineChart(
//		         "Temperature Vs Time","Time",
//		         "Hobart- Temperature",
//		         line_chart_dataset,PlotOrientation.VERTICAL,
//		         true,true,false);
//		      
//		      	int width =400;	
//		      	int height=300;
//		      	
////		      int width = 640; /* Width of the image */
////		      int height = 480; /* Height of the image */ 
//		      File lineChart = new File( "LineChart.jpeg" ); 
//		      try {
//				ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

}
