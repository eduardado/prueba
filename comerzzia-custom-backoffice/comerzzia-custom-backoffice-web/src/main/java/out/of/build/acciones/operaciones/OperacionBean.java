package com.comerzzia.core.model.acciones.operaciones;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.comerzzia.core.util.base.Estado;

public class OperacionBean extends OperacionKey {
	
	private static final long serialVersionUID = 6316542523711011274L;
	
    private Byte orden;

    private String desOperacion;

    private String ejecucion;

    private Long idEstado;

    private Boolean visible;

    private String parametros;

    private String icono;
    
    //INICIO ATRIBUTOS PERSONALIZADOS--------------------------------------------
    
    //FIN ATRIBUTOS PERSONALIZADOS-----------------------------------------------


    public Byte getOrden() {
        return orden;
    }

    public void setOrden(Byte orden) {
        this.orden = orden;
    }

    public String getDesOperacion() {
        return desOperacion;
    }

    public void setDesOperacion(String desOperacion) {
        this.desOperacion = desOperacion == null ? null : desOperacion.trim();        
    }

    public String getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        this.ejecucion = ejecucion == null ? null : ejecucion.trim();
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros == null ? null : parametros.trim();
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono == null ? null : icono.trim();
    }
    
    //INICIO MÉTODOS PERSONALIZADOS--------------------------------------------
    
	public boolean requiereConfirmacion() {
		return parametros != null && parametros.toUpperCase().contains("CONFIRMACION");
	}

	public boolean requiereObservaciones() {
		return parametros != null && parametros.toUpperCase().contains("OBSERVACIONES");
	}
    
	@Override
	protected void initNuevoBean() {
    	this.setActivo(false);
        this.setVisible(false);
	}

	// ¿Para qué es este compare?
 	public int compareTo(OperacionBean o) {
 		// miramos si son iguales, en caso contrario devolvemos mayor o igual en función del orden
 		if (o.getIdOperacion().equals(getIdOperacion())) {
 			return 0;
 		}
 		return this.getOrden().compareTo(o.getOrden());
 	}

 	public void borrar() {
 		this.setEstadoBean(Estado.BORRADO);
 	}
 	
 	@JsonIgnore
	public String getVisibleString() {
		return (visible) ? TRUE : FALSE;
	}
    
    //FIN MÉTODOS PERSONALIZADOS-----------------------------------------------

}