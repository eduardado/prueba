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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.comerzzia.core.model.config.ayudas.AyudaBean;
import com.comerzzia.core.model.config.ayudas.ElementoAyudaBean;
import com.comerzzia.core.servicios.config.ayudas.AyudaException;
import com.comerzzia.core.servicios.config.ayudas.Ayudas;
import com.comerzzia.core.servicios.config.ayudas.ServicioAyudasImpl;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.TeclasRapidasKeys;
import com.comerzzia.taglib.WebKeys;

public class AyudaTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9037620810437693229L;
	
	/* Código */
	private String idCodigo = null;
	private String valorCodigo = null;
	private String longitudMaximaCodigo = null;
	private String anchuraCodigo = null;
	private String estiloCodigo = null;
	private String onchange = null;

	/* Descripción */
	private String idDescripcion = null;
	private String valorDescripcion = null;
	private String anchuraDescripcion = null;
	private String estiloDescripcion = null;
	private boolean editable = false;

	/* Comunes */
	private boolean soloLectura = false;
	private boolean requerido = false;
	private String accionAyudaXML = null;
	private String nombreAyuda = null;
	private String onclick = null;
	private String campoFiltro = null;
	private String callbackFunction = null;
	
	/* Parámetros */
	private Map<String, String> mapaParams = new HashMap<String, String>(); 
	
	public int doStartTag() throws JspException {
		try {
			return EVAL_BODY_BUFFERED;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag AyudaTag: "+e.getMessage());
		}
	}
	
	public int doAfterBody() throws JspException {
		try {
			BodyContent body = getBodyContent();
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag AyudaTag: "+e.getMessage());
		}
	}

	public int doEndTag()throws JspTagException{
		try {
			JspWriter out = pageContext.getOut();
			
			//Obtenemos el bean de la ayuda según el nombre de esta
			Ayudas ayudas = Ayudas.getInstance();
			AyudaBean ayuda = ayudas.getAyuda(nombreAyuda);

			String inputCodigo = obtenerInputCodigo(out, ayuda);
			out.println(inputCodigo);
			
			String inputDescripcion = obtenerInputDescripcion(out, ayuda);
			out.println(inputDescripcion);

			String params = obtenerParametros();
			
			String imagenDesplegable = "";
			if(!soloLectura) {
				if((onclick != null) && (!onclick.equals(""))){
					imagenDesplegable = "<img src=\"comun/images/iconos/i-binoculares.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"" + onclick + "\"  width=\"17px\" height=\"17px\"/>";
				}
				else if(((accionAyudaXML != null) && (!accionAyudaXML.equals("")) && ((campoFiltro != null) && (!campoFiltro.equals(""))))){
					imagenDesplegable = "<img src=\"comun/images/iconos/i-binoculares.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', '" + accionAyudaXML + "', '" + campoFiltro + "', "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")\"  width=\"17px\" height=\"17px\"/>";
				}
				else if((accionAyudaXML != null) && (!accionAyudaXML.equals(""))){
					imagenDesplegable = "<img src=\"comun/images/iconos/i-binoculares.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', '" + accionAyudaXML + "', " + campoFiltro + ", "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")\"  width=\"17px\" height=\"17px\"/>";
				}
				else if((campoFiltro != null) && (!campoFiltro.equals(""))){
					imagenDesplegable = "<img src=\"comun/images/iconos/i-binoculares.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', " + accionAyudaXML + ", '" + campoFiltro + "', "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")\"  width=\"17px\" height=\"17px\"/>";
				}
				else if((callbackFunction != null)){
					imagenDesplegable = "<img src=\"comun/images/iconos/i-binoculares.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', " + accionAyudaXML + ", " + campoFiltro + ", "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")\"  width=\"17px\" height=\"17px\"/>";
				}
				else{
					imagenDesplegable = "<img src=\"comun/images/iconos/i-binoculares.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', undefined, undefined, undefined"+(params != null ? ", '"+params+"'" :"")+")\"  width=\"17px\" height=\"17px\"/>";
				}

				if(!ayuda.isCampoCodigoVisible() && !editable){
					imagenDesplegable += "&nbsp;&nbsp;<img src=\"comun/images/iconos/i-goma.gif\" style=\"VERTICAL-ALIGN:top;HEIGHT: 17px; CURSOR: pointer;\" onClick=\"borrarDatos('" + idCodigo + "', '" + idDescripcion + "')\" align=\"absMiddle\" border=\"0\" valign=\"middle\" width=\"17px\" height=\"17px\"/>";
				}
				
				out.println("");
				out.println("<script type=\"text/javascript\">");
				String funcion = "";
				if(onclick != null && !onclick.isEmpty()){
					funcion = onclick;
				}
				else if(((accionAyudaXML != null) && (!accionAyudaXML.equals("")) && ((campoFiltro != null) && (!campoFiltro.equals(""))))){
					funcion =  "buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', '" + accionAyudaXML + "', '" + campoFiltro + "', "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")";
				}
				else if((accionAyudaXML != null) && (!accionAyudaXML.equals(""))){
					funcion = "buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', '" + accionAyudaXML + "', " + campoFiltro + ", "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")";
				}
				else if((campoFiltro != null) && (!campoFiltro.equals(""))){
					funcion = "buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', " + accionAyudaXML + ", '" + campoFiltro + "', "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")";
				}
				else if((callbackFunction != null)){
					funcion = "buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', " + accionAyudaXML + ", " + campoFiltro + ", "+callbackFunction+(params != null ? ", '"+params+"'" :"")+")";
				}
				else{
					funcion = "buscar('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "', undefined, undefined, undefined"+(params != null ? ", '"+params+"'" :"")+")";
				}
				
				out.println("jQuery('#" + idCodigo + "').bind('keydown',\"" + TeclasRapidasKeys.ABRIR_AYUDA_HK + "\", function(event) {");
				out.println("	" + funcion + ";");
			    out.println("	event.stopPropagation();");
			    out.println("	event.preventDefault();");
				out.println("	return false;});");
				out.println("</script>");
				out.println("");
			}
			
			
			out.println(imagenDesplegable);
		mapaParams.clear();

		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag AyudaTag: "+e.getMessage());
		}

		return SKIP_BODY;
	}
	
	private String obtenerInputCodigo(JspWriter out, AyudaBean ayuda) throws AyudaException {
		//Empezamos a contruir el input
		String input = "<input id=\"" + idCodigo + "\" name=\"" + idCodigo + "\"";
		String params = obtenerParametros();
		//Comprobamos si el campo código es visible o no
		if(ayuda.isCampoCodigoVisible()) {
			input += "  type=\"text\"";
			//Indicamos cual será la clase del campo
			if(soloLectura){
				input += " class=\"campo soloLectura\" readonly=\"readonly\" tabindex=\"-1\"";
			}
			else if(requerido) {
				input += " class=\"campo requerido\"";
			}
			else {
				input += " class=\"campo\"";
			}
			//Indicamos la longitud máxima del código
			if(longitudMaximaCodigo != null) {
				input += " maxlength=\"" + longitudMaximaCodigo + "\"";
			}
			//Indicamos su anchura
			if(anchuraCodigo != null && !anchuraCodigo.isEmpty()) {
				input += " width=\"" + anchuraCodigo + "\"";
			}
			//Definimos a qué ayuda XML llamará
			if((accionAyudaXML != null) && (!accionAyudaXML.equals(""))){
				if(campoFiltro != null && !campoFiltro.isEmpty()) {
					input += " onchange=\"return buscarAccionXML('" + accionAyudaXML + "','" + idCodigo + "','" + idDescripcion + "','" + campoFiltro + "')\"";
				}
				else {
					input += " onchange=\"return buscarAccionXML('" + accionAyudaXML + "','" + idCodigo + "','" + idDescripcion + "')\"";
				}
				
			}
			else{
				if((onchange != null) && (!onchange.isEmpty())){
					input += " onchange=\"" + onchange + " \"";					
				}
				else{
					if(campoFiltro != null && !campoFiltro.isEmpty()) {
						input += " onchange=\"return buscarXML('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "','" + campoFiltro + "'"+(params != null ? ", '"+params+"'" : "")+")\" ";
					}
					else {
						input += " onchange=\"return buscarXML('" + nombreAyuda + "','" + idCodigo + "', '" + idDescripcion + "',undefined" +(params != null ? ", '"+params+"'" : "")+")\" ";
					}
				}
			}
		}
		else {
			input += "  type=\"hidden\"";
		}

		//Indicamos el valor del campo código por defecto
		if(valorCodigo != null && !valorCodigo.isEmpty()) {
			input += " value=\"" + valorCodigo + "\"";
		}
		else {
			input += " value=\"\"";
		}
		
		// Definición del estilo personalizado, más la anchura indicada si viene
		String style = " style=\"";
		if(anchuraCodigo != null && !anchuraCodigo.isEmpty()) {
			style += "width:" + anchuraCodigo + ";";
		}
		if(estiloCodigo != null && !estiloCodigo.isEmpty()) {
			style += estiloCodigo;
		}
		style += "\"";
		input += style;
		// Fin del estilo personalizado
		
		// capturamos evento onkeydown
		input += " onkeydown=\"_onkeydownAyuda(event, this, \'"+ idDescripcion +"\');\" ";
		
		//Cerramos el campo input
		input += " />";
		
		return input;
	}

	private String obtenerInputDescripcion(JspWriter out, AyudaBean ayuda) {
		String input = "<input id=\"" + idDescripcion + "\" name=\"" +idDescripcion + "\" type=\"text\"";
		
		if(valorDescripcion != null && !valorDescripcion.isEmpty()) {
			valorDescripcion = valorDescripcion.replaceAll("\"", "&#034;");
			input += " value=\"" + valorDescripcion + "\"";
		}
		else {
			if(StringUtils.isNotBlank(valorCodigo)){
				DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
				String params = obtenerParametros();
				try {
					ElementoAyudaBean elemento = ServicioAyudasImpl.get().consultar(ayuda, valorCodigo, params, datosSesion);
					input += " value=\"" + elemento.getDescripcion() + "\"";
				} catch (Exception ignore) {}
				
			}else{
				input += " value=\"\"";
			}
		}
		
		//Indicamos la anchura del campo
		if(anchuraDescripcion != null && !anchuraDescripcion.isEmpty()) {
			input += " width=\"" + anchuraDescripcion + "\"";
		}
		
		// Definición del estilo personalizado, más la anchura indicada si viene
		String style = " style=\"";
		if(anchuraDescripcion != null && !anchuraDescripcion.isEmpty()) {
			style += "width:" + anchuraDescripcion + ";";
		}
		if(estiloDescripcion != null && !estiloDescripcion.isEmpty()) {
			style += estiloDescripcion;
		}
		style += "\"";
		input += style;
		// Fin del estilo personalizado
		
		String classRequerido = "";
		if(requerido && !isSoloLectura()) {
			classRequerido = "requerido";
		}
		//Indicamos cual será la clase del campo
		if(editable){
			input += " class=\"campo "+classRequerido+"\"";
		}
		else if(ayuda.isCampoCodigoVisible()){
			input += " class=\"campo soloLectura\" readonly=\"readonly\"";
		}
		else{
			input += " class=\"campo soloLectura "+classRequerido+"\" readonly=\"readonly\"";
		}

		//Indicamos que el campo será solo lectura
		input += " tabindex=\"-1\"";
		
		//Cerramos el input de la descripción
		input += " />";
		
		return input;
	}
	
	protected String obtenerParametros(){
		String params = null;
		for(String param : mapaParams.keySet()){
			if(params == null){
				params = "";
			}
			params += param+"/"+mapaParams.get(param)+";";
		}
		if(params != null){
			params = params.substring(0, params.length()-1);
		}
		
		return params;
	}

	public boolean isSoloLectura() {
		return soloLectura;
	}

	public void setSoloLectura(boolean soloLectura) {
		this.soloLectura = soloLectura;
	}

	public boolean isRequerido() {
		return requerido;
	}

	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}

	public String getAccionAyudaXML() {
		return accionAyudaXML;
	}

	public void setAccionAyudaXML(String accionAyudaXML) {
		this.accionAyudaXML = accionAyudaXML;
	}

	public String getNombreAyuda() {
		return nombreAyuda;
	}

	public void setNombreAyuda(String nombreAyuda) {
		this.nombreAyuda = nombreAyuda;
	}

	public String getIdCodigo() {
		return idCodigo;
	}

	public void setIdCodigo(String idCodigo) {
		this.idCodigo = idCodigo;
	}

	public String getValorCodigo() {
		return valorCodigo;
	}

	public void setValorCodigo(String valorCodigo) {
		this.valorCodigo = valorCodigo;
	}

	public String getLongitudMaximaCodigo() {
		return longitudMaximaCodigo;
	}

	public void setLongitudMaximaCodigo(String longitudMaximaCodigo) {
		this.longitudMaximaCodigo = longitudMaximaCodigo;
	}

	public String getAnchuraCodigo() {
		return anchuraCodigo;
	}

	public void setAnchuraCodigo(String anchuraCodigo) {
		this.anchuraCodigo = anchuraCodigo;
	}

	public String getEstiloCodigo() {
		return estiloCodigo;
	}

	public void setEstiloCodigo(String estiloCodigo) {
		this.estiloCodigo = estiloCodigo;
	}

	public String getIdDescripcion() {
		return idDescripcion;
	}

	public void setIdDescripcion(String idDescripcion) {
		this.idDescripcion = idDescripcion;
	}

	public String getValorDescripcion() {
		return valorDescripcion;
	}

	public void setValorDescripcion(String valorDescripcion) {
		this.valorDescripcion = valorDescripcion;
	}

	public String getAnchuraDescripcion() {
		return anchuraDescripcion;
	}

	public void setAnchuraDescripcion(String anchuraDescripcion) {
		this.anchuraDescripcion = anchuraDescripcion;
	}

	public String getEstiloDescripcion() {
		return estiloDescripcion;
	}

	public void setEstiloDescripcion(String estiloDescripcion) {
		this.estiloDescripcion = estiloDescripcion;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getCampoFiltro() {
		return campoFiltro;
	}

	public void setCampoFiltro(String campoFiltro) {
		this.campoFiltro = campoFiltro;
	}

    public String getCallbackFunction() {
    	return callbackFunction;
    }
    
    public void setCallbackFunction(String callbackFunction) {
    	this.callbackFunction = callbackFunction;
    }

	public Map<String, String> getMapaParams() {
		return mapaParams;
	}

	public void setMapaParams(Map<String, String> mapaParams) {
		this.mapaParams = mapaParams;
	}
}
