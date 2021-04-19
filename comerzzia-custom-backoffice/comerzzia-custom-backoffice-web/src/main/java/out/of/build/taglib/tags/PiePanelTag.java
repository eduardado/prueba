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
public class PiePanelTag extends CuerpoPanelTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1287046683875312449L;
	
	private String alineacion;

	public int doStartTag() throws JspException {
		super.setAlineacion(alineacion);
		return super.doStartTag();
	}
	
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	/**
	 * @return the alineacion
	 */
	public String getAlineacion() {
		return alineacion;
	}

	/**
	 * @param alineacion the alineacion to set
	 */
	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}
}
