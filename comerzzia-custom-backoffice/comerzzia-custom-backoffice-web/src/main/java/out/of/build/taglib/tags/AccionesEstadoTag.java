package com.comerzzia.taglib.tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.comerzzia.core.model.acciones.estados.operaciones.OperacionEstadoBean;
import com.comerzzia.core.servicios.acciones.estados.operaciones.ServicioOperacionesEstadoImpl;

public class AccionesEstadoTag extends BodyTagSupport {

	private static final long serialVersionUID = -5208715583622369647L;
	
	private Long idAccionEstados;
	private Long idEstado;
	
	public int doStartTag() throws JspException {
		try {
			List<OperacionEstadoBean> operacionesEstado = ServicioOperacionesEstadoImpl.get().getOperacionesPosibles(idAccionEstados, idEstado);
			
			for(OperacionEstadoBean operacionEstado: operacionesEstado) {
				if(!"EJECUCION".equals(operacionEstado.getEjecucion()) && operacionEstado.getVisible()) {
					AccionTag tag = new AccionTag();
					tag.setIcono(operacionEstado.getIcono());
					tag.setTitulo(operacionEstado.getDesoperacion());
					tag.setDescripcion(operacionEstado.getDesoperacion());
					if(operacionEstado.getParametros() != null && !operacionEstado.getParametros().isEmpty()) {
						tag.setOnclick("ejecutarOperacionEstado('"+ idAccionEstados +"', '" + operacionEstado.getEjecucion() +"', '" + operacionEstado.getParametros() +"');");
					}
					else {
						tag.setOnclick("ejecutarOperacionEstado('"+ idAccionEstados +"', '" + operacionEstado.getEjecucion() +"');");
					}
					
					tag.setPageContext(pageContext);
					tag.doStartTag();
				}
			}
		} catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag AccionesTag: "+e.getMessage());
		}	
    	return EVAL_BODY_BUFFERED;
	}

	public Long getIdAccionEstados() {
		return idAccionEstados;
	}

	public void setIdAccionEstados(Long idAccionEstados) {
		this.idAccionEstados = idAccionEstados;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
}
