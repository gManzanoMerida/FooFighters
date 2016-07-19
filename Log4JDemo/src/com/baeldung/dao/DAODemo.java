package com.baeldung.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAODemo {

	private Log log = LogFactory.getLog(this.getClass());

	public DAODemo() {
		if (log.isDebugEnabled()) {
			log.debug("DEBUG log - DAODemo");
		}
		log.error("ERROR log - DAODemo");
	}

}
