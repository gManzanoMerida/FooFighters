package test;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	/**
	 * To log a message, first, create a final static logger and define a name for the logger, 
	 * normally, we use the full package class name.
	 */
	final static Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		
		
		/**
		 * Then, logs messages with different priorities, for example, debug, info, warn, error and fatal. 
		 * Normally, you just need to use debug or error.
		 */
		String parameter = "PARAMETERS!!!!"; 
		 
		
		//logs a debug message
		if(logger.isDebugEnabled()){
		    logger.debug("This is debug");
		}
		
		//logs an error message with parameter
		logger.error("This is error : " + parameter);
		
		//logs an exception thrown from somewhere
		try{
			System.out.print("Hola");
		}catch(Exception exception){
			logger.error("This is error", exception);
		}
		
		//RunMe Example
		Log4jTest obj = new Log4jTest();
		obj.runMe("GMM");

	}
	
	/**
	 * RunMe example
	 * @param parameter
	 */
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}

}
