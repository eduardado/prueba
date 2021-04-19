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

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.core.model.acciones.AccionBean;
import com.comerzzia.core.model.informes.TrabajoInformeBean;
import com.comerzzia.core.model.informes.VersionInformeBean;
import com.comerzzia.core.servicios.acciones.AccionException;
import com.comerzzia.core.servicios.acciones.AccionesService;
import com.comerzzia.core.servicios.acciones.operaciones.OperacionConstraintViolationException;
import com.comerzzia.core.servicios.acciones.operaciones.OperacionException;
import com.comerzzia.core.servicios.informes.InformeConstraintViolationException;
import com.comerzzia.core.servicios.informes.InformeException;
import com.comerzzia.core.servicios.informes.InformeNotFoundException;
import com.comerzzia.core.servicios.informes.InformesService;
import com.comerzzia.core.servicios.permisos.PermisoConstraintViolationException;
import com.comerzzia.core.servicios.permisos.PermisoException;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.web.i18n.ui.i18nUtil;

public abstract class InformeAccion extends Accion {

	protected static final Vista FORM_PAGE = new Vista("core/informes/jsp/version.jsp", Vista.INTERNA);
	protected static final Vista DOWNLOAD_PAGE = new Vista("/informes", Vista.INTERNA);
	
	protected static final String OP_IMPRIMIR = "imprimir";
	protected static final String OP_IMPRIMIR_RAPIDO = "imprimirRapido";
	protected static final String OP_EJECUTAR = "ejecutar";
	
	protected static final String OP_NUEVA_VERSION = "nuevaVersion";
	protected static final String OP_EDITAR_VERSION = "editar";
	protected static final String OP_ELIMINAR_VERSION = "eliminar";
	protected static final String OP_TRATAR_FICHERO = "tratarFichero";

	protected Vista ERROR = ERROR_PAGE;

	protected static Logger log;

	protected AccionBean accionInforme;
	protected PermisosEfectivosAccionBean permisosInforme;

	@Autowired
	InformesService informesService;
	
	@Autowired
	AccionesService accionesService;
	
	public AccionBean getAccionInforme() {
		return this.accionInforme;
	}

	public String getNombre() {
		return getNombreInforme();
	}

	public abstract Vista vistaInforme(HttpServletRequest request);

	public abstract void imprimirInforme(HttpServletRequest request, TrabajoInformeBean trabajoInforme) throws InformeException;

	public abstract String getNombreInforme();

	public InformeAccion() {
		log = Logger.getLogger(this.getClass());
		try {
			accionInforme = accionesService.obtenerAccion(getNombreInforme());
		}
		catch (AccionException e) {
			log.error("Error al obtener la acción asociada al informe " + getNombreInforme());
		}
	}

