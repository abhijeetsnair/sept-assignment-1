package com.sept01.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFavouriate {
	
	private String fileName = "Fav/fav.txt";

	public SaveFavouriate(){
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
        	 bufferedWriter.write(Singleton.getInstance().getApplication().getFav().get(i).getStation().getName());
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
