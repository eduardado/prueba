/**
 * ComerZZia 3.0
 *
 * Copyright (c) 2008-2015 Comerzzia, S.L.  All Rights Reserved.
 *
 * THIS WORK IS  SUBJECT  TO  SPAIN  AND  INTERNATIONAL  COPYRIGHT  LAWS  AND
 * TREATIES.   NO  PART  OF  THIS  WORK MAY BE  USED,  PRACTICED,  PERFORMED
 * COPIED, DISTRIBUTED, REVISED, MODIFIED, TRANSLATED,  ABRIDGED, CONDENSED,
 * EXPANDED,  COLLECTED,  COMPILED,  LINKED,  RECAST, TRANSFORMED OR ADAPTED
 * WITHOUT THE PRIOR WRITTEN CONSENT OF COMERZZIA, S.L. ANY USE OR EXPLOITATION
 * OF THIS WORK WITHOUT AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO
 * CRIMINAL AND CIVIL LIABILITY.
 *
 * CONSULT THE END USER LICENSE AGREEMENT FOR INFORMATION ON ADDITIONAL
 * RESTRICTIONS.
 */
package com.comerzzia.web.base;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Clase base para servlets
 */
@Configurable
public abstract class SpringEnabledServlet extends HttpServlet {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1488293754993164938L;
	
	/**
	 * Logger
	 */
	protected static Logger log;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		log = Logger.getLogger(this.getClass());
		log.info("Initializing Spring Enabled Servlet " + this.getServletName());
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
// metodo alternativo		
//		WebApplicationContext context = WebApplicationContextUtils
//		    .getWebApplicationContext(getServletContext());
//		AutowireCapableBeanFactory ctx = context.getAutowireCapableBeanFactory();
//		ctx.autowireBean(this);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}