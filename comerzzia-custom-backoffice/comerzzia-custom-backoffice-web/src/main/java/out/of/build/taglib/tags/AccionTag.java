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
/**
 * 
 */
package com.comerzzia.taglib.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.taglib.WebKeys;

/**
 * @author JMTM
 *
 */
public class AccionTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1634894511333542478L;
	
	protected String icono;
	protected String titulo;
	protected String onclick;
	protected String descripcion;
	protected String teclaRapida;
	protected String estilo;
	protected Tag parentTag;
	protected String id;
	
	public int doStartTag() throws JspException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
			
			if(teclaRapida != null && !teclaRapida.isEmpty()){
				out.println("<script type=\"text/javascript\">");
			    out.println("    jQuery(document).bind(\"keydown\", \"" + teclaRapida + "\", function(event) {");
			    out.println("     " + onclick);
			    out.println("         event.stopPropagation();");
			    out.println("         event.preventDefault();");
			    out.println("         return false;");
			    out.println("    })");
			    out.println("</script>");				
			}
			
			//contador para agrupar las acciones
			int numAccionesPintadas = (Integer)pageContext.getAttribute("numAccionesPintadas");
			int numAccionesSinAgrupar = (Integer)pageContext.getAttribute("numAccionesVisibles");
			
			parentTag = (Tag)pageContext.getAttribute("parentTag");
			
			if (numAccionesSinAgrupar == 0 || numAccionesPintadas < numAccionesSinAgrupar) {
				// Pintar la acción
				pintarAccion(out, 3, datosSesion.getTranslation());
			}
			else {
				//accion agrupada
				if (!(Boolean)pageContext.getAttribute("accionesAgrupadas")){
					pageContext.setAttribute("accionesAgrupadas", true);
			    	String idAcciones = (String)pageContext.getAttribute("idAcciones");
			    	if (idAcciones==null){
			    		idAcciones = ((Integer)pageContext.getAttribute("idMasAcciones")).toString();
			    	}
			    	
			    	/*
					 * Si el tag no es la CabeceraPrincipal, la grupación de acciones se pintará en modo tabla. En caso contrario se utilizará la nueva forma con div
					 */
			    	if(!(parentTag instanceof CabeceraPanelPrincipalTag)) {
			    		//incluimos el botón de más acciones
						out.println("<td class=\"accion empty-style\" style=\"text-align: right;\">");
						out.println("<a style=\"cursor: pointer;\" onclick=\"javascript:_toggleMenu(event, '__comerzzia__masAcciones_"+ idAcciones +"'); return false;\" title=\"Más Acciones\">" + datosSesion.getTranslation()._("Más Acciones") + "");
						out.println("<img height=\"16px\" width=\"16px\" align=\"top\" border=\"0\" src=\"comun/images/iconos/more.gif\" style=\"cursor: pointer;float:none\"/>");
						out.println("</a>");
						out.println("<div id=\"__comerzzia__masAcciones_"+ idAcciones +"\" class=\""+getEstilo()+"\" style=\"display:none;\">");
						out.println("<table class=\"masAcciones\" cellspacing=\"4\" cellpadding=\"0\" border=\"0\">");
						out.println("<tbody>");
			    	}
			    	else{
			    		//incluimos el botón de más acciones
				    	out.println("<li class='n-ico-barra hand' onclick=\"javascript:_toggleMenu(event, '__comerzzia__masAcciones_"+idAcciones+"'); return false;\">");
				    	out.println("	<span>"+datosSesion.getTranslation()._("Más Acciones")+"</span>");
				    	out.println("	<ul id='__comerzzia__masAcciones_"+idAcciones+"' class='n-child' style='display:none;'>");
			    	}
				}
				if(!(parentTag instanceof CabeceraPanelPrincipalTag)) {
					out.println("<tr>");
					
					// Para pintar la acción
					pintarAccion(out, 0, datosSesion.getTranslation());
					
					out.println("</tr>");
				}
				else{
					pintarAccionMasAcciones(out, 0, datosSesion.getTranslation());
				}
			}
			
			numAccionesPintadas++;
			pageContext.setAttribute("numAccionesPintadas", numAccionesPintadas);
			
		}
		catch (Exception ex){
			throw new JspTagException("Excepción en la clase del tag: "+ex.getMessage());
		}
		
		return SKIP_BODY;
	}

	/**
	 * Para pintar la acción es necesario que al menos venga el icono o el texto
	 * 
	 * @param out
	 * @throws IOException
	 */
	private void pintarAccion(JspWriter out, int margen, Translation t) throws IOException {
		/*
		 * Si el tag no es la CabeceraPrincipal, la acción se pintará en modo tabla. En caso contrario se utilizará la nueva forma con div
		 */
		if(!(parentTag instanceof CabeceraPanelPrincipalTag)) {
			if((icono != null && !icono.isEmpty()) || (titulo != null && !titulo.isEmpty())) {
				out.println("<td class=\"accion empty-style\" nowrap=\"nowrap\">");
				out.println("<a id=" + id + " onclick=\"" + onclick + "\" style=\"cursor: pointer; margin-right:"+ margen +";\">");
				if(icono != null && !icono.isEmpty()) {
					String alt = (descripcion != null) ? t._(descripcion) : "";
					out.println("<img src=\"" + icono + "\" border=\"0\" align=\"absmiddle\" title=\"" + alt + "\" alt=\"" + alt + "\" >");
				}
				if (titulo != null && !titulo.isEmpty()) {
					out.println(t._(titulo));
				}
				out.println("</a>");
			    out.println("</td>");
			}
		}
		else{
			if((icono != null && !icono.isEmpty()) || (titulo != null && !titulo.isEmpty())) {
				String imgVisibility = "style='display: none;'";
				if(icono != null && !icono.isEmpty()) {
					imgVisibility = "";
				}
				String alt = (descripcion != null) ? t._(descripcion) : "";
				out.println("<li class='n-ico-barra' onclick=\"" + onclick + "\">");
				if(icono != null && !icono.isEmpty()) {
					out.println("<img src='"+icono+"' title='" + alt + "' alt='" + alt + "' "+imgVisibility+">");
				}
				if (titulo != null && !titulo.isEmpty()) {
					out.println("<a style=\"cursor: pointer;\">"+t._(titulo)+"</a>");
				}
				out.println("</li>");
			}
		}
	}
	
	private void pintarAccionMasAcciones(JspWriter out, int margen, Translation t) throws IOException {
		if((icono != null && !icono.isEmpty()) || (titulo != null && !titulo.isEmpty())) {
			String imgVisibility = "style='display: none;'";
			if(icono != null && !icono.isEmpty()) {
				imgVisibility = "";
			}
			String alt = (descripcion != null) ? t._(descripcion) : "";
			out.println("		<li onclick=\"" + onclick + "\">");
	    	out.println("	<div class='n-flotaiz'><img src='"+icono+"' title='" + alt + "' alt='" + alt + "' "+imgVisibility+"></div>");
			if (titulo != null && !titulo.isEmpty()) {
				out.println("<span><a style=\"cursor: pointer;\">"+t._(titulo)+"</a></span>");
			}
			out.println("</li>");
		}
	}
	
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}
	
	
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public String getOnclick() {
		return onclick;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstilo() {
		if(estilo == null)
		estilo = "cuadroMasAcciones";
		
		return estilo;
		
		
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
