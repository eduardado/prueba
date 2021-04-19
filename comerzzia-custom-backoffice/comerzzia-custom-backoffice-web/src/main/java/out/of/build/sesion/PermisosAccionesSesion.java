/**
 * ComerZZia 3.0
 *
 * Copyright (c) 2008-2015 Comerzzia, S.L.  All Rights Reserved.
 *
 * THIS WORK IS  SUBJECT  TO  SPAIN  AND  INTERNATIONAL  COPYRIGHT  LAWS  AND
 * TREATIES.   NO  PART  OF  THIS  WORK MAY BE  USED,  PRACTICED,  PERFORMED
 * COPIED, DISTRIBUTED, REVISED, MODIFIED, TRANSLATED,  ABRIDGED, CONDENSED,
 * EXPANDED,  COLLECTED,  COMPILED,  LINKED,  RECAST, TRANSFORMED OR ADAPTED
 * WITHOUT THE PRIOR WRITTEN CONSENT OF COMERZZIA, S.L. ANY USE OR EXPLOITATION
 * OF THIS WORK WITHOUT AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO
 * CRIMINAL AND CIVIL LIABILITY.
 *
 * CONSULT THE END USER LICENSE AGREEMENT FOR INFORMATION ON ADDITIONAL
 * RESTRICTIONS.
 */
package com.comerzzia.core.servicios.sesion;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.comerzzia.core.model.acciones.AccionBean;
import com.comerzzia.core.servicios.permisos.PermisoException;
import com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean;
import com.comerzzia.core.servicios.permisos.ServicioPermisosImpl;


/**
 * Cache de Permisos de Acciones asociados al usuario de la sesión
 *
 */
public class PermisosAccionesSesion implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3378450854572336727L;
	
	
	private DatosSesionBean datosSesion;
	private Map<AccionBean, PermisosEfectivosAccionBean> cache;
	
	
	public PermisosAccionesSesion(DatosSesionBean datosSesion) {
		this.datosSesion = datosSesion;
		cache = new HashMap<AccionBean, PermisosEfectivosAccionBean>();
	}
	
	
	public PermisosEfectivosAccionBean getPermisosCache(AccionBean accion) {
		if (cache.containsKey(accion)) {
			return cache.get(accion);
		}
		else {
			return getPermisos(accion);
		}
	}
	
	public PermisosEfectivosAccionBean getPermisos(AccionBean accion) {
		PermisosEfectivosAccionBean permisos = null;
		
		try {
			permisos = ServicioPermisosImpl.get().obtenerPermisosEfectivos(datosSesion, accion, datosSesion.getUsuario().getIdUsuario());
		} 
		catch (PermisoException e) {
			// Si tenemos un error al obtener los permisos consideramos
			// que el usuario no tiene ningún permiso sobre la acción
			permisos = new PermisosEfectivosAccionBean(accion, 
					datosSesion.getUsuario().getIdUsuario());
		}
		cache.put(accion, permisos);
		
		return permisos;
	}
}
