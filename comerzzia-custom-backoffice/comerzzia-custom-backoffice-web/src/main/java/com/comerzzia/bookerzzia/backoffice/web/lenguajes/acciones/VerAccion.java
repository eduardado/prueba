package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;

import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;

public class VerAccion extends Accion{

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		
		return null;
	}

	@Override
	public String getNombre() {
		return "ver";
	}

}
