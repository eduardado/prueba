package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class SalvarAccion extends Accion{
	
	protected static Logger log = Logger.getLogger(SalvarAccion.class);

	private static final Vista NEXT_PAGE = new Vista("backoffice/lenguajes/mantenimiento/jsp/lenguaje.jsp", Vista.INTERNA);

	@Autowired
	LenguajeService lenguajeService;

	@Override
	public String getNombre() {
		return "salvar";
	}
	
	@Override
	public Vista ejecutar(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		DatosSesionBean datosSesion = (DatosSesionBean) sesion.getAttribute(WebKeys.DATOS_SESION);
		
		try {
			// Comprueba los permisos de la acción
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisosCache(this.getAccionMenu()); // TODO duda: este this porqué
			if(!permisos.isPuedeEditar()) {
				return SIN_PERMISO;
			}
			
			Lenguaje lenguaje = (Lenguaje) sesion.getAttribute(CustomWebKeys.LENGUAJE); // la referencia al objeto se guarda en httpsesion
			lenguaje.setCodlengua(request.getParameter("codlengua")); // para obtener el valor, se hace una petición al Servlet y se le pide el parámetro
			lenguaje.setDeslengua(request.getParameter("deslengua"));
			
			lenguajeService.salvar(lenguaje, datosSesion); // guardamos en base de datos
			
			// liberamos recursos
			sesion.removeAttribute(CustomWebKeys.LENGUAJE);
			
			try {
				// vuelve a consultar el registro
				lenguaje = lenguajeService.consultar(lenguaje.getCodlengua(), datosSesion);
				setMensaje(request, datosSesion.getTranslation().getText("El lenguaje se ha salvado correctamente")); // AHHH ESTE ES EL MENSAJE ESE VERDE
			}
			catch (Exception e) {
				setMensajeError(request, datosSesion.getTranslation().getText("El lenguaje se ha guardado correctamente pero no se ha podido acceder a él"));
				return getControlador().getAccion("buscar").ejecutar(request); // vuelve a la pantalla de búsqueda.
			}
			
			
			return NEXT_PAGE;
		}
		catch (Exception e) {
			setMensajeError(request, datosSesion.getTranslation().getText("Ha ocurrido un error"));
			setError(request, e);
			return ERROR_PAGE;
		}
		
	}

}
