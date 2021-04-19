package com.comerzzia.web.base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.base.ParametrosBuscarBean;
import com.comerzzia.core.util.fechas.FechaException;
import com.comerzzia.core.util.fechas.Fechas;

public abstract class AccionPermisoBuscar extends AccionPermiso{

	public AccionPermisoBuscar(){
		super();
	}
	
	public AccionPermisoBuscar(String ejecucion) {
		super(ejecucion);
	}

	@Override
	public String getNombre() {
		return "buscar";
	}

	@Override
	public Vista ejecutarAccion(HttpServletRequest request, HttpSession sesion,
			DatosSesionBean datosSesion) {
		
		// Obtenemos parámetros de búsqueda
		ParametrosBuscarBean param = (ParametrosBuscarBean) sesion.getAttribute(getNombreParametrosBuscar());
		
		String operacion = request.getParameter("operacion");
        if (operacion != null) {
            // Consultar
            if (operacion.equals("consultar")) {
                // Establecemos parámetros de busqueda
                setParametrosBuscar(param, request);
            }
            // Ver pagina
            else if (operacion.equals("paginar")) {
                setPaginaBuscar(param, request);
            }
            // Ordenar
            else if (operacion.equals("ordenar")) {
                setOrdenBuscar(param, request);
            }
        }
		return ejecutarAccionBuscar(request, sesion, datosSesion, param);
	}
	
	

	protected void setParametrosBuscar(ParametrosBuscarBean param, HttpServletRequest request) {
		
		for(Field field : param.getClass().getDeclaredFields()){
			procesarParametro(request, field, param);
			
		}
		param.setNumPagina(1);
		
		// Actualizar el número de resultados por página
		try {
			param.setTamañoPagina(Integer.parseInt(request.getParameter("tamanoPagina")));
		} 
		catch(Exception ignore) {
			// Si no se recibe el tamaño de página, se mantiene el que se tenía
		}
	}	
	protected void procesarParametro(HttpServletRequest request, Field field, ParametrosBuscarBean param) {
		String name = field.getName();
		String value =  request.getParameter(name);
		try {
			if(field.getType().equals(Date.class)){
				try {
					BeanUtils.copyProperty(param, name, Fechas.getFecha(value));
				} catch (FechaException ignore) {}
			}else if(field.getType().equals(Boolean.TYPE)){
				BeanUtils.copyProperty(param, name, value != null);
			}else{
				BeanUtils.copyProperty(param, name, value);
			}
			
		} catch (IllegalAccessException | InvocationTargetException ignore) {
		}
	}

	protected void setPaginaBuscar(ParametrosBuscarBean param, HttpServletRequest request) {
        try {
            // Obtenemos la pagina solicitada
            int pagina = Integer.parseInt(request.getParameter("pagina"));
            param.setNumPagina(pagina);
        }
        catch (Exception ignore) {
            // Si no tenemos pagina, se mostrará la que teníamos
        }
    }
	protected abstract void setOrdenBuscar(ParametrosBuscarBean param, HttpServletRequest request);
	protected abstract String getNombreParametrosBuscar();
	public abstract Vista ejecutarAccionBuscar(HttpServletRequest request, HttpSession sesion, DatosSesionBean datosSesion, ParametrosBuscarBean param);

}
