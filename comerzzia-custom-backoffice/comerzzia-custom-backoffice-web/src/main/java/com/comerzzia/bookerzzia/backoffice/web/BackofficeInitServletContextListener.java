package com.comerzzia.bookerzzia.backoffice.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;


@WebListener
public class BackofficeInitServletContextListener extends com.comerzzia.web.listeners.BackofficeInitServletContextListener {

	protected static Logger log = Logger.getLogger(BackofficeInitServletContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Configuring custom services");
		
		super.contextInitialized(sce);

		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
