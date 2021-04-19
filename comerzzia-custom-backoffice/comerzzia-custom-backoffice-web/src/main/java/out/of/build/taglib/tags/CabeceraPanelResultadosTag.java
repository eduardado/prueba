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

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.WebKeys;

/**
 * @author JMTM
 *
 */
public class CabeceraPanelResultadosTag extends CabeceraPanelTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7098624997511607009L;
	
	private String titulo = I18nUtil._("Resultados");
	private String numPorPagina;
	
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			super.setTitulo(titulo);
			super.doStartTag();

			if (numPorPagina != null){
				DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
				Translation t = datosSesion.getTranslation();

				out.println("<td align=\"right\">");
        		out.println("<span id=\"browse:items-txt1\">"+ t._("Resultados por página")+"</span>");
     	        out.println("<input id=\"tamanoPagina\" name=\"tamanoPagina\" type=\"text\" class=\"campo numero\" maxlength=\"3\" value=\"" + numPorPagina + "\" >");
     	        out.println("</td>");
        	}
		
		} catch (Exception ex) {
		    throw new JspTagException("doStartTag() - Excepción en la clase del tag CabeceraPanelTag: "+ex.getMessage());
		}
		
		return EVAL_BODY_BUFFERED;
	}
	
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the numPorPagina
	 */
	public String getNumPorPagina() {
		return numPorPagina;
	}

	/**
	 * @param numPorPagina the numPorPagina to set
	 */
	public void setNumPorPagina(String numPorPagina) {
		this.numPorPagina = numPorPagina;
	}

}
