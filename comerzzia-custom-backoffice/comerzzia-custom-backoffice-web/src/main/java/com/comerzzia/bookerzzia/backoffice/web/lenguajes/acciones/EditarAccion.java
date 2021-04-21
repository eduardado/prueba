package com.comerzzia.bookerzzia.backoffice.web.lenguajes.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeException;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeNotFoundException;
import com.comerzzia.bookerzzia.backoffice.services.lenguajes.LenguajeService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class EditarAccion extends Accion{
	
	protected static Logger log = Logger.getLogger(EditarAccion.class);
	
	private static final Vista NEXT_PAGE = new Vista("backoffice/lenguajes/mantenimiento/jsp/lenguaje.jsp", Vista.INTERNA);
	// TODO por qué no guardar todas las páginas en un WebKeysVistas? 
	
	@Autowired
	LenguajeService lenguajeService;

	@Override
	public String getNombre() {
		return "editar";
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
			
			String codlengua = request.getParameter(WebKeys.ID_OBJETO);
			Lenguaje lenguaje = lenguajeService.consultar(codlengua, datosSesion);
			lenguaje.setEstadoBean(Estado.MODIFICADO); // lo diferencia de alta acción en que está modificado en luegar de nuevo
			lenguaje.setEnEdicion(true);
			
			sesion.setAttribute(CustomWebKeys.LENGUAJE, lenguaje);
			
			return NEXT_PAGE;
		}
		catch (LenguajeNotFoundException e) {
			setMensajeError(request, datosSesion.getTranslation().getText("No se ha encontrado el registro"));
			
		}
		catch (LenguajeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
