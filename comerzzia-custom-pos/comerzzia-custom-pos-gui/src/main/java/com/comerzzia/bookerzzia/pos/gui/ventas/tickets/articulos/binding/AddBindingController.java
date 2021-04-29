package com.comerzzia.bookerzzia.pos.gui.ventas.tickets.articulos.binding;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.comerzzia.bookerzzia.pos.utils.PosKeys;
import com.comerzzia.pos.core.gui.InitializeGuiException;
import com.comerzzia.pos.core.gui.controllers.WindowController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * @author eduar
 * Controlador de la ventana modal que puede lanzarse desde la pantalla de ventas 
 * Permite añadir una encuadernación a cada libro.
 */
@Component
public class AddBindingController extends WindowController {

	private static final String ARTESANA = "artesana";
	private static final String TELA = "tela";
	private static final String PIEL = "piel";
	private static final String TAPA_DURA = "tapa dura";

	protected Logger log = Logger.getLogger(getClass());

	@FXML
	private Button btAceptar;

	@FXML
	private Button btCancelar;

	@FXML
	private ComboBox<String> cbTipo;

	@FXML
	private TextField tfSubtitulo;

	@FXML
	private TextArea taDedicatoria;

	@FXML
	void accionCancelar(ActionEvent event) {
		getStage().close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	public void initializeComponents() throws InitializeGuiException {

		ObservableList<String> lista = FXCollections.observableArrayList();
		lista.addAll(TAPA_DURA, PIEL, TELA, ARTESANA);
		cbTipo.setItems(lista);

	}

	@Override
	public void initializeFocus() {

	}

	@Override
	public void initializeForm() throws InitializeGuiException {
		taDedicatoria.clear();
		tfSubtitulo.clear();
		cbTipo.setValue(TAPA_DURA); // opción por defecto (campo obligatorio)
	}

	@FXML
	void accionAceptar(ActionEvent event) {
		HashMap<String, Object> datos = getDatos();

		if (!tfSubtitulo.getText().isEmpty()) {
			datos.put(PosKeys.SUBTITULO, tfSubtitulo.getText());
		}
		if (!taDedicatoria.getText().isEmpty()) {
			datos.put(PosKeys.DEDICATORIA, taDedicatoria.getText());
		}
		
		datos.put(PosKeys.TAPA, cbTipo.getSelectionModel().getSelectedItem());
		
		getStage().close();
	}

}
