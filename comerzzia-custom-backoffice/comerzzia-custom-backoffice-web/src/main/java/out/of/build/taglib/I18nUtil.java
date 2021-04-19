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
package com.comerzzia.taglib;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.i18n.Translation;

public class I18nUtil {

	public static final String COOKIE_IDIOMA_USUARIO = "IDIOMA_USUARIO";
	
	
	public static void seleccionarIdioma(HttpServletRequest request, HttpServletResponse response){
		
		//Obtenemos el idioma seleccionado
		String idiomaSeleccionado = request.getParameter("language");
		if(idiomaSeleccionado == null || idiomaSeleccionado.isEmpty()){
			//No recibimos idioma, el idioma será el que tengamos en el locale
			idiomaSeleccionado = request.getLocale().toString();
		}
		
		/*
		 * Obtenemos la cookie:
		 * 
		 * · Si existe actualizamos la cookie con el idioma seleccionado
		 * · Si no existe creamos la cookie con el valor del idioma seleccionado 
		 *
		 */
		Cookie cookieIdioma = obtenerCookieIdioma(request);
		if(cookieIdioma != null){
			//Actualizamos la cookie
			cookieIdioma.setValue(idiomaSeleccionado);
			response.addCookie(cookieIdioma);
			
		}
		else{
			//Creamos la cookie e insertamos el valor
			Cookie cookie = new Cookie(COOKIE_IDIOMA_USUARIO, idiomaSeleccionado);
			cookie.setMaxAge(10*365*24*60*60); //10 años
			response.addCookie(cookie);
		}
		
		/*
		 * Obtenemos los datos de sesión para actualizar el objeto Translation
		 * con el nuevo idioma seleccionado.
		 */
		//DatosSesionBean datosSesion = (DatosSesionBean)request.getSession().getAttribute(WebKeys.DATOS_SESION);
		DatosSesionBean datosSesion = (DatosSesionBean)request.getSession().getAttribute("datosSesion");
		if(datosSesion != null){
			//Creamos el translation con el nuevo locale
			datosSesion.getConfigEmpresa().setTranslation(new Translation(getLocale(idiomaSeleccionado)));
		}
	}
	
	public static Translation getTranslation(HttpServletRequest request, DatosSesionBean datosSesion){
    	//Obtenemos la cookie del idioma del usuario
    	Cookie idiomaUsuario = I18nUtil.obtenerCookieIdioma(request);
    	
    	//Si tenemos cookie el idioma será el de la cookie
    	if(idiomaUsuario != null){
			//Instanciamos el objeto Translation a partir de la cookie
    		return new Translation(getLocale(idiomaUsuario.getValue()));
    	}
    	else if(datosSesion!=null && datosSesion.getDatosEmpresa().getCodPais() != null){
    		return new Translation(getLocale(datosSesion.getDatosEmpresa().getCodPais()));
    	}
    	else{
    		//Instanciamos el objeto Translation a partir del locale del cliente
    		return new Translation(request.getLocale());
    	}    	
	}

	public static String getIdiomaSeleccionado(HttpServletRequest request, DatosSesionBean datosSesion){
		//Obtenemos la cookie del idioma del usuario
    	Cookie idiomaUsuario = I18nUtil.obtenerCookieIdioma(request);
    	
    	//Si tenemos cookie el idioma será el de la cookie
    	if(idiomaUsuario != null){
			//Instanciamos el objeto Translation a partir de la cookie
    		return idiomaUsuario.getValue();
    	}
//    	else if(datosSesion!=null && datosSesion.getDatosEmpresa().getCodPais() != null){
//    		return datosSesion.getDatosEmpresa().getCodPais();
//    	}
    	else{
    		//Instanciamos el objeto Translation a partir del locale del cliente
    		return request.getLocale().toString();
    	}
	}
	
	public static String obtenerIdiomaSeleccionado(HttpServletRequest request, DatosSesionBean datosSesion){
		//Obtenemos la cookie del idioma del usuario
    	Cookie idiomaUsuario = I18nUtil.obtenerCookieIdioma(request);
    	
    	//Si tenemos cookie el idioma será el de la cookie
    	if(idiomaUsuario != null){
			//Instanciamos el objeto Translation a partir de la cookie
    		return idiomaUsuario.getValue().toUpperCase();
    	}
//    	else if(datosSesion!=null && datosSesion.getDatosEmpresa().getCodPais() != null){
//    		return datosSesion.getDatosEmpresa().getCodPais();
//    	}
    	else{
    		//Instanciamos el objeto Translation a partir del locale del cliente
    		return request.getLocale().getLanguage().toUpperCase();
    	}
	}
	
	private static Cookie obtenerCookieIdioma(HttpServletRequest request){
		//Obtenemos las cookies
		Cookie[] cookies = request.getCookies();
	
		// Comprobamos que las cookies no sean NULL
		if (cookies == null){
			return null;
		}
				
		//Recorremos las cookies
		for (Cookie cookie : cookies) {
		   if (COOKIE_IDIOMA_USUARIO.equals(cookie.getName())){
			   return cookie;
		   }
		}
		
		return null;
	}
	
	public static Locale getLocale(String idiomaUsuario){
		//Separamos el idioma y el país
		String[] idioma = idiomaUsuario.split("_");

		//Creamos el locale dependiendo de si tenemos idioma o idioma y país
		if(idioma.length > 1){
			return new Locale(idioma[0], idioma[1]);
		}
		else{
			return new Locale(idioma[0]);
		}
	}

	/**
	 * Método "noop" de gettext. Usar para que gettext encuentre el mensaje a traducir.
	 * @return la misma cadena s
	 */
	public static String _(String s) {
		return s;
	}

}
