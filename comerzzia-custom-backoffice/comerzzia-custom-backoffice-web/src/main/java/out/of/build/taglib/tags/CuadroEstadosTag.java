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

import java.util.List;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.core.model.estados.EstadoBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.WebKeys;

public class CuadroEstadosTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8603196452120471805L;
	
	private String titulo = null;
	private List<EstadoBean> estados = null;
	
	
	public int doStartTag () throws JspTagException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
			
			PanelTag panelTag = new PanelTag();
			panelTag.setPageContext(pageContext);
			panelTag.doStartTag();
			
			CabeceraPanelTag cabeceraPanelTag = new CabeceraPanelTag();
			cabeceraPanelTag.setPageContext(pageContext);
			cabeceraPanelTag.setTitulo(titulo);
			cabeceraPanelTag.doStartTag();
			
			// Menú más acciones
			out.println("<td class=\"accion\" style=\"text-align: right;padding-left:10px\">");
			out.println("  <a onclick=\"javascript:_toggleMenu(event, '__comerzzia__masAcciones_cuadro_estados_'); return false;\" title=\"" + datosSesion.getTranslation()._("Más Acciones") + "\">" + datosSesion.getTranslation()._("Más Acciones") + "");
			out.println("    <img width=\"16px\" height=\"16px\" align=\"top\" border=\"0\" src=\"comun/images/iconos/more.gif\" style=\"cursor: pointer;float:none\"/>");
			out.println("  </a>");
			out.println("  <div id=\"__comerzzia__masAcciones_cuadro_estados_\" class=\"cuadroMasAccionesEstados\" style=\"display:none;\">");
			out.println("    <table class=\"masAccionesEstados\" cellspacing=\"4\" cellpadding=\"0\" border=\"0\">");
			out.println("      <tbody>");
	        out.println("        <tr>");
	        out.println("          <td class=\"accion\" nowrap=\"nowrap\">");
	        out.println("            <a onclick=\"__seleccionar__Estados__(1);\" style=\"cursor: pointer; margin-right: \">");
	        out.println("              <img src=\"comun/images/iconos/checkbox.png\" border=\"0\" align=\"absmiddle\" title=\"" + datosSesion.getTranslation()._("Seleccionar todos") + "\" alt=\"" + datosSesion.getTranslation()._("Seleccionar todos") + "\" />");
	        out.println("              " + datosSesion.getTranslation()._("Seleccionar todos") + "");
	        out.println("            </a>");
	        out.println("          </td>");
	        out.println("        </tr>");
	        out.println("        <tr>");
	        out.println("          <td class=\"accion\" nowrap=\"nowrap\">");
	        out.println("            <a onclick=\"__seleccionar__Estados__(0);\" style=\"cursor: pointer; margin-right: \">");
	        out.println("              <img src=\"comun/images/iconos/checkboxVacio.png\" border=\"0\" align=\"absmiddle\" title=\"" + datosSesion.getTranslation()._("Deseleccionar todos") + "\" alt=\"" + datosSesion.getTranslation()._("Deseleccionar todos") + "\" />");
	        out.println("              " + datosSesion.getTranslation()._("Deseleccionar todos") + "");
	        out.println("            </a>");
	        out.println("          </td>");
	        out.println("        </tr>");
	        out.println("        <tr>");
	        out.println("          <td class=\"accion\" nowrap=\"nowrap\">");
	        out.println("            <a onclick=\"__invertir__Seleccion__Estados__();\" style=\"cursor: pointer; margin-right: \">");
	        out.println("              <img src=\"comun/images/iconos/invertir.png\" border=\"0\" align=\"absmiddle\" title=\"" + datosSesion.getTranslation()._("Invertir selección") + "\" alt=\"" + datosSesion.getTranslation()._("Invertir selección") + "\" />");
	        out.println("              " + datosSesion.getTranslation()._("Invertir selección") + "");
	        out.println("            </a>");
	        out.println("          </td>");
	        out.println("        </tr>");
	        out.println("      </tbody>");
	        out.println("    </table>");
	        out.println("  </div>");
	        out.println("</td>");
	        // Fin Menú más acciones
			
			cabeceraPanelTag.doEndTag();
			
			// Introducción de los scripts necesarios para las acciones en "Más acciones"
			out.println("<script type=\"text/javascript\">");
			out.println("function __seleccionar__Estados__(marca) {var inputs = document.getElementsByTagName(\"input\");for (var i = 0; i < inputs.length; i++) {if(inputs[i].type == \"checkbox\") {if(inputs[i].name.substring(0, 11) == \"_chkEstado_\") {inputs[i].checked = marca;}}}}");
			out.println("function __invertir__Seleccion__Estados__() {var inputs = document.getElementsByTagName(\"input\");for (var i = 0; i < inputs.length; i++) {if(inputs[i].type == \"checkbox\") {if(inputs[i].name.substring(0, 11) == \"_chkEstado_\") {inputs[i].checked = (inputs[i].checked) ? 0 : 1;}}}}");
			out.println("</script>");
			
			CuerpoPanelTag cuerpoPanelTag = new CuerpoPanelTag();
			cuerpoPanelTag.setPageContext(pageContext);
			cuerpoPanelTag.doStartTag();
			
			// Inicio del pintado de los estados
			out.println("        <table width=\"100%\" align=\"left\">");
			for(int i = 0; i < estados.size(); i++) {
				EstadoBean estado = estados.get(i);
				String name = "_chkEstado_" + estado.getEstado();
				String image = estado.getIcono();
				
				out.println("      <tr>");
				out.println("        <td nowrap=\"nowrap\">");
				out.println("          <input type=\"checkbox\" id=\"" + name + "\" name=\"" + name + "\"" + ((estado.isChecked()) ? "checked=\"checked\"" : "") + " />");
				out.println("          <font class=\"subtituloTabla\">" + datosSesion.getTranslation()._(estado.getDesEstado()) + "</font>");
				out.println("        </td>");
				out.println("        <td>");
				out.println("          <img width=\"16px\" height=\"16px\" align=\"absmiddle\" src=\"" + image + "\" title=\"" + datosSesion.getTranslation()._(estado.getAmbitoAplicacion()) + "\" alt=\"" + datosSesion.getTranslation()._(estado.getAmbitoAplicacion()) + "\" />");
				out.println("        </td>");
				out.println("      </tr>");
			}
			out.println("        </table>");
			// Fin del pintado de los estados
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag EstadosTag: "+e.getMessage());
		}
	}
	
	public int doEndTag () throws JspTagException {
		try {
			CuerpoPanelTag cuerpoPanelTag = new CuerpoPanelTag();
			cuerpoPanelTag.setPageContext(pageContext);
			cuerpoPanelTag.doEndTag();
			
			PanelTag panelTag = new PanelTag();
			panelTag.setPageContext(pageContext);
			panelTag.doEndTag();
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag EstadosTag: "+e.getMessage());
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public List<EstadoBean> getEstados() {
		return estados;
	}
	public void setEstados(List<EstadoBean> estados) {
		this.estados = estados;
	}
}
