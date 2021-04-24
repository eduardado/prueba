package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.services.comunidades.IComunidadService;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class EliminarAccion extends Accion{
	
	protected static Logger log = Logger.getLogger(EliminarAccion.class);
	
	@Autowired
	IComunidadService comService;

	@Override
	public String getNombre() {
		return "eliminar";
	}
	
	@Override
	public Vista ejecutar(HttpServletRequest servletRequest) {
		HttpSession session = servletRequest.getSession();
		DatosSesionBean datosSesion  = (DatosSesionBean) session.getAttribute(WebKeys.DATOS_SESION);
		
		try {
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisosCache(getAccionMenu()); // TODO esta línea no la entiendo
			if(!permisos.isPuedeEliminar()) {
				return SIN_PERMISO;
			}
			
			String codigo = servletRequest.getParameter(WebKeys.ID_OBJETO);
			comService.eliminar(codigo, datosSesion);
			
			setMensaje(servletRequest, datosSesion.getTranslation().getText("La comunidad se ha borrado correctamente"));
			return getControlador().getAccion("buscar").ejecutar(servletRequest);
			
		}
		catch (Exception e) {
			log.error("Ha ocurrido un error");
			setError(servletRequest,e);
			return ERROR_PAGE; 
		}
		
		
	}


}
