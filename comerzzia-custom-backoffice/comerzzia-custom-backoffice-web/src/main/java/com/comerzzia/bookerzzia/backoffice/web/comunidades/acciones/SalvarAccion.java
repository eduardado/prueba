package com.comerzzia.bookerzzia.backoffice.web.comunidades.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean;
import com.comerzzia.bookerzzia.backoffice.services.comunidades.IComunidadService;
import com.comerzzia.bookerzzia.backoffice.web.tags.CustomWebKeys;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.web.base.Accion;
import com.comerzzia.web.base.Vista;
import com.comerzzia.web.base.WebKeys;

public class SalvarAccion extends Accion{
	
	// se debe devolver esta vista?
	private static final Vista NEXT_PAGE = new Vista("backoffice/comunidades/mantenimiento/jsp/comunidad.jsp", Vista.INTERNA);
	
	@Autowired
	IComunidadService comService;

	@Override
	public String getNombre() {
		return "salvar";
	}
	
	@Override
	public Vista ejecutar(HttpServletRequest servletRequest) {
		
		Log.debug("ejecutar() - ejecutando acción ver");
		
		/**
		 *  Este método 
		 *  1) obtiene los datos del objeto a partir del HttpServletRequest
		 *  2) instancia un bean del objeto con dichos inputs del user
		 *  3) saca el objeto que existiese en DatosSesionBean
		 *  4) Pide al servicio un objeto que tenga esa primary key
		 *  5) Guarda la referencia del objeto en el Hashmap de DatosSeasionBean
		 *  
		 */
		
		HttpSession sesion = servletRequest.getSession();
		DatosSesionBean datosSesion = (DatosSesionBean) sesion.getAttribute(WebKeys.DATOS_SESION);
		
		try {
			PermisosEfectivosAccionBean permisos = datosSesion.getPermisosCache(getAccionMenu()); 
			if(!permisos.isPuedeEditar()) {
				return SIN_PERMISO;
			}
			
			// TODO duda: por qué seteamos aquí el objeto? no se guarda la referencia a el mismo en el mapa de la sesión?
			// TODO resuelta: creo que lo que hace es actualizar, porque esta acción ocurre cuando el usurio pulsa el botón salvar
			// luego los input pueden haber cambiado antes de que pulse el botón
			
			ComunidadBean comunidad = (ComunidadBean) sesion.getAttribute(CustomWebKeys.COMUNIDAD);
			// esto hay que hacerlo manualmente
			comunidad.setCodigo(servletRequest.getParameter("codigo"));
			comunidad.setDescripcion(servletRequest.getParameter("descripcion"));
			comunidad.setIdioma(servletRequest.getParameter("idioma"));
			/*
			 * DIOS MIO ME FALTABAN ESTAS DOS LÍNEAS Y NO FUNCIONABA NADA
			 */
//			comunidad.setActivo(true); // TODO QUÉ HACE ESTO????? -> 
			// No sé qué hace esto pero estaba en el constructor del modelo en el ejemplo de David
			comService.salvar(comunidad, datosSesion);
			
			sesion.removeAttribute(CustomWebKeys.COMUNIDAD); // libera recursos
			
			try {
				comunidad = comService.consultar(comunidad.getCodigo(), datosSesion);
				sesion.setAttribute(CustomWebKeys.COMUNIDAD, comunidad); // vuelve a asignar (imagino que borrando y volviendo a poner, se asegura.
				setMensaje(servletRequest, datosSesion.getTranslation().getText("El lenguaje se ha salvado correctamente")); // TODO estos mensajes se podrían parametrizar
			}
			catch (Exception e) {
				setMensajeError(servletRequest, datosSesion.getTranslation().getText("La comunidad se ha guardado correctamente pero no se ha podido acceder a él"));
				return getControlador().getAccion("buscar").ejecutar(servletRequest); // vuelve a la pantalla de búsqueda.
			}
			
			return NEXT_PAGE;
			
			
		}
		catch (Exception e) {
			setMensajeError(servletRequest, datosSesion.getTranslation().getText("Ha ocurrido un error en el guardado de la comunidad"));
			setError(servletRequest, e);
			return ERROR_PAGE;
		}
		
	}


}
