/**
 * ComerZZia 3.0
 *
 * Copyright (c) 2008-2015 Comerzzia, S.L.  All Rights Reserved.
 *
 * THIS WORK IS  SUBJECT  TO  SPAIN  AND  INTERNATIONAL  COPYRIGHT  LAWS  AND
 * TREATIES.   NO  PART  OF  THIS  WORK MAY BE  USED,  PRACTICED,  PERFORMED
 * COPIED, DISTRIBUTED, REVISED, MODIFIED, TRANSLATED,  ABRIDGED, CONDENSED,
 * EXPANDED,  COLLECTED,  COMPILED,  LINKED,  RECAST, TRANSFORMED OR ADAPTED
 * WITHOUT THE PRIOR WRITTEN CONSENT OF COMERZZIA, S.L. ANY USE OR EXPLOITATION
 * OF THIS WORK WITHOUT AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO
 * CRIMINAL AND CIVIL LIABILITY.
 *
 * CONSULT THE END USER LICENSE AGREEMENT FOR INFORMATION ON ADDITIONAL
 * RESTRICTIONS.
 */
/**
 * 
 */
package com.comerzzia.taglib.tags;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.comerzzia.taglib.I18nUtil;


public class HeadTag extends TagSupport {

	private static final long serialVersionUID = 572334150769279568L;
	
	private static HashMap<String, String> idiomasDisponibles;
	
	
	public HeadTag() {
		if(idiomasDisponibles == null){
			idiomasDisponibles = new HashMap<String, String>();
			idiomasDisponibles.put("es", "es");
			idiomasDisponibles.put("en", "en");
		}
	}
	
	public int doStartTag() throws JspException {
		try {

			JspWriter out = pageContext.getOut();
			out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
			
			//URL completa necesaria para cargar el archivo .po necesario
			String url = pageContext.getRequest().getScheme() + "://" + pageContext.getRequest().getServerName() + ":" + pageContext.getRequest().getServerPort() + ((HttpServletRequest)pageContext.getRequest()).getContextPath();
			
			//Obtenemos los datos del locale
			Locale locale = I18nUtil.getLocale(I18nUtil.getIdiomaSeleccionado((HttpServletRequest) pageContext.getRequest(), null));			

			//Comprobamos si tenemos el idioma del locale en el HashMap de idiomas disponibles
			if(idiomasDisponibles.containsKey(locale.toString())){
				
				/*
				 * Link que incluye el archivo .po correspondiente al idioma que se utiliza.
				 * 
				 * Se incluye la url completa porque si se ejecuta Comerzzia en IE no funciona la internacionalización
				 * del javascript.
				 * 
				 * El hashmap de idiomas disponibles contiene el locale recibido
				 * 
				 */
				out.println("<link rel='gettext' lang='" + locale + "' href='" + url + "/idioma?po=" + locale + "' ></link>");
			}
			else{
				
				/*
				 * El hashmap no contiene el locale recibido, obtenemos el idioma del locale y lo utilizamos
				 * para cargar el link.
				 * 
				 * Si no existe el archivo .po para el idioma indicado la traducción no funcionará y por defecto
				 * se mostrará el mensaje en español.
				 */
				out.println("<link rel='gettext' lang='" + locale + "' href='" + url + "/idioma?po=" + locale.getLanguage() + "' ></link>");
			}
			
			//Se incluye en el tag el link del css de comerzzia para que se incluya en las cabeceras de todas las páginas
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/comerzzia.css' ></link>");
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/jquery.mCustomScrollbar.css' ></link>");
			
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/magnific-popup.css' ></link>");
			out.println("<link rel='stylesheet' type='text/css' media='screen,projection,print' href='comun/css/responsive.css' ></link>");
			out.println("<link rel='shortcut icon' href='comun/images/iconos/favicon.ico' ></link>");
			
			out.println("<script type='text/javascript' language='javascript' src='comun/js/jquery-1.9.1.min.js'></script>");
			out.println("<script type='text/javascript' src='comun/js/jquery.magnific-popup.min.js'></script>");	
			//Importación de lalibrería para scroll
			out.println("<script type='text/javascript' src='comun/js/jquery.mousewheel.js'></script>");
			out.println("<script type='text/javascript' src='comun/js/jquery.mCustomScrollbar.js'></script>");
			//Importamos los scripts para el uso de las teclas rapidas
			out.println("<script type='text/javascript' language='javascript' src='comun/js/jquery.hotkeys.min.js'></script>");
			
			//Importación de las librerías necesarias para la internacionalización de los mensajes javascript
			out.println("<script type='text/javascript' src='comun/js/prototype.js'></script>");
			out.println("<script type='text/javascript' src='comun/js/gettext.js'></script>");
			
			//Definición del lenguage para la clase Gettext
			out.println("<script type='text/javascript'>");
			out.println(" jQuery.noConflict();		");
	        out.println(" Gettext.lang = '" + locale + "'; ");
	        out.println(" Gettext.include.apply(Gettext, Gettext.links[Gettext.linksPointer]);");
	        
	        //Definición del objeto que incluye los separadores de la localización del servidor
	        DecimalFormat formateador = (DecimalFormat)NumberFormat.getInstance();
	        out.println(" var comerzzia = new Object();");	       
	        out.println(" comerzzia.decimalSeparator = '"+formateador.getDecimalFormatSymbols().getDecimalSeparator()+"';");
	        out.println(" comerzzia.thousandSeparator = '"+formateador.getDecimalFormatSymbols().getGroupingSeparator()+"';");
			out.println("</script>");
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag HeadTag: "+e.getMessage());
		}
	}

	
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}
}
