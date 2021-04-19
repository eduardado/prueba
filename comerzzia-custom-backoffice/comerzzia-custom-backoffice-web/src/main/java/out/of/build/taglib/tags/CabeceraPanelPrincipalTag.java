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


public class CabeceraPanelPrincipalTag extends BodyTagSupport {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -9130259949622596689L;
	
	private String titulo;
	private String icono;
	
	
	public int doStartTag() throws JspException {
		try{
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
			
			// Iniciamos la cabecera
			out.println("<div class='n-top-central'>");
			if(icono != null && !icono.isEmpty()) {
				out.println("<img id='_icono_menu_item' src='" + icono + "' onerror=\"this.src='comun/images/menu/menu_item.gif'\">");
		    }
			out.println("<span>" + datosSesion.getTranslation()._(titulo) + "</span>");
		}
		catch (Exception e) {
			throw new JspTagException("Excepción en la clase del tag: "+e.getMessage());
		}
		
		return EVAL_BODY_BUFFERED;
	}
	
	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
		 	out.println("</div>");
		}
		catch (Exception e) {
			throw new JspTagException("Excepción en la clase del tag: "+e.getMessage());
		}
		
		return SKIP_BODY;
	}
	
	
	public int doAfterBody() throws JspTagException {
		BodyContent body = getBodyContent();

		try {
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
		}
		catch(IOException ioe) {
			throw new JspTagException("Excepción en la clase del tag: "+ioe.getMessage());
		}
	
		return SKIP_BODY; 
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
