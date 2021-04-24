package com.comerzzia.bookerzzia.backoffice.persistence.comunidades;

public class ComunidadBean extends ComunidadBeanKey {

	private static final long serialVersionUID = 536487244069249790L;

	private String descripcion;

	private String idioma;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion == null ? null : descripcion.trim();
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma == null ? null : idioma.trim();
	}

	@Override
	public String toString() {
		return "ComunidadBean [descripcion=" + descripcion + ", idioma=" + idioma + "]";
	}
	
	
}