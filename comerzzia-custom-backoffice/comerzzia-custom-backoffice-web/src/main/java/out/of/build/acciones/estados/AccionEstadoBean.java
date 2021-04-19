package com.comerzzia.core.model.acciones.estados;

import java.util.List;

import com.comerzzia.core.model.acciones.estados.operaciones.OperacionEstadoBean;

public class AccionEstadoBean extends AccionEstadoKey {

	private static final long serialVersionUID = 2456533993906324729L;

	private Short estado;

    private Short subestado;

    private String desestado;

    private String abreviatura;

    private String icono;

    private String ambitoAplicacion;

    private String dessubestado;
    
    private String titulo;
    
    //INICIO ATRIBUTOS PERSONALIZADOS--------------------------------------------
    
    private boolean operacionEstadosCargados = false;
	private List<OperacionEstadoBean> operacionEstados;
    
    //FIN ATRIBUTOS PERSONALIZADOS-----------------------------------------------

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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura == null ? null : abreviatura.trim();
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono == null ? null : icono.trim();
    }

    public String getAmbitoAplicacion() {
        return ambitoAplicacion;
    }

    public void setAmbitoAplicacion(String ambitoAplicacion) {
        this.ambitoAplicacion = ambitoAplicacion == null ? null : ambitoAplicacion.trim();
    }

    public String getDessubestado() {
        return dessubestado;
    }

    public void setDessubestado(String dessubestado) {
        this.dessubestado = dessubestado == null ? null : dessubestado.trim();
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    
    //INICIO MÉTODOS PERSONALIZADOS--------------------------------------------
	
	public boolean isOperacionEstadosCargados() {
		return operacionEstadosCargados;
	}

	public void setOperacionEstadosCargados(boolean operacionEstadosCargados) {
		this.operacionEstadosCargados = operacionEstadosCargados;
	}

	public List<OperacionEstadoBean> getOperacionEstados() {
		return operacionEstados;
	}

	public void setOperacionEstados(List<OperacionEstadoBean> operacionEstados) {
		this.operacionEstados = operacionEstados;
	}
	
	public int getNumeroOperacionEstados() {
		return operacionEstados.size();
	}

	public OperacionEstadoBean getEstado(int indice) {
		return operacionEstados.get(indice);
	}

	public void addEstado(OperacionEstadoBean operacionEstado) {
		operacionEstados.add(operacionEstado);
	}
    
    //FIN MÉTODOS PERSONALIZADOS-----------------------------------------------

}