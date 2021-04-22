package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

import com.comerzzia.core.util.base.MantenimientoBean;

public class LenguajeKey extends MantenimientoBean{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3286915326160189973L;

	private String uidInstancia;

    private String codlengua;

    public String getUidInstancia() {
        return uidInstancia;
    }

    public void setUidInstancia(String uidInstancia) {
        this.uidInstancia = uidInstancia == null ? null : uidInstancia.trim();
    }

    public String getCodlengua() {
        return codlengua;
    }

    public void setCodlengua(String codlengua) {
        this.codlengua = codlengua == null ? null : codlengua.trim();
    }

	@Override
	protected void initNuevoBean() {
		
	}
}