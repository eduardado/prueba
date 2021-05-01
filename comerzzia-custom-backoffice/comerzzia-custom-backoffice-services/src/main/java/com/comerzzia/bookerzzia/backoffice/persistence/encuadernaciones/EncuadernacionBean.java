package com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones;

public class EncuadernacionBean extends EncuadernacionBeanKey {
    private String tapa;

    private String subtitulo;

    private String dedicatoria;

    private String hecho;

    public String getTapa() {
        return tapa;
    }

    public void setTapa(String tapa) {
        this.tapa = tapa == null ? null : tapa.trim();
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo == null ? null : subtitulo.trim();
    }

    public String getDedicatoria() {
        return dedicatoria;
    }

    public void setDedicatoria(String dedicatoria) {
        this.dedicatoria = dedicatoria == null ? null : dedicatoria.trim();
    }

    public String getHecho() {
        return hecho;
    }

    public void setHecho(String hecho) {
        this.hecho = hecho == null ? null : hecho.trim();
    }
}