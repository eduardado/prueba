package com.comerzzia.core.model.acciones.estados.operaciones;

import com.comerzzia.core.util.base.MantenimientoBean;

public class OperacionEstadoKey extends MantenimientoBean {

	private static final long serialVersionUID = 8325919969509523078L;

	private Long idAccion;

    private Long idEstado;

    private Long idOperacion;

    public Long getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Long idAccion) {
        this.idAccion = idAccion;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Long idOperacion) {
        this.idOperacion = idOperacion;
    }

	@Override
	protected void initNuevoBean() {
	}
}