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
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.core.model.acciones.AccionBean;
import com.comerzzia.core.servicios.acciones.AccionException;
import com.comerzzia.core.servicios.acciones.AccionesService;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.I18nUtil;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;

/**
 * Clase base para servlets
 */
public abstract class ControladorServlet extends SpringEnabledServlet {
	@Autowired
	private AccionesService servicioAcciones;
			
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -7482820726621608377L;

	/**
	 * Acción de menú asociada al servlet
	 */
	protected AccionBean accionMenu;

	/**
	 * Acciones que puede llevar a cabo el servlet
	 */
	protected HashMap<String, Accion> acciones;

	/**
	 * Inicializa el servlet
	 * 
	 * @param config
	 * @throws javax.servlet.ServletException
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// Obtenemos la información del la acción de menú asociada al servlet
		try {
			accionMenu = servicioAcciones.obtenerAccion(this.getClass().getCanonicalName());
		}
		catch (AccionException e) {
			log.error("Error al obtener la acción asociada a " + this.getClass().getCanonicalName());
		}

		// Registramos las acciones del servlet
		acciones = new HashMap<String, Accion>();
		loadAcciones();

		log.info("Servlet " + this.getServletName() + " inicializado correctamente");
	}

	/**
	 * Procesa peticiones HTTP GET
	 * 
	 * @param request
	 *            Informacion de la petición
	 * @param response
	 *            Informacion de la respuesta
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * Procesa peticiones HTTP POST
	 * 
	 * @param request
	 *            Información de la petición
	 * @param response
	 *            Información de la respuesta
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * Procesa peticiones GET y POST del servlet
	 * 
	 * @param request
	 *            Peticion
	 * @param response
	 *            Respuesta
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */
	protected void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codAccion = null;
		Accion accion = null;
		Vista vista = null;

		// si tenemos multiformdataRequest, lo obtenemos y lo pasamos como atributo del request para que lo trate la acción
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			MultipartFormDataRequest mrequest = (MultipartFormDataRequest) request.getAttribute(WebKeys.MULTIPART_REQUEST);
			if (mrequest == null) {
				try {
					mrequest = new MultipartFormDataRequest(request, null, MultipartFormDataRequest.MAXCONTENTLENGTHALLOWED, MultipartFormDataRequest.DEFAULTPARSER, "UTF-8", false);
					request.setAttribute(WebKeys.MULTIPART_REQUEST, mrequest);
					codAccion = mrequest.getParameter("accion");
				}
				catch (UploadException e) {
					log.warn("Error no se ha podido crear el MultipartFormDataRequest: " + e.getMessage());
				}
			}
		}
		else{
			 codAccion = getAccion(request);
		}
			
		// Obtenemos la acción solicitada
		if (codAccion == null) {
			codAccion = "default";
		}
		log.debug("performTask() - accion=" + codAccion);

		// Obtenemos la acción
		accion = (Accion) acciones.get(codAccion);

		// Si la acción está registrada en el servlet
		if (accion != null) {

			vista = accion.ejecutar(request);

			try {
				// Establecemos los permisos de la acción en el request
				DatosSesionBean datosSesion = (DatosSesionBean) request.getSession().getAttribute(WebKeys.DATOS_SESION);
				if (datosSesion != null && accion.getAccionMenu() != null) {
					request.setAttribute(WebKeys.PERMISOS, datosSesion.getPermisosCache(accion.getAccionMenu()));
					request.setAttribute(WebKeys.IDIOMA_SELECCIONADO, I18nUtil.obtenerIdiomaSeleccionado(request, datosSesion));
				}
			}
			catch (Exception e) {
				log.warn("No se han podido establecer los permisos de la acción en el request: " + e.getMessage());
			}

		}
		else { // Si no tenemos la acción registrada
			log.error("performTask() - accion=" + codAccion + " no registrada");

			Exception e = new RuntimeException("Se ha solicitado la acción no registrada \"" + codAccion + "\"" + " sobre el controlador " + this.getClass().getCanonicalName());
			request.setAttribute(WebKeys.EXCEPTION, e);
			vista = Accion.ERROR_PAGE;
		}

		// Devolvemos la siguiente vista
		dispatch(request, response, vista);
	}

	/**
	 * Devuelve el nombre de la accion contenida en la petición
	 * 
	 * @param request
	 *            Datos de la petición
	 * @return Cadena con el nombre de la acción solicitada
	 */
	protected String getAccion(HttpServletRequest request) {
		return request.getParameter("accion");
	}

	/**
	 * Redirige a la siguiente pagina en función de la vista pasada
	 * 
	 * @param request
	 *            Datos de la peticion
	 * @param response
	 *            Datos de la respuesta
	 * @param nextPage
	 *            Siguiente pagina a mostrar
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 */
	protected void dispatch(HttpServletRequest request, HttpServletResponse response, Vista nextPage) throws ServletException, IOException {
		// Establecemos propiedades de cache
		response.setHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);

		if (nextPage == null) {
			log.warn("dispatch() - Se ha recibido una Vista null");
			response.sendError(HttpServletResponse.SC_ACCEPTED, "La petición ha sido procesada pero un error interno ha provocado que " + "no se pueda continuar. Consulte con el Administrador.");
			return;
		}

		if (nextPage.getTipo() == Vista.EXTERNA) {
			response.sendRedirect(nextPage.getURL());
		}
		else if (nextPage.getTipo() == Vista.INTERNA) {
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage.getURL());
			dispatch.forward(request, response);
		}
	}

	/**
	 * Registra la acción en el servlet
	 * 
	 * @param accion
	 */
	protected void añadirAccion(Accion accion) {
		accion.setControlador(this);
		acciones.put(accion.getNombre(), accion);
	}

	/**
	 * Registra la acción en el servlet y la establece como acción por defecto
	 * 
	 * @param accion
	 */
	protected void añadirAccionDefault(Accion accion) {
		añadirAccion(accion);
		acciones.put("default", accion);
	}

	/**
	 * Obtiene la Accion registrada en el servlet por su nombre
	 * 
	 * @param nombre
	 * @return
	 */
	public Accion getAccion(String nombre) {
		return acciones.get(nombre);
	}

	/**
	 * Obtiene la acción de menú asociada al servlet
	 * 
	 * @return the accionMenu
	 */
	public AccionBean getAccionMenu() {
		return accionMenu;
	}

	/**
	 * Establece la acción de menú asociada al servlet
	 * 
	 * @param accionMenu
	 *            the accionMenu to set
	 */
	public void setAccionMenu(AccionBean accionMenu) {
		this.accionMenu = accionMenu;
	}

	/**
	 * Carga las acciones que puede llevar a cabo el servlet
	 */
	protected abstract void loadAcciones();
}