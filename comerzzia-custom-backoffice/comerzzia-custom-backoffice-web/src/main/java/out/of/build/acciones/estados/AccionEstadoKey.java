package com.comerzzia.core.model.acciones.estados;

import com.comerzzia.core.util.base.MantenimientoBean;

public class AccionEstadoKey extends MantenimientoBean {

	private static final long serialVersionUID = -7692783856283427971L;

	private Long idAccionEstados;

    private Long idEstado;

    public Long getIdAccionEstados() {
        return idAccionEstados;
    }

    public void setIdAccionEstados(Long idAccionEstados) {
        this.idAccionEstados = idAccionEstados;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

	@Override
	protected void initNuevoBean() {
	}
}