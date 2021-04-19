package com.comerzzia.core.model.acciones.estados.vistas;

import com.comerzzia.core.util.base.MantenimientoBean;

public class VistaAccionEstadoKey extends MantenimientoBean {

	private static final long serialVersionUID = -9162642912103860997L;

	private Long idAccion;

    private String codvista;

    private Long idEstado;

    public Long getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Long idAccion) {
        this.idAccion = idAccion;
    }

    public String getCodvista() {
        return codvista;
    }

    public void setCodvista(String codvista) {
        this.codvista = codvista == null ? null : codvista.trim();
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

	@Override
	protected void initNuevoBean() {
		// TODO Auto-generated method stub
		
	}
}