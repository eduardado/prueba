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

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CabeceraListaTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169292408838193459L;

	private String ordenActual = null;
	
	public int doStartTag() throws JspTagException{
		try {
			JspWriter out = pageContext.getOut();
	        out.println("<thead>");
	        out.println("<tr>");

	        // Poner como atributo el orden actual para luego indicar la ordenación en la columna correspondiente
	        pageContext.setAttribute(TagKeys.ORDEN_ACTUAL, ordenActual);

		} catch (Exception ex) {
		    throw new JspTagException("doStartTag() - Excepción en la clase del tag CabeceraListaTag: "+ex.getMessage());
		}
		
		return EVAL_BODY_BUFFERED;
	}
	
	public int doEndTag()throws JspTagException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("</tr>");
	        out.println("</thead>");
		    
		} catch (Exception e){
			throw new JspTagException("doEndTag() - Excepción en la clase del tag CabeceraListaTag: "+e.getMessage());
		}
		
		return 0;
	}
	
	public int doAfterBody() throws JspTagException {
      BodyContent body = getBodyContent();

      try {
		JspWriter out = body.getEnclosingWriter();
	    out.println(body.getString());
	    body.clearBody();
	    
      } catch(Exception e) {
    	  throw new JspTagException("doAfterBody() - Excepción en la clase del tag CabeceraListaTag: "+e.getMessage());
	  }
		
      return(SKIP_BODY); 
	}

	public String getOrdenActual() {
		return ordenActual;
	}

	public void setOrdenActual(String ordenActual) {
		this.ordenActual = ordenActual;
	}
}
