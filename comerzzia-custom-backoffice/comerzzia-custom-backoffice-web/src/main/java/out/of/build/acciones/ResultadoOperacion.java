package com.comerzzia.core.model.acciones;

import java.io.Serializable;

public class ResultadoOperacion implements Serializable {

	private static final long serialVersionUID = 688491557930949350L;
	
	public static final String TIPO_ALERTA = "ALERTA";
	public static final String TIPO_ADVERTENCIA = "ADVERTENCIA";
	public static final String TIPO_INFORMACION = "INFORMACION";

	protected String tipoMensaje;
	protected String mensaje;

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public boolean isMensajeAlerta() {
		return mensaje != null && TIPO_ALERTA.equals(mensaje);
	}
	
	public boolean isMensajeAdvertencia() {
		return mensaje != null && TIPO_ADVERTENCIA.equals(mensaje);
	}

	public boolean isMensajeInformacion() {
		return mensaje != null && TIPO_INFORMACION.equals(mensaje);
	}
}
