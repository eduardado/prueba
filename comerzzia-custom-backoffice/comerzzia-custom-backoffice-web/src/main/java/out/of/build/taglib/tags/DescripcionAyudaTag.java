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

public class DescripcionAyudaTag extends AyudaTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8210011947105893975L;

	/* Descripción */
	private String idDescripcion = null;
	private String valorDescripcion = null;
	private String anchuraDescripcion = null;
	private String estiloDescripcion = null;
	private boolean editable = false;

	public int doStartTag() throws JspException {
		try {
			//Cogemos el padre para pasarle los parámetros del hijo
			AyudaTag ayuda = (AyudaTag)findAncestorWithClass(this, AyudaTag.class);
			ayuda.setIdDescripcion(idDescripcion);
			ayuda.setValorDescripcion(valorDescripcion);
			ayuda.setAnchuraDescripcion(anchuraDescripcion);
			ayuda.setEstiloDescripcion(estiloDescripcion);
			ayuda.setEditable(editable);

			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag DescripcionAyudaTag: "+e.getMessage());
		}
	}
	
	public int doEndTag() {
		return SKIP_BODY;
	}
	

	public String getValorDescripcion() {
		return valorDescripcion;
	}

	public void setValorDescripcion(String valorDescripcion) {
		this.valorDescripcion = valorDescripcion;
	}

	public String getAnchuraDescripcion() {
		return anchuraDescripcion;
	}

	public void setAnchuraDescripcion(String anchuraDescripcion) {
		this.anchuraDescripcion = anchuraDescripcion;
	}

	public String getEstiloDescripcion() {
		return estiloDescripcion;
	}

	public void setEstiloDescripcion(String estiloDescripcion) {
		this.estiloDescripcion = estiloDescripcion;
	}

	public String getIdDescripcion() {
		return idDescripcion;
	}

	public void setIdDescripcion(String idDescripcion) {
		this.idDescripcion = idDescripcion;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}

