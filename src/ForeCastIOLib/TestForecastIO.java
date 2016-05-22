package ForeCastIOLib;
import ForeCastIOLib.ForecastIO;

public class TestForecastIO {

	public static void main (String args[])
	{	
		
		//https:api.forecast.io/forecast/5370c63bf884c9970205d009908f1575/37.8267,-122.423
			ForecastIO fio = new ForecastIO("5370c63bf884c9970205d009908f1575");
	    fio.setUnits(ForecastIO.UNITS_SI);
	    fio.setLang(ForecastIO.LANG_ENGLISH);
	    fio.getForecast("37.8267", "-122.423");
	    System.out.println("Latitude: "+fio.getLatitude());
	    System.out.println("Longitude: "+fio.getLongitude());
	    System.out.println("Timezone: "+fio.getTimezone());
	    System.out.println("Offset: "+fio.offset());
	    
	    
	    FIOCurrently currently = new FIOCurrently(fio);
	    //Print currently data
	    System.out.println("\nCurrently\n");
	    String [] f  = currently.get().getFieldsArray();
	    for(int i = 0; i<f.length;i++)
	        System.out.println(f[i]+": "+currently.get().getByKey(f[i]));
	    
	    //daily
	    
	  
	    // This is the daily report we need for the assignment
	    FIODaily daily = new FIODaily(fio);
	    //In case there is no daily data available
	    if(daily.days()<0)
	        System.out.println("No daily data.");
	    else
	        System.out.println("\nDaily:\n");
	    //Print daily data
	    for(int i = 0; i<daily.days(); i++){
	        String [] h = daily.getDay(i).getFieldsArray();
	        System.out.println("Day #"+(i+1));
	        for(int j=0; j<h.length; j++)
	            System.out.println(h[j]+": "+daily.getDay(i).getByKey(h[j]));
	        System.out.println("\n");
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	
}
