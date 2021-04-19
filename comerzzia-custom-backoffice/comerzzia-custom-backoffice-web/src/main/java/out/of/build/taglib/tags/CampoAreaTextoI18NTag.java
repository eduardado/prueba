package com.comerzzia.taglib.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.comerzzia.core.model.lenguajes.LenguajesBean;
import com.comerzzia.core.servicios.lenguajes.ServicioLenguajesImpl;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.WebKeys;

public class CampoAreaTextoI18NTag extends BodyTagSupport{

	private static final long serialVersionUID = 2362468306371069126L;
	
	private String id = null;
	private String valor = null;
	private String clase = null;
	private Integer longitudMaxima = null;
	private String anchura = null;
	private String altura = null;
	private String estilo = null;
	private boolean soloLectura = false;
	private boolean campoEditable = true;
	private boolean requerido = false;
	private String idClase = null;
	private String nombreObjetoSesion = null;
	private boolean esDetalle = false;
	private boolean traducido = false;
	private boolean traduccionEditable = true;
	
	public int doStartTag() throws JspException {
		try {
			return EVAL_BODY_BUFFERED;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag CampoI18NAreaTag: "+e.getMessage());
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
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag CampoI18NAreaTag: "+e.getMessage());
		}
	}

	public int doEndTag()throws JspTagException{
		try{
		JspWriter out = pageContext.getOut();
		
		String input = obtenerTextArea(out);
		out.println(input);
		HttpSession sesion = pageContext.getSession();
				
		DatosSesionBean datosSesion = (DatosSesionBean)sesion.getAttribute(WebKeys.DATOS_SESION);
		String idiomaSeleccionado = (String) pageContext.getRequest().getAttribute(WebKeys.IDIOMA_SELECCIONADO);
		if(idiomaSeleccionado == null){
			idiomaSeleccionado = I18nUtil.obtenerIdiomaSeleccionado((HttpServletRequest) pageContext.getRequest(), datosSesion);
		}
				
		List<LenguajesBean> lenguajesDisponibles = (List<LenguajesBean>) sesion.getAttribute(WebKeys.LENGUAJES_DISPONIBLES);
		if(lenguajesDisponibles == null){
			lenguajesDisponibles = ServicioLenguajesImpl.get().consultarTodos(datosSesion);
			sesion.setAttribute(WebKeys.LENGUAJES_DISPONIBLES, lenguajesDisponibles);
		}
		
		
		
		String imagenDesplegable = "";
		if(traduccionEditable){
			imagenDesplegable = "<img src=\"comun/images/flags/earth.gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"abrirI18NArea('"+anchura+"','"+altura+"','"+traduccionEditable+"','"+idClase+"','"+nombreObjetoSesion+"',"+esDetalle+",'"+lenguajesDisponibles.size()+"')\"  width=\"17px\" height=\"17px\"/>";
		}else{
			if(traducido){
				imagenDesplegable = "<img src=\"comun/images/flags/flag_"+idiomaSeleccionado.toLowerCase()+".gif\" class=\"prismaticos\" align=\"absMiddle\" border=\"0\" valign=\"middle\"  onClick=\"abrirI18NArea('"+anchura+"','"+altura+"','"+traduccionEditable+"','"+idClase+"','"+nombreObjetoSesion+"',"+esDetalle+",'"+lenguajesDisponibles.size()+"')\"  width=\"17px\" height=\"17px\"/>";
			}
			
		}

		out.println(imagenDesplegable);

	}
	catch (Exception e) {
		throw new JspTagException("doEndTag() - Excepción en la clase del tag CampoI18NTag: "+e.getMessage());
	}
		return SKIP_BODY;
	}

	private String obtenerTextArea(JspWriter out) {
		String textarea = "<textarea id=\"" + id + "\" name=\"" +id + "\" ";
		
		
		
		String style = " style=\"";
		if(anchura != null && !anchura.isEmpty()) {
			style += "width:" + anchura + ";";
		}
		if(altura != null && !altura.isEmpty()) {
			style += "height:" + altura + ";";
		}
		if(estilo != null && !estilo.isEmpty()) {
			style += estilo;
		}
		style += "\"";
		textarea += style;
		// Fin del estilo personalizado
		
		if(clase != null && !clase.isEmpty()) {
			textarea += " class=\"" + clase + "\"";
		}
		else {
			if(campoEditable && requerido) {
				textarea += " class=\"campo requerido\"";
			}
			else if(soloLectura){
				textarea += " class=\"campo soloLectura\"";
			}
			else {
				textarea += " class=\"campo\"";
			}
		}
		
		if(soloLectura) {
			textarea += " readonly=\"readonly\" tabindex=\"-1\" ";
		}
		
		if(longitudMaxima != null) {
			textarea += " maxlength=\"" + longitudMaxima + "\"";
		}
	
		//Indicamos que el campo será solo lectura
	//	input += " tabindex=\"-1\"";
		
		//Cerramos el input de la descripción
		textarea += " >";
		if(valor != null && !valor.isEmpty()) {
			valor = valor.replaceAll("\"", "&#034;");
			textarea += valor;
		}
		textarea += "</textarea>";
		
		return textarea;
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
	
	public String getClase() {
		return clase;
	}
	
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public Integer getLongitudMaxima() {
		return longitudMaxima;
	}
	
	public void setLongitudMaxima(Integer longitudMaxima) {
		this.longitudMaxima = longitudMaxima;
	}
	
	public String getAnchura() {
		return anchura;
	}
	
	public void setAnchura(String anchura) {
		this.anchura = anchura;
	}
	
	public String getAltura() {
		return altura;
	}
	
	public void setAltura(String altura) {
		this.altura = altura;
	}
	
	public String getEstilo() {
		return estilo;
	}
	
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	public boolean isSoloLectura() {
		return soloLectura;
	}
	
	public void setSoloLectura(boolean soloLectura) {
		this.soloLectura = soloLectura;
	}
	
	public boolean isCampoEditable() {
		return campoEditable;
	}
	
	public void setCampoEditable(boolean campoEditable) {
		this.campoEditable = campoEditable;
	}
	
	public boolean isTraduccionEditable() {
		return traduccionEditable;
	}
	
	public void setTraduccionEditable(boolean traduccionEditable) {
		this.traduccionEditable = traduccionEditable;
	}
	
	public boolean isRequerido() {
		return requerido;
	}
	
	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}
	
	public String getIdClase() {
		return idClase;
	}
	
	public void setIdClase(String idClase) {
		this.idClase = idClase;
	}
	
	public String getNombreObjetoSesion() {
		return nombreObjetoSesion;
	}
	
	public void setNombreObjetoSesion(String nombreObjetoSesion) {
		this.nombreObjetoSesion = nombreObjetoSesion;
	}
	
	public boolean isTraducido() {
		return traducido;
	}
	
	public void setTraducido(boolean traducido) {
		this.traducido = traducido;
	}

	public boolean isEsDetalle() {
		return esDetalle;
	}

	public void setEsDetalle(boolean esDetalle) {
		this.esDetalle = esDetalle;
	}

}
