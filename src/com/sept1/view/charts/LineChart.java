package com.sept1.view.charts;

import java.io.*;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
	
// Line chart that shows line graph for the temperature information 
//present in the system 


public class LineChart
{
   public static void main( String[ ] args ) throws Exception
   {
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      line_chart_dataset.addValue( 10, "temp" , "" );
      line_chart_dataset.addValue( 12 , "temp" , "9 am" );
      line_chart_dataset.addValue( 19 , "temp" , "10 am" );
      line_chart_dataset.addValue( 20 , "temp" , "11 am" );
      line_chart_dataset.addValue( 21 , "temp" , "12 pm" );
      line_chart_dataset.addValue( 22 , "temp" , "13 pm" ); 
      line_chart_dataset.addValue( 10 , "temp" , "14 pm" );

      JFreeChart lineChartObject = ChartFactory.createLineChart(
         "Temperature Vs Time","Time",
         "Hobart- Temperature",
         line_chart_dataset,PlotOrientation.VERTICAL,
         true,true,false);
      
      	int width =400;	
      	int height=300;
      	
//      int width = 640; /* Width of the image */
//      int height = 480; /* Height of the image */ 
      File lineChart = new File( "LineChart.jpeg" ); 
      ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
   }
}