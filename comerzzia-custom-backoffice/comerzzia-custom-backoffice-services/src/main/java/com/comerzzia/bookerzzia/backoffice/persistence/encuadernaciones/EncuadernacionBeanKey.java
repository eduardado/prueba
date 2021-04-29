package com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones;

import com.comerzzia.core.util.base.MantenimientoBean;

public class EncuadernacionBeanKey extends MantenimientoBean {

	private static final long serialVersionUID = 8074517061039126724L;

	private String uidActividad;

	private String codalm;

	private Long idClieAlbaran;

	public EncuadernacionBeanKey() {
		super();
		super.setActivo(true); // TODO esto lo pongo por si acaso porque no me funcionaba el mantenimiento de
		                       // comunidades sin esto no sé porqué
	}

	public String getUidActividad() {
		return uidActividad;
	}

	public void setUidActividad(String uidActividad) {
		this.uidActividad = uidActividad == null ? null : uidActividad.trim();
	}

	public String getCodalm() {
		return codalm;
	}

	public void setCodalm(String codalm) {
		this.codalm = codalm == null ? null : codalm.trim();
	}

	public Long getIdClieAlbaran() {
		return idClieAlbaran;
	}

	public void setIdClieAlbaran(Long idClieAlbaran) {
		this.idClieAlbaran = idClieAlbaran;
	}

	@Override
	protected void initNuevoBean() {

	}
}