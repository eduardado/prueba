package com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones.info;

import org.apache.ibatis.session.SqlSession;

import com.comerzzia.core.model.ventas.tickets.TicketBean;
import com.comerzzia.core.servicios.procesamiento.IProcesadorDocumento;
import com.comerzzia.core.servicios.procesamiento.ProcesadorDocumentoException;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.db.Connection;

/*
 * Esta clase no se usa en el ejercicio porque no estamos creando un nuevo tipo de documento sino
 * modificando la manera en la que se parsea el XML del ticket de venta.
 */


/*
 * 
 * Cuando queremos crear un nuevo tipo de documento, se crea una clase que implemente IProcesadorDocumento
 * Tras esto, se copia el "QualifiedName" de la clase creada en el campo "clase_procesamiento" de la tabla:
 * d_tipos_documentos_tbl.
 */
public class CustomProcesadorTipoDocumento implements IProcesadorDocumento{

	@Override
	public boolean procesaDocumento(Connection conn, DatosSesionBean datosSesion, TicketBean ticket, SqlSession sqlSession) throws ProcesadorDocumentoException {
		
		
		ticket.getCodAlmacen(); // Para obtener el código del almacen
		
		ticket.getTicket();  // para obtener el XML del ticket de venta (campo ticket de d_tickets_tbl;
		
		return false;
		
		/* RETURNS
		 * -------
		 * false: si queremos que se procese más tarde (x ejemplo cuando el ticket de devolución llega antes
		 * 	que el ticket original)
		 * true: si todo bien
		 * Excepción: si algo falla
		 */
	}
	

}
