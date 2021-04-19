package com.comerzzia.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;

public abstract class AccionPermiso extends Accion{
	
	protected String ejecucion;

	public abstract String getNombre();
	
	public AccionPermiso(){
		super();
	}
	
	public AccionPermiso(String ejecucion){
		this.ejecucion = ejecucion;
	}
	
	public String getEjecucion() {
		return ejecucion;
	}

	public Vista ejecutar(HttpServletRequest request){
		HttpSession sesion = request.getSession();
		DatosSesionBean datosSesion = getDatosSesion(sesion);
		// Comprobamos los permisos de la acción
		if(!isPuede(datosSesion)){
			return SIN_PERMISO;
		}
		return ejecutarAccion(request, sesion, datosSesion);
	}
	
	public abstract Vista ejecutarAccion(HttpServletRequest request, HttpSession sesion, DatosSesionBean datosSesion);

	protected boolean isPuede(DatosSesionBean datosSesion){
		
		PermisosEfectivosAccionBean permisos = datosSesion.getPermisos(this.getAccionMenu());		
		return ejecucion == null || permisos.isPuede(ejecucion);
	}
	
	protected DatosSesionBean getDatosSesion(HttpSession sesion){
		return (DatosSesionBean) sesion.getAttribute(WebKeys.DATOS_SESION);
	}

}
