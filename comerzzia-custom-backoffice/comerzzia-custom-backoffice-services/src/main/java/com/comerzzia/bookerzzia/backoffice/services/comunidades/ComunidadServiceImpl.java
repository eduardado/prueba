package com.comerzzia.bookerzzia.backoffice.services.comunidades;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean;
import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBeanExample;
import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBeanExample.Criteria;
import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBeanKey;
import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBeanMapper;
import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ParametrosBuscarComunidadBean;
import com.comerzzia.core.servicios.sesion.IDatosSesion;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.core.util.paginacion.PaginaResultados;

@Service
public class ComunidadServiceImpl implements IComunidadService {

	protected static Logger log = Logger.getLogger(ComunidadServiceImpl.class);

	@Autowired
	ComunidadBeanMapper mapper;

	@Override
	public PaginaResultados consultar(ParametrosBuscarComunidadBean param, IDatosSesion datosSesion) throws ComunidadException {
		/*
		 * Cuando se hace una consulta la clase ParametrosBuscarComunidadAutonomaBean es la que consulta al jsp por los
		 * input del usuario. Este objeto almacenará: Desde la superclase: - orden - tamaño de la página - numero de
		 * páginas En la propia clase: - los atributos propios del modelo salvo UidActividad o UidInstancia En esta
		 * clase, aparte de hacer una consulta, se prepara una instancia de PaginaResultados a partir de
		 * ParametrosBuscarComunidadAutonomaBean. La cual será usada por el jsp para mostrar los resultados al usuario
		 */
		log.debug("consultar() - consultando comunidades autónomas por parámetros ");

		ComunidadBeanExample example = new ComunidadBeanExample();

		Criteria criteria = example.or().andUidActividadEqualTo(datosSesion.getUidActividad()); // WHERE

		// CODIGO
		if (StringUtils.isNotBlank(param.getCodigo())) {
			criteria.andCodigoLikeInsensitive("%" + param.getCodigo() + "%"); // AND
		}

		// DESCRIPCIÓN
		if (StringUtils.isNotBlank(param.getDescripcion())) {
			criteria.andCodigoLikeInsensitive("%" + param.getDescripcion() + "%"); // AND
		}

		// IDIOMA
		if (StringUtils.isNotBlank(param.getIdioma())) {
			criteria.andCodigoLikeInsensitive("%" + param.getIdioma() + "%"); // AND
		}

		// seteamos el orden de la consulta por el Bean
		example.setOrderByClause(param.getOrden()); // ORDER BY

		/*
		 * ParametrosBuscarComunidadAutonomaBean extends ParametrosBuscarBean
		 */

		if (param.getNumPagina() == 0) { // siempre habrá 1 página cuando se consulte
			param.setNumPagina(1);
		}

		// un array vacío del tamaño de de ParametrosBuscarComunidadAutonomaBean.tamañoPagina
		List<ComunidadBean> resultados = new ArrayList<ComunidadBean>(param.getTamañoPagina());

		/*
		 * PaginaResultados
		 */

		PaginaResultados paginaResultados = new PaginaResultados(param, resultados);

		/*
		 * CONSULTA: selectByExample porque usamos más de un parámetro de búsqueda
		 */
		List<ComunidadBean> comunidades = mapper.selectByExample(example);

		/*
		 * PaginaResultados
		 */

		Integer fromIndex = paginaResultados.getInicio() - 1;
		Integer toIndex = paginaResultados.getInicio() + paginaResultados.getTamañoPagina() - 1; // ??

		// corrección del tope
		if (toIndex > comunidades.size()) {
			toIndex = comunidades.size();
		}

		// se añaden las comunidades al ArrayList que lleva el PaginaResultados
		resultados.addAll(comunidades.subList(fromIndex, toIndex));

		// informamos al objeto de cuáles son en total, aunque no los tenga todos, necesita saber el total
		paginaResultados.setTotalResultados(comunidades.size());

		return paginaResultados;
	}

	@Override
	public ComunidadBean consultar(String codigo, IDatosSesion datosSesion) throws ComunidadNotFoundException, ComunidadException {

		try {
			log.debug("consultar() - consultando comunidades por su código " + codigo);

			ComunidadBeanKey key = new ComunidadBeanKey();
			log.debug("uidactividad" + datosSesion.getUidActividad());
			key.setUidActividad(datosSesion.getUidActividad());
			key.setCodigo(codigo);

			// sólo hemos necesitado setear el código y la uidactividad que son las claves primarias
			ComunidadBean comunidad = mapper.selectByPrimaryKey(key);
			log.debug("comunidad consultada " + comunidad); 

			// si no se encuentra ningún registro, se lanza un error
			if (comunidad == null) {
				String msg = "No se ha encontrado la comunidad autónoma";
				log.info("consultar() - " + msg);
				throw new ComunidadNotFoundException(msg); // duda, cuando lanzo una excepción, se sale del método?
			}

			return comunidad;
		}
		catch (ComunidadNotFoundException e) {
			throw e;
		}
		catch(Exception e) {
			
			String msg = "Ha ocurrido un error consultando la comunidad"; // mensaje personalizado
			log.error(msg + ": " + e.getMessage()); // capturamos el mensaje de error de la excepción que sea

			throw new ComunidadException(msg, e); 
			
		}
	}

	@Override
	public void salvar(ComunidadBean comunidad, IDatosSesion datosSesion) throws ComunidadException {

		// dependiendo del estado del bean comunidad, así se hará una modificación o una creación
		log.debug("salvar()");

		switch (comunidad.getEstadoBean()) {
			case Estado.NUEVO:
				crear(comunidad, datosSesion);
				break;
			case Estado.MODIFICADO:
				modificar(comunidad, datosSesion);
				break;

		}

	}

	@Override
	public void crear(ComunidadBean comunidad, IDatosSesion datosSesion) throws ComunidadException {

		log.debug("crear() - creando nueva comunidad");

		try {
			comunidad.setUidActividad(datosSesion.getUidActividad());
			mapper.insertSelective(comunidad);
		}
		catch (Exception e) {
			String msg = "no se ha podido crear la comunidad";
			log.error(msg);
			throw new ComunidadException(msg, e);
		}

	}

	@Override
	public void modificar(ComunidadBean comunidad, IDatosSesion datosSesion) throws ComunidadException {

		log.debug("modificar() - modificando comunidad: " + comunidad.getCodigo());

		try {
			comunidad.setUidActividad(datosSesion.getUidActividad());
			mapper.updateByPrimaryKey(comunidad); // se le puedes hacer un update by primary key y pasarle el
			                                      // objectdomain
		}
		catch (Exception e) {
			String msg = "No se ha podido modificar la comunidad";
			log.error(msg); // está bien esto? creo que no tiene sentido

			throw new ComunidadException(msg, e);
		}

	}

	@Override
	public void eliminar(String codigo, IDatosSesion datosSesion) throws ComunidadException {
		log.debug("eliminar() - eliminando comunidad:" + codigo);

		try {
			ComunidadBeanKey key = new ComunidadBeanKey();
			key.setUidActividad(datosSesion.getUidActividad());
			key.setCodigo(codigo);
			mapper.deleteByPrimaryKey(key);
		}
		catch (Exception e) {
			String msg = "eliminar() - no se ha podido eliminar la comunidad";
			log.error(msg + ":" + e.getMessage());
			throw new ComunidadException(msg, e);
		}

	}

}
