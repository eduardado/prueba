package com.comerzzia.bookerzzia.backoffice.persistence.encuadernacion;

import com.comerzzia.model.ventas.albaranes.articulos.ArticuloAlbaranVentaBean;

public class EncuadernacionBean extends ArticuloAlbaranVentaBean {


	private static final long serialVersionUID = -200048733054933274L;
	
	private String uidActividad; // PK
	private String codalm; // PK
	private Long idClieAlbaran; // PK
	private String tapa;
	private String subtitulo;
	private String dedicatoria;
	private String hecho;

	public EncuadernacionBean() {
		super();
		hecho = "S";
		super.setActivo(true);
	}

	public String getUidActividad() {
		return uidActividad;
	}

	public String getCodalm() {
		return codalm;
	}

	public Long getIdClieAlbaran() {
		return idClieAlbaran;
	}

	public String getTapa() {
		return tapa;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public String getDedicatoria() {
		return dedicatoria;
	}

	public String getHecho() {
		return hecho;
	}

	public void setUidActividad(String uidActividad) {
		this.uidActividad = uidActividad;
	}

	public void setCodalm(String codalm) {
		this.codalm = codalm;
	}

	public void setIdClieAlbaran(Long idClieAlbaran) {
		this.idClieAlbaran = idClieAlbaran;
	}

	public void setTapa(String tapa) {
		this.tapa = tapa;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public void setDedicatoria(String dedicatoria) {
		this.dedicatoria = dedicatoria;
	}

	public void setHecho(String hecho) {
		this.hecho = hecho;
	}

}
