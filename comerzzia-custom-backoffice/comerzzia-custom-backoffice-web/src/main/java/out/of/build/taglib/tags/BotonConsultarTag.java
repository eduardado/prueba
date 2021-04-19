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

import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.TeclasRapidasKeys;

public class BotonConsultarTag extends BotonTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7102158752686141645L;
	
	private String onclick = "";
	private String id = "btnConsultar";
	private String valor = I18nUtil._("Consultar");

	@Override
	public int doStartTag() throws JspException {
		super.onclick = this.onclick;
		super.id = this.id;
		super.valor = this.valor;
		
		try {
			JspWriter out = pageContext.getOut();
			out.println("<script type=\"text/javascript\">");
		    out.println("    jQuery(document).bind(\"keydown\", \"" + TeclasRapidasKeys.ACCION_CONSULTAR_HK + "\", function(event) {");
		    out.println("     " + onclick);
		    out.println("         event.stopPropagation();");
		    out.println("         event.preventDefault();");
		    out.println("         return false;");
		    out.println("    })");
		    out.println("</script>");
		    
		    return super.doStartTag();
			
		} catch (Exception e) {
			throw new JspTagException("Excepción en la clase del tag: "+e.getMessage());
		}
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
