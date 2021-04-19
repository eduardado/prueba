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

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.comerzzia.core.util.numeros.Numero;

public class FormateaNumeroTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9089943173777303827L;
	
	private Object valor;
	private boolean valorEspecificado;
	private String variable;
	private boolean variableEspecificada;
	private int numDecimales;
	private boolean numDecimalesEspecificado;
	
	public FormateaNumeroTag (){
		inicio();
	}
	
	/**
	 * Método para inicializar las variables del tag
	 */
	private void inicio(){
		this.valor = null;
		this.valorEspecificado = false;
		this.variable = null;
		this.variableEspecificada = false;
		this.numDecimalesEspecificado = false;
	}
	
	public int doEndTag() throws JspException {
		String valorFormateado = null;
		Object v = null;
		
		if (valorEspecificado){
			//el valor se especifica en el tag
			v = this.valor;
		}else if (bodyContent != null && (bodyContent.getString() != null)){
			//el valor se especifica en el cuerpo del tag
			v = bodyContent.getString().trim();
		}
		
		//si no tenemos valor especificado, eliminamos la variable
		if (v == null || v.equals("")){
			if (this.variable != null){
				pageContext.removeAttribute(this.variable);
			}
			return EVAL_PAGE;
		}
		
		//si el valor lo recogemos del body, debemos deformatearlo
		if (v instanceof String){
			try {
		        if (((String)v).indexOf(46) != -1)
		          v = Double.valueOf((String)v);
		        else
		          v = Long.valueOf((String)v);
		      }
		      catch (NumberFormatException nfe) {
		    	  throw new JspTagException("doEndTag() - Error de formato en la clase del tag FormateaNumeroTag: "+nfe.getMessage());
		      }
		}
		
		//obtenemos el valor formateado
		if (numDecimalesEspecificado){
			 valorFormateado = Numero.formatea(v, this.numDecimales);
		}else{
			valorFormateado = Numero.formatea(v);
		}
		
	    if (variableEspecificada){
	    	pageContext.setAttribute(this.variable, valorFormateado);
	    }else{
	    	try{
	    		pageContext.getOut().print(valorFormateado);
	    	}catch (IOException ioe){
	    		throw new JspTagException("doEndTag() - Error en la clase del tag FormateaNumeroTag: "+ioe.getMessage());
	    	}
	    }
	    
		return EVAL_PAGE;
	}


	public Object getValor() {
		return valor;
	}


	public void setValor(Object valor) {
		this.valor = valor;
		this.valorEspecificado = true;
	}


	public String getVariable() {
		return variable;
	}


	public void setVariable(String variable) {
		this.variable = variable;
		this.variableEspecificada = true;
	}


	public int getNumDecimales() {
		return numDecimales;
	}


	public void setNumDecimales(int numDecimales) {
		this.numDecimales = numDecimales;
		this.numDecimalesEspecificado = true;
	}
}
