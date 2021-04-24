package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;

public class AltaAccion extends Accion {
	
	protected static final Logger log = Logger.getLogger(AltaAccion.class);
	
	private static final Vista NEXT_PAGE = new Vista("backoffice/comunidades/mantenimiento/jsp/comunidad.jsp", Vista.INTERNA);
	

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		
		ComunidadBean comunidad = new ComunidadBean();
		comunidad.setEstadoBean(Estado.NUEVO); // estado del bean a NUEVO
		comunidad.setEnEdicion(true); // en edición
		
		sesion.setAttribute(CustomWebKeys.COMUNIDAD, comunidad); // la guarda como comunidad actual.
		
		return NEXT_PAGE; // devuelve la vista de detalle
	}

	@Override
	public String getNombre() {
		return "alta";
	}

}
