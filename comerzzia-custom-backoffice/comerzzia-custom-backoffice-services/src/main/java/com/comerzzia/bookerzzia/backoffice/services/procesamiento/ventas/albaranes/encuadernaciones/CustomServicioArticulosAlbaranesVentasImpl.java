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

	private EncuadernacionBean createBinding(ArticuloAlbaranVentaBean articulo, Connection conn, ConfigEmpresaBean configEmpresa) {
		/*
		 * Extraigo los valores de los key-value que había almacenado en el mapa de ArticuloAlbaranVentaBean
		 */
		String tapa = (String) articulo.getExtension(EncuadernacionKeys.TAPA);
		String subtitulo = (String) articulo.getExtension(EncuadernacionKeys.SUBTITULO);
		String dedicatoria = (String) articulo.getExtension(EncuadernacionKeys.DEDICATORIA);
		String codalm = (String) articulo.getExtension(EncuadernacionKeys.CODIGO_ALMACEN);

		/*
		 * crea una encuadernación usando el modelo Bean sin Mybatis-Spring y setea los valores
		 */
		EncuadernacionBean encuadernacion = new EncuadernacionBean();

		encuadernacion.setUidActividad(configEmpresa.getUidActividad()); // PK
		encuadernacion.setCodalm(codalm); // PK
		encuadernacion.setIdClieAlbaran(articulo.getIdAlbaran()); // PK
		encuadernacion.setTapa(tapa);
		encuadernacion.setSubtitulo(subtitulo);
		encuadernacion.setDedicatoria(dedicatoria);

		return encuadernacion;

	}

	@Override
	public void crear(ArticuloAlbaranVentaBean articulo, ConfigEmpresaBean configEmpresa, Connection conn) throws ArticuloAlbaranVentaException {
		log.debug("crear() - PRUEBAS");
		super.crear(articulo, configEmpresa, conn);
		EncuadernacionBean encuadernacion = createBinding(articulo, conn, configEmpresa); // crea encuadernación
		insertarEncuadernacion(encuadernacion, conn); // la guarda en BD
	}

	/**
	 * @param encuadernacion
	 * @param datosSesion2
	 */
	private void insertarEncuadernacion(EncuadernacionBean encuadernacion, Connection conn) {

		log.debug("insertarEncuadernacion()");

		@SuppressWarnings("deprecation")
		SqlSession sqlSession = conn.abrirConexion();
		EncuadernacionBeanMapper mapper = sqlSession.getMapper(EncuadernacionBeanMapper.class);
		mapper.insert(encuadernacion);
		sqlSession.commit(); // hace falta?
		sqlSession.close();

	}

}
