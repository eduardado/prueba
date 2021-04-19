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
import com.comerzzia.taglib.WebKeys;

/**
 *
 */
public class BotonTag extends TagSupport {

	/**
	 * 
	 */ //TODO: TAGLIB: Pensar si estaría bien poner un atributo para el ancho del botón, sería útil para el asistente de las tarifas
	private static final long serialVersionUID = -4044791423380206846L;
	
	protected String id;
	protected String valor;
	protected String onclick;
	
	
	public int doStartTag() throws JspException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
			out.println("<input type=\"button\" id=\""+ id +"\" class=\"boton\" name=\""+ id +"\" value=\""+ datosSesion.getTranslation()._(valor) +"\" onclick=\""+ onclick + "\" />");	
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
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
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
