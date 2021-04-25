package com.comerzzia.bookerzzia.backoffice.persistence.comunidades;

import com.comerzzia.core.util.base.MantenimientoBean;

public class ComunidadBeanKey extends MantenimientoBean {

	private static final long serialVersionUID = 1673875269898325304L;

	private String uidActividad;

	private String codigo;

	/*
	 * No sé para qué es esto
	 */
	public ComunidadBeanKey() {
		super();
		super.setActivo(true);
	}

	public String getUidActividad() {
		return uidActividad;
	}

	public void setUidActividad(String uidActividad) {
		this.uidActividad = uidActividad == null ? null : uidActividad.trim();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo == null ? null : codigo.trim();
	}

	@Override
	protected void initNuevoBean() {

	}
}