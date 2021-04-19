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
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;

public class PestanaTag extends BodyTagSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7058718947133642107L;
	
	private String titulo = null;
	private String width = "90";
	private String onclick = null;
	private String accion = null;
	
	public int doStartTag() throws JspException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
			
			String activa = (String)pageContext.getAttribute(TagKeys.PESTAÑA_ACTIVA);
			if (activa.equalsIgnoreCase(accion)) {
				out.println("<td style=\"background:url(comun/images/tablas/pestanas.gif) 0 0\"><img name=\"p1_1\" src=\"comun/images/tablas/vacio.gif\" width=5 height=22></td>");
				out.println("<td nowrap=\"nowrap\" class=\"etiquetaPestaña\"><div id=\"p1_2\" onclick=\"\"  align=\"center\" style=\"background:url(comun/images/tablas/horizontal.gif) repeat-x 0 -10px\"><font>"+ datosSesion.getTranslation()._(titulo) +"</font></div></td>");
				out.println("<td style=\"background:url(comun/images/tablas/pestanas.gif) 5px 0\"><img name=\"p1_3\" src=\"comun/images/tablas/vacio.gif\" width=5 height=22></td>");
			}
			else{
				out.println("<td style=\"background:url(comun/images/tablas/pestanas.gif) 0 22px\"><img name=\"p1_1\" src=\"comun/images/tablas/vacio.gif\" width=5 height=22></td>");
				out.println("<td nowrap=\"nowrap\" class=\"etiquetaPestaña\"><div id=\"p1_2\" onclick=\""+ onclick +"\"   align=\"center\" style=\"background:url(comun/images/tablas/horizontal.gif) repeat-x 0 -32px\"><font>"+ datosSesion.getTranslation()._(titulo) +"</font></div></td>");
				out.println("<td style=\"background:url(comun/images/tablas/pestanas.gif) 5px 22px\"><img name=\"p1_3\" src=\"comun/images/tablas/vacio.gif\" width=5 height=22></td>");
			}
			
			return SKIP_BODY;
		}
		catch (Exception e){
			throw new JspTagException("doStartTag() - Excepción en la clase del tag PestañaTag: "+e.getMessage());
		}
	}
	
	
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	
	public String getOnclick() {
		return onclick;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
