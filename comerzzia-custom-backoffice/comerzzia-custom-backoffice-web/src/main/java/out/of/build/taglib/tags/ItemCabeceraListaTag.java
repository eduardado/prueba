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
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;

public class ItemCabeceraListaTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6468307148034933239L;

	private String nombre;
	private Integer columna;
	private String ordenColumna;
	private String estilo;
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
        	String cabecera = "<th class=\"cabeceraResultados\"";
        	if (estilo != null) {
        		cabecera += " style=\"" + estilo + "\"";
        	}
        	cabecera += ">";
        	
        	out.println(cabecera);
        	
        	// Obtener el orden actual para determinar
        	String ordenActual = (String)pageContext.getAttribute(TagKeys.ORDEN_ACTUAL);
        	
        	// Comprobar si se está usando ordenación
        	if (ordenActual != null && !ordenActual.isEmpty()
        			&& ordenColumna != null && !ordenColumna.isEmpty()
        			&& columna != null && columna > 0) {
        		
        		out.println("<a style=\"cursor: pointer;\" class=\"cabeceraResultados\" onclick=\"ordenar(" + columna + ");\">");
        		String imagenOrdenacion = null;
        		
        		// Comprobar si se está ordenando por la columna en cuestión
        		if(ordenActual.equals(ordenColumna) || ordenActual.equals(ordenColumna + " DESC")) {
        			imagenOrdenacion = "<img height=\"6px\" width=\"10px\" border=\"0\" src=\"comun/images/iconos/";
	        		
	        		// Comprobar si el orden es ascendiente o descendiente
	        		if (ordenActual.endsWith("DESC")) {
	        			imagenOrdenacion += "orden_des-white.gif\"";
	        		}
	        		else {
	        			imagenOrdenacion += "orden_asc-white.gif\"";
	        		}
	        		
	        		imagenOrdenacion += " />";
        		}
        		
            	out.println(datosSesion.getTranslation()._(nombre));
            	
            	if(imagenOrdenacion != null) {
            		out.println(imagenOrdenacion);
            	}
            	
        		out.println("</a>");
        	}
        	else {
        		out.println(datosSesion.getTranslation()._(nombre));
        	}
        	
        	out.println("</th>");
        	
        	return SKIP_BODY;
		}
		catch (Exception e) {
		    throw new JspTagException("doStartTag() - Excepción en la clase del tag ColumnaTag: "+e.getMessage());
		}
	}
	
	
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Integer getColumna() {
		return columna;
	}
	public void setColumna(Integer columna) {
		this.columna = columna;
	}
	
	
	public String getOrdenColumna() {
		return ordenColumna;
	}
	public void setOrdenColumna(String ordenColumna) {
		this.ordenColumna = ordenColumna;
	}
	
	
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
}
