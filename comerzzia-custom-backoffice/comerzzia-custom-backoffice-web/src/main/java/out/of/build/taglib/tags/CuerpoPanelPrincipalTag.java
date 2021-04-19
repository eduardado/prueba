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

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class CuerpoPanelPrincipalTag extends BodyTagSupport {
	
	// TODO: habría que unificar esta clase con la CuerpoPanelTag, ya que deberían hacer lo mismo
	private static final long serialVersionUID = -4301551935706143144L;

	
	private String alineacion = "top";
	
	// Variable que indicará si el cuerpo se debe expandior al 100% del ancho de la pantalla
	private boolean vExpand = false;
	
	
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if(vExpand) {
				out.println("<div class='n-contenidos expand'>");
			}
			else{
				out.println("<div class='n-contenidos'>");
			}
			
		    return EVAL_BODY_BUFFERED;
		}
		catch (IOException e) {
			throw new JspException(e);
		}
	}
	
	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
			out.println("</div>");
		    
		    return SKIP_BODY;
		}
		catch (Exception ex){
			throw new JspTagException("Excepción en la clase del tag: "+ex.getMessage());
		}
	}
	
	
	public int doAfterBody() throws JspException {
		try {
			BodyContent body = getBodyContent();
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
			
			return SKIP_BODY;
		}
		catch (IOException ioe) {
			throw new JspTagException("Excepción en la clase del tag: "+ioe.getMessage());
		}
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

    public boolean isvExpand() {
    	return vExpand;
    }
    
    public void setvExpand(boolean vExpand) {
    	this.vExpand = vExpand;
    }
}
