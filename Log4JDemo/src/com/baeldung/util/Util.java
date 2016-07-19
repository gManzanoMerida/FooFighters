package com.baeldung.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Util {

	private Log log = LogFactory.getLog(this.getClass());

	public Util(){
		if (log.isDebugEnabled()){
			log.debug("DEBUG log - Util");
		}
		log.error("ERROR log - Util");
	}

}
