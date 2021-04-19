package com.comerzzia.bookerzzia.backoffice.web.lenguajes;

import javax.servlet.annotation.WebServlet;

import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.BuscarAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.EjecutarAccion;
import com.comerzzia.web.base.ControladorServlet;

@WebServlet(value = "/lenguajes", description = "Servlet de Lenguajes", displayName = "LenguajesServlet", name="LenguajesServlet")
public class LenguajesServlet extends ControladorServlet{
	
	//TODO ojo no estoy añadiendo el serial ... será necesario?

	@Override
	protected void loadAcciones() {
		/*
		 * Servlets necesarios para la Vista de búsqueda
		 */
		this.añadirAccionDefault(new EjecutarAccion()); // por qué el this aquí? no es redundante?
		this.añadirAccion(new BuscarAccion());
		//TODO aquí Julián añadió más acciones.. pero... no serían de la otra vista y por lo tanto no deberían estar en otro Servlet?
		
		
	}

}
