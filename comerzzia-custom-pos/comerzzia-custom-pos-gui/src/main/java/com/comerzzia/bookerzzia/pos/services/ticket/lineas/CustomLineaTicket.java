package com.comerzzia.bookerzzia.pos.services.ticket.lineas;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comerzzia.bookerzzia.pos.services.ticket.lineas.binding.Binding;
import com.comerzzia.pos.services.ticket.lineas.LineaTicket;

/*
 * LineaTicket es prototype, cada vez que CustomLineaTicket se inyecte será una nueva instancia...
 */

@Component
@Primary
@Scope("prototype")
public class CustomLineaTicket extends LineaTicket {

	private static final long serialVersionUID = 3937428355657945819L;

	// TODO borrar isBinding si no lo uso
	private Boolean isBinding; // si se activa es porque el usuario quiere añadir una encuadernación

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
