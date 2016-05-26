package com.sept01.utility;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * <p>
 * A Utility Class that is used for Error Logging related functionality.
 * </p>
 * <p>
 * Examples of Use: Popup messages, Error messages
 * </p>
 * @version 1.0
 * @see Time
 * @see Date
 */
public class ErrorLog {

	static Time time;
	static Date date;
	String msg;
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	private static String eToString(String msg){
		date = new Date();
		String outString = "ERROR " + date.toString() + " " + msg;
		return outString;
	}
	
	public void setTime(Time time){
		ErrorLog.time = time;
	}
	
	@SuppressWarnings("unused")
	private Time getTime(){
		return time;
	}
	
	@SuppressWarnings("unused")
	private String getMsg(){
		return msg;
	}
	public static void createErrorPopup(Exception e){
		JFrame frame = new JFrame("ERROR");
		// assuming a JFrame called frame...
		JOptionPane optionPane = new JOptionPane("ERROR"); 
		optionPane.setMessage(eToString(e.getMessage()));
		JDialog eDialog = optionPane.createDialog(frame, "ERROR");
		
		eDialog.setModal(false);
		eDialog.setVisible(true);
//		JOptionPane.showMessageDialog(frame, eToString(e.getMessage()),"ERROR ",JOptionPane.ERROR_MESSAGE);

		
	}
	public static void createErrorPopup(String e){
		JFrame frame = new JFrame("ERROR");
		// assuming a JFrame called frame...
		JOptionPane optionPane = new JOptionPane("ERROR"); 
		optionPane.setMessage(eToString(e));
		JDialog eDialog = optionPane.createDialog(frame, "ERROR");
		
		eDialog.setModal(false);
		eDialog.setVisible(true);
		
//		JOptionPane.showMessageDialog(frame, eToString(e),"ERROR ",JOptionPane.ERROR_MESSAGE);

		
	}
}
