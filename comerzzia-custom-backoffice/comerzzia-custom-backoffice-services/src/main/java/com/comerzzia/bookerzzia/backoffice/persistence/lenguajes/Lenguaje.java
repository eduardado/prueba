package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

public class Lenguaje extends LenguajeKey {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2696378679730050666L;
	private String deslengua;
	
	

	public String getDeslengua() {
        return deslengua;
    }

    public void setDeslengua(String deslengua) {
        this.deslengua = deslengua == null ? null : deslengua.trim();
    }

}