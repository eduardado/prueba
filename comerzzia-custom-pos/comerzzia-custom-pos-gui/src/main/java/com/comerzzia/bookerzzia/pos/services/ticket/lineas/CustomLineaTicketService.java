package com.comerzzia.bookerzzia.pos.services.ticket.lineas;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.comerzzia.bookerzzia.pos.gui.ventas.tickets.articulos.CustomFacturacionArticulosController;
import com.comerzzia.bookerzzia.pos.services.ticket.lineas.binding.Binding;
import com.comerzzia.pos.services.articulos.ArticuloNotFoundException;
import com.comerzzia.pos.services.ticket.TicketVenta;
import com.comerzzia.pos.services.ticket.lineas.LineaTicketAbstract;
import com.comerzzia.pos.services.ticket.lineas.LineaTicketException;
import com.comerzzia.pos.services.ticket.lineas.LineasTicketServices;

@Component
@Primary
public class CustomLineaTicketService extends LineasTicketServices {

	protected Logger log = Logger.getLogger(getClass());

	@Autowired
	Binding binding; 

	@Autowired
	CustomFacturacionArticulosController articulosController;

	@SuppressWarnings("rawtypes")
	@Override
	public LineaTicketAbstract createLineaArticulo(TicketVenta arg0, String arg1, String arg2, String arg3, BigDecimal arg4, BigDecimal arg5, LineaTicketAbstract arg6, boolean arg7)
	        throws LineaTicketException, ArticuloNotFoundException {

		LineaTicketAbstract linea = super.createLineaArticulo(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);

		if (linea instanceof CustomLineaTicket) {

			((CustomLineaTicket) linea).setBinding(binding); // añade el binding

		}

		return linea;
	}

}
