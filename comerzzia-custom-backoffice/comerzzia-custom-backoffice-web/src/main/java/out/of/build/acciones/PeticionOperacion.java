package com.comerzzia.core.model.acciones;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.comerzzia.core.model.acciones.operaciones.OperacionBean;
import com.comerzzia.core.model.usuarios.UsuarioBean;

@SuppressWarnings("rawtypes")
@XmlRootElement(name="peticionOperacion")
@XmlType(name="peticionOperacion")
public class PeticionOperacion<T> implements Serializable {

	private static final long serialVersionUID = -1936738405037495972L;
	
	protected T registro;
	protected Long idAccionEstados;
	protected String ejecucionOperacion;
	protected Long idOperacion;
	
	protected OperacionBean operacion;
	protected UsuarioBean usuario;
	private String observaciones;
	
	protected PeticionOperacion peticionOperacionOrigen;

	protected ResultadoOperacion resultadoOperacion = new ResultadoOperacion();
	
	protected Map<String, Object> params = new HashMap<String, Object>();
	
	PeticionOperacion() {}
	
	public PeticionOperacion(T registro, OperacionBean operacion) {
		this.registro = registro;
		this.operacion = operacion;
	}
	
	public PeticionOperacion(T registro, Long idAccionEstados, String ejecucionOperacion) {
		this.registro = registro;
		this.idAccionEstados = idAccionEstados;
		this.ejecucionOperacion = ejecucionOperacion;
	}
	
	public PeticionOperacion(T registro, Long idAccionEstados, Long idOperacion) {
		this.registro = registro;
		this.idAccionEstados = idAccionEstados;
		this.idOperacion = idOperacion;
	}
	
	public T getRegistro() {
		return registro;
	}

	public void setRegistro(T registro) {
		this.registro = registro;
	}

	public OperacionBean getOperacion() {
		return operacion;
	}

	public void setOperacion(OperacionBean operacion) {
		this.operacion = operacion;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
 
	public ResultadoOperacion getResultadoOperacion() {
		return resultadoOperacion;
	}

	public void setResultadoOperacion(ResultadoOperacion resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	
	public void setResultadoOperacion(String tipoMensaje, String mensaje) {
		this.resultadoOperacion.setTipoMensaje(tipoMensaje);
		this.resultadoOperacion.setMensaje(mensaje);
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public PeticionOperacion getPeticionOperacionOrigen() {
		return peticionOperacionOrigen;
	}

	public void setPeticionOperacionOrigen(PeticionOperacion peticionOperacionOrigen) {
		this.peticionOperacionOrigen = peticionOperacionOrigen;
	}

	public Long getIdAccionEstados() {
		return idAccionEstados;
	}

	public void setIdAccionEstados(Long idAccionEstados) {
		this.idAccionEstados = idAccionEstados;
	}
	
	public String getEjecucionOperacion() {
		return ejecucionOperacion;
	}

	public void setEjecucionOperacion(String ejecucionOperacion) {
		this.ejecucionOperacion = ejecucionOperacion;
	}
	
	public Long getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(Long idOperacion) {
		this.idOperacion = idOperacion;
	}
	
	public void setParam(String key, Object value) {
		params.put(key, value);
	}
	
	public Object getParam(String key) {
		return params.get(key);
	}
}