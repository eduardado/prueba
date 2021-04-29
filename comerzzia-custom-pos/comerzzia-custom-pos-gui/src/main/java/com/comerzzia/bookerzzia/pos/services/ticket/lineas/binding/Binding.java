package com.comerzzia.bookerzzia.pos.services.ticket.lineas.binding;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comerzzia.bookerzzia.pos.utils.PosKeys;
/**
 * Esta clase representa el nodo <Binding></Binding> 
 * (Encuadernación en el modelo dentro de la capa de persistencia del backoffice)
 * @author eduar
 *
 */
@Component
@Scope("prototype")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "binding")
@XmlType(propOrder = { "tapa", "subtitulo", "dedicatoria" })
public class Binding implements Cloneable, Serializable {

	private static final long serialVersionUID = 5431270509278381757L;

	protected static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Binding.class);

	@XmlElement(name = PosKeys.TAPA)
	private String tapa;
	@XmlElement(name = PosKeys.SUBTITULO)
	private String subtitulo;
	@XmlElement(name = PosKeys.DEDICATORIA)
	private String dedicatoria;

	public Binding() {
		tapa = "";
		subtitulo = "";
		dedicatoria = "";
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

	public void setTapa(String tapa) {
		this.tapa = (tapa == null) ? "" : tapa;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = (subtitulo == null) ? "" : subtitulo;
	}

	public void setDedicatoria(String dedicatoria) {
		this.dedicatoria = (dedicatoria == null) ? "" : dedicatoria;
	}
	

	@Override
	public String toString() {
		return "Binding [tapa=" + tapa + ", subtitulo=" + subtitulo + ", dedicatoria=" + dedicatoria + "]";
	}

}
