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
package com.comerzzia.taglib.tags;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.comerzzia.core.model.lenguajes.LenguajesBean;
import com.comerzzia.core.model.usuarios.UsuarioBean;
import com.comerzzia.core.servicios.lenguajes.ServicioLenguajesImpl;
import com.comerzzia.core.servicios.sesion.DatosSesionBean;
import com.comerzzia.core.util.config.AppInfo;
import com.comerzzia.core.util.i18n.Translation;
import com.comerzzia.core.util.xml.XMLDocumentUtils;
import com.comerzzia.taglib.I18nUtil;
import com.comerzzia.taglib.WebKeys;

public class MainTag extends BodyTagSupport{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 420954178300740517L;
	
	private static final String MENU = "MENU";
	private static final String MENUS = "MENUS";
	
	@SuppressWarnings("unchecked")
	public int doStartTag() throws JspException {
		try {
			
			//Obtenemos los datos de sesión
			DatosSesionBean datosSesion = (DatosSesionBean)pageContext.getSession().getAttribute(WebKeys.DATOS_SESION);
	
			JspWriter out = pageContext.getOut();
			
			String empresa = null;
			if (datosSesion.getDatosEmpresa() != null && datosSesion.getDatosEmpresa().getDesEmp() != null) {
				empresa = datosSesion.getDatosEmpresa().getDesEmp();
			}
			else {
				empresa = "";
			}
		
			boolean menuLateralVisible = menuLateralVisible();
			
			out.println("<script type='text/javascript' language='javascript'>	");
			out.println("	jQuery(document).ready(function(){ 					");
			out.println("      jQuery(window).on(\"load\",function(){           ");
			out.println("        jQuery(\".content\").mCustomScrollbar({scrollInertia: 5000});       ");
			out.println("      });                                              ");
			out.println("	jQuery('#__comerzzia__idiomas_').click(function() {	");
			out.println("		jQuery(this).find('ul').toggle();				");
			out.println("	});													");
			out.println("	jQuery('.push-topMenu').click(function() {			");
			out.println("		jQuery('.n-botonera').toggleClass('show-menu');	");
			out.println("	});													");
			out.println("	jQuery('#toggleMenu').find('a').click( function() {	");
							if(menuLateralVisible) {
			out.println("		__comerzzia__OcultarMenuLateral();				");
							}
							else{
			out.println("		__comerzzia__MostrarMenuLateral();				");
							}
			out.println("	});													");
			
//			out.println("	jQuery('.push-leftMenu').click( function() {		");
//				out.println("	if(jQuery('.n-wrapp1').hasClass('mostrar-menu')) {	");
//				out.println("		__comerzzia__OcultarMenuLateral();				");
//				out.println("	} else {											");
//				out.println("		__comerzzia__MostrarMenuLateral();				");
//				out.println("	}											");
//			out.println("	});													");
			
			out.println("});													");
			
	        // Javascript para mostrar/ocultar menu
	        out.println("	function __comerzzia__OcultarMenuLateral() {												");
	        out.println("		jQuery('.n-wrapp1').removeClass('mostrar-menu')											");
			out.println("		jQuery('.n-wrapp2').addClass('big');													");
			out.println("		jQuery('#toggleMenu').toggleClass('switch');											");
			out.println("		jQuery('#toggleMenu').find('a').html('"+datosSesion.getTranslation()._("Mostrar")+"')	");
			out.println("		jQuery('#toggleMenu').find('a').unbind();												");
			out.println("		jQuery('#toggleMenu').find('a').bind('click', function() {								");
			out.println("			__comerzzia__MostrarMenuLateral();													");
			out.println("		});																						");
			out.println("		jQuery('.push-leftMenu').unbind();														");
			out.println("		jQuery('.push-leftMenu').bind('click', function() {										");
			out.println("			if(!jQuery('.n-wrapp1').hasClass('mostrar-menu')) {									");
			out.println("			__comerzzia__MostrarMenuLateral();													");
			out.println("			}																					");
			out.println("		});																						");
			out.println("		document.cookie = 'comerzzia.menuLateral.visible=0';									");
			out.println("	}");
			
			out.println("	function __comerzzia__MostrarMenuLateral() {												");
			out.println("		jQuery('.n-wrapp1').addClass('mostrar-menu');											");
			out.println("		jQuery('.n-wrapp2').removeClass('big');													");
			out.println("		jQuery('#toggleMenu').toggleClass('switch');											");
			out.println("		jQuery('#toggleMenu').find('a').html('"+datosSesion.getTranslation()._("Ocultar")+"')	");
			out.println("		jQuery('#toggleMenu').find('a').unbind();												");
			out.println("		jQuery('#toggleMenu').find('a').bind('click', function() {								");
			out.println("			__comerzzia__OcultarMenuLateral();													");
			out.println("		});																						");
			out.println("		jQuery('.push-leftMenu').unbind();														");
			out.println("		jQuery('.push-leftMenu').bind('click', function() {										");
			out.println("			if(jQuery('.n-wrapp1').hasClass('mostrar-menu')) {									");
			out.println("			__comerzzia__OcultarMenuLateral();													");
			out.println("			}																					");
			out.println("		});																						");
			out.println("		document.cookie = 'comerzzia.menuLateral.visible=1';									");
			out.println("	}																							");
	        // Fin javascript para mostrar/ocultar menu
			
			// Javascript para abrir la opción de menú sleccionada
			out.println("function __comerzzia__mostrarMenu(idMenu, auto){											");
			out.println("	jQuery('.n-menu li').each(function( i ) {										");
			out.println("		if(this.id.indexOf('__comerzzia__menu_') == 0) {							");
			out.println("			if(this.id == idMenu) {													");
			out.println("				jQuery( this ).toggleClass( 'opened' );								");
			out.println(" 				jQuery(this).find('span').toggleClass( 'opened' );					");
			out.println("				jQuery(this).find('.n-child').toggleClass('show-section');			");
			out.println("				if(!auto){															");
			out.println("					var valueCookie = readCookie('comerzzia.opcionMenu.visible')	");			
			out.println("					valueCookie = valueCookie+'/'+idMenu							");
			out.println("					document.cookie = 'comerzzia.opcionMenu.visible='+valueCookie;	");
			out.println("				}																	");
			out.println("			}																		");
			out.println("		}																			");
			out.println("	});																				");
			out.println("}																					");
	        
	        // javascript para mostrar ventana de consulta de las teclas rápidas
	        out.println("	function __comerzzia__consultaTeclasRapidas() {						");
	        out.println("		abrirVentanaModal('teclasRapidas.screen', '500px', '450px');	");
			out.println("	}																	");
	        // Fin de javascript
	        
	        // javascript para mostrar ventana de acerca de
	        out.println("	function __comerzzia__acercaDe() {							");
	        out.println("		abrirVentanaModal('acercaDe.screen', '290px', '500px', callbackCerrarVentanaModal);	");
			out.println("	}															");
			
			// javascript para cerrar ventana modal a través de un callback
			out.println("	function callbackCerrarVentanaModal(event) {");
			out.println("		magnificPopupIframe.items.close_replaceWith.click();");
			out.println("	}");
	        
			// javascript para cambiar de menú seleccionadno una aplicación
			out.println("	function __comerzzia__cambioMenu(menu){												");
			out.println("		document.cookie = 'comerzzia.opcionMenu.visible=-1';						    ");
			out.println("		document.location.href = 'aplicaciones?accion=cambioMenu&menu='+menu			");
			out.println("	}																					");
			
			// javascript para leer una cookie específica
						out.println("function readCookie(name) {                     										");
						out.println("	  var nameEQ = name + '='; 															");
						out.println("	  var ca = document.cookie.split(';');												");
						out.println("     for(var i=0;i < ca.length;i++) {													");
						out.println("    	var c = ca[i];																	");
						out.println("    	while (c.charAt(0)==' ') c = c.substring(1,c.length);							");
						out.println("    	if (c.indexOf(nameEQ) == 0) {													");
						out.println("		      return decodeURIComponent( c.substring(nameEQ.length,c.length) );			");
						out.println("    	}																				");
						out.println("	  }																					");
						out.println("	  return null;																		");
						out.println("	}																					");
			out.println("	</script>																			");
																						
			
	        // Establecemos una clase css específica para el navegador que lo requiera
	        String claseNavegador = getNombreNavegador();
	        			
			String menu = (String) datosSesion.getAtributos().get(MENU);
			UsuarioBean usuario = datosSesion.getUsuario();
			Map<String, String> menus = (Map<String, String>) datosSesion.getAtributos().get(MENUS);
			
			// ============================================================================================= //
			/*
			 * 	Generación de la cabecera de la aplicación. En esta cabecera aparecerá el logo y la barra con las
			 * acciones estáticas de la aplicación las cuales son: 
			 *   · Nombre de la empresa
			 *   · Mostrar/Ocultar el menú
			 *   · Mi Perfil
			 *   · Teclas Rápidas
			 *   · Documentación
			 *   · Idioma
			 *   · Acerca de
			 *   · Desconectar
			 *   
			 */
			if(AppInfo.getEntorno() != null && !AppInfo.getEntorno().isEmpty()) {	
				out.println("<div class='flag'>");					
				out.println(AppInfo.getEntorno());
				out.println("	</div>");
			}
		
			out.println("<div class='n-cab'>");
			out.println("	<!-- Logo de la aplicación -->");
			out.println("	<div class='n-logo'>");
			out.println("		<img src='"+AppInfo.getUrlLogo()+"' alt='" + datosSesion.getTranslation()._("Comerzzia") + "'>");
			out.println("	</div>");
		
				
			out.println("	<!-- Menú superior de la aplicación -->");
			out.println("	<div class='n-menu-top'>");
			// -- Botones menú móvil --------------------------------------------------------------------------------------------- //
			out.println("   <div class='wrap-movil'>");
			out.println("	<div class='push-leftMenu'>");
			out.println("	</div>");
			out.println("	<div class='push-topMenu'>");
			out.println("	</div>");
			out.println("	</div>");
			// -- Contenedor menu --------------------------------------------------------------------------------------------- //
			out.println("		<div class='n-content-menu-top'>");
			
			// -- Nombre de la empresa --------------------------------------------------------------------------------------------- //
			out.println("			<!-- Nombre de la empresa con enlace a la página principal -->");
			out.println("			<div class='n-link-index'>");
			out.println("				<a href='inicio.screen'>"+empresa+"</a>");
			out.println("			</div>");
			out.println("			<ul class='n-botonera'>");
			
			// -- Mostrar/Ocultar menú lateral ------------------------------------------------------------------------------------- //
			out.println("				<!-- Botón para Mostrar/Ocultar el menú lateral -->");
			out.println("				<li id='toggleMenu' class='n-bot-top n-ocultar'>");
											if(menuLateralVisible) {
			out.println("						<a style=\"cursor: pointer;\">"+datosSesion.getTranslation()._("Ocultar")+"</a>");
											}
											else{
			out.println("						<a style=\"cursor: pointer;\">"+datosSesion.getTranslation()._("Mostrar")+"</a>");
											}
			out.println("				</li>");
			
			// -- Mi Perfil -------------------------------------------------------------------------------------------------------- //
			out.println("				<!-- Botón para acceder al perfil del usuario conectado -->");
			out.println("				<li class='n-bot-top n-miperfil'>");
			out.println("					<a href='"+ AppInfo.getUrlMiPerfil() +"'>"+ datosSesion.getUsuario().getUsuario() +"</a>");
			out.println("				</li>");
			
			// -- Teclas Rápidas --------------------------------------------------------------------------------------------------- //
			out.println("				<!-- Botón para mostrar la ayuda de las teclas rápidas -->");
			out.println("				<li class='n-bot-top n-teclas'>");
			out.println("					<a style=\"cursor: pointer;\" onclick=\"__comerzzia__consultaTeclasRapidas();\">"+ datosSesion.getTranslation()._("Teclas Rápidas") + "</a>");
			out.println("				</li>");
			
			// -- Documentación ---------------------------------------------------------------------------------------------------- //
			out.println("				<!-- Botón para ir a la documentación -->");
			out.println("				<li class='n-bot-top n-documentacion'>");
			out.println("					<a target='_blank' href='" + AppInfo.getDocumentacionInfo().getUrlDocumentacion() + "'>"+datosSesion.getTranslation()._("Documentación")+"</a>");
			out.println("				</li>");
			
			// -- Idioma ----------------------------------------------------------------------------------------------------------- //
			HttpSession sesion = pageContext.getSession();
			if(sesion != null && sesion.getAttribute(WebKeys.LENGUAJES_DISPONIBLES) == null){
				sesion.setAttribute(WebKeys.LENGUAJES_DISPONIBLES, ServicioLenguajesImpl.get().consultarTodos(datosSesion));
			}
			String idiomaSeleccionado = I18nUtil.getIdiomaSeleccionado((HttpServletRequest) pageContext.getRequest(), datosSesion); 
			
			out.println("				<!-- Opción para la selección de idioma -->");
			out.println("				<li id='__comerzzia__idiomas_' class='n-bot-top n-idioma'>");
			out.println("					<a style=\"cursor: pointer;\">"+ datosSesion.getTranslation()._("Idioma") +"</a>");
			out.println("					<ul class='n-child n-link-idioma' style='display:none;'>");
			
			for(LenguajesBean lenguaje : (List<LenguajesBean>) sesion.getAttribute(WebKeys.LENGUAJES_DISPONIBLES)){
				String iSelVisibility ="style='visibility: hidden;'";
				//idiomaSeleccionado = ES (Chrome); idiomaSeleccionado = es_ES (Firefox) 
				if ((idiomaSeleccionado.substring(idiomaSeleccionado.indexOf("_")+1).equalsIgnoreCase(lenguaje.getCodLengua()))) {
					iSelVisibility = "";
				}
				
				out.println("						<li rel='" + lenguaje.getDesLengua() + "'>");
				out.println("							<div class='n-flotaiz'>");
				out.println("								<img src='comun/images/iconos/idioma-actual.gif' "+iSelVisibility+"></img>");
				out.println("							</div>");
				out.println("							<a href='idioma?language="+lenguaje.getCodLengua()+"'>"+ datosSesion.getTranslation()._(lenguaje.getDesLengua()) +"</a>");
				out.println("						</li>");
			}
			out.println("					</ul>");
			out.println("				</li>");
			
			
			// -- Acerca de ---------------------------------------------------------------------------------------------------------- //
			out.println("				<li class='n-bot-top n-acerca'>");
			out.println("					<a style=\"cursor: pointer;\" onclick=\"__comerzzia__acercaDe();\">"+ datosSesion.getTranslation()._("Acerca de") +"</a>");
			out.println("				</li>");
			
			// -- Desconectar -------------------------------------------------------------------------------------------------------- //
			out.println("				<li class='n-bot-top n-desconectar'>");
			out.println("					<a href='login''>" + datosSesion.getTranslation()._("Desconectar") + "</a>");
			out.println("				</li>");
			out.println("			</ul>");
			out.println("	</div>");
			out.println("</div>");
			out.println("</div>");

			
			
			// ============================================================================================= //
			/*
			 *  Generación del menú lateral
			 */
			boolean menuLateralDisplay = true;
			if(!menuLateralVisible) {
				menuLateralDisplay = false;
			}
			
			String classMostrarMenu = "";
	        if(menuLateralVisible) {
	        	classMostrarMenu = "mostrar-menu ";
	        }
			
			out.println("<div class='n-wrapper'>");
			if (usuario.getPuedeCambiarMenu() && menus.size() > 0) {
				out.println("			<ul id='n-arrow-volatil' class='n-arrow-volatil' style='display: none;'>");
				
				for(Entry<String, String> entry : menus.entrySet()) {
					out.println("			<li class='n-volatil' onclick=\"__comerzzia__cambioMenu('"+entry.getKey()+"');\"> ");
					out.println(" 				<div class='n-img-volatil'>");
					out.println("					<img src='comun/images/menu/menu_aplicaciones.gif' width='16px' height='16px' title='"+datosSesion.getTranslation()._("Menú ") + entry.getValue()+"' alt='"+datosSesion.getTranslation()._("Menú ") + entry.getValue()+"'>");
					out.println("				</div>");
					out.println(" 				<span>"+datosSesion.getTranslation()._(entry.getValue())+"</span>");
					out.println("			</li>");
				}
				out.println("			</ul>");
			}
			
			out.println("	<div class='n-wrapp1 mCustomScrollbar " + classMostrarMenu + "' data-mcs-theme=\"dark\">");
			out.println("		<div class='n-wrappmenu'>");
			// -- Título del Menú con posibilidad (dependiendo de los permisos) de cambiar entre los distintos menús --------------------------- //
			out.println("			<div class='n-tit-menu'>");
			out.println("				<div>"+ datosSesion.getTranslation()._("Menú") +" <span>" + datosSesion.getTranslation()._(menus.get(menu)) + "</span></div>");
			
			if (usuario.getPuedeCambiarMenu() && menus.size() > 0) {
				// -- Generación de la imagen y menú de los distintos menús seleccionables --------------------------------------- //
				out.println("			<div class='n-arrow-menu' onclick=\"javascript:_toggleMenu(event, 'n-arrow-volatil'); return false;\">");
				out.println("				<img src='comun/images/iconos/more.gif' >");
				out.println(" 			</div>");
	        }
			out.println("			</div>");

			if (datosSesion != null) {
		        Document document = datosSesion.getArbolMenu().getDocument();
		        NodeList nodos = document.getElementsByTagName("menu");
		        
		        // -- Listado de opciones del Menú ------------------------------------------------------------------------------------------- //
				out.println("			<ul class='n-menu'>");
		        
				String[] opcionesMenuVisible = opcionesMenuVisible();
			    for (int i = 0; i < nodos.getLength(); i++) {
			       pintarMenu(nodos.item(i), i, out, datosSesion.getTranslation());
			    }

			    out.println("<script type='text/javascript'>");
			    
			    /*
			     * Si no existe ninguna opción de menú seleccionada, se selecciona la primera 
			     */
//			    if(opcionMenuVisible.equals("-1")) {
//			    	out.println("__comerzzia__mostrarMenu('__comerzzia__menu_0');");
//			    }
//			    else{
			    for(int i=0; i<opcionesMenuVisible.length; i++){
			    	out.println("__comerzzia__mostrarMenu('"+opcionesMenuVisible[i]+"', true);");
			    }
//			    }
			    
			    out.println("</script>");
			    out.println("			</ul>");
	        }
			out.println("</div>");
	        out.println("</div>");
	        
	        // ============================================================================================= //
	        /*
	         *  Generación del panel para el contenido que consitirá en una cabecera, una parte central y un pie
	         */
	        
	        String displayContenido = "";
	        if(!menuLateralDisplay) {
	        	displayContenido = " big ";
	        }
	        
	        out.println("<div class='n-wrapp2 "+claseNavegador+displayContenido+"'>");
			
			return EVAL_BODY_BUFFERED;
		}
		catch(Exception e) {
			throw new JspTagException("doStartTag() - Excepción en la clase del tag MainTag: "+e.getMessage());
		}
	}
	
	
	private void pintarMenu(Node nodoMenu, int indice, JspWriter out, Translation t) throws Exception {
		Element menu = (Element)nodoMenu;
		String titulo = t._(menu.getAttribute("titulo"));
		String opcionVisible = "";
		
		out.println("<li id='__comerzzia__menu_"+indice+"' class='n-opcion'>");
		out.println("	<span class='n-linkmenu "+opcionVisible+"'>");
		out.println("		<a style=\"cursor: pointer;\" id='link__comerzzia__menu_"+indice+"' onclick=\"__comerzzia__mostrarMenu('__comerzzia__menu_"+indice+"', false);\">"+titulo+"</a>");
		out.println("	</span>");
		
		// Solo tenemos dos niveles de menú, por lo que vamos a recorrer sus hijos directos y no vamos a hacer recursividad
		NodeList menuItems = menu.getChildNodes();
		
		if(menuItems.getLength() > 0) {
			out.println("	<ul class='n-child mCustomScrollBox'>");
			
			for(int j = 0; j<menuItems.getLength(); j++) {
	        	Element menuItem = (Element)menuItems.item(j);
	            String tituloItem = t._(menuItem.getAttribute("titulo"));
	            String tipoAccion = XMLDocumentUtils.getTagValue(menuItem, "tipoAccion", true);
	            String ejecucion = XMLDocumentUtils.getTagValue(menuItem, "ejecucion", true);
	            String parametros = XMLDocumentUtils.getTagValue(menuItem, "parametros", true);
	            String icono = XMLDocumentUtils.getTagValue(menuItem, "icono", true);
	            
	            // Obtenemos la url de la opción de menú
	            String url = "";
	            if (tipoAccion != null && tipoAccion.equals("URL")) {
	            	if (ejecucion != null) {
	            		url = ejecucion;
	            		if (parametros != null && parametros.length() > 0) {
	            			url += "?" + parametros;
	            		}
	            	}
	            }
	            
	            out.println("		<li>");
	            if(icono.equals("")){
            		out.println("<div class='n-ico-menu'><img src='comun/images/menu/menu_item.gif'></div>");
        		}
        		else{
        			out.println("<div class='n-ico-menu'><img src='"+icono+"' onerror=\"this.src='comun/images/menu/menu_item.gif'\"></div>");
        		}
	    		
	    		out.println("	<div class='sub'><a href='"+url+"'>"+tituloItem+"</a></div>");
	    		out.println("	<div class='limpia'></div>");
	    		out.println("		</li>");
	            /*
	    		if(tituloItem.equals("-")){
	        		out.println("<td class='separadorMenu'>");
	        		out.println("</td>");
	    		}
	    		*/
	        }
			out.println("	</ul>");
		}
		out.println("</li>");    
	    
	}
	
	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();
		
