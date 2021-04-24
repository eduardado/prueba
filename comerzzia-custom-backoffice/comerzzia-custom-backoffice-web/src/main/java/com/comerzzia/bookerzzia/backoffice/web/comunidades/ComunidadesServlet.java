package com.comerzzia.bookerzzia.backoffice.web.comunidades;

import javax.servlet.annotation.WebServlet;

import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.AltaAccion;
import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.BuscarAccion;
import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.EditarAccion;
import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.EjecutarAccion;
import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.EliminarAccion;
import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.SalvarAccion;
import com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones.VerAccion;
import com.comerzzia.web.base.ControladorServlet;

@WebServlet(value = "/comunidades", description = "Servlet de Comunidades", displayName = "ComunidadesServlet", name = "ComunidadesServlet")
public class ComunidadesServlet extends ControladorServlet {

	private static final long serialVersionUID = -6516388901631677452L;

	@Override
	protected void loadAcciones() {

		this.añadirAccion(new AltaAccion());
		this.añadirAccion(new BuscarAccion());
		this.añadirAccion(new EditarAccion());
		this.añadirAccionDefault(new EjecutarAccion());
		this.añadirAccion(new EliminarAccion());
		this.añadirAccion(new SalvarAccion());
		this.añadirAccion(new VerAccion());

	}

}
