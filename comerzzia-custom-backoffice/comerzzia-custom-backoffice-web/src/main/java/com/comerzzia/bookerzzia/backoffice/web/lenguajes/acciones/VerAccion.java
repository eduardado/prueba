package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeException;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeNotFoundException;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

// Esta clase sirve para devolver la vista de detalle del registro seleccionado
public class VerAccion extends Accion{
	// ruta desde webapp
	// final porque nadie heredará esto
	private static final Vista NEXT_PAGE = new Vista("backoffice/lenguajes/mantenimiento/jsp/lenguaje.jsp", Vista.INTERNA);
	
	@Autowired
	private LenguajeService lenguajeService;


	@Override
	public String getNombre() {
		return "ver";
	}

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		DatosSesionBean datosSesion = (DatosSesionBean) sesion.getAttribute(WebKeys.ID_OBJETO);
		
		try {
			String codlengua = request.getParameter(WebKeys.ID_OBJETO);
			Lenguaje lenguaje = lenguajeService.consultar(codlengua, datosSesion); // TODO duda: para hacer la consulta se le pasa el objeto datosSesion, para qué
			sesion.setAttribute(CustomWebKeys.LENGUAJE, lenguaje); // se asigna a la sesión http el objeto lenguaje activo
			
			return NEXT_PAGE;
		}
		catch (LenguajeNotFoundException e) {
			// TODO duda: porqué así?
			String errorMsg = datosSesion.getTranslation().getText("No se ha encontrado el registro"); 
			setMensajeError(request, errorMsg);
			Vista buscar = getControlador().getAccion("buscar").ejecutar(request); // TODO se obtiene la Vista "buscar"
			return buscar;
		}
		catch (Exception e) {
			// Además del error, se le puede pasar al log la excepción en sí ¿Mostrará el error asociado a la Excepción?
			Log.error("ejecutar() - Error obteniendo la vista del registro de lenguaje", e );
			setError(request,e); // se asocia un error a la request
			return ERROR_PAGE;
		}
		
		
	}

}
