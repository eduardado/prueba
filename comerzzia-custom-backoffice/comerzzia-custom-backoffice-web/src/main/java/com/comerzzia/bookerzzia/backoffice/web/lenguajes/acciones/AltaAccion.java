package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;

public class AltaAccion extends Accion {

	protected static final Logger log = Logger.getLogger(AltaAccion.class);
	
	private static final Vista NEXT_PAGE = new Vista("backoffice/lenguajes/mantenimiento/jsp/lenguaje.jsp", Vista.INTERNA);

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		
		Lenguaje lenguaje = new Lenguaje();
		lenguaje.setEstadoBean(Estado.NUEVO); // parece que necesitamos poner que es nuevo
		lenguaje.setEnEdicion(true); // y que lo estamos editando
		
		sesion.setAttribute(CustomWebKeys.LENGUAJE, lenguaje); // guarda el registro en acción
		

		return NEXT_PAGE;
	}

	@Override
	public String getNombre() {
		return "alta";
	}

}