	public Vista ejecutar(HttpServletRequest request) {
		try {
			MultipartFormDataRequest mrequest = (MultipartFormDataRequest) request.getAttribute(WebKeys.MULTIPART_REQUEST);

			String operacionReq = (String) request.getAttribute("operacion");
			HttpSession session = request.getSession(false);
			String operacion = request.getParameter("operacion");
			
			DatosSesionBean datosSesion = (DatosSesionBean) request.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			/*
			 * Se comprueba si se tiene permiso de ejecución para la pantalla desde la que se lanza el informe 
			 */
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisos(getAccionMenu());
    		if (!permisos.isPuedeEjecutar()) {
    			return SIN_PERMISO;
    		}
			
    		/*
    		 * Obtenemos los permisos para la acción del informe.
    		 */
			permisosInforme = datosSesion.getPermisos(getAccionInforme());
			request.setAttribute(WebKeys.PERMISOS_INFORME, datosSesion.getPermisosCache(getAccionInforme()));
			
			if (mrequest != null) {
				inicia(mrequest, request);
				operacion = mrequest.getParameter("operacion");
			}

			/*
			 * Si la operación está relacionada con la administración de las versiones (añadir, editar y eliminar), sólo si se es administrador
			 * se tendrá permiso.
			 */
			if (OP_NUEVA_VERSION.equalsIgnoreCase(operacionReq) || OP_NUEVA_VERSION.equalsIgnoreCase(operacion) || 
					OP_EDITAR_VERSION.equalsIgnoreCase(operacionReq) || OP_EDITAR_VERSION.equalsIgnoreCase(operacion) ||
					OP_ELIMINAR_VERSION.equalsIgnoreCase(operacionReq) || OP_ELIMINAR_VERSION.equalsIgnoreCase(operacion) ) {
				if (!permisos.isPuedeAdministrar()) {
					return SIN_PERMISO;
				}
			}

			// Preguntamos por la operación. Por defecto, se ejecuta la operación que muestra el lanzador de informes.
			if (OP_EJECUTAR.equalsIgnoreCase(operacionReq) || OP_EJECUTAR.equalsIgnoreCase(operacion) || (operacion == null && operacionReq == null)) {
				listado_versiones(request, session);
				
				String idObjeto = null;
				try{
					idObjeto = request.getParameter(WebKeys.ID_OBJETO);
				}catch(Exception e){
				}
				session.setAttribute(WebKeys.ID_OBJETO, idObjeto);
				
				return vistaInforme(request);

			}// Envio de formulario para crear una nueva versión.
			if (OP_NUEVA_VERSION.equalsIgnoreCase(operacion) || OP_NUEVA_VERSION.equalsIgnoreCase(operacionReq)) {
				return nueva_version(session);
			}// En caso de edición, se recupera la versión solicitada y se carga en el formulario.
			if (OP_EDITAR_VERSION.equalsIgnoreCase(operacion)) {
				return editar(request, session);
			}
			// Tratar la subida/modificación de un fichero .jrxml.
			if (OP_TRATAR_FICHERO.equalsIgnoreCase(operacion)) {
				return tratarFichero(mrequest, request);
			}
			// Eliminar una versión.
			if (OP_ELIMINAR_VERSION.equalsIgnoreCase(operacion)) {
				return eliminar(request);
			}
			if (OP_IMPRIMIR.equalsIgnoreCase(operacion)) {
				return imprimir(request, datosSesion, session);
			}
			if (OP_IMPRIMIR_RAPIDO.equalsIgnoreCase(operacion)) {
				return imprimirRapido(request, datosSesion, session);
			}
			setMensaje(request,datosSesion.getTranslation()._("No se ha indicado una operación correcta para ejecutar el informe."));
			return ERROR;
		}
		catch (InformeConstraintViolationException e) {
			setMensajeError(request, e.getMessage());
			return FORM_PAGE;
		}
		catch (InformeNotFoundException e) {
			setMensajeError(request, e.getMessage());
			return FORM_PAGE;
		}
		catch (InformeException e) {
			setMensajeError(request, e.getMessage());
			return ERROR;
		}
		catch (OperacionException e) {
			setMensajeError(request, e.getMessage());
			return ERROR;
		}
		catch (PermisoException e) {
			setMensajeError(request, e.getMessage());
			return ERROR;
		}
		catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		
	}
	
	protected String correccion(String s) {
		s = s.toLowerCase();
		String first = s.substring(0, 1);
		first = first.toUpperCase();
		String res = first + s.substring(1);
		return res;
	}

	protected TrabajoInformeBean listado_versiones(HttpServletRequest request, HttpSession session) throws InformeException {
		// creamos un nuevo trabajo para ese informe
		TrabajoInformeBean trabajoInforme = new TrabajoInformeBean();
		trabajoInforme.setIdInforme(getAccionInforme().getIdAccion());
		trabajoInforme.setInforme(getAccionInforme().getAccion());
		trabajoInforme.setTitulo(getAccionInforme().getTitulo());
		session.setAttribute(WebKeys.TRABAJO_INFORME, trabajoInforme);

		// consultamos lista de versiones disponibles
		List<VersionInformeBean> listaVersiones = informesService.consultarVersionesInforme(trabajoInforme.getIdInforme());
		request.setAttribute("listaVersionesInforme", listaVersiones);
		return trabajoInforme;
	}

	// Formulario para crear una nueva versión.
	protected Vista nueva_version(HttpSession session) {
		VersionInformeBean version = new VersionInformeBean();
		version.setEstadoBean(Estado.NUEVO);
		session.setAttribute("versionBean", version);
		return FORM_PAGE;
	}

	// Editar una versión existente
	protected Vista editar(HttpServletRequest request, HttpSession session) throws NumberFormatException, InformeException, InformeNotFoundException {
		VersionInformeBean versionInforme = new VersionInformeBean();
		String id1 = request.getParameter("idInforme");
		String id2 = request.getParameter("idVersion");

		// Obtenemos la versión.
		versionInforme = informesService.consultarVersionInforme(new Long(id1), new Long(id2));

		versionInforme.setEstadoBean(Estado.MODIFICADO);
		versionInforme.setEnEdicion(true);
		// La pasamos por session para recogerla en el jsp.
		session.setAttribute("versionBean", versionInforme);
		return FORM_PAGE;
	}

