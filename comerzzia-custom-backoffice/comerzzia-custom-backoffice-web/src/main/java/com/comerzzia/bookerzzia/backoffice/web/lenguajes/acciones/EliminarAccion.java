package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeService;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class EliminarAccion extends Accion{
	
protected static Logger log = Logger.getLogger(SalvarAccion.class);
	
	private static final Vista NEXT_PAGE = new Vista("backoffice/lenguajes/mantenimiento/jsp/lenguaje.jsp", Vista.INTERNA);
	
	@Autowired
	LenguajeService lenguajeService;

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		DatosSesionBean datosSesion  = (DatosSesionBean) session.getAttribute(WebKeys.DATOS_SESION);
		
		try {
			// permisos para eliminar?
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisosCache(this.getAccionMenu());
			if(!permisos.isPuedeEliminar()) {
				return SIN_PERMISO;
			}
			
			// obtiene lenguaje
			String codelengua = request.getParameter(WebKeys.ID_OBJETO);
			lenguajeService.eliminar(codelengua, datosSesion);
			
			setMensaje(request,datosSesion.getTranslation().getText("El lenguaje se ha borrado correctamente"));
			
			return getControlador().getAccion("busca").ejecutar(request);
		}
		catch (Exception e) {
			log.error("Ha ocurrido un error",e);
			setError(request,e);
			return ERROR_PAGE;
		}
		
		
	}

	@Override
	public String getNombre() {
		return "eliminar";
	}

}
