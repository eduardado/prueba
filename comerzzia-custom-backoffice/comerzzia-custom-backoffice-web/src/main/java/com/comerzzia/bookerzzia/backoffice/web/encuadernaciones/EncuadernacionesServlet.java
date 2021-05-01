package com.comerzzia.bookerzzia.backoffice.web.encuadernaciones;

import javax.servlet.annotation.WebServlet;

import com.comerzzia.web.base.ControladorServlet;


@WebServlet(value = "/encuadernaciones", description = "Servlet de Encuadernaciones", displayName = "EncuadernacionesServlet", name = "EncuadernacionesServlet")
public class EncuadernacionesServlet extends ControladorServlet{

	private static final long serialVersionUID = -4091599477405774927L;

	@Override
	protected void loadAcciones() {
		
	}

}
