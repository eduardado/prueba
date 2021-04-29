package com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Element;

import com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBeanMapper;
import com.comerzzia.bookerzzia.backoffice.util.EncuadernacionKeys;
import com.comerzzia.core.model.ventas.tickets.TicketBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.db.Connection;
import com.comerzzia.core.util.xml.XMLDocumentException;
import com.comerzzia.core.util.xml.XMLDocumentUtils;
import com.comerzzia.model.ventas.albaranes.articulos.ArticuloAlbaranVentaBean;
import com.comerzzia.servicios.ventas.tickets.TicketParser;

/*
 * Esta clase lee el XML del ticket de venta y crea el objeto ArticuloAlbaranVentaBean que después usará el standard
 * para guardar la información de la venta en diferentes tablas de la base de datos, entre ellas
 * d_clie_albaranes_cab_tbl(cabecera) y d_clie_albaranes_det_tbl (detalles)
 */
public class CustomTicketParser extends TicketParser {

	protected Logger log = Logger.getLogger(getClass());
	protected String codal;

	@Autowired
	EncuadernacionBeanMapper encuadernacionBeanMapper; // se puede inyectar en todo tipo de clases?

	public CustomTicketParser(Connection conn, DatosSesionBean datosSesion, TicketBean ticket, SqlSession sqlSession) {
		super(conn, datosSesion, ticket, sqlSession);
		codal = ticket.getCodAlmacen(); // obtengo el código de almacen y lo almaceno en un atributo de la clase
	}

	@Override
	protected ArticuloAlbaranVentaBean obtenerDetalleArticulo(Element linea) throws XMLDocumentException {

		/*
		 * DAVID: Es mejor llamar al super porque si cambia el standard esta implementación ya no vale.
		 */

		/*
		 * Recupero el objeto que ha obtenido todos los detalles de la línea standard
		 */
		ArticuloAlbaranVentaBean albaran = super.obtenerDetalleArticulo(linea);

		try {
			Element binding = XMLDocumentUtils.getElement(linea, "binding", true);

			String tapa = XMLDocumentUtils.getTagValueAsString(binding, EncuadernacionKeys.TAPA, true);
			String subtitulo = XMLDocumentUtils.getTagValueAsString(binding, EncuadernacionKeys.SUBTITULO, true);
			String dedicatoria = XMLDocumentUtils.getTagValueAsString(binding, EncuadernacionKeys.DEDICATORIA, true);

			/*
			 * Añade campos extra en el mapa de "extension" 
			 */
			albaran.putExtension(EncuadernacionKeys.TAPA, tapa); 
			albaran.putExtension(EncuadernacionKeys.SUBTITULO, subtitulo); 
			albaran.putExtension(EncuadernacionKeys.DEDICATORIA, dedicatoria); 
			albaran.putExtension(EncuadernacionKeys.CODIGO_ALMACEN, codal); // lo añado a partir de un atributo de la clase
		}
		catch (XMLDocumentException e) {
			log.error("Error al leer el XML del ticket");
			e.printStackTrace();
		}


		return albaran;
	}

}
