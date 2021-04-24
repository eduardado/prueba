package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean;
import com.comerzzia.bookerzzia.backoffice.services.comunidades.ComunidadNotFoundException;
import com.comerzzia.bookerzzia.backoffice.services.comunidades.IComunidadService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class EditarAccion extends Accion {
	/*
	 * Todas las acciones hacen algo y luego devuelven una Vista
	 * - Obtiene la PK de la comunidad del mapa de atributos del servlet (lo hereda de ServletController)
	 * - Usa el servicio para consultar por id
	 * - Establece la comunidad como la comunidad activa en el mapa de parámetros del servlet
	 * - Devuelve una vista:
	 * 	- si no hay permisos SIN_PERMISO (Vista heredada de Accion)
	 *  - si hay permisos
	 *  	- si encuentra la comunidad -> Vista de detalles
	 *  	- si no encuentra la comunidad -> la Vista de búsqueda 
	 */

	protected static Logger log = Logger.getLogger(EditarAccion.class);

	private static final Vista NEXT_PAGE = new Vista("backoffice/comunidades/mantenimiento/jsp/comunidad.jsp", Vista.INTERNA);

	@Autowired
	IComunidadService comService;

	@Override
	public String getNombre() {
		return "editar";
	}

	@Override
	public Vista ejecutar(HttpServletRequest servletRequest) {

		HttpSession httpSession = servletRequest.getSession();
		DatosSesionBean datosSesion = (DatosSesionBean) httpSession.getAttribute(WebKeys.DATOS_SESION);
		
		try {
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisos(getAccionMenu());
			if (!permisos.isPuedeEditar()) {
				return SIN_PERMISO;
			}

			String codigo = servletRequest.getParameter(WebKeys.ID_OBJETO); 
			ComunidadBean comunidad = comService.consultar(codigo, datosSesion);
			comunidad.setEstadoBean(Estado.MODIFICADO);
			comunidad.setEnEdicion(true);

			httpSession.setAttribute(CustomWebKeys.COMUNIDAD, comunidad);

			return NEXT_PAGE;
		}
		catch (ComunidadNotFoundException e) {
			setMensajeError(servletRequest, datosSesion.getTranslation().getText("No se ha encontrado el registro de comunidad"), e);
			return getControlador().getAccion("buscar").ejecutar(servletRequest); 
		}
		catch (Exception e) {
			String msg = "ha ocurrido un eror";
			log.error(msg, e);
			setError(servletRequest, e);
			return ERROR_PAGE;
		}

	}

}
