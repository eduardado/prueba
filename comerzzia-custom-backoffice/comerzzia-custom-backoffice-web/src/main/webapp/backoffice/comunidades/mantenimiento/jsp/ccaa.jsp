<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cmz" uri="http://comerzzia.com/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="ccaa"
	class="com.comerzzia.bookerzzia.backoffice.persistence.ccaa.ComunidadAutonoma"
	scope="session" />
<jsp:useBean id="permisos"
	class="com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean"
	scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comerzzia</title>
<cmz:head />
<link rel="stylesheet" type="text/css" media="screen,projection,print"
	href="comun/css/calendario.css" />
<script type="text/javascript" language="javascript"
	src="comun/js/comun.js" />
<script type="text/javascript" language="javascript"
	src="comun/js/mantenimiento.js" />
<script type="text/javascript" language="javascript"
	src="comun/js/ayudas.js" />
<script type="text/javascript" language="javascript"
	src="comun/js/validacion.js" />

<script type="text/javascript">
         	function inicio() {
         		document.getElementById("codigo").focus();
         	}
         
         	function checkForm() {
         		if (!esValido("codigo", "TEXTO", true)) {
         			return false;
         		}
         		if (!esValido("descripcion", "TEXTO", true)) {
         			return false;
         		}
         		if (!esValido("idioma", "TEXTO", true)) {
         			return false;
         		}
         		return true;
         	}
         
         	function aceptar() {
         		if (checkForm()) {
         			document.getElementById("accion").value = "salvar";
         			document.getElementById("frmDatos").submit();
         			_esperando();
         		}
         	}
      </script>
</head>
<body onload="inicio();">
	<cmz:main>
		<cmz:panelCMZ>
			<cmz:cabeceraPanelCMZ titulo="${permisos.accionMenu.titulo}"
				icono="${permisos.accionMenu.icono}">
				<cmz:acciones numAccionesVisibles="5">
					<c:choose>
						<c:when test="${!ccaa.enEdicion}">
							<cmz:accion icono="comun/images/iconos/i-volver.gif"
								onclick="volver();" titulo="Volver" descripcion="Volver" />
							<c:if test="${permisos.puedeEditar}">
								<cmz:accion icono="comun/images/iconos/i-edit.gif"
									onclick="editar();" titulo="Editar"
									descripcion="Editar Comunidad Autónoma" />
							</c:if>
							<c:if test="${permisos.puedeAñadir}">
								<cmz:accionNuevoRegistro onclick="alta();"
									descripcion="Añadir Comunidad Autónoma" />
							</c:if>
							<c:if test="${permisos.puedeEliminar}">
								<cmz:accion icono="comun/images/iconos/i-cancel.gif"
									onclick="eliminar();" titulo="Eliminar"
									descripcion="Eliminar Comunidad Autónoma" />
							</c:if>
						</c:when>
						<c:otherwise>
							<cmz:accionSalvar onclick="aceptar();" />
							<cmz:accionCancelar onclick="cancelar();" />
						</c:otherwise>
					</c:choose>
				</cmz:acciones>
			</cmz:cabeceraPanelCMZ>
			<cmz:cuerpoPanelCMZ>
				<cmz:mensaje />
				<form id="frmDatos" name="frmDatos" action="ccaa" method="post">
					<input id="accion" name="accion" type="hidden" value="" /> <input
						id="idObjeto" name="idObjeto" type="hidden" value="${ccaa.codigo}" />
					<input id="estadoObjeto" name="estadoObjeto" type="hidden"
						value="${ccaa.estadoBean}" />
					<cmz:panel>
						<cmz:cabeceraPanel titulo="Datos de la Comunidad Autónoma"></cmz:cabeceraPanel>
						<cmz:cuerpoPanel>
							<table cellpadding="2px" cellspacing="2px" border="0px">
								<tr>
									<td>
										<table cellpadding="2px" cellspacing="2px" border="0px">
											<tr>
												<td><cmz:etiqueta titulo="Código" />:</td>
												<td><cmz:campoTexto id="codigo" valor="${ccaa.codigo}"
														requerido="true" anchura="400px" longitudMaxima="6"
														editable="${ccaa.enInsercion}"
														soloLectura="${!ccaa.enInsercion}" /></td>
											</tr>
											<tr>
												<td><cmz:etiqueta titulo="Descripción" />:</td>
												<td><cmz:campoTexto id="descripcion"
														valor="${ccaa.descripcion}" requerido="true"
														anchura="400px" longitudMaxima="20"
														editable="${ccaa.enEdicion}"
														soloLectura="${!ccaa.enEdicion}" /></td>
											</tr>
											<tr>
												<td><cmz:etiqueta titulo="Idioma" />:</td>
												<td><cmz:campoTexto id="idioma" valor="${ccaa.idioma}"
														requerido="false" anchura="400px" longitudMaxima="20"
														editable="${ccaa.enEdicion}"
														soloLectura="${!ccaa.enEdicion}" /></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</cmz:cuerpoPanel>
					</cmz:panel>
				</form>
			</cmz:cuerpoPanelCMZ>
		</cmz:panelCMZ>
	</cmz:main>
</body>
</html>