	protected Vista tratarFichero(MultipartFormDataRequest mrequest, HttpServletRequest request) throws InformeException, InformeNotFoundException, InformeConstraintViolationException,
	        OperacionException, OperacionConstraintViolationException, PermisoConstraintViolationException, PermisoException {
		DatosSesionBean datosSesion =  (DatosSesionBean)request.getSession().getAttribute((WebKeys.DATOS_SESION));
		Long idVersion;
		String accion = (String) mrequest.getParameter("accion");
		UploadFile fichero = (UploadFile) mrequest.getFiles().get("fichero");
		String tipo = fichero.getContentType();
		
		// Tratamiento del formulario
		VersionInformeBean version = (VersionInformeBean) request.getSession().getAttribute("versionBean");
		if (version.isEnEdicion()) {
			idVersion = informesService.modificar(version);
			version.setIdVersion(idVersion);
			// En caso de edición se modifican los datos de la versión.
			if (tipo != null) {
				if (fichero == null || fichero.getFileName() == null || !fichero.getFileName().contains(".jrxml")) {
					setMensajeError(request, datosSesion.getTranslation()._("Error: Seleccione un archivo .jrxml"));
					request.setAttribute("operacion", OP_NUEVA_VERSION);
					return FORM_PAGE;
				}
				informesService.modificarVersion(fichero.getInpuStream(), accion, version.getVersion());
			}
		}
		// Estado nuevo.
		else {			
			if (fichero == null || fichero.getFileName() == null || !fichero.getFileName().contains(".jrxml")) {
				setMensajeError(request,datosSesion.getTranslation()._("Error: Seleccione un archivo .jrxml"));
				return FORM_PAGE;
			}
			else {				
				idVersion = informesService.crear(version, datosSesion);
				informesService.insertarFicheroInforme(fichero.getInpuStream(), accion, version.getVersion());
			}
		}
		setMensaje(request,datosSesion.getTranslation()._("La versión se ha grabado correctamente"));
		request.setAttribute("operacion", OP_EJECUTAR);
		return getControlador().getAccion(accion).ejecutar(request);
	}

	protected Vista eliminar(HttpServletRequest request) throws InformeException, InformeNotFoundException, SQLException, OperacionException {
		// Se elimina la versión de BD y del servidor (.jasper y .jrxml).
		DatosSesionBean datosSesion =  (DatosSesionBean)request.getSession().getAttribute((WebKeys.DATOS_SESION));
		String id1 = request.getParameter("idInforme");
		String id2 = request.getParameter("idVersion");
		String accion = request.getParameter("accion");

		informesService.eliminar(accion, id1, id2);
		setMensaje(request,datosSesion.getTranslation()._("La versión se ha eliminado correctamente"));

		request.setAttribute("operacion", OP_EJECUTAR);
		return getControlador().getAccion(accion).ejecutar(request);
	}

	protected Vista imprimir(HttpServletRequest request, DatosSesionBean datosSesion, HttpSession session) throws InformeException, NumberFormatException, InformeNotFoundException {
		ERROR = ERROR_WIN;	
		TrabajoInformeBean trabajoInforme = (TrabajoInformeBean) session.getAttribute(WebKeys.TRABAJO_INFORME);
		String idVersion = request.getParameter("idVersion");
		String tipo = request.getParameter("tipo");
		VersionInformeBean version = null;
		if (idVersion == null || idVersion.isEmpty()) {
			List<VersionInformeBean> listaVersiones = informesService.consultarVersionesInforme(trabajoInforme.getIdInforme());
			if(!listaVersiones.isEmpty()) {
				trabajoInforme.setVersion(listaVersiones.get(0));
			}
		}
		else {
			version = informesService.consultarVersionInforme(trabajoInforme.getIdInforme(), Long.parseLong(idVersion));
			trabajoInforme.setVersion(version);
		}
		
		if (!permisosInforme.isPuede(trabajoInforme.getVersion().getVersion())){
			return SIN_PERMISO;
		}
		
	
		// añadimos como parámetros los datos de la empresa
		trabajoInforme = añadirDatosEmpresa(trabajoInforme, datosSesion);
		
		//Añadimos el locale para la internacionalización
		trabajoInforme.addParametro("REPORT_LOCALE", i18nUtil.getLocale(i18nUtil.getIdiomaSeleccionado(request, datosSesion)));
		
		imprimirInforme(request, trabajoInforme);
		if ("pdf".equalsIgnoreCase(tipo)) {
			trabajoInforme.addParametro("tipo", "pdf");
			return DOWNLOAD_PAGE;
		}
		else if ("rtf".equalsIgnoreCase(tipo)) {
			trabajoInforme.addParametro("tipo", "rtf");
			return DOWNLOAD_PAGE;
		}
		//else if ("excel".equalsIgnoreCase(tipo)) {
		else {
			trabajoInforme.addParametro("tipo", "excel");
			return DOWNLOAD_PAGE;
		}
	}

	protected Vista imprimirRapido(HttpServletRequest request, DatosSesionBean datosSesion, HttpSession session) throws InformeException, InformeNotFoundException {
		TrabajoInformeBean trabajoInforme = new TrabajoInformeBean();
		VersionInformeBean version = null;
		Long idInforme = getAccionInforme().getIdAccion();

		// Intentamos obtener la versión por defecto del informe.

		version = informesService.getVersionPorDefecto(idInforme);

		trabajoInforme.setVersion(version);
		trabajoInforme.setIdInforme(idInforme);
		trabajoInforme.setInforme(getAccionInforme().getAccion());
		trabajoInforme.setTitulo(getAccionInforme().getTitulo());

		// añadimos como parámetros los datos de la empresa
		trabajoInforme = añadirDatosEmpresa(trabajoInforme, datosSesion);
		
		//Añadimos el locale para la internacionalización
		trabajoInforme.addParametro("REPORT_LOCALE", i18nUtil.getLocale(i18nUtil.getIdiomaSeleccionado(request , datosSesion)));

		imprimirInforme(request, trabajoInforme);
		
		trabajoInforme.addParametro("tipo", "pdf");
		
		session.setAttribute(WebKeys.TRABAJO_INFORME, trabajoInforme);
		return DOWNLOAD_PAGE;
	}

	protected TrabajoInformeBean añadirDatosEmpresa(TrabajoInformeBean trabajoInforme, DatosSesionBean datosSesion) {
		trabajoInforme.addParametro("CODEMP", datosSesion.getConfigEmpresa().getCodEmpresa());
		trabajoInforme.addParametro("DESEMP", datosSesion.getDatosEmpresa().getDesEmp());
		trabajoInforme.addParametro("UID_INSTANCIA", datosSesion.getConfigEmpresa().getUidInstancia());
		trabajoInforme.addParametro("UID_ACTIVIDAD", datosSesion.getConfigEmpresa().getUidActividad());
		return trabajoInforme;
	}

	protected void inicia(MultipartFormDataRequest mrequest, HttpServletRequest request) {
		String idInforme = mrequest.getParameter("idInforme");
		String idVersion = mrequest.getParameter("idVersion");
		String version = mrequest.getParameter("version");
		String descripcion = mrequest.getParameter("descripcion");
		String formatoSalida = mrequest.getParameter("formatoSalida");
		String titulo = mrequest.getParameter("titulo");
		String porDefecto = mrequest.getParameter("porDefecto");
		Boolean isPorDefecto = false;

		// Formateo de campos.
		// Se eliminan espacios en blanco del campo "version".
		if (version.length() > 0) {
			version = correccion(version);
			String sinEspacios = version.replaceAll(" ", "_");
			version = sinEspacios;
		}
		if (titulo.length() > 0) {
			titulo = correccion(titulo);
		}
		if (descripcion.length() > 0) {
			descripcion = correccion(descripcion);
		}
		VersionInformeBean versionInforme = (VersionInformeBean) request.getSession().getAttribute("versionBean");
		if (idVersion.length() <= 0) {
			versionInforme.setIdVersion(new Long(0));
		}
		else {
			versionInforme.setIdVersion(new Long(idVersion));
		}
		if ("on".equalsIgnoreCase(porDefecto)) {
			isPorDefecto = true;
		}
		
		versionInforme.setIdInforme(new Long(idInforme));
		versionInforme.setVersion(version);
		versionInforme.setDescripcion(descripcion);
		versionInforme.setFormatoSalida(formatoSalida);
		versionInforme.setActivo(true);
		versionInforme.setTitulo(titulo);
		versionInforme.setPorDefecto(isPorDefecto);
	}	
}