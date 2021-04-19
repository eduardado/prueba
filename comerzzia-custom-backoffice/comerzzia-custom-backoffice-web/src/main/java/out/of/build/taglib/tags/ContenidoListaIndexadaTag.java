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

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import com.comerzzia.taglib.TeclasRapidasKeys;


public class ContenidoListaIndexadaTag extends ContenidoListaTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 247727858702546100L;
	
	//accion asociada a la pulsación de las teclas rápidas correspondientes
	private String accion = "verRegistroPestaña(0);";
	
	@Override
	public int doStartTag() throws JspTagException {
		try {
			JspWriter out = pageContext.getOut();
			
			if(lista.size() > 0){
				out.println("<script type=\"text/javascript\">");
			    out.println("    jQuery(document).bind(\"keydown\", \"" + TeclasRapidasKeys.MODO_TABLA_FICHA_HK + "\", function(event) {");
			    out.println("     " + accion);
			    out.println("         event.stopPropagation();");
			    out.println("         event.preventDefault();");
			    out.println("         return false;");
			    out.println("    })");
			    out.println("</script>");
			}
			
			return super.doStartTag();	
			
		} catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag ResultadosTag: "+e.getMessage());
		}
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
}
