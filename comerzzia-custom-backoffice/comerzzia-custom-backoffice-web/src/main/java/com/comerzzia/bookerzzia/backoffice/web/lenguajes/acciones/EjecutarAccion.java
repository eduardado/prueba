package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jfree.util.Log;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.ParametrosBuscarLenguajesBean;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;

// este servlet se ejecuta al entrar en la pantalla por primera vez
public class EjecutarAccion extends Accion {
	
	protected static Logger log = Logger.getLogger(EjecutarAccion.class);
	

	@Override
	public Vista ejecutar(HttpServletRequest request) { // recibe un request y devuelve una vista
		log.debug("ejecutar() - EjecutarAccion");
		try {
			// obtiene los datos de la sesión
			HttpSession httpSesion = request.getSession(); // a partir de un HttpServletRequest se obtiene la sesión
			DatosSesionBean datosSesion = (DatosSesionBean) httpSesion.getAttribute(WebKeys.DATOS_SESION);

			// Comprueba los permisos de la acción
			/*
			 * Ni idea de lo que hace esta línea. ¿Por qué el this?
			 */
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisos(this.getAccionMenu()); // TODO para qué este
			                                                                                      // this?
			if (!permisos.isPuedeEjecutar()) { // si el permiso no se puede ejecutar
				return SIN_PERMISO; // si no se puede ejecutar devuelve la vista llamada SIN_PERMISO
			}

			// Inicializa parámetros de búsqueda
			ParametrosBuscarLenguajesBean param = (ParametrosBuscarLenguajesBean) httpSesion.getAttribute(CustomWebKeys.PARAM_BUSCAR_LENGUAJES);
			if (param == null) { // si no hay parámetros de búsqueda instanciados
				param = new ParametrosBuscarLenguajesBean(); // se instancia el objeto
				httpSesion.setAttribute(CustomWebKeys.PARAM_BUSCAR_LENGUAJES, param); // se le pasa al mapa de la sesión
			}
			else {
				param.setNumPagina(0); // si está iniciado ya en la sesión se pone cero páginas (no se mostrará nada)
			}
			
			

			return getControlador().getAccion("buscar").ejecutar(request); // TODO acción buscar... lo que hace es buscar pero se devuelven cero páginas, y así se carga la vista
			// si no hay permisos para cargar la vista se muestra la vista SIN_PERMISO que estará definida en el jsp
		}
		catch (Exception e) {
			String msg = "Ha ocurrido un error al cargar la pantalla";
			
			Log.error(msg + ":" + e);
			setError(request, e); //TODO esto qué es??? imagino que socia un error a la request?
			
			return ERROR_PAGE;
			
		}
	}

	@Override
	public String getNombre() {
		return "ejecutar";
	}

}
