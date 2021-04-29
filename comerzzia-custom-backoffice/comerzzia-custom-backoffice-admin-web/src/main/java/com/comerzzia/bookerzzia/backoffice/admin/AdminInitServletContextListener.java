package com.comerzzia.bookerzzia.backoffice.admin;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones.CustomServicioArticulosAlbaranesVentasImpl;
import com.comerzzia.servicios.ventas.albaranes.articulos.ServicioArticulosAlbaranesVentasImpl;

@WebListener
public class AdminInitServletContextListener extends com.comerzzia.web.listeners.BackofficeInitServletContextListener {

	protected static Logger log = Logger.getLogger(AdminInitServletContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Configuring custom services");
		
		/*
		 * Inyecta la instancia de la clase personalizada
		 * El módulo admin es el que procesa los documentos, es éste listener donde hay que inyectar las
		 * instancias de las clases personalizadas.
		 */
		ServicioArticulosAlbaranesVentasImpl.setCustomInstance(new CustomServicioArticulosAlbaranesVentasImpl());
		
		super.contextInitialized(sce);
		
		/*
		 * Inyecto la instancia de mi clase personalizada
		 */
		ServicioArticulosAlbaranesVentasImpl.setCustomInstance(new CustomServicioArticulosAlbaranesVentasImpl());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
