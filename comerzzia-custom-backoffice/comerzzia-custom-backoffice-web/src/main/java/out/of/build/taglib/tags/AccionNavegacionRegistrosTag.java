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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.taglib.WebKeys;

/**
 *
 */
public class AccionNavegacionRegistrosTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3613760565241132902L;
	
	private int actual;
	private int total;
	private int primero;
	private int anterior;
	private int siguiente;
	private int ultimo;
	private String onclick;

	public int doStartTag() throws JspException {
		try {

			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			Translation t = datosSesion.getTranslation();

			JspWriter out = pageContext.getOut();

			String img = null;
			String func = null;
			String estilo = null;
			
			// Botón Primer Registro
			if (primero == -1) {
				img = "comun/images/iconos/paginaPrimera_no.gif";
				func = "";
				estilo = "";
			}
			else {
				img = "comun/images/iconos/paginaPrimera.gif";
				func = onclick + "('"+ primero +"')";
				estilo = "cursor:pointer;";
			}
			
			out.println("<td class=\"accion\" nowrap=\"nowrap\">");
			out.println("<img src=\""+ img +"\" onclick=\""+ func +"\" style=\""+ estilo +" margin-right: 3px;\"  border=\"0\" align=\"absmiddle\" title=\""+ t._("Primer Registro") + "\" alt=\""+ t._("Primer Registro") + "\" >");
		    out.println("</td>");
		    
		    
		    // Botón Anterior Registro
		    if (anterior == -1) {
				img = "comun/images/iconos/paginaPrevia_no.gif";
				func = "";
				estilo = "";
			}
			else {
				img = "comun/images/iconos/paginaPrevia.gif";
				func = onclick + "('"+ anterior +"')";
				estilo = "cursor:pointer;";
			}
		    
		    out.println("<td class=\"accion\" nowrap=\"nowrap\">");
		    out.println("<img src=\""+ img +"\" onclick=\""+ func +"\" style=\""+ estilo +" margin-right: 3px;\"  border=\"0\" align=\"absmiddle\" title=\""+ t._("Anterior") + "\" alt=\""+ t._("Anterior") + "\" >");
		    out.println("</td>");
		    
		    
		    // Indicador de registro actual y número total de registros
		    out.println("<td>");
		    out.println("<b>"+ t._("Reg.")+" " + actual + "/" + total + "</b>&nbsp;");
		    out.println("</td>");
		    
		    
		    // Botón Siguiente Registro
		    if (siguiente == -1) {
				img = "comun/images/iconos/paginaSiguiente_no.gif";
				func = "";
				estilo = "";
			}
			else {
				img = "comun/images/iconos/paginaSiguiente.gif";
				func = onclick + "('"+ siguiente +"')";
				estilo = "cursor:pointer;";
			}
		    
		    out.println("<td class=\"accion\" nowrap=\"nowrap\">");
		    out.println("<img src=\""+ img +"\" onclick=\""+ func +"\" style=\""+ estilo +" margin-right: 3px;\"  border=\"0\" align=\"absmiddle\" title=\""+ t._("Siguiente") + "\" alt=\""+ t._("Siguiente") + "\" >");
		    out.println("</td>");
		    
		    
		    // Botón Último Registro
		    if (ultimo == -1) {
				img = "comun/images/iconos/paginaFinal_no.gif";
				func = "";
				estilo = "";
			}
			else {
				img = "comun/images/iconos/paginaFinal.gif";
				func = onclick + "('"+ ultimo +"')";
				estilo = "cursor:pointer;";
			}
		    
		    out.println("<td class=\"accion\" nowrap=\"nowrap\">");
		    out.println("<img src=\""+ img +"\" onclick=\""+ func +"\" style=\""+ estilo +" margin-right: 3px;\"  border=\"0\" align=\"absmiddle\" title=\""+ t._("Último Registro") + "\" alt=\""+ t._("Último Registro") + "\" >");
		    out.println("</td>");
			
		}
		catch (Exception ex){
			throw new JspTagException("Excepción en la clase del tag: "+ex.getMessage());
		}
		
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}

	/**
	 * @return the actual
	 */
	public int getActual() {
		return actual;
	}

	/**
	 * @param actual the actual to set
	 */
	public void setActual(int actual) {
		this.actual = actual;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the primero
	 */
	public int getPrimero() {
		return primero;
	}

	/**
	 * @param primero the primero to set
	 */
	public void setPrimero(int primero) {
		this.primero = primero;
	}

	/**
	 * @return the anterior
	 */
	public int getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(int anterior) {
		this.anterior = anterior;
	}

	/**
	 * @return the siguiente
	 */
	public int getSiguiente() {
		return siguiente;
	}

	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(int siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * @return the ultimo
	 */
	public int getUltimo() {
		return ultimo;
	}

	/**
	 * @param ultimo the ultimo to set
	 */
	public void setUltimo(int ultimo) {
		this.ultimo = ultimo;
	}

	/**
	 * @return the onclick
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * @param onclick the onclick to set
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
}
