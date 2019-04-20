package info.trustzone.logger;

/*
 * Inspiration:
 *   https://stackoverflow.com/questions/20737880/java-logging-through-multiple-classes/20739785
 *   https://www.youtube.com/watch?v=4Bpg5i4tUFg
 */

import java.io.IOException;
import java.util.logging.*;
//import java.util.logging.SimpleFormatter;
//import java.util.logging.FileHandler;
//import java.util.logging.Handler;
//import java.util.logging.Logger;
//import java.util.logging.Level;

// How to customize
// https://www.google.com/search?q=java.io.IOException+logger+hide+datetime&oq=java.io.IOException+logger+hide+datetime&aqs=chrome..69i57.11392j0j4&sourceid=chrome&ie=UTF-8

public class MyLog {
	static Logger logger;
	public Handler fileHandler;
	private SimpleFormatter plainText;
	//private String myFormatString;
	
	private MyLog() throws IOException {
		logger = Logger.getLogger(MyLog.class.getName());
		fileHandler = new FileHandler("errorlog.txt",true);
		plainText = new SimpleFormatter();
		//myFormatString=plainText.format(null);
		fileHandler.setFormatter(plainText);
		logger.addHandler(fileHandler);
	}
	
	private static Logger getLogger(){
	    if(logger == null){
	        try {
	            new MyLog();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return logger;
	}
	
	public static void info(String msg){
	    getLogger().log(Level.INFO, msg);
	}
	
	public static void exception(Exception e, String message) throws Exception {
		boolean isMyException;
		
		isMyException = e instanceof AlreadyHandledException;
				
		if (isMyException) {
			if (message.length()>0) {
				getLogger().log(Level.SEVERE, message);
			}
			throw (AlreadyHandledException)e;
		} else {
			getLogger().log(Level.SEVERE, e.getMessage(), e);
			if (message.length()>0) {
				getLogger().log(Level.SEVERE, message);
			}
			throw new AlreadyHandledException();
		}
	}
	
}
