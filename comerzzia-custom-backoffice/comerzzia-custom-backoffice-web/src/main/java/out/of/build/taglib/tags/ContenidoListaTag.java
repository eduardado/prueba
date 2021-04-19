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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.core.util.base.MantenimientoBean;
import com.comerzzia.taglib.WebKeys;

public class ContenidoListaTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -894769306702944730L;

	// Atributos que recibe la clase del tag en su invocación
	protected List<Object> lista = null;
	protected String variable;

	// Atributos necesarios para la iteración
	private Iterator<?> iterator = null;
	private int indice = 0; // Representa la posición del elemento en la lista
	private int contadorVueltas = 0; // Se utiliza para pintar un estilo de fila u otro 
	
	//atributo para mostrar los elementos borrados o no
	protected boolean verBorrados = false;
	
	
	// TODO: cambiar atributo contadorVuentas por un boolean que indique si la fila es par o no
	// TODO: Eliminar atributo iterator y recorrer la lista con el índice que ya tenemos como atributo
	
	
	public int doStartTag() throws JspTagException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			
			JspWriter out = pageContext.getOut();
			
			// Inicializar los contadores y poner en el pageContext su valor para saber en la JSP el índice actual
			indice = -1;
			contadorVueltas = 0;
			
			out.println("<tbody>");
			
			Object siguiente = obtenerSiguiente();
			if (siguiente != null){
				pageContext.setAttribute(TagKeys.INDICE, indice);
				
				pageContext.setAttribute(variable, siguiente);
				
				return EVAL_BODY_BUFFERED;
			}
			else {
				// Mensaje de que no existen resultados
				out.println("<tr height=\"30px\">");
				out.println("<td align=\"center\" colspan=\"99\">");
				out.println(datosSesion.getTranslation()._("No se han encontrado resultados"));
				out.println("</td>");
				out.println("</tr>");
				
				return SKIP_BODY;
			}
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag ResultadosTag: "+e.getMessage());
		}
	}
	
	public void doInitBody() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			if(lista.get(indice) instanceof MantenimientoBean && !((MantenimientoBean) lista.get(indice)).isActivo()){
				out.println("<tr class=\"fila par inactivo\">");
			}else{
				out.println("<tr class=\"fila par\">");
			}
		}
		catch (Exception e) {
			throw new JspTagException("doInitBody() - Excepción en la clase del tag doInitBody: "+e.getMessage());
		}
	}

	public int doAfterBody() throws JspTagException {
		try {
			BodyContent body = getBodyContent();
			JspWriter out = body.getEnclosingWriter();
			
			body.writeOut(getPreviousOut());
			out.println("</tr>");
			
			// Limpiar, ya que la siguiente vez el contenido del cuerpo está vacío 
			body.clearBody();
			
			Object siguiente = obtenerSiguiente();
			if (siguiente != null){
				//tenemos un objeto que pintar
				
				pageContext.setAttribute(TagKeys.INDICE, indice);
				
				// Incrementar el contador de vueltas y poner el elemento en el pageContext para recuperarlo en la JSP
				contadorVueltas++;
				
				pageContext.setAttribute(variable, siguiente);
				
				String clase = "fila";
				// Dependiendo del módulo del valor del contador de vueltas, se usará un estilo u otro para la fila
				if (contadorVueltas % 2 == 0) {
					clase += " par";
				} else {
					clase += " impar";
				}
				//Si esta inactivo se añade a la clase
				if(lista.get(indice) instanceof MantenimientoBean && !((MantenimientoBean) lista.get(indice)).isActivo()){
					clase += " inactivo";
				}
				
				out.println("<tr class=\"" + clase + "\">");
				
				return EVAL_BODY_AGAIN; 
			}else{
				return SKIP_BODY;
			}
		}
		catch (Exception e) {
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag ResultadosTag: "+e.getMessage());
		}
	}
	
	/**
	 * @return
	 */
	private Object obtenerSiguiente() {
		if (iterator == null) {
			return null;
		}
		
		while (iterator.hasNext()){
			indice++;
			Object siguiente = iterator.next();
			
			if (verBorrados) {
				return siguiente;
			}
			else if (siguiente instanceof MantenimientoBean) {
				if (((MantenimientoBean) siguiente).getEstadoBean() != Estado.BORRADO) {
					return siguiente;
				}
			}
			else {
				return siguiente;
			}
		}
		
		return null;
	}

	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
			out.println("</tbody>");
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag ResultadosTag: "+e.getMessage());
		}
	}
	
	public List<?> getLista() {
		return lista;
	}
	
	public void setLista(List<?> lista) {
		this.lista= new ArrayList<Object>();
		
		// TODO: mejorar la asignación entre listas con tipo genérico en la parte derecha.
		if (lista != null && lista.size() > 0) {
			for(int i = 0; i < lista.size(); i++) {
				this.lista.add(lista.get(i));
			}
			
			iterator = this.lista.iterator();
		}
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	/**
	 * @return the verBorrados
	 */
	public boolean isVerBorrados() {
		return verBorrados;
	}

	/**
	 * @param verBorrados the verBorrados to set
	 */
	public void setVerBorrados(boolean verBorrados) {
		this.verBorrados = verBorrados;
	}
}

