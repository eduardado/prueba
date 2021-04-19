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
/**
 * 
 */
package com.comerzzia.taglib.tags;

import javax.servlet.jsp.JspException;

/**
 * @author JMTM
 *
 */
public class ItemCabeceraListaPaginadaTag extends ItemCabeceraListaTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2037993663931421058L;
	
	private String nombre;
	private int columna;
	private String ordenColumna;
	private String estilo;

	public int doStartTag() throws JspException {
		super.setNombre(nombre);
		if (this.columna > 0)
			super.setColumna(columna);
		if (this.ordenColumna != null && !this.ordenColumna.equals(""))
			super.setOrdenColumna(ordenColumna);
		if (this.estilo != null && !this.estilo.equals(""))
			super.setEstilo(estilo);
		return super.doStartTag();
	}
	
	
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the columna
	 */
	public Integer getColumna() {
		return columna;
	}


	/**
	 * @param columna the columna to set
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}


	/**
	 * @return the ordenColumna
	 */
	public String getOrdenColumna() {
		return ordenColumna;
	}


	/**
	 * @param ordenColumna the ordenColumna to set
	 */
	public void setOrdenColumna(String ordenColumna) {
		this.ordenColumna = ordenColumna;
	}


	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		return estilo;
	}


	/**
	 * @param estilo the estilo to set
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

}
