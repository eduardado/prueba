package com.comerzzia.bookerzzia.backoffice.services.comunidades;

import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean;
import com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ParametrosBuscarComunidadBean;
import com.comerzzia.core.servicios.sesion.IDatosSesion;
import com.comerzzia.core.util.paginacion.PaginaResultados;
/**
 * dudas:
 * - consultar y eliminar reciben PK, el resto reciben beans
 */
public interface IComunidadService {

	PaginaResultados consultar(ParametrosBuscarComunidadBean param, IDatosSesion datosSesion) throws ComunidadException;

	ComunidadBean consultar(String codigo, IDatosSesion datosSesion) throws ComunidadNotFoundException, ComunidadException;

	void eliminar(String codigo, IDatosSesion datosSesion) throws ComunidadException;

	void salvar(ComunidadBean comunidad, IDatosSesion datosSesion) throws ComunidadException;

	void crear(ComunidadBean comunidad, IDatosSesion datosSesion) throws ComunidadException;

	void modificar(ComunidadBean comunidad, IDatosSesion datosSesion) throws ComunidadException;


}
