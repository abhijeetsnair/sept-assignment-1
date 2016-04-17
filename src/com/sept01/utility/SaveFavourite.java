package com.sept01.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.sept01.model.Singleton;
/*
 * NOTE :-
 *SAVE FAVOURIATE :-
 *THE SAVE FAVOURITE CLASS SAVES FAVOURITES SUCH THAT EACH TIME
 *THE APPLICATION IS ACCESSED THE FAVORITAES PERMANENTLY GET STORED TO A TEXT FILE
 *EACH TIME THE APPLICATION IS ACCESSED THE FAVORIATES GET SHOWN TO THE USER
 */
public class SaveFavourite {
	
	private String fileName = "Fav/fav.txt";

	public SaveFavourite(){
    try {
        // Assume default encoding.
        FileWriter fileWriter =
            new FileWriter(fileName);

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);

        // Note that write() does not automatically
        // append a newline character.	
        	
        for(int i=0;i<Singleton.getInstance().getApplication().getFav().size();i++)
        {	
        		
            bufferedWriter.write(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName()+"-"+Singleton.getInstance().getApplication().getFav().get(i).getStation().url);
	        //	        bufferedWriter.append(fav.getStation().getName()+"-"+fav.getStation().url);
	        bufferedWriter.newLine();	
        }
        // Always close files.
        bufferedWriter.close();
    }
    catch(IOException ex) {
        System.out.println(
            "Error writing to file '"
            + fileName + "'");
        // Or we could just do this:
        // ex.printStackTrace();
    }
}
}
