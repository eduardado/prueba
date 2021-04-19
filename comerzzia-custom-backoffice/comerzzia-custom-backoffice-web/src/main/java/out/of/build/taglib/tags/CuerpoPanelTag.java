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
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class CuerpoPanelTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5720894273018165638L;

	private String alineacion = "top";

	
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
	        out.println("<tr style=\"vertical-align:top\">");
	        out.println("<td>");
	        out.println("<table class=\"cuadroBusquedaDesplegable\" cellspacing=\"2\" cellpadding=\"0\" border=\"0\"  id=\"cuadroBusqueda\">");
	        out.println("<tr>");
	        out.println("<td>");
		    
		    return EVAL_BODY_BUFFERED;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag ContenidoPanelTag: "+e.getMessage());
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
		catch (Exception e) {
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag ContenidoPanelTag: "+e.getMessage());
		}
	}
	
	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</td>");
			out.println("</tr>");
		    
		    return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag ContenidoPanelTag: "+e.getMessage());
		}
	}
	
	
	public String getAlineacion() {
		return alineacion;
	}
	
	
	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}
}
