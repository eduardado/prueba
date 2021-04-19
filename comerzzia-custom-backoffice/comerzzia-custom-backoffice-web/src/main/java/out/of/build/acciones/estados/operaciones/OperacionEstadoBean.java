package com.comerzzia.core.model.acciones.estados.operaciones;


public class OperacionEstadoBean extends OperacionEstadoKey{


	private static final long serialVersionUID = -2699856681090402561L;
	
	private Integer orden;
	
	private String desoperacion;
	
	private String ejecucion;
	
	private Boolean visible;
	
	private String parametros;
	
	private String icono;
	
	private Short estado;

    private Short subestado;

    private String desestado;
    
    private String dessubestado;

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getDesoperacion() {
		return desoperacion;
	}

	public void setDesoperacion(String desoperacion) {
		this.desoperacion = desoperacion;
	}

	public String getEjecucion() {
		return ejecucion;
	}

	public void setEjecucion(String ejecucion) {
		this.ejecucion = ejecucion;
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
		this.parametros = parametros;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Short getSubestado() {
        return subestado;
    }

    public void setSubestado(Short subestado) {
        this.subestado = subestado;
    }

    public String getDesestado() {
        return desestado;
    }

    public void setDesestado(String desestado) {
        this.desestado = desestado == null ? null : desestado.trim();
    }
    
    public String getDessubestado() {
        return dessubestado;
    }

    public void setDessubestado(String dessubestado) {
        this.dessubestado = dessubestado == null ? null : dessubestado.trim();
    }

}
