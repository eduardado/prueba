package com.comerzzia.bookerzzia.backoffice.persistence.lenguajes;

public class Lenguaje extends LenguajeKey {
    private String deslengua;


    public String getDeslengua() {
        return deslengua;
    }

    public void setDeslengua(String deslengua) {
        this.deslengua = deslengua == null ? null : deslengua.trim();
    }

}