package com.comerzzia.core.model.acciones;

import java.util.ArrayList;
import java.util.List;

import com.comerzzia.core.model.acciones.estados.AccionEstadoBean;
import com.comerzzia.core.model.acciones.operaciones.OperacionBean;
import com.comerzzia.core.util.base.MantenimientoBean;

public class AccionBean extends MantenimientoBean {
    
	private static final long serialVersionUID = -327519378757320168L;

	private Long idAccion;

    private String accion;

    private String tipoAccion;

    private String ejecucion;

    private String parametros;

    private String descripcion;

    private String titulo;

    private String icono;
    
    //INICIO ATRIBUTOS PERSONALIZADOS--------------------------------------------
    private String teclaRapida;
    
    private boolean operacionesCargadas = false;
	private List<OperacionBean> operaciones;
	
	private boolean estadosCargados = false;
	private List<AccionEstadoBean> estados;
	
    //FIN ATRIBUTOS PERSONALIZADOS-----------------------------------------------

	public Long getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Long idAccion) {
        this.idAccion = idAccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion == null ? null : accion.trim();
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion == null ? null : tipoAccion.trim();
    }

    public String getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(String ejecucion) {
        this.ejecucion = ejecucion == null ? null : ejecucion.trim();
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros == null ? null : parametros.trim();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? null : descripcion.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo == null ? null : titulo.trim();
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono == null ? null : icono.trim();
    }

    //INICIO MÉTODOS PERSONALIZADOS--------------------------------------------
    
    @Override
	protected void initNuevoBean() {
    	operaciones = new ArrayList<OperacionBean>();
		operacionesCargadas = true;
	}
    
    public String getUrl() {
		String url = "";
		if (tipoAccion != null && (tipoAccion.equals("URL") || tipoAccion.equals("INFORME"))) {
			if (ejecucion != null) {
				url = ejecucion;
				if (parametros != null && parametros.length() > 0) {
					url += "?" + parametros;
				}
			}
		}
		return url;
	}
    
    public boolean isOperacionesCargadas() {
		return operacionesCargadas;
	}

	public void setOperacionesCargadas(boolean operacionesCargadas) {
		this.operacionesCargadas = operacionesCargadas;
	}

	public List<OperacionBean> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<OperacionBean> operaciones) {
		this.operaciones = operaciones;
	}

	public int getNumeroOperaciones() {
		return operaciones.size();
	}

	public OperacionBean getOperacion(int indice) {
		return operaciones.get(indice);
	}

	public void addOperacion(OperacionBean operacion) {
		operaciones.add(operacion);
	}

	public void deleteOperacion(int indice) {

	}
	
	public boolean isEstadosCargados() {
		return estadosCargados;
	}

	public void setEstadosCargados(boolean estadosCargados) {
		this.estadosCargados = estadosCargados;
	}

	public List<AccionEstadoBean> getEstados() {
		return estados;
	}

	public void setEstados(List<AccionEstadoBean> estados) {
		this.estados = estados;
	}
	
	public int getNumeroEstados() {
		return estados.size();
	}

	public AccionEstadoBean getEstado(int indice) {
		return estados.get(indice);
	}

	public void addEstado(AccionEstadoBean estado) {
		estados.add(estado);
	}

	public void deleteEstado(int indice) {

	}
	
	public String getTeclaRapida() {
		return teclaRapida;
	}

	public void setTeclaRapida(String teclaRapida) {
		this.teclaRapida = teclaRapida;
	}
    
    //FIN MÉTODOS PERSONALIZADOS-----------------------------------------------

}