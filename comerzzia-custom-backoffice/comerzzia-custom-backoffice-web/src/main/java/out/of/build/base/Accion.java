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

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.comerzzia.core.model.acciones.AccionBean;


/**
 * Acción que se ejecuta en el servidor
 */
public abstract class Accion {

    /** Vista de la pagina de error en aplicación */
    protected static final Vista ERROR_PAGE = new Vista("comun/jsp/pagina_error.jsp", Vista.INTERNA);
    /** Vista de la pagina de error en ventana*/
    protected static final Vista ERROR_WIN = new Vista("comun/jsp/ventana_error.jsp", Vista.INTERNA);
    /** Vista de la pagina de informacion en aplicación */
    protected static final Vista INFO_PAGE = new Vista("comun/jsp/pagina_info.jsp", Vista.INTERNA);
    /** Vista de la pagina de información en ventana*/
    protected static final Vista INFO_WIN = new Vista("comun/jsp/ventana_info.jsp", Vista.INTERNA);
    /** Vista de la página de error por no tener permiso para ejecutar una acción*/
    protected static final Vista SIN_PERMISO = new Vista("comun/jsp/sin_permiso.jsp", Vista.INTERNA);
    /** Vista de la página de error por no poseer ningún almacén*/
    protected static final Vista SIN_ALMACEN = new Vista("comun/jsp/sin_almacen.jsp", Vista.INTERNA);
    /** Vista de la página de error por no poseer más de un almacén*/
    protected static final Vista NO_ELECCION_ALMACEN = new Vista("comun/jsp/no_eleccion_almacen.jsp", Vista.INTERNA);
    
    
    /**
     * Referencia al servlet controlador que registra la accion
     */
    private ControladorServlet controlador;
    
    /**
     * Constructor
     */
    public Accion() {
		//		WebApplicationContext context = WebApplicationContextUtils
		//	    .getWebApplicationContext(controlador.getServletContext());
		//	AutowireCapableBeanFactory ctx = context.getAutowireCapableBeanFactory();
		//	ctx.autowireBean(this);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);    	
    }
    
    /**
     * Devuelve el nombre identificador de la acción 
     * @return 
     */
	public abstract String getNombre();
	
	/**
	 * Devuelve la accion de menú asociada a la Accion 
	 * @return the accionMenu
	 */
	public AccionBean getAccionMenu() {
		return controlador.getAccionMenu();
	}

	/**
	 * Establece la referencia al servlet controlador en  el
	 * que la acción está registrada
	 * @param servlet the servlet to set
	 */
	public void setControlador(ControladorServlet controlador) {
		this.controlador = controlador;
	}

	/**
	 * Obtiene la referencia al servlet controlador en el
	 * que la acción está registrada
	 * @return the servlet
	 */
	public ControladorServlet getControlador() {
		return controlador;
	}

	/**
     * Ejecutará el código necesario para realizar la acción 
     * @param request datos de la peticion
     * @return 
     */
	public abstract Vista ejecutar(HttpServletRequest request);
	
	
	public void setMensajeError(HttpServletRequest request, String mensaje) {
		request.setAttribute(WebKeys.MENSAJE_ERROR, mensaje);
	}
	
	public void setMensajeError(HttpServletRequest request, String mensaje, String nextPage) {
		request.setAttribute(WebKeys.MENSAJE_ERROR, mensaje);
		request.setAttribute(WebKeys.NEXT_PAGE, nextPage);
	}
	
	public void setMensajeError(HttpServletRequest request, String mensaje, Throwable e) {
		request.setAttribute(WebKeys.MENSAJE_ERROR, mensaje);
		request.setAttribute(WebKeys.EXCEPTION, e);
	}
	
	public void setMensajeError(HttpServletRequest request, String mensaje, Throwable e, String nextPage) {
		request.setAttribute(WebKeys.MENSAJE_ERROR, mensaje);
		request.setAttribute(WebKeys.EXCEPTION, e);
		request.setAttribute(WebKeys.NEXT_PAGE, nextPage);
	}
	
	public void setError(HttpServletRequest request, Throwable e) {
		request.setAttribute(WebKeys.EXCEPTION, e);
	}
	
	public void setError(HttpServletRequest request, Throwable e, String nextPage) {
		request.setAttribute(WebKeys.EXCEPTION, e);
		request.setAttribute(WebKeys.NEXT_PAGE, nextPage);
	}
	
	public void setMensaje(HttpServletRequest request, String mensaje) {
		request.setAttribute(WebKeys.MENSAJE, mensaje);
	}
	
	public void setMensaje(HttpServletRequest request, String mensaje, String nextPage) {
		request.setAttribute(WebKeys.MENSAJE, mensaje);
		request.setAttribute(WebKeys.NEXT_PAGE, nextPage);
	}
	
	public void setMensajeAviso(HttpServletRequest request, String mensaje) {
		request.setAttribute(WebKeys.MENSAJE_AVISO, mensaje);
	}
	
	public void setMensajeAviso(HttpServletRequest request, String mensaje, String nextPage) {
		request.setAttribute(WebKeys.MENSAJE_AVISO, mensaje);
		request.setAttribute(WebKeys.NEXT_PAGE, nextPage);
	}
	
	public void setMensajeInfo(HttpServletRequest request, String mensaje) {
		request.setAttribute(WebKeys.MENSAJE_INFO, mensaje);
	}
	
	public void setMensajeInfo(HttpServletRequest request, String mensaje, String nextPage) {
		request.setAttribute(WebKeys.MENSAJE_INFO, mensaje);
		request.setAttribute(WebKeys.NEXT_PAGE, nextPage);
	}
}
