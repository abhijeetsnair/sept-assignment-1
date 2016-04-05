package com.sept01.main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sept01.view.MainView;
import com.sept01.view.areas.WestPanel;

public class Singleton {
		private MainView MainView;	
		private int  xloc;
		private int yloc;
		private com.sept01.view.areas.EastPanel EastPanel;
		private WestPanel WestPanel;
		private com.sept01.view.areas.CenterPanel CenterPanel;	
		private com.sept01.view.areas.NorthPanel NorthPanel;	
		private com.sept01.view.areas.SouthPanel SouthPanel;
		private ArrayList<Favourites> fav = new ArrayList<Favourites>();
		ArrayList<State> states = new ArrayList<State>();
		// Create all the states
		State NSW = new State("NSW");
		State VIC = new State("VIC");
		State QLD = new State("QLD");
		State WA = new State("WA");
		State SA = new State("SA");
		State TAS = new State("TAS");
		State ACT = new State("ACT");
		State NT = new State("NT");
		State ANTARTICA = new State("ANTARTICA");
	   public JFrame getMainView() {
			return MainView;
		}

		public ArrayList<Favourites> getFav() {
		return fav;
	}

	public void setFav(ArrayList<Favourites> fav) {
		this.fav = fav;
	}

	public ArrayList<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

		public void setMainView(MainView mainView) {
			MainView = mainView;
		}

		public com.sept01.view.areas.EastPanel getEastPanel() {
			return EastPanel;
		}

		public void setEastPanel(com.sept01.view.areas.EastPanel eastPanel) {
			EastPanel = eastPanel;
		}

		public JPanel getWestPanel() {
			return WestPanel;
		}

		public void setWestPanel(com.sept01.view.areas.WestPanel westPanel) {
			WestPanel = westPanel;
		}

		public JPanel getCenterPanel() {
			return CenterPanel;
		}

		public void setCenterPanel(com.sept01.view.areas.CenterPanel centerPanel) {
			CenterPanel = centerPanel;
		}

		public JPanel getNorthPanel() {
			return NorthPanel;
		}

		public void setNorthPanel(com.sept01.view.areas.NorthPanel northPanel) {
			NorthPanel = northPanel;
		}

		public JPanel getSouthPanel() {
			return SouthPanel;
		}

		public void setSouthPanel(com.sept01.view.areas.SouthPanel southPanel) {
			SouthPanel = southPanel;
		}

		public static Singleton getSingleton() {
			return singleton;
		}

