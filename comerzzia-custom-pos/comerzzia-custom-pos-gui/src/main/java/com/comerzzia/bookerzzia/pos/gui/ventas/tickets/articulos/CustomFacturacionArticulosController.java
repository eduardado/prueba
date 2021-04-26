package com.comerzzia.bookerzzia.pos.gui.ventas.tickets.articulos;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.comerzzia.bookerzzia.pos.gui.ventas.tickets.articulos.binding.AddBindingView;
import com.comerzzia.bookerzzia.pos.services.ticket.lineas.CustomLineaTicket;
import com.comerzzia.bookerzzia.pos.services.ticket.lineas.CustomLineaTicketService;
import com.comerzzia.bookerzzia.pos.services.ticket.lineas.binding.Binding;
import com.comerzzia.bookerzzia.pos.utils.PosKeys;
import com.comerzzia.pos.gui.ventas.tickets.articulos.FacturacionArticulosController;
import com.comerzzia.pos.services.ticket.lineas.ILineaTicket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
@Primary
public class CustomFacturacionArticulosController extends FacturacionArticulosController {

	protected org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());

	@Autowired
	CustomLineaTicketService lineaService;

	@FXML
	private Button btAddBinding;

	@FXML
	void addBinding(ActionEvent event) {
		log.info("addBinding()");

		// crea un HashMap
		HashMap<String, Object> bindingMap = new HashMap<String, Object>();
		// lanza ventana modal
		getApplication().getMainView().showModalCentered(AddBindingView.class, bindingMap, getStage());

		log.info("addBinding() - Creando encuadernación");

		Binding binding = new Binding();
		binding.setTapa((String) bindingMap.get(PosKeys.TAPA));
		binding.setSubtitulo((String) bindingMap.get(PosKeys.SUBTITULO));
		binding.setDedicatoria((String) bindingMap.get(PosKeys.DEDICATORIA));

		log.info("addBinding() - encuadernación creada " + binding);

		// recupera la línea seleccionada en la pantalla de ventas
		Integer lineaSeleccionada = getLineaSeleccionada().getIdLinea();
		ILineaTicket linea = ticketManager.getTicket().getLinea(lineaSeleccionada);

		// asegura que la línea sea una instancia de nuestra línea personalizada
		if (linea instanceof CustomLineaTicket) {
			((CustomLineaTicket) linea).setBinding(binding); // añade la encuadernación ("binding")
		}

		log.info("addBinding() - linea seleccionada: " + lineaSeleccionada);

	}

}
