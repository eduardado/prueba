<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cmz" uri="http://comerzzia.com/taglib" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="comunidad" class="com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ComunidadBean" scope="request" />
<jsp:useBean id="paramBuscarComunidades" type="com.comerzzia.bookerzzia.backoffice.persistence.comunidades.ParametrosBuscarComunidadBean" scope="session" />
<jsp:useBean id="paginaResultados" class="com.comerzzia.core.util.paginacion.PaginaResultados" scope="request" />
<jsp:useBean id="permisos" class="com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean" scope="request" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Comerzzia</title>
    
    <cmz:head/>
    <script type="text/javascript" language="javascript" src="comun/js/comun.js"></script>
    <script type="text/javascript" language="javascript" src="comun/js/formulario.js"></script>
    <script type="text/javascript" language="javascript" src="comun/js/ayudas.js"></script>
    
    <script type="text/javascript">
        function inicio() {
            setFoco("codigo");
        }
    </script>
  </head>

 

  <body onload="inicio();">
    <cmz:main>
      <cmz:panelCMZ>
        <cmz:cabeceraPanelCMZ titulo="Mantenimiento de Comunidades Autónomas" icono="${permisos.accionMenu.icono}">
          <cmz:acciones numAccionesVisibles="1">
            <c:if test="${permisos.puedeAñadir}">
              <cmz:accionNuevoRegistro onclick="alta();" descripcion="Alta de una nueva Comunidad Autónoma"/>
            </c:if>
            <cmz:accion titulo="Ver Permisos" icono="comun/images/iconos/i-key.gif" descripcion="Ver permisos efectivos del usuario" onclick="verPermisos(${permisos.accionMenu.idAccion})" />
            <c:if test="${permisos.puedeAdministrar}">
              <cmz:accion titulo="Administrar Permisos" icono="comun/images/iconos/i-admin_permisos.gif" descripcion="Administración de permisos" onclick="adminPermisos(${permisos.accionMenu.idAccion})" />
            </c:if>
          </cmz:acciones>
        </cmz:cabeceraPanelCMZ>
        
        <cmz:cuerpoPanelCMZ>
          <cmz:mensaje/>
          <form id="frmDatos" name="frmDatos" action="comunidades" method="post">
            <input id="accion" name="accion" type="hidden" value="" />
            <input id="operacion" name="operacion" type="hidden" value="" />
            <input id="columna" name="columna" type="hidden" value="" />
            <input id="pagina" name="pagina" type="hidden" value="" />
            <input id="idObjeto" name="idObjeto" type="hidden" value="" />
            
            <cmz:panel>
              <cmz:cabeceraPanel titulo="Búsqueda de Comunidades Autónomas"></cmz:cabeceraPanel>
              <cmz:cuerpoPanel>
                <table cellpadding="0px" cellspacing="0px" border="0px">
                  <tr>
                    <td>
                      <table cellpadding="2px" cellspacing="2px" border="0px">
                        <tr>
                          <td><cmz:etiqueta titulo="Código"/>:</td>
                          <td><cmz:campoTexto id="codigo" valor="${paramBuscarComunidades.codigo}" anchura="100px" longitudMaxima="6"/></td>
                                                  
                          <td>
                            <cmz:botonConsultar onclick="consultar();"/>
                          </td>
                        </tr>
                        <tr>
                          <td><cmz:etiqueta titulo="Descripción"/>:</td>
                          <td><cmz:campoTexto id="descripcion" valor="${paramBuscarComunidades.descripcion}" anchura="100px" longitudMaxima="20"/></td>
                        </tr>
                        <tr>
                          <td><cmz:etiqueta titulo="Idioma"/>:</td>
                          <td><cmz:campoTexto id="idioma" valor="${paramBuscarComunidades.idioma}" anchura="100px" longitudMaxima="20"/></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </cmz:cuerpoPanel>
            </cmz:panel>
            
            <c:choose>
              <c:when test="${paginaResultados.pagina != null}">
                <cmz:panel>
                  <cmz:cabeceraPanelResultados numPorPagina="${paginaResultados.tamañoPagina}" />
                  <cmz:cuerpoPanel>
                    <cmz:listaPaginada>
                    <!-- Input user -->
                      <cmz:cabeceraListaPaginada ordenActual="${paramBuscarComunidades.orden}">
                        <cmz:itemCabeceraListaPaginada nombre="Código" columna="1" ordenColumna="CODIGO" />
                        <cmz:itemCabeceraListaPaginada nombre="Descripción" columna="2" ordenColumna="DESCRIPCION" />
                        <cmz:itemCabeceraListaPaginada nombre="Idioma" columna="3" ordenColumna="IDIOMA" />
                        <cmz:itemCabeceraListaPaginada nombre="Acciones" estilo="text-align: center;" />
                      </cmz:cabeceraListaPaginada>
                      <!-- variable en contenido lista paginada -->
                      <cmz:contenidoListaPaginada variable="comunidad" paginaResultados="${paginaResultados}">
                        <cmz:itemContenidoListaPaginada valor="${comunidad.codigo}" onclick="ver('${comunidad.codigo}');" />
                        <cmz:itemContenidoListaPaginada valor="${comunidad.descripcion}" />
                        <cmz:itemContenidoListaPaginada valor="${comunidad.idioma}" />
                        <cmz:acciones alineacion="center">
                          <cmz:accion icono="comun/images/iconos/i-busca.gif" onclick="ver('${comunidad.codigo}');" descripcion="Ver Comunidad Autónoma" />
                          <c:if test="${permisos.puedeEditar}">
                            <cmz:accion icono="comun/images/iconos/i-edit.gif" onclick="editar('${comunidad.codigo}');" descripcion="Editar Comunidad Autónoma" />
                          </c:if>
                          <c:if test="${permisos.puedeEliminar}">
                            <cmz:accion icono="comun/images/iconos/i-cancel.gif" onclick="eliminar('${comunidad.codigo}');" descripcion="Eliminar Comunidad Autónoma" />
                          </c:if>
                        </cmz:acciones>
                      </cmz:contenidoListaPaginada>
                    </cmz:listaPaginada>
                  </cmz:cuerpoPanel>
                </cmz:panel>
              </c:when>
            </c:choose>
          </form>
        </cmz:cuerpoPanelCMZ>
      </cmz:panelCMZ>
    </cmz:main>
  </body>
</html>