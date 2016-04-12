package com.sept01.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadScreenLoc {
   	int i=0;

	public ReadScreenLoc()
	{	
		
		String fileName = "Fav/loc.txt";
		String loc;
	    try{
	        FileReader fr= new FileReader(fileName);
	        BufferedReader br= new BufferedReader(fr);
	        System.out.println("--------");
	    while ((loc=br.readLine()) != null){		
	 
	    	++i;
	    	if(i==1)
	    	{
	    		Singleton.getInstance().setXloc(Integer.parseInt(loc));	

	    	}
	    	else
	    	{	
	    		Singleton.getInstance().setYloc(Integer.parseInt(loc));
	    	}
	    	
	    	System.out.println(loc);
	    	
	    }	
	    System.out.println(Singleton.getInstance().getXloc() +" sdsds"+Singleton.getInstance().getYloc());
	        br.close();

	    }catch (IOException e){	
	    	System.out.println("Reading has issues");
	    }
	}
}
