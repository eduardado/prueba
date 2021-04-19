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

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;

public class ItemContenidoListaTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1347934060285895418L;
	
	private String valor;
	private String alineacion;
	private String onclick;
	private String contenido;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			if (alineacion != null){
				out.println("<td style=\"text-align:"+ alineacion +"\">");
			}
			else {
				out.println("<td style=\"text-align: left;\">");
			}
			contenido = valor;
			return EVAL_BODY_BUFFERED;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag ItemContenidoListaTag: "+e.getMessage());
		}
	}
	
	public int doAfterBody() throws JspTagException {
		BodyContent body = getBodyContent();

		try {
			String contenidoBody = body.getString().trim();
			if (contenidoBody != null && !contenidoBody.isEmpty()){
				contenido = contenidoBody;
			}
			
			body.clearBody();
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag ItemContenidoListaTag: "+e.getMessage());
		}
	}
	
	public int doEndTag() throws JspException {
		DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
		
		JspWriter out = pageContext.getOut();

		try {
			if (contenido == null){
				contenido = "";
			}
			if (onclick != null && !onclick.isEmpty()){
				out.println("<a  style=\"cursor: pointer;\" onclick=\""+ onclick +"\">");
				out.println("<span>" + datosSesion.getTranslation()._(contenido) + "</span>");
				out.println("</a>");
			}
			else{
				out.println("<span>" + datosSesion.getTranslation()._(contenido) + "</span>");
			}
			out.println("</td>");
		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag ItemContenidoListaTag: "+e.getMessage());
		}
		return EVAL_PAGE;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getAlineacion() {
		return alineacion;
	}

	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

}
