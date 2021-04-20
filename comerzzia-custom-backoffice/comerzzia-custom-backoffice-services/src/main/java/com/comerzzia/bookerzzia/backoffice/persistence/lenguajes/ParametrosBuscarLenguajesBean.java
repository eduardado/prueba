package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

import com.comerzzia.core.util.base.ParametrosBuscarBean;

public class ParametrosBuscarLenguajesBean extends ParametrosBuscarBean{
	
	private static final long serialVersionUID = 5761172894653714845L; // TODO OJO! 
	
	private String codlengua;
	private String deslengua;
	
	public String getCodlengua() {
		return codlengua;
	}
	
	public void setCodlengua(String codlengua) {
		this.codlengua = codlengua;
	}
	
	public String getDeslengua() {
		return deslengua;
	}
	
	public void setDeslengua(String deslengua) {
		this.deslengua = deslengua;
	}
	
	

}
