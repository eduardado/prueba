package com.comerzzia.bookerzzia.backoffice.web.encuadernaciones;

import javax.servlet.annotation.WebServlet;

import com.comerzzia.web.base.ControladorServlet;

//@WebServlet(value = "/comunidades", description = "Servlet de Comunidades", displayName = "ComunidadesServlet", name = "ComunidadesServlet")

@WebServlet(value = "/encuadernaciones", description = "Servlet de Comunidades", displayName = "ComunidadesServlet", name = "ComunidadesServlet")
public class EncuadernacionesServlet extends ControladorServlet{

	private static final long serialVersionUID = -4091599477405774927L;

	@Override
	protected void loadAcciones() {
		// TODO implementar acciones
		
	}

}