		try {
			JspWriter out = body.getEnclosingWriter();
			out.println(body.getString());
			body.clearBody();
			
			return SKIP_BODY;
		}
		catch (Exception e) {
			throw new JspTagException("doAfterBody() - Excepción en la clase del tag MainTag: "+e.getMessage());
		}
	}
	
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
			out.println("<script type='text/javascript'>									");
			out.println("	jQuery(window).resize(function() { "
								+ "if(jQuery(window).width() < 1150) { "
									+ "__comerzzia__OcultarMenuLateral(); "
								+ "} else { "
									+ "__comerzzia__MostrarMenuLateral(); "
								+ "} "
								+ "if(jQuery(window).width() > 1150) { __comerzzia__MostrarMenuLateral(); }"
							+ "});							");
			out.println("	if(jQuery(window).width() < 1150) { __comerzzia__OcultarMenuLateral(); }						");
		    out.println("</script>");
			
			out.println("</div>");
			out.println("</div>");
			
			return EVAL_BODY_BUFFERED;
		}
		catch(Exception e) {
			throw new JspTagException("doEndTag() - Excepción en la clase del tag MainTag: "+e.getMessage());
		}
	}
	
	/**
	 * Indica si el menú debe estar visible u oculto en función del valor de la
	 * cookie comerzzia.menu.visible
	 * Si vale 0 se establecerá oculto
	 * Si vale 1 se establecerá visible
	 */
	private boolean menuLateralVisible() {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
				
		if (getCookieValue(request.getCookies(), "comerzzia.menuLateral.visible", "1").equals("1")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Indica qué punto del menú está desplegado.
	 * cookie comerzzia.opcionMenu.visible
	 */
	private String[] opcionesMenuVisible() {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		String cookieValue = getCookieValue(request.getCookies(), "comerzzia.opcionMenu.visible", "-1");
		
		return cookieValue.split("/");
	}

	private static String getCookieValue(Cookie[] cookies, String cookieName, String defaultValue) {
		for(int i=0; i<cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		
		return defaultValue;
	}
	
	private String getNombreNavegador() {
		String nombreNavegador = null;
		
		try {
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			String navegador = request.getHeader("User-Agent");
			navegador = navegador.toLowerCase();
			if (navegador.contains("chrome")) { 
				nombreNavegador = "chrome";
	        } else if (navegador.contains("safari")) { 
				nombreNavegador = "safari";
	        }
			else {
				nombreNavegador = "";
			}
		}
		catch (Exception e) {
			nombreNavegador = "";
		}
		
		return nombreNavegador;
	}
}
