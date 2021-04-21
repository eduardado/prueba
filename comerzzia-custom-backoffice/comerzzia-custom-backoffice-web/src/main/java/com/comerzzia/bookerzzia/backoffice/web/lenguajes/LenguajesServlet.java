package com.comerzzia.bookerzzia.backoffice.web.lenguajes;

import javax.servlet.annotation.WebServlet;

import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.AltaAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.BuscarAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.EditarAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.EjecutarAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.EliminarAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.SalvarAccion;
import com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones.VerAccion;
import com.comerzzia.web.base.ControladorServlet;

@WebServlet(value = "/lenguajes", description = "Servlet de Lenguajes", displayName = "LenguajesServlet", name="LenguajesServlet")
public class LenguajesServlet extends ControladorServlet{
	
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1341742045679015472L;

	@Override
	protected void loadAcciones() {
		/*
		 * Acciones necesarias para la Vista de búsqueda
		 */
		this.añadirAccionDefault(new EjecutarAccion()); // TODO  por qué el this aquí? no es redundante?
		this.añadirAccion(new AltaAccion());
		//acciones de la vista de detalles
		this.añadirAccion(new BuscarAccion());
		this.añadirAccion(new EditarAccion());
		this.añadirAccion(new EjecutarAccion());
		this.añadirAccion(new EliminarAccion());
		this.añadirAccion(new SalvarAccion());
		this.añadirAccion(new VerAccion());
		
		
		
	}

}
