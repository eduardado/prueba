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
import javax.servlet.jsp.JspTagException;

public class CodigoAyudaTag extends AyudaTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6598145519670759845L;
	
	/* Código */
	private String idCodigo = null;
	private String valorCodigo = null;
	private String longitudMaximaCodigo = null;
	private String anchuraCodigo = null;
	private String estiloCodigo = null;
	private String onchange = null;

	public int doStartTag() throws JspException {
		try {
			//Cogemos el padre para pasarle los parámetros del hijo
			AyudaTag ayuda = (AyudaTag)findAncestorWithClass(this, AyudaTag.class);
			ayuda.setIdCodigo(idCodigo);
			ayuda.setValorCodigo(valorCodigo);
			ayuda.setLongitudMaximaCodigo(longitudMaximaCodigo);
			ayuda.setAnchuraCodigo(anchuraCodigo);
			ayuda.setEstiloCodigo(estiloCodigo);
			ayuda.setOnchange(onchange);
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag CodigoAyudaTag: "+e.getMessage());
		}
	}
	
	public int doEndTag() {
		return SKIP_BODY;
	}
	
	
	public String getValorCodigo() {
		return valorCodigo;
	}

	public void setValorCodigo(String valorCodigo) {
		this.valorCodigo = valorCodigo;
	}

	public String getLongitudMaximaCodigo() {
		return longitudMaximaCodigo;
	}

	public void setLongitudMaximaCodigo(String longitudMaximaCodigo) {
		this.longitudMaximaCodigo = longitudMaximaCodigo;
	}

	public String getAnchuraCodigo() {
		return anchuraCodigo;
	}

	public void setAnchuraCodigo(String anchuraCodigo) {
		this.anchuraCodigo = anchuraCodigo;
	}

	public String getEstiloCodigo() {
		return estiloCodigo;
	}

	public void setEstiloCodigo(String estiloCodigo) {
		this.estiloCodigo = estiloCodigo;
	}

	public String getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(String idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}
}
