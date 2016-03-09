package com.gmm.fooWebProject.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LogFile {

	static Logger logFile = Logger.getLogger(LogFile.class);

	/**
	 * Constructor
	 */
	public LogFile() {
		super();
	}

	/**
	 * Obtiene y configura el logger para My Account
	 * 
	 * @return Logger. Objeto de log4j.
	 */
	public static Logger configLogger(final String strNombreLog) {
		String strDirectorio = Constantes.RUTA_LOGS;
		logFile.setAdditivity(false);
		final String APPENDER_CAPATG = strDirectorio + strNombreLog + ".log";
		String loggerName = LogFile.class.getName();

		Properties propiedadesGILog = new Properties();
		propiedadesGILog.setProperty("log4j.logger." + loggerName, "debug, " + loggerName);
		propiedadesGILog.setProperty("log4j.appender." + loggerName, "org.apache.log4j.RollingFileAppender");
		propiedadesGILog.setProperty("log4j.appender." + loggerName + ".File", APPENDER_CAPATG);
		propiedadesGILog.setProperty("log4j.appender." + loggerName + ".MaxFileSize", "2MB");
		propiedadesGILog.setProperty("log4j.appender." + loggerName + ".MaxBackupIndex", "3");
		propiedadesGILog.setProperty("log4j.appender." + loggerName + ".layout", "org.apache.log4j.PatternLayout");
		propiedadesGILog.setProperty("log4j.appender." + loggerName + ".layout.ConversionPattern", "[%d{dd/MM/yyyy HH:mm:ss:SSS}] %-5p %l %x: %m%n");

		PropertyConfigurator.configure(propiedadesGILog);

		return logFile;

	}

}
