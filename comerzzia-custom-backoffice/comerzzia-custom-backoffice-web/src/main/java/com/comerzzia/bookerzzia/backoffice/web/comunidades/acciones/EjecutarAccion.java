package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ParametrosBuscarComunidadBean;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;

public class EjecutarAccion extends Accion {

	protected static Logger log = Logger.getLogger(EjecutarAccion.class);

	@Override
	public Vista ejecutar(HttpServletRequest servletRequest) {
		try {
			log.debug("ejecutar() - EjecutarAccion");
			HttpSession httpSession = (HttpSession) servletRequest.getSession();
			DatosSesionBean datosSesion = (DatosSesionBean) httpSession.getAttribute(WebKeys.DATOS_SESION);
			
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisos(getAccionMenu());
			if(!permisos.isPuedeEjecutar()) {
				return SIN_PERMISO;
			}
			
			ParametrosBuscarComunidadBean param = (ParametrosBuscarComunidadBean) httpSession.getAttribute(CustomWebKeys.PARAM_BUSCAR_COMUNIDADES);
			
			if(param == null) { // si no lo recupera del mapa de parámetros del controlador
				// crea un objeto
				param = new ParametrosBuscarComunidadBean(); // esto es importante porque es una clase Custom
				// asigna el objeto al mapa de atributos de la sesión
				httpSession.setAttribute(CustomWebKeys.PARAM_BUSCAR_COMUNIDADES, param);
			}else {
				param.setNumPagina(0); // al ser la acción por defecto, debe hacer esto para que no se muestre nada al entrar
			}
			
			return getControlador().getAccion("buscar").ejecutar(servletRequest); // la acción por defecto llama y ejecuta a la cción buscar... es esto necesario?
		}
		catch (Exception e) {
			String msg = "Ha ocurrido un error al cargar la pantalla";
			log.error(msg + ": " + e);
			setError(servletRequest, e);
			
			return ERROR_PAGE;
		}
		

	}

	@Override
	public String getNombre() {
		return "ejecutar";
	}

}
