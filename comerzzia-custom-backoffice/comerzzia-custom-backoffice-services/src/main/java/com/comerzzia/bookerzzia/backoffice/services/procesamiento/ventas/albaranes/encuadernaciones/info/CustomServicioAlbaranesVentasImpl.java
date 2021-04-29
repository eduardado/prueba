package com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones.info;


import org.apache.log4j.Logger;
import com.comerzzia.core.model.empresas.ConfigEmpresaBean;
import com.comerzzia.core.util.db.Connection;
import com.comerzzia.servicios.ventas.albaranes.AlbaranVenta;
import com.comerzzia.servicios.ventas.albaranes.AlbaranVentaConstraintViolationException;
import com.comerzzia.servicios.ventas.albaranes.AlbaranVentaException;
import com.comerzzia.servicios.ventas.albaranes.ServicioAlbaranesVentasImpl;
/** TODO QUE PENA! :(
 * Al final resulta que esto no hace falta porque se puede obtener el id del Albaran en cualquier
 * clase que extienda de CustomProcesadorAlbaranVenta.. pero no la quiero borrar por si acaso
 */


/**
 * Esta clase será "inyectada" oldschool style
 * @author eduar
 * 
 * ¿No habría que modificar ArticulosAlbaranesVentasDao? Ahí es donde están los nombres de las tablas donde se hacen los insert... 
 *
 */
public class CustomServicioAlbaranesVentasImpl extends ServicioAlbaranesVentasImpl{
	
	
	protected Logger log = Logger.getLogger(getClass());

	@Override
	public void crear(AlbaranVenta albaran, ConfigEmpresaBean configEmpresa, Connection conn) throws AlbaranVentaConstraintViolationException, AlbaranVentaException {
		super.crear(albaran, configEmpresa, conn);
		
		/*
		 * Obtenemos una referencia idAlbaran 
		 */
//		Long idAlbaran = albaran.getIdAlbaran();
		
		
	}
	
	
	
	
	

}
