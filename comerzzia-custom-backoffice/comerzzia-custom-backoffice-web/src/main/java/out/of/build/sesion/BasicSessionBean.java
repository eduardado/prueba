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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.comerzzia.core.servicios.empresas.EmpresaException;
import com.comerzzia.core.util.db.Database;
import com.comerzzia.core.util.i18n.Translation;


/**
 * Datos básicos de una sesión
 * 
 */
public class BasicSessionBean implements IDatosSesion {

	private String uidInstancia;
	
	private String uidActividad;
	
	private String user;
	
	private Long userId;
	
	private String codEmpresa;
	
	private Translation translation;
	
	private Locale locale;
		
    /**
     * Otros atributos de la sesión
     */
	private Map<String, Object> atributos = new HashMap<String, Object>();
	
	public BasicSessionBean() {
		
	}
	public BasicSessionBean(String uidInstancia, String uidActividad, String user, Locale locale, String codEmpresa) {
		this.uidInstancia = uidInstancia;
		this.uidActividad = uidActividad;
		this.user = user;
		this.locale = locale;
		this.codEmpresa = codEmpresa;
	}	
	
	/**
	 * Establece el valor del atributo atributos
	 * @param atributos Mapa con los objetos que se van a guardar en sesión
	 */
	public void setAtributos(Map<String, Object> atributos) {
		this.atributos = atributos;
	}

	/**
	 * Obtiene el valor del atributo atributos
	 * @return Mapa con los objetos guardados en sesión
	 */
	public Map<String, Object> getAtributos() {
		return atributos;
	}	
	
	@Override
	public String getUidInstancia() {
		return uidInstancia;
	}

	public void setUidInstancia(String uidInstancia) throws EmpresaException {
		this.uidInstancia = uidInstancia;
	}

	@Override
	public String getUidActividad() {
		return uidActividad;
	}
	
	public void setUidActividad(String uidActividad) throws EmpresaException {
		this.uidActividad = uidActividad;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Locale getLocale() {
		if (locale == null) {
			return Locale.getDefault();
		} else {
		   return locale;
		}
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa  = codEmpresa;
	}

	@Override
	public String getCodEmpresa() {
		return codEmpresa;
	}

	@Override
	@Deprecated
	public SqlSessionFactory getSqlSessionFactory() {
		return Database.getSqlSessionFactory();
	}
	
	public void setTranslation(Translation translation) {
	   this.translation = translation;
	}
	@Override
	public Translation getTranslation() {
		if(translation == null){
			translation = new Translation(getLocale()); 
		}
		
		return translation;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public Long getUserId() {		
		return this.userId;
	}
}

