package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

import com.comerzzia.core.util.base.ParametrosBuscarBean;

public class ParametrosBuscarLenguajesBean extends ParametrosBuscarBean {

	private static final long serialVersionUID = 5761172894653714845L; // TODO OJO!

	private String codlengua = "";
	private String deslengua = "";
	private String activo = "";

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = (activo != null) ? activo : "";
	}
	

	// setea el orden del Bean con la clave primaria
	public ParametrosBuscarLenguajesBean() {
		super.setOrden("CODLENGUA"); // TODO es necesario poner este super?
	}


	public String getCodlengua() {
		return codlengua;
	}

	public void setCodlengua(String codlengua) { // TODO un setter to wapo para que no peten las bases de datos no?
		this.codlengua = (codlengua != null) ? codlengua.toUpperCase() : "";
	}

	public String getDeslengua() {
		return deslengua;
	}

	public void setDeslengua(String deslengua) {
		this.deslengua = (deslengua != null) ? deslengua.toUpperCase() : "";
	}

}
