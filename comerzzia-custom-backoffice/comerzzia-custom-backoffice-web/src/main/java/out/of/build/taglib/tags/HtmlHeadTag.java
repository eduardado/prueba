package com.comerzzia.taglib.tags;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.comerzzia.taglib.I18nUtil;


public class HtmlHeadTag extends BodyTagSupport{
	
	/**
     * 
     */
    private static final long serialVersionUID = -981260095071106263L;
	private String title;

	@Override
    public int doStartTag() throws JspException {
		
		try {
			// ############### INITIALIZATION ###############
			if(title == null || title.isEmpty()){
				title = "Comerzzia";
			}
			Locale locale = I18nUtil.getLocale(I18nUtil.getIdiomaSeleccionado((HttpServletRequest) pageContext.getRequest(), null));
			DecimalFormat formateador = (DecimalFormat)NumberFormat.getInstance();
			String url = pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() + ((HttpServletRequest)pageContext.getRequest()).getContextPath();
			
			// ############### META CONTENT ###############
			JspWriter out = pageContext.getOut();
	        out.println("<head>");
	        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
	        out.println("<title>"+title+"</title>");
	        
	        
	        // ############### STYLESHEETS ###############
	        
	        out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/comerzzia.css' ></link>");
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/jquery.mCustomScrollbar.css' ></link>");
			
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/magnific-popup.css' ></link>");
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/responsive.css' ></link>");
			out.println("<link rel='shortcut icon' href='comun/images/iconos/favicon.ico' ></link>");
			
			// - Common use stylesheets
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/calendario.css' />");
			out.println("<link rel='stylesheet' href='comun/css/jquery.tagit.css' type='text/css' media='all'/>");
			out.println("<link rel='stylesheet' href='comun/css/tagit.ui-zendesk.css' type='text/css' media='all'/>");
	        
	        // ############### SCRIPTS ###############
			out.println("<script type='text/javascript' language='javascript' src='comun/js/jquery-1.9.1.min.js'></script>");
			out.println("<script type='text/javascript' src='comun/js/jquery.magnific-popup.min.js'></script>");
			
			// - Scroll libraries
			out.println("<script type='text/javascript' src='comun/js/jquery.mousewheel.js'></script>");
			out.println("<script type='text/javascript' src='comun/js/jquery.mCustomScrollbar.js'></script>");
			
			// - Hotkeys library
			out.println("<script type='text/javascript' language='javascript' src='comun/js/jquery.hotkeys.min.js'></script>");
			
			// - JS internationalization libraries
			out.println("<link rel='gettext' lang='" + locale + "' href='" + url + "/idioma?po=" + locale.getLanguage() + "' ></link>");
			out.println("<script type='text/javascript' src='comun/js/prototype.js'></script>");
			out.println("<script type='text/javascript' src='comun/js/gettext.js'></script>");
			out.println("<script type='text/javascript'>");
			out.println(" jQuery.noConflict();		");
	        out.println(" Gettext.lang = '" + locale + "'; ");
	        out.println(" Gettext.include.apply(Gettext, Gettext.links[Gettext.linksPointer]);");
	        //     -Server's locale's separator's definition
	        out.println(" var comerzzia = new Object();");	       
	        out.println(" comerzzia.decimalSeparator = '"+formateador.getDecimalFormatSymbols().getDecimalSeparator()+"';");
	        out.println(" comerzzia.thousandSeparator = '"+formateador.getDecimalFormatSymbols().getGroupingSeparator()+"';");
			out.println("</script>");
			
			// - tag-it library
			out.println("<script type='text/javascript' language='javascript' src='comun/js/jquery-ui-1.9.2.min.js'></script>");
			out.println("<script type='text/javascript' language='javascript' src='comun/js/tag-it.js'></script>");
			
			// - Common use scripts
			out.println("<script type='text/javascript' language='javascript' src='comun/js/calendario.js'></script>");
			out.println("<script type='text/javascript' language='javascript' src='comun/js/comun.js'></script>");
			out.println("<script type='text/javascript' language='javascript' src='comun/js/validacion.js'></script>");
			out.println("<script type='text/javascript' language='javascript' src='comun/js/formulario.js'></script>");
			out.println("<script type='text/javascript' language='javascript' src='comun/js/ayudas.js'></script>");
        }
		catch (Exception e) {
			throw new JspTagException("doStartTag() - HtmlHeadTag throws an exception: "+e.getMessage());
		}
	    return super.doStartTag();
    }

	@Override
    public int doEndTag() throws JspException {
		try {			
			JspWriter out = pageContext.getOut();
	        out.println("</head>");
        }
		catch (Exception e) {
			throw new JspTagException("doStartTag() - HtmlHeadTag throws an exception: "+e.getMessage());
		}
	    return super.doEndTag();
    }

	@Override
    public int doAfterBody() throws JspException {

		try {
			BodyContent body = getBodyContent();
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
			return super.doAfterBody();
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - HtmlHeadTag throws an exception: "+e.getMessage());
		}
    }
	
    public String getTitle() {
    	return title;
    }
	
    public void setTitle(String title) {
    	this.title = title;
    }
	
	
}
