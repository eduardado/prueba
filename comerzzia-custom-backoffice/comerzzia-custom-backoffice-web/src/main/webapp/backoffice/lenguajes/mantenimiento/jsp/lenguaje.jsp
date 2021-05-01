<%--

    ComerZZia 3.0

    Copyright (c) 2008-2015 Comerzzia, S.L.  All Rights Reserved.

    THIS WORK IS  SUBJECT  TO  SPAIN  AND  INTERNATIONAL  COPYRIGHT  LAWS  AND
    TREATIES.   NO  PART  OF  THIS  WORK MAY BE  USED,  PRACTICED,  PERFORMED
    COPIED, DISTRIBUTED, REVISED, MODIFIED, TRANSLATED,  ABRIDGED, CONDENSED,
    EXPANDED,  COLLECTED,  COMPILED,  LINKED,  RECAST, TRANSFORMED OR ADAPTED
    WITHOUT THE PRIOR WRITTEN CONSENT OF COMERZZIA, S.L. ANY USE OR EXPLOITATION
    OF THIS WORK WITHOUT AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO
    CRIMINAL AND CIVIL LIABILITY.

    CONSULT THE END USER LICENSE AGREEMENT FOR INFORMATION ON ADDITIONAL
    RESTRICTIONS.

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cmz" uri="http://comerzzia.com/taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="lenguaje"
	class="com.comerzzia.bookerzzia.backoffice.persistence.lenguajes.Lenguaje"
	scope="session" />
<jsp:useBean id="permisos"
	class="com.comerzzia.core.servicios.permisos.PermisosEfectivosAccionBean"
	scope="request" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comerzzia</title>

<cmz:head />

<script type="text/javascript" language="javascript"
	src="comun/js/comun.js"></script>
<script type="text/javascript" language="javascript"
	src="comun/js/mantenimiento.js"></script>
<script type="text/javascript" language="javascript"
	src="comun/js/ayudas.js"></script>
<script type="text/javascript" language="javascript"
	src="comun/js/validacion.js"></script>
<script type="text/javascript">
        function inicio() {
            document.getElementById("codlengua").focus();
        }

//         validación del formulario
        function checkForm() {
            if(!esValido("codlengua", "TEXTO", true)){
                return false;
            }
            if(!esValido("deslengua", "TEXTO", true)){
                return false;
            }
            return true;
        }
    
        function aceptar() {
        	if(checkForm()) {
        	    document.getElementById("accion").value = "salvar";
        	    document.getElementById("frmDatos").submit();
        		_esperando();
        	}
        }
    </script>
</head>

<!-- Las acciones que pueden hacerse desde la pantalla -->
<!-- añado el keyDown -->
<body onload="inicio();" onkeydown="keyDown(event);">
	<cmz:main>
		<cmz:panelCMZ>
			<cmz:cabeceraPanelCMZ titulo="${permisos.accionMenu.titulo}"
				icono="${permisos.accionMenu.icono}">
				<cmz:acciones numAccionesVisibles="5">
					<c:choose>
						<c:when test="${!lenguaje.enEdicion}">
							<cmz:accion icono="comun/images/iconos/i-volver.gif"
								onclick="volver();" titulo="Volver" descripcion="Volver"></cmz:accion>
							<c:if test="${permisos.puedeEditar}">
								<cmz:accion icono="comun/images/iconos/i-edit.gif"
									onclick="editar();" titulo="Editar" descripcion="Editar País"></cmz:accion>
							</c:if>
							<c:if test="${permisos.puedeAñadir}">
								<cmz:accionNuevoRegistro onclick="alta();"
									descripcion="Añadir un nuevo País" />
							</c:if>
							<c:if test="${permisos.puedeEliminar}">
								<cmz:accion icono="comun/images/iconos/i-cancel.gif"
									onclick="eliminar();" titulo="Eliminar"
									descripcion="Eliminar País"></cmz:accion>
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
				<!-- Declaración del formulario y sus inputs -->
				<form id="frmDatos" name="frmDatos" action="lenguajes" method="post">
					<input id="accion" name="accion" type="hidden" value="" /> <input
						id="idObjeto" name="idObjeto" type="hidden"
						value="${lenguaje.codlengua}" /> <input id="estadoObjeto"
						name="estadoObjeto" type="hidden" value="${lenguaje.estadoBean}" />

					<cmz:panel>
						<cmz:cabeceraPanel titulo="Datos del Lenguaje"></cmz:cabeceraPanel>
						<cmz:cuerpoPanel>
							<table cellpadding="2px" cellspacing="2px" border="0px">
								<tr>
									<td><cmz:etiqueta titulo="Código" />:</td>
									<td><cmz:campoTexto id="codlengua"
											valor="${lenguaje.codlengua}" requerido="true"
											anchura="130px" longitudMaxima="6"
											editable="${lenguaje.estadoNuevo}"
											soloLectura="${!lenguaje.estadoNuevo}" /></td>
								</tr>
								<tr>
									<td><cmz:etiqueta titulo="Descripción" />:</td>
									<td><cmz:campoTexto id="deslengua"
											valor="${lenguaje.deslengua}" requerido="true"
											anchura="400px" longitudMaxima="20"
											editable="${lenguaje.enEdicion}"
											soloLectura="${!lenguaje.enEdicion}" /></td>
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