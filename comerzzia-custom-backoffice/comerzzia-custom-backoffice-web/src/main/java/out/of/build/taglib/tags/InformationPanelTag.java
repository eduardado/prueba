package com.comerzzia.taglib.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.WebKeys;

public class InformationPanelTag extends BodyTagSupport{

	private static final long serialVersionUID = -3147329478969750835L;
	
	private String title = null;
	private String info = null;
	private String value = null;
	
	public int doStartTag() throws JspException {
		try {
			return EVAL_BODY_BUFFERED;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag CampoI18NTag: "+e.getMessage());
		}
	}
	
	public int doAfterBody() throws JspException {
		try {
			BodyContent body = getBodyContent();
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag CampoI18NTag: "+e.getMessage());
		}
	}

	public int doEndTag()throws JspTagException{
		try{
			Translation t = null;
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
			if(datosSesion == null){
				t = I18nUtil.getTranslation((HttpServletRequest) pageContext.getRequest(), datosSesion);
			}
			else{
				t = datosSesion.getTranslation();
			}
			JspWriter out = pageContext.getOut();
			out.println("<div style=\"text-align: center;\">");
			out.println("<div>");										
			out.println(t._(getTitle()));
			if(StringUtils.isNotBlank(getInfo())) {
				out.println("<img src=\"comun/images/iconos/info.gif\" align=\"absMiddle\" border=\"0\" valign=\"middle\" style=\"vertical-align:top;\" alt=\""+t._(getInfo())+"\" title=\""+t._(getInfo())+"\"/>"); 
			}			
			out.println("</div>");
			out.println("<div style=\"font-size: x-large;\">");
			out.println(StringUtils.isNotBlank(getValue()) ? getValue() : "-");
			out.println("</div>");
			out.println("</div>");

		}
		catch (Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag CampoI18NTag: "+e.getMessage());
		}
			return SKIP_BODY;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
