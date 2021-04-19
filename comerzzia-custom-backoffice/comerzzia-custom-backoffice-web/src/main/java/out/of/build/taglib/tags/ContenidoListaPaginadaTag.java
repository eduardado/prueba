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

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.core.util.paginacion.PaginaResultados;
import com.comerzzia.taglib.WebKeys;

/**
 * @author JMTM
 *
 */
public class ContenidoListaPaginadaTag extends ContenidoListaTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8637743432827711369L;
	
	private PaginaResultados paginaResultados;
	private String variable;
	
	public int doStartTag() throws JspTagException {
		super.setLista(this.paginaResultados.getPagina());
		super.setVariable(this.variable);
		return super.doStartTag();
	}
	
	public void doInitBody() throws JspException {
		super.doInitBody();
	}
	
	public int doAfterBody() throws JspTagException {
		return super.doAfterBody();
	}
	
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		try {
			// Inicio del pintado de la paginación
		    out.println("<tr>");
		    out.println("<td colspan=\"99\" align=\"center\">");
		    if (paginaResultados.getTotalResultados() != 0) {
				DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
				Translation t = datosSesion.getTranslation();

		    	out.println("<span class=\"paginacion\">");
		    	if(paginaResultados.getNumPagina() > 0 && !paginaResultados.isEsPrimeraPagina()) {
		    		out.println("<img src=\"comun/images/iconos/paginaPrimera.gif\" width=\"16px\" height=\"16px\" border=\"0\" onClick=\"paginar('1')\" style=\"cursor: pointer;\">&nbsp;");
		    		out.println("<img src=\"comun/images/iconos/paginaPrevia.gif\" width=\"16px\" height=\"16px\" border=\"0\" onClick=\"paginar('" + paginaResultados.getAnteriorPagina() + "')\" style=\"cursor: pointer;\">&nbsp;");
		    	}
		    	else {
		    		out.println("<img src=\"comun/images/iconos/paginaPrimera_no.gif\" width=\"16px\" height=\"16px\" border=\"0\">&nbsp;");
		    		out.println("<img src=\"comun/images/iconos/paginaPrevia_no.gif\" width=\"16px\" height=\"16px\" border=\"0\">&nbsp;");
		    	}
		    	String pag = t._("Pág.");
		    	out.println("<b>"+pag+" " + paginaResultados.getNumPagina() + "/" + +paginaResultados.getNumeroTotalPaginas() + "</b>&nbsp;");
		    	if(!paginaResultados.isEsUltimaPagina()) {
		    		out.println("<img src=\"comun/images/iconos/paginaSiguiente.gif\" width=\"16px\" height=\"16px\" border=\"0\" onClick=\"paginar('" + paginaResultados.getSiguientePagina() + "')\" style=\"cursor: pointer;\">&nbsp;");
		    		out.println("<img src=\"comun/images/iconos/paginaFinal.gif\" width=\"16px\" height=\"16px\" border=\"0\" onClick=\"paginar('" + paginaResultados.getNumeroTotalPaginas() + "')\" style=\"cursor: pointer;\">");
		    	}
		    	else {
		    		out.println("<img src=\"comun/images/iconos/paginaSiguiente_no.gif\" width=\"16px\" height=\"16px\" border=\"0\">&nbsp;");
		    		out.println("<img src=\"comun/images/iconos/paginaFinal_no.gif\" width=\"16px\" height=\"16px\" border=\"0\">");
		    	}
		    	out.println("</span>");
		    }
		    out.println("</td>");
		    out.println("</tr>");
			// Fin del pintado de la paginación
		    
			out.println("</tbody>");
			
			return SKIP_BODY;
		}
		catch (IOException e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag ResultadosPaginadosTag: "+e.getMessage());
		}
	}

	/**
	 * @return the paginaResultados
	 */
	public PaginaResultados getPaginaResultados() {
		return paginaResultados;
	}

	/**
	 * @param paginaResultados the paginaResultados to set
	 */
	public void setPaginaResultados(PaginaResultados paginaResultados) {
		this.paginaResultados = paginaResultados;
	}

	/**
	 * @return the variable
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * @param variable the variable to set
	 */
	public void setVariable(String variable) {
		this.variable = variable;
	}

}
