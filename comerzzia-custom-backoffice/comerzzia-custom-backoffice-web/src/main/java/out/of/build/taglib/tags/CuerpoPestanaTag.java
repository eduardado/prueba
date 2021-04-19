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

public class CuerpoPestanaTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5998271061689855914L;
	
	
	public int doStartTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.println("<tr>");
			out.println("<td colspan=\"3\">");
			out.println("<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"cuadroPestanas\">");
			//fin tr para pintar la esquina superior derecha
			//tr para pintar el recuadro del contenido, incluyendo ambos bordes 
			out.println("<tr valign=top>");
			out.println("<td width=\"7px\"></td>");
			out.println("<td bgcolor='white' width=\"100%\" style=\"border-radius: 5px;\">");
			
		}catch (Exception e){
			throw new JspTagException("doStartTag() - Excepción en la clase del tag CuerpoPestañaTag: "+e.getMessage());
		}
		
		return EVAL_BODY_BUFFERED;
	}
	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("</td>");
			out.println("<td></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</td>");
			out.println("</tr>");
		    
		} catch (Exception e){
			throw new JspTagException("doEndTag() - Excepción en la clase del tag CuerpoPestañaTag: "+e.getMessage());
		}
		
		return 0;
	}
	
	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();

	      try {
			JspWriter out = body.getEnclosingWriter();
		    out.println(body.getString());
		    body.clearBody();
		    
	      } catch(Exception e) {
	    	  throw new JspTagException("doAfterBody() - Excepción en la clase del tag CuerpoPestañaTag: "+e.getMessage());
		  }
			
	      return(SKIP_BODY); 
	}

}
