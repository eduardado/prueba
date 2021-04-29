package com.comerzzia.bookerzzia.pos.services.ticket.lineas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comerzzia.bookerzzia.pos.services.ticket.lineas.binding.Binding;
import com.comerzzia.pos.services.ticket.lineas.LineaTicket;

/*
 * Esta clase substituye a LineaTicket del standard. Añade el nodo <Binding> a cada línea del ticket de Venta
 */

@Component
@Primary
@Scope("prototype")
public class CustomLineaTicket extends LineaTicket {

	private static final long serialVersionUID = 3937428355657945819L;

	@XmlTransient // TODO borrar isBinding si no lo uso ( de momento no se usa)
	private Boolean isBinding; // true si el usuario quiere añadir una encuadernación

	public CustomLineaTicket() {
		isBinding = false;
	}

	@XmlElement(name = "binding")
	private Binding binding;

	public Boolean isBinding() {
		return isBinding;
	}

	public void isBinding(Boolean isBinding) {
		this.isBinding = isBinding;
	}

	public void setBinding(Binding binding) {
		this.binding = binding;
	}

}
