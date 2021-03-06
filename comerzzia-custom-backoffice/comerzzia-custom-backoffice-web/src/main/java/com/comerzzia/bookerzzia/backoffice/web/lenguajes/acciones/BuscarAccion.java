package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.ParametrosBuscarLenguajesBean;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.paginacion.PaginaResultados;
import com.comerzzia.taglib.WebKeys;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;

public class BuscarAccion extends Accion {

	protected static Logger log = Logger.getLogger(BuscarAccion.class);

	private static final Vista NEXT_PAGE = new Vista("backoffice/lenguajes/buscar/jsp/buscar.jsp", Vista.INTERNA);

	@Autowired
	LenguajeService lenguajeService; // TODO se hace el autowired de la interfaz no de la implementación! O_O porque está apuntando a la implementación automáticamente

	@Override
	public String getNombre() {
		return "buscar";
	}

	@Override
	public Vista ejecutar(HttpServletRequest request) {

		try {
			HttpSession sesion = request.getSession();
			DatosSesionBean datosSesion = (DatosSesionBean) sesion.getAttribute(WebKeys.DATOS_SESION); // TODO hay 2
			                                                                                           // webkeys
			                                                                                           // en el standard

			// Se comprueban los permisos de la sesión sobre la acción
			// TODO en EjecutarAccion se hacía getPermisos en lugar de este método
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisosCache(this.getAccionMenu()); // TODO este
			                                                                                           // this?
			if (!permisos.isPuedeEjecutar()) { // TODO revisar no será si puede buscar?
				return SIN_PERMISO; // se devuelve la Vista sin permiso
			}

			// se obtienen los parámetros de la búsqueda (del formulario de la página)
			ParametrosBuscarLenguajesBean param = (ParametrosBuscarLenguajesBean) sesion.getAttribute(CustomWebKeys.PARAM_BUSCAR_LENGUAJES);

			// dependiendo del parámetro que le llegue de la request haremos una de estas 3 operaciones
			String operacion = request.getParameter("operacion");
			if (operacion != null) {
				// consultar
				if (operacion.equals("consultar")) {
					setParametrosBuscar(param, request);
				} // ver página
				else if (operacion.equals("paginar")) {
					setPaginaBuscar(param, request);
				} // ordenar
				else if (operacion.equals("ordenar")) {
					setOrdenBuscar(param, request);
				}
			}

			// si existe página, hace la búsqueda
			if (param.getNumPagina() > 0) {
				PaginaResultados paginaResultados = lenguajeService.consultar(param, datosSesion);
				request.setAttribute(com.comerzzia.web.base.WebKeys.PAGINA_RESULTADOS, paginaResultados);
			}

			return NEXT_PAGE;
		}
		catch (Exception e) {
			String msg = "Ha ocurrido un error";
			log.error(msg, e);
			setError(request, e); // siempre se setea el error

			return ERROR_PAGE;
		}
	}

	private void setOrdenBuscar(ParametrosBuscarLenguajesBean param, HttpServletRequest request) {
		// establecemos primera pagina
		try {
			param.setNumPagina(1);

			// Obtenemos la columna por la que ordenar
			Integer columna = Integer.parseInt(request.getParameter("columna"));

			// Establece la columna por la que se ordena
			switch (columna) {
				case 1: // CODLENGUA
					if (param.getOrden().equals("CODLENGUA")) { // TODO porqué en mayúsculas
						param.setOrden("CODLENGUA DESC"); // TODO porque es SQL
					}

					else {
						param.setOrden("CODLENGUA");
					}
					break;
				case 2:
					if (param.getOrden().equals("DESLENGUA")) {
						param.setOrden("DESLENGUA DESC");
					}
					else {
						param.setOrden("DESLENGUA");
					}
					break;
				default:
					param.setOrden("DESLENGUA");
			}
		}
		catch (Exception ignore) {

		}
	}

	private void setPaginaBuscar(ParametrosBuscarLenguajesBean param, HttpServletRequest request) {
		// Obtenemos la página solicitada
		try {
			Integer pagina = Integer.parseInt(request.getParameter("pagina"));
			param.setNumPagina(pagina);
		}
		catch (Exception ignore) {
		}
	}

	private void setParametrosBuscar(ParametrosBuscarLenguajesBean param, HttpServletRequest request) {
		// TODO dónde añadimos estos parámetros al request?
		param.setCodlengua(request.getParameter("codlengua"));
		param.setDeslengua(request.getParameter("deslengua"));

		param.setNumPagina(1);

		// Actualizar el número de resultados por página
		try {
			param.setTamañoPagina(Integer.parseInt(request.getParameter("tamanoPagina")));
		}
		catch (Exception ignore) {
		}

	}

}
