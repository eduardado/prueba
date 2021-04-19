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

import javax.servlet.jsp.JspTagException;

/**
 * @author JMTM
 *
 */
public class CabeceraListaPaginadaTag extends CabeceraListaTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5339757570712963447L;
	
	private String ordenActual;

	
	public int doAfterBody() throws JspTagException {
		return super.doAfterBody();
	}

	
	public int doEndTag() throws JspTagException {
		return super.doEndTag();
	}

	
	public int doStartTag() throws JspTagException {
		if (ordenActual != null && !ordenActual.equals(""))
			super.setOrdenActual(ordenActual);
		return super.doStartTag();
	}


	/**
	 * @return the ordenActual
	 */
	public String getOrdenActual() {
		return ordenActual;
	}


	/**
	 * @param ordenActual the ordenActual to set
	 */
	public void setOrdenActual(String ordenActual) {
		this.ordenActual = ordenActual;
	}

}
