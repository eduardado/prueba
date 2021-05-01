package com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones;

import org.apache.log4j.Logger;
import org.apache.ibatis.session.SqlSession;

import com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBean;
import com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBeanMapper;
import com.comerzzia.bookerzzia.backoffice.util.EncuadernacionKeys;
import com.comerzzia.core.model.empresas.ConfigEmpresaBean;
import com.comerzzia.core.util.db.Connection;
import com.comerzzia.model.ventas.albaranes.articulos.ArticuloAlbaranVentaBean;
import com.comerzzia.servicios.ventas.albaranes.articulos.ArticuloAlbaranVentaException;
import com.comerzzia.servicios.ventas.albaranes.articulos.ServicioArticulosAlbaranesVentasImpl;

public class CustomServicioArticulosAlbaranesVentasImpl extends ServicioArticulosAlbaranesVentasImpl {

	protected Logger log = Logger.getLogger(getClass());

	
	@Override
	public void crear(ArticuloAlbaranVentaBean articulo, ConfigEmpresaBean configEmpresa, Connection conn) throws ArticuloAlbaranVentaException {
		log.debug("crear()@override");
		/*
		 * Por aquí se pasa una vez por cada línea del Ticket de Venta
		 */
		EncuadernacionBean encuadernacion = crearEncuadernacion(articulo, conn, configEmpresa); // crea encuadernación
		insertarEncuadernacion(encuadernacion, conn); // la guarda en BD
		
		super.crear(articulo, configEmpresa, conn);
	}

	/**
	 * @param encuadernacion
	 * @param datosSesion2
	 */
	private void insertarEncuadernacion(EncuadernacionBean encuadernacion, Connection conn) {
//com.comerzzia.bookerzzia.backoffice.persistence.encuadernaciones.EncuadernacionBeanMapper
		log.debug("insertarEncuadernacion() - insertando la encuadernacion con subtítulo: " + encuadernacion.getSubtitulo() );

		@SuppressWarnings("deprecation")
		SqlSession sqlSession = conn.abrirConexion();
		EncuadernacionBeanMapper mapper = sqlSession.getMapper(EncuadernacionBeanMapper.class);
		mapper.insertSelective(encuadernacion);
		/*
		 * no cierro la conexión por si acaso
		 */
		sqlSession.commit(); // hace falta?
//		sqlSession.close(); // TODO tendrá que ver con el executioner?

	}
	
	private EncuadernacionBean crearEncuadernacion(ArticuloAlbaranVentaBean articuloAlbaranVentaBean, Connection conn, ConfigEmpresaBean configEmpresa) {
		log.debug("crearEncuadernacion() - Creando Encuadernación");
		
		/*
		 * Extraigo los valores de los key-value que había almacenado en el mapa de ArticuloAlbaranVentaBean
		 */
		String tapa = (String) articuloAlbaranVentaBean.getExtension(EncuadernacionKeys.TAPA);
		String subtitulo = (String) articuloAlbaranVentaBean.getExtension(EncuadernacionKeys.SUBTITULO);
		String dedicatoria = (String) articuloAlbaranVentaBean.getExtension(EncuadernacionKeys.DEDICATORIA);
		String codalm = (String) articuloAlbaranVentaBean.getExtension(EncuadernacionKeys.CODIGO_ALMACEN);
		
		
		
// hay algún atributo de los objetos que recibo por parámetro que guarde el código del almacen en este punto?
		
		/*
		 * Creo un objeto nuevo a partir de la información contenida en la extensión del 
		 * ArticuloAlbaranVentaBean
		 */
		EncuadernacionBean encuadernacionBean = new EncuadernacionBean();
		encuadernacionBean.setUidActividad(configEmpresa.getUidActividad()); // PK
		encuadernacionBean.setCodalm(codalm); // PK
		encuadernacionBean.setIdClieAlbaran(articuloAlbaranVentaBean.getIdAlbaran()); // PK
		encuadernacionBean.setLinea(articuloAlbaranVentaBean.getLinea()); // TODO NEW!
		encuadernacionBean.setTapa(tapa);
		encuadernacionBean.setSubtitulo(subtitulo);
		encuadernacionBean.setDedicatoria(dedicatoria);
		
		log.debug("crearEncuadernacion() - Encuadernación creada: " + encuadernacionBean);

		return encuadernacionBean;

	}

}
