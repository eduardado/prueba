package com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.comerzzia.core.model.ventas.tickets.TicketBean;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.db.Connection;
import com.comerzzia.servicios.procesamiento.ventas.albaranes.ProcesadorAlbaranVenta;
import com.comerzzia.servicios.ventas.tickets.TicketParser;

public class CustomProcesadorAlabaranVenta extends ProcesadorAlbaranVenta{
	
	protected Logger log = Logger.getLogger(getClass());
	
	
	/*
	 * Si quisieramos hacer un parseo diferente del XML del ticket de venta,
	 * necesitamos sobreescribir la clase TicketParser, pero primero, tenemos que sobreescribir
	 * el método crearTicketParser para que, en lugar de crear un TicketParser, devuelva nuestro
	 * CustomTicketParser (ver CustomTicketParser)
	 * 
	 */
	@Override
	protected TicketParser crearTicketParser(Connection conn, DatosSesionBean datosSesion, TicketBean ticket, SqlSession sqlSession) {
		log.debug("TicketParser() - Creando un TicketParser Adaptado");
		/*
		 * En el standard crea un TicketParser.
		 * Sobreescribimos para que cree uno personalizado
		 * TODO ¿No se podría haber inyectado un TicketParser con Spring??
		 */
		return new CustomTicketParser(conn, datosSesion, ticket, sqlSession);  
	}
	

}
