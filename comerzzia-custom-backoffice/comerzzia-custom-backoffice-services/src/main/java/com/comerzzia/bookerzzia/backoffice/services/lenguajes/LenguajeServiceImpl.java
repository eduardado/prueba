package com.comerzzia.bookerzzia.backoffice.services.lenguajes;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje;
import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.LenguajeExample;
import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.LenguajeExample.Criteria;
import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.LenguajeKey;
import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.LenguajeMapper;
import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.ParametrosBuscarLenguajesBean;
import com.comerzzia.core.servicios.sesion.IDatosSesion;
import com.comerzzia.core.util.base.Estado;
import com.comerzzia.core.util.paginacion.PaginaResultados;

import jxl.common.Logger;

@Service
public class LenguajeServiceImpl implements LenguajeService {

	protected static Logger log = Logger.getLogger(LenguajeServiceImpl.class);

	@Autowired
	LenguajeMapper lenguajeMapper;

	@Override
	public PaginaResultados consultar(ParametrosBuscarLenguajesBean param, IDatosSesion datosSesion) throws LenguajeException {
		log.debug("consultar() - Consultando lenguajes");

		LenguajeExample example = new LenguajeExample();

		Criteria criteria = example.or().andUidInstanciaEqualTo(datosSesion.getUidInstancia());

		// CODLENGUA
		if (StringUtils.isNotBlank(param.getCodlengua())) {
			criteria.andCodlenguaLikeInsensitive("%" + param.getCodlengua() + "%");
		}

		// DESLENGUA
		if (StringUtils.isNotBlank(param.getDeslengua())) {
			criteria.andDeslenguaLikeInsensitive("%" + param.getDeslengua() + "%");
		}

		example.setOrderByClause(param.getOrden());
		if (param.getNumPagina() == 0) {
			param.setNumPagina(1);
		}

		List<Lenguaje> resultados = new ArrayList<Lenguaje>(param.getTamañoPagina());
		PaginaResultados paginaResultados = new PaginaResultados(param, resultados); // TODO porqué no instanciamos un
		                                                                             // ParametrosBuscarLenguajesBean?

		// todos los lenguajes
		List<Lenguaje> lenguajes = lenguajeMapper.selectByExample(example);

		// no sé cómo funciona esto pero creo que setea los índices en función del nº de lenguajes que hay
		Integer fromIndex = paginaResultados.getInicio() - 1;
		Integer toIndex = paginaResultados.getInicio() + paginaResultados.getTamañoPagina() - 1;
		if (toIndex > lenguajes.size()) {
			toIndex = lenguajes.size();
		}

		// añade, a los resultados una sublista, dependiendo de cómo se hayan seteado los índices.
		resultados.addAll(lenguajes.subList(fromIndex, toIndex));

		// el componente JSP utiliza esta clase para mostrar los resultados
		paginaResultados.setTotalResultados(lenguajes.size());
		return paginaResultados;
	}

	// consulta por clave primaria
	@Override
	public Lenguaje consultar(String codlengua, IDatosSesion datosSession) throws LenguajeNotFoundException, LenguajeException {

		log.debug("consultar() - consultando lenguaje con código: " + codlengua);

		try {
			// se crea el objeto que representa la clave primaria
			LenguajeKey key = new LenguajeKey();
			key.setUidInstancia(datosSession.getUidInstancia());
			key.setCodlengua(codlengua);

			// se hace la consulta usando el mapper y se le pasa el objeto-clave primaria
			Lenguaje lenguaje = lenguajeMapper.selectByPrimaryKey(key);

			// control de errores
			if (lenguaje == null) {
				String msg = "No se ha encontrado el lenguaje: " + codlengua;
				log.info("consultar() - " + msg);
				throw new LenguajeNotFoundException(msg); // TODO si no encuentra el lenguaje el método se sale por
				                                          // aquí?
			}

			return lenguaje;
		}
		catch (LenguajeNotFoundException e) {
			throw e;
		}
		catch (Exception e) {
			// captura cualquier otra excepción que pueda ocurrir
			String msg = "Ha ocurrido un error consultando el lenguaje"; // mensaje personalizado
			log.error(msg + ": " + e.getMessage()); // capturamos el mensaje de error de la excepción que sea

			throw new LenguajeException(msg, e); // lanzamos nuestra excepción con el msg y el mensaje de la causa del
			                                     // error

		}

	}

	@Override
	public void salvar(Lenguaje lenguaje, IDatosSesion datosSession) throws LenguajeException {

		switch (lenguaje.getEstadoBean()) { // TODO me encanta esta implementación
			case Estado.NUEVO:
				crear(lenguaje, datosSession);
				break;
				
			case Estado.MODIFICADO:
				modificar(lenguaje, datosSession);
				break;

		}
	}

	@Override
	public void crear(Lenguaje lenguaje, IDatosSesion datosSesion) throws LenguajeException {
		log.debug("crear() - creando nuevo lenguaje");
		
		try {
			log.debug("crear() - creando nuevo lenguaje");
			lenguaje.setUidInstancia(datosSesion.getUidInstancia());
//			lenguajeMapper.insert(lenguaje);
			lenguajeMapper.insertSelective(lenguaje);
			
			
		}
		catch (Exception e) {
			String msg = "crear() - no se ha podido crear lenguaje";
			log.error(msg + ": " + e.getMessage());
			throw new LenguajeException(msg, e);
		}

	}

	@Override
	public void modificar(Lenguaje lenguaje, IDatosSesion datosSesion) throws LenguajeException {

		log.debug("modificar() - modificando el lenguaje: " + lenguaje.getCodlengua());

		try {
			lenguaje.setUidInstancia(datosSesion.getUidInstancia());
			lenguajeMapper.updateByPrimaryKey(lenguaje); // TODO cómo sabe aquí que el objeto lenguaje un LenguajeKey
			                                             // ??? de hecho no lo es no?
			// Lenguaje es una subclase de LenguajeKey. Por lo que podremos usar updateByPrimaryKey
		}
		catch (Exception e) {
			String msg = "No se ha podido modificar lenguaje";
			log.error(msg + ":" + e.getMessage()); // en el log mostramos tanto nuestro mensaje personalizado como el
			
			throw new LenguajeException(msg, e);
		}

	}

	@Override
	public void eliminar(String codLenguaje, IDatosSesion datosSesion) throws LenguajeException {
		log.debug("eliminar() - eliminando lenguaje: " + codLenguaje);

		try {
			LenguajeKey key = new LenguajeKey();
			key.setUidInstancia(datosSesion.getUidInstancia());
			key.setCodlengua(codLenguaje);
			lenguajeMapper.deleteByPrimaryKey(key); // by primary key??
		}
		catch (Exception e) {
			String msg = "eliminar() - No se ha podido eliminar lenguaje";
			log.error(msg + ":" + e.getMessage());
			throw new LenguajeException(msg, e); // mostrará tanto el mensaje como la causa del error
		}

	}

}
