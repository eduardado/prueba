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

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;

/**
 * @author JMTM
 *
 */
public class CabeceraPanelTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 808380549830679533L;
	
	//atributos para la cabecera
	private String titulo;
	private String icono;
	

	public int doStartTag() throws JspException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
		
	        out.println("<tr height=\"16px\" style=\"background-color:#eef2f7\">");
	        out.println("<td class=\"cabeceraCuadro\">");
	        out.println("<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\">");
	        out.println("<tr>");
	        if(icono != null && !icono.isEmpty()) {
	        	out.println("<td width=\"22px\">");
 		        out.println("<img src=\"" + icono + "\" width=\"18px\">");
 		        out.println("</td>");
	        }
	        if(titulo != null && !titulo.isEmpty()) {
	        	out.println("<td><span class=\"titulo\">" + datosSesion.getTranslation()._(titulo) + "</span></td>");
	        }
		
		} catch (Exception ex) {
		    throw new JspTagException("doStartTag() - Excepción en la clase del tag CabeceraPanelTag: "+ex.getMessage());
		}
		
		return EVAL_BODY_BUFFERED;
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
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag CabeceraPanelTag: "+ioe.getMessage());
		} 
	}

	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
	        out.println("</tr>");
	        out.println("</table>");
	        out.println("</td>");
	        out.println("</tr>");
	        
		    return EVAL_PAGE;
		}
		catch (Exception ex){
			throw new JspTagException("doEndTag() - Excepción en la clase del tag CabeceraPanelTag: "+ex.getMessage());
		}
	}
	
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the icono
	 */
	public String getIcono() {
		return icono;
	}

	/**
	 * @param icono the icono to set
	 */
	public void setIcono(String icono) {
		this.icono = icono;
	}
}
