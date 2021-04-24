package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean;
import com.comerzzia.bookerzzia.backoffice.services.comunidades.ComunidadNotFoundException;
import com.comerzzia.bookerzzia.backoffice.services.comunidades.IComunidadService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class VerAccion extends Accion {
	
	protected static Logger log = Logger.getLogger(VerAccion.class);

	private static final Vista NEXT_PAGE = new Vista("backoffice/comunidades/mantenimiento/jsp/comunidad.jsp", Vista.INTERNA);

	@Autowired
	IComunidadService comService;

	@Override
	public String getNombre() {
		return "ver";
	}

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		log.debug("ejecutar() - ejecutando accion ver ");
		HttpSession sesion = request.getSession();
		DatosSesionBean datosSesion = (DatosSesionBean) sesion.getAttribute(WebKeys.DATOS_SESION);

		try {
			String codigo = request.getParameter(WebKeys.ID_OBJETO);
			log.debug("ejecutar() - código de la comunidad del parámetro : " + codigo);
			ComunidadBean comunidad = comService.consultar(codigo, datosSesion);
			Log.debug("ejecutar() - comunidad elegida: " + comunidad);
			sesion.setAttribute(CustomWebKeys.COMUNIDAD, comunidad); 
			                                                         
			return NEXT_PAGE;
		}
		catch (ComunidadNotFoundException e) {
			String errorMsg = datosSesion.getTranslation().getText("No se ha encontrado el registro");
			setMensajeError(request, errorMsg);
			return getControlador().getAccion("buscar").ejecutar(request);
		}
		catch (Exception e) {
			Log.error("ejecutar() - Error obteniendo la vista del registro de comunidad", e);
			setError(request, e); // se asocia un error a la request
			return ERROR_PAGE;
		}
	}

}
