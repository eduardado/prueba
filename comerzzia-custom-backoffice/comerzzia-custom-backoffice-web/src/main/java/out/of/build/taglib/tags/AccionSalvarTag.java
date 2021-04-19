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
package com.comerzzia.taglib.tags;

import javax.servlet.jsp.JspException;

import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.TeclasRapidasKeys;


public class AccionSalvarTag extends AccionTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449526347293299401L;
	
	private String icono = "comun/images/iconos/aceptar.gif";
	private String titulo = I18nUtil._("Aceptar");
	private String onclick = "";
	private String descripcion = I18nUtil._("Acepta los cambios realizados");
	private String teclaRapida = TeclasRapidasKeys.ACCION_SALVAR_HK;

	@Override
	public int doStartTag() throws JspException {
		super.icono = this.icono;
		super.titulo = this.titulo;
		super.onclick = this.onclick;
		super.descripcion = this.descripcion;
		super.teclaRapida = this.teclaRapida;
		
		return super.doStartTag();
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
