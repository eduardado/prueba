package com.comerzzia.taglib.tags;

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class ParamAyudaTag extends AyudaTag{

	private static final long serialVersionUID = -8982324196365306694L;
	
	private String idParam = null;
	private String valorParam = null;
	
	public int doStartTag() throws JspException {
		try {
			//Cogemos el padre para pasarle los parámetros del hijo
			AyudaTag ayuda = (AyudaTag)findAncestorWithClass(this, AyudaTag.class);
			Map<String, String> mapaParams = ayuda.getMapaParams();
			mapaParams.put(idParam, valorParam);
			ayuda.setMapaParams(mapaParams);
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag CodigoAyudaTag: "+e.getMessage());
		}
	}
	
	public int doEndTag() {
		return SKIP_BODY;
	}

	public String getIdParam() {
		return idParam;
	}

	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}

	public String getValorParam() {
		return valorParam;
	}

	public void setValorParam(String valorParam) {
		this.valorParam = valorParam;
	}

}
