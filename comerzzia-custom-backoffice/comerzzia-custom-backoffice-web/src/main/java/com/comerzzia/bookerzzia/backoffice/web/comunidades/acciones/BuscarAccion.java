package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ParametrosBuscarComunidadBean;
import com.comerzzia.bookerzzia.backoffice.services.comunidades.IComunidadService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.paginacion.PaginaResultados;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class BuscarAccion extends Accion {

	protected static Logger log = Logger.getLogger(BuscarAccion.class);

	private static final Vista NEXT_PAGE = new Vista("backoffice/comunidades/buscar/jsp/buscar.jsp", Vista.INTERNA);

	@Autowired
	IComunidadService comService;
	
	@Override
	public String getNombre() {
		return "buscar";
	}

	@Override
	public Vista ejecutar(HttpServletRequest request) {
		try {
			HttpSession httpSession = request.getSession();
			DatosSesionBean datosSesion = (DatosSesionBean) httpSession.getAttribute(WebKeys.DATOS_SESION);

			PermisosEfectivosAccionBean permisos = datosSesion.getPermisosCache(this.getAccionMenu()); // HE PUESTO AQUÍ UN THIS no creo que sea eso el error por el amor de dios

			if (!permisos.isPuedeEjecutar()) { // permiso para buscar y ejecutar es lo mismo
				return SIN_PERMISO; // se devuelve la Vista sin permiso
			}

			// se obtienen los parámetros de la búsqueda (del formulario de la página)
			ParametrosBuscarComunidadBean param = (ParametrosBuscarComunidadBean) httpSession.getAttribute(CustomWebKeys.PARAM_BUSCAR_COMUNIDADES);

			// dependiendo del parámetro que le llegue de la request haremos una de estas 3 operaciones
			String operacion = request.getParameter("operacion");
			if (operacion != null) {
				log.debug("operacion");
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

			if (param.getNumPagina() > 0) { // TODO duda: esto para qué
				PaginaResultados paginaResultados = comService.consultar(param, datosSesion);
				request.setAttribute(WebKeys.PAGINA_RESULTADOS, paginaResultados);
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
	
	private void setParametrosBuscar(ParametrosBuscarComunidadBean param, HttpServletRequest request) {
		/*
		 *  HttpServletRequest -> (inputs) -> ParametrosBuscarComunidadAutonomaBean
		 */
		param.setCodigo(request.getParameter("codigo"));
		param.setDescripcion(request.getParameter("descripcion"));
		param.setIdioma(request.getParameter("idioma"));

		param.setNumPagina(1); // TODO esto no termino de entenderlo

		try {
			// en el jsp hay un "tamañoPagina" tendrá algo que ver??
			param.setTamañoPagina(Integer.parseInt(request.getParameter("tamanoPagina")));
		}
		catch (Exception e) { 
			log.debug("setParametrosBuscar() - error al establecer los valores de comunidad establecidos por el usuario");
		}
	}

	private void setPaginaBuscar(ParametrosBuscarComunidadBean param, HttpServletRequest request) {
		/**
		 * Si el usuario cambia el nº de páginas a mostrar
		 * Extraemos dicho nº lo casteamos y lo pasamos a ParametrosBuscarComunidadAutonomaBean
		 */
		log.debug("setPaginaBuscar()");
		try {
			Integer pagina = Integer.parseInt(request.getParameter("pagina"));
			param.setNumPagina(pagina);
		}
		catch (Exception e) {
		}
	}

	private void setOrdenBuscar(ParametrosBuscarComunidadBean param, HttpServletRequest request) {
		/**
		 * Si el usuario pincha en una columna, el request es "ordenar"
		 * - Ponemos la primera página?
		 * - Averiguamos qué columna a pulsado
		 */
		try {
			param.setNumPagina(1); // si ordenamos, ordenamos sólo la página 1?

			Integer columna = Integer.parseInt(request.getParameter("columna"));

			switch (columna) {
				case 1: // CODIGO
					if (param.getOrden().equals("CODIGO")) {
						param.setOrden("CODIGO DESC");
					}
					else {
						param.setOrden("CODIGO");
					}
					break;
				case 2: // DESCRIPCION
					// si ya estaba ordenado por descripción, lo hará descendientemente
					if (param.getOrden().equals("DESCRIPCION")) {
						param.setOrden("DESCRIPCION DESC");
					}
					else {
						param.setOrden("DESCRIPCION");
					}
					break;
				case 3:
					// IDIOMA
					if (param.getOrden().equals("IDIOMA")) {
						param.setOrden("IDIOMA DESC");
					}
					else {
						param.setOrden("IDIOMA");
					}
					break;
				default:
					param.setOrden("CODIGO");

			}
		}
		catch (Exception e) {
			log.error("setOrdenBuscar() - Error ordenando por columnas", e);
		}

	}

	

	

}
