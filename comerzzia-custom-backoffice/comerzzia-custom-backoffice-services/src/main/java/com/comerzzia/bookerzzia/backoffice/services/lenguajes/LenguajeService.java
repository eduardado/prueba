package com.comerzzia.bookerzzia.backoffice.services.lenguajes;

import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje;
import com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.ParametrosBuscarLenguajesBean;
import com.comerzzia.core.servicios.sesion.IDatosSesion;
import com.comerzzia.core.util.paginacion.PaginaResultados;

public interface LenguajeService {

	PaginaResultados consultar(ParametrosBuscarLenguajesBean param, IDatosSesion datosSesion) throws LenguajeException;

	Lenguaje consultar(String codLengua, IDatosSesion datosSesion) throws LenguajeNotFoundException, LenguajeException;

	void salvar(Lenguaje lenguaje, IDatosSesion datosSesion)throws LenguajeException;

	void crear(Lenguaje lenguaje, IDatosSesion datosSesion)throws LenguajeException;

	void modificar(Lenguaje lenguaje, IDatosSesion datosSesion)throws LenguajeException;

	//TODO duda : no entiendo por qué modificar usa el objeto lenguaje y eliminar usa código 
	void eliminar(String codlengua, IDatosSesion datosSesion)throws LenguajeException;

}
