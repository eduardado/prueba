package com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones;

public class EncuadernacionBeanKey {
    private String uidActividad;

    private String codalm;

    private Long idClieAlbaran;

    private Integer linea;

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

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }
}