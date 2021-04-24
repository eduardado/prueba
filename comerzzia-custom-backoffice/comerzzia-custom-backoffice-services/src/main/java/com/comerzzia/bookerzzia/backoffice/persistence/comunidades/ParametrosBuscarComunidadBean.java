package com.comerzzia.bookerzzia.backoffice.persistence.comunidades;

import com.comerzzia.core.util.base.ParametrosBuscarBean;

public class ParametrosBuscarComunidadBean extends ParametrosBuscarBean {

	private static final long serialVersionUID = -1822400989888381062L;

	private String codigo = "";
	private String descripcion = "";
	private String idioma = "";

	public ParametrosBuscarComunidadBean() {
		super.setOrden("CODIGO");
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getIdioma() {
		return idioma;
	}

	/*
	 * Los setters, siempre guardarán al menos una cadena vacía
	 * de tal manera que no haya problemas al hacer los insert
	 */
	public void setCodigo(String codigo) {
		this.codigo = (codigo != null) ? codigo.toUpperCase() : "";
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = (descripcion != null) ? descripcion.toUpperCase() : "";
	}

	public void setIdioma(String idioma) {
		this.idioma = (idioma != null) ? idioma.toUpperCase() : "";
	}

}
