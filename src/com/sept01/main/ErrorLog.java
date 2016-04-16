package com.sept01.main;

import java.awt.Color;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

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
		this.time = time;
	}
	
	private Time getTime(){
		return time;
	}
	
	private String getMsg(){
		return msg;
	}
	public static void createErrorPopup(Exception e){
		JFrame frame = new JFrame("ERROR");
		
		JOptionPane.showMessageDialog(frame, eToString(e.getMessage()),"ERROR ",JOptionPane.ERROR_MESSAGE);

		
	}
	public static void createErrorPopup(String e){
		JFrame frame = new JFrame("ERROR");
		
		JOptionPane.showMessageDialog(frame, eToString(e),"ERROR ",JOptionPane.ERROR_MESSAGE);

		
	}
}