		public static void setSingleton(Singleton singleton) {
			Singleton.singleton = singleton;
		}
	private static Singleton singleton = new Singleton( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private Singleton(){ }
	   
	   /* Static 'instance' method */
	   public static Singleton getInstance( ) {
	      return singleton;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for singleton"); 
	   }	
	   	
	   public void initialiseStates() {
			// Adding cities in New South wales
//			states.add(NSW);
//			NSW.addCity("Cape Bryon");
//			NSW.addCity("Casino");
//			NSW.addCity("Coolangatta");
//			NSW.addCity("Evans Head");
//			NSW.addCity("Grafton AgRS");
//			NSW.addCity("Grafton Airpot");
//			NSW.addCity("Lismore Airport");
//			NSW.addCity("Murwillumbah");
//			NSW.addCity("Yamba");
//			NSW.addCity("Coffs Harbour Airport");
//			NSW.addCity("Forster");
//			NSW.addCity("kempsey airport");
//			NSW.addCity("Mount Seaview");
//			NSW.addCity("Port Macquaire Airport");
//			NSW.addCity("Smoky Cape");
//			NSW.addCity("Taree Airport");
//			NSW.addCity("Cassnock Airport");
//			NSW.addCity("Taree Airport");
//			NSW.addCity("Cassnock Airport");
//			NSW.addCity("Taree Airport");
//			NSW.addCity("Cassnock Airport");
//			NSW.addCity("Taree Airport");
//			NSW.addCity("Cassnock Airport");
//
//			states.add(VIC);
//
//			// Adding cities in Victoria
//			VIC.addCity("VIC");
//			VIC.addCity("Cape Bryon");
//			VIC.addCity("Casino");
//			VIC.addCity("Coolangatta");
//			VIC.addCity("Evans Head");
//			VIC.addCity("Grafton AgRS");
//			VIC.addCity("Grafton Airpot");
//			VIC.addCity("Lismore Airport");
//			VIC.addCity("Murwillumbah");
//			VIC.addCity("Yamba");
//			VIC.addCity("Coffs Harbour Airport");
//			VIC.addCity("Forster");
//			VIC.addCity("kempsey airport");
//			VIC.addCity("Mount Seaview");
//			VIC.addCity("Port Macquaire Airport");
//			VIC.addCity("Smoky Cape");
//			VIC.addCity("Taree Airport");
//			VIC.addCity("Cassnock Airport");
//
//			states.add(QLD);
//
//			QLD.addCity("QLD");
//			QLD.addCity("Cape Bryon");
//			QLD.addCity("Casino");
//			QLD.addCity("Coolangatta");
//			QLD.addCity("Evans Head");
//			QLD.addCity("Grafton AgRS");
//			QLD.addCity("Grafton Airpot");
//			QLD.addCity("Lismore Airport");
//			QLD.addCity("Murwillumbah");
//			QLD.addCity("Yamba");
//			QLD.addCity("Coffs Harbour Airport");
//			QLD.addCity("Forster");
//			QLD.addCity("kempsey airport");
//			QLD.addCity("Mount Seaview");
//			QLD.addCity("Port Macquaire Airport");
//			QLD.addCity("Smoky Cape");
//			QLD.addCity("Taree Airport");
//			QLD.addCity("Cassnock Airport");
//			// West Australia
//			states.add(WA);
//			WA.addCity("WA");
//			WA.addCity("Cape Bryon");
//			WA.addCity("Casino");
//			WA.addCity("Coolangatta");
//			WA.addCity("Evans Head");
//			WA.addCity("Grafton AgRS");
//			WA.addCity("Grafton Airpot");
//			WA.addCity("Lismore Airport");
//			WA.addCity("Murwillumbah");
//			WA.addCity("Yamba");
//			WA.addCity("Coffs Harbour Airport");
//			WA.addCity("Forster");
//			WA.addCity("kempsey airport");
//			WA.addCity("Mount Seaview");
//			WA.addCity("Port Macquaire Airport");
//			WA.addCity("Smoky Cape");
//			WA.addCity("Taree Airport");
//			WA.addCity("Cassnock Airport");
//
//			// South Australia
//
//			states.add(SA);
//			SA.addCity("SA");
//			SA.addCity("Cape Bryon");
//			SA.addCity("Casino");
//			SA.addCity("Coolangatta");
//			SA.addCity("Evans Head");
//			SA.addCity("Grafton AgRS");
//			SA.addCity("Grafton Airpot");
//			SA.addCity("Lismore Airport");
//			SA.addCity("Murwillumbah");
//			SA.addCity("Yamba");
//			SA.addCity("Coffs Harbour Airport");
//			SA.addCity("Forster");
//			SA.addCity("kempsey airport");
//			SA.addCity("Mount Seaview");
//			SA.addCity("Port Macquaire Airport");
//			SA.addCity("Smoky Cape");
//			SA.addCity("Taree Airport");
//			SA.addCity("Cassnock Airport");
//
//			states.add(TAS);
//			TAS.addCity("TAS");
//			TAS.addCity("Cape Bryon");
//			TAS.addCity("Casino");
//			TAS.addCity("Coolangatta");
//			TAS.addCity("Evans Head");
//			TAS.addCity("Grafton AgRS");
//			TAS.addCity("Grafton Airpot");
//			TAS.addCity("Lismore Airport");
//			TAS.addCity("Murwillumbah");
//			TAS.addCity("Yamba");
//			TAS.addCity("Coffs Harbour Airport");
//			TAS.addCity("Forster");
//			TAS.addCity("kempsey airport");
//			TAS.addCity("Mount Seaview");
//			TAS.addCity("Port Macquaire Airport");
//			TAS.addCity("Smoky Cape");
//			TAS.addCity("Taree Airport");
//			TAS.addCity("Cassnock Airport");
//
//			states.add(ACT);
//			ACT.addCity("Ballina");
//			ACT.addCity("Cape Bryon");
//			ACT.addCity("Casino");
//			ACT.addCity("Coolangatta");
//			ACT.addCity("Evans Head");
//			ACT.addCity("Grafton AgRS");
//			ACT.addCity("Grafton Airpot");
//			ACT.addCity("Lismore Airport");
//			ACT.addCity("Murwillumbah");
//			ACT.addCity("Yamba");
//			ACT.addCity("Coffs Harbour Airport");
//			ACT.addCity("Forster");
//			ACT.addCity("kempsey airport");
//			ACT.addCity("Mount Seaview");
//			ACT.addCity("Port Macquaire Airport");
//			ACT.addCity("Smoky Cape");
//			ACT.addCity("Taree Airport");
//			ACT.addCity("Cassnock Airport");
//
//			states.add(NT);
//			NT.addCity("NT");
//			NT.addCity("Cape Bryon");
//			NT.addCity("Casino");
//			NT.addCity("Coolangatta");
//			NT.addCity("Evans Head");
//			NT.addCity("Grafton AgRS");
//			NT.addCity("Grafton Airpot");
//			NT.addCity("Lismore Airport");
//			NT.addCity("Murwillumbah");
//			NT.addCity("Yamba");
//			NT.addCity("Coffs Harbour Airport");
//			NT.addCity("Forster");
//			NT.addCity("kempsey airport");
//			NT.addCity("Mount Seaview");
//			NT.addCity("Port Macquaire Airport");
//			NT.addCity("Smoky Cape");
//			NT.addCity("Taree Airport");
//			NT.addCity("Cassnock Airport");
//
//			states.add(ANTARTICA);
//
//			ANTARTICA.addCity("ANTARTICA");
//			ANTARTICA.addCity("Cape Bryon");
//			ANTARTICA.addCity("Casino");
//			ANTARTICA.addCity("Coolangatta");
//			ANTARTICA.addCity("Evans Head");
//			ANTARTICA.addCity("Grafton AgRS");
//			ANTARTICA.addCity("Grafton Airpot");
//			ANTARTICA.addCity("Lismore Airport");
//			ANTARTICA.addCity("Murwillumbah");
//			ANTARTICA.addCity("Yamba");
//			ANTARTICA.addCity("Coffs Harbour Airport");
//			ANTARTICA.addCity("Forster");
//			ANTARTICA.addCity("kempsey airport");
//			ANTARTICA.addCity("Mount Seaview");
//			ANTARTICA.addCity("Port Macquaire Airport");
//			ANTARTICA.addCity("Smoky Cape");
//			ANTARTICA.addCity("Taree Airport");
//			ANTARTICA.addCity("Cassnock Airport");
		}
	   
//		public State getState(String state) {
//			for (int i = 0; i < states.size(); i++) {
//				if (states.get(i).getName().compareTo(state) == 0) {
//					return states.get(i);
//				}
//			}
//			return null;
//		}

		public Area getArea(String area) {
			for (int i = 0; i < states.size(); i++) {	
				for (int j = 0; j < states.size(); j++) {
			
					if (states.get(i).areas.get(j).getName() == area) {	
						System.out.println("This is it"+states.get(i).areas.get(j));
						 return states.get(i).areas.get(j);
					}
				}

			}
			return null;
		}

		public void addFav(Favourites favoriate) {
			// Adds to the favorites list and updates the view
			fav.add(favoriate);
		}

		public void remFav(Favourites favourite) {

			for (int i = 0; i < fav.size(); i++) {
				if (fav.get(i).getArea().getName().compareTo(favourite.getArea().getName()) == 0) {
					fav.remove(i);
				}
			}
		}

		public int getXloc() {
			return xloc;
		}

		public void setXloc(int xloc) {
			this.xloc = xloc;
		}

		public int  getYloc() {
			return yloc;
		}

		public void setYloc(int yloc) {
			this.yloc = yloc;
		}
	   	
	   
	}