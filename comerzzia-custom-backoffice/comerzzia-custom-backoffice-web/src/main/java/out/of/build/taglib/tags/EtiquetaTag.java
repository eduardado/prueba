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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.WebKeys;

public class EtiquetaTag extends TagSupport {

	private static final long serialVersionUID = 572334150769279568L;
	
	
	protected String titulo;
	

	public int doStartTag() throws JspException {
		Translation t = null;
		
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			if(datosSesion == null){
				t = I18nUtil.getTranslation((HttpServletRequest) pageContext.getRequest(), datosSesion);
			}
			else{
				t = datosSesion.getTranslation();
			}
			
			JspWriter out = pageContext.getOut();
			out.println(t._(this.titulo));
		    	
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag EtiquetaTag: "+e.getMessage());
		}
	}

	
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
