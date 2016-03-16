package com.sept01.main;
import java.util.Iterator;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
public class State {
String name;
	public State(String name){
		this.name = name;
		System.out.println(this.name);
		updateWeather();
	}
	
	protected boolean updateWeather(){
		try{
			UserAgent userAgent = new UserAgent();
			 userAgent.visit("http://www.bom.gov.au/"+name+"/observations/"+name+"all.shtml");                        //visit a url  
			 Elements elements = userAgent.doc.findEvery("<a href>");
		
			 Iterator<Element> itr = elements.iterator();
			 int x = 0;
			 while(itr.hasNext()){
				 if(elements.getElement(x).getAtString("href").contains("product")){
					 System.out.println("search results:\n" + elements.getElement(x).getAtString("href")); 
				 }
				 itr.next();
				 x++;
			 }
		}catch(JauntException e){
			 System.err.println(e);
		}
		
		
		return false;
		
		
	}
	
	

}
