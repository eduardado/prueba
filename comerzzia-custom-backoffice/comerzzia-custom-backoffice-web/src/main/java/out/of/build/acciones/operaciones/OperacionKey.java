package com.comerzzia.core.model.acciones.operaciones;

import com.comerzzia.core.util.base.MantenimientoBean;

public class OperacionKey extends MantenimientoBean {

	private static final long serialVersionUID = 5104193493917628867L;

	private Long idAccion;

    private Byte idOperacion;

    public Long getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Long idAccion) {
        this.idAccion = idAccion;
    }

    public Byte getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Byte idOperacion) {
        this.idOperacion = idOperacion;
    }

	@Override
	protected void initNuevoBean() {
	}
}