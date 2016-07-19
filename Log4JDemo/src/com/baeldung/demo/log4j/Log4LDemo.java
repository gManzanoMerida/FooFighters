package com.baeldung.demo.log4j;
 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;

import com.baeldung.dao.DAODemo;
import com.baeldung.util.Util;

public class Log4LDemo {
	
	public static void main(String[] args) {
		// Cargamos la configuración de Log4J desde un archivo accesible via CLASSPATH
		DOMConfigurator.configure(Log4LDemo.class.getClassLoader().getResource("Log4J_Config.xml"));
		
		// Obtenemos el Log para esta clase.
		Log log = LogFactory.getLog(Log4LDemo.class);
		
		// Por motivos de eficiencia, siempre se debería preguntar si está activado el log para este nivel.
		if (log.isDebugEnabled()){
			log.debug("DEBUG log - Log4LDemo");
		}
		
		log.error("ERROR log - Log4LDemo");
		
		DAODemo dao = new DAODemo();
		Util util = new Util();
	}
}
