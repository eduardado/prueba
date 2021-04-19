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

public class PestanasTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6646832707767937657L;

	public int doStartTag() throws JspException {
		try{
			JspWriter out = pageContext.getOut();
			out.println("<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"cuadro pestañas\">");
		}catch (Exception e){
			throw new JspTagException("doStartTag() - Excepción en la clase del tag PestañasTag: "+e.getMessage());
		}
		
		return EVAL_BODY_BUFFERED;
	}
	

	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println("</table>");
		    
		} catch (Exception e){
			throw new JspTagException("doEndTag() - Excepción en la clase del tag PestañasTag: "+e.getMessage());
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
	    	  throw new JspTagException("doAfterBody() - Excepción en la clase del tag PestañasTag: "+e.getMessage());
		  }
			
	      return(SKIP_BODY); 
	}
}