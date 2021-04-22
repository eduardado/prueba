/*Scripts el tutorial de creaci�n de pantalla del backoffice*/
/*prueba*/


/*TABLAS modificadas*/
select * from  cmz_bookerzzia.config_acciones_tbl cat ; 
select  * from cmz_bookerzzia.config_acciones_operacione_tbl;
select * from cmz_bookerzzia.d_acciones_permisos_tbl dapt ; -- 
select * from cmz_bookerzzia.config_menu_acciones_tbl cmat ; -- menu

/*Para copiar los valores �nicos de la instalaci�n*/
select * from D_ACTIVIDADES_TBL;

/*tabla a consultar en la pantalla*/
select * from cmz_bookerzzia.d_lenguajes_tbl dlt ;


/*A�ade opci�n al men� del backoffice de lenguajes(ejecutado) */
insert into cmz_bookerzzia.config_acciones_tbl (id_accion , accion , tipo_accion ,ejecucion ,descripcion ,titulo ,icono ,activo )
							values (70001, "com.comerzzia.bookerzzia.backoffice.web.lenguajes.LenguajesServlet", "URL", "lenguajes","Men� de Mantenimiento de Lenguajes", "Men� de Mantenimiento de Lenguajes","comun/images/menu/pagina.png","S" );
						
						
						
/*A�ade operaci�n EJECUTAR para la pantalla de acci�n*/
select * from cmz_bookerzzia.config_acciones_operacione_tbl caot ;
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70001, 0, 0, "EJECUTAR","EJECUTAR", "S", "S");
/*A�ade operaci�n A�ADIR para la pantalla de acci�n*/
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70001, 1, 1, "A�ADIR","A�ADIR", "S", "S");
/*A�ade operaci�n EDITAR para la pantalla de acci�n*/
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70001, 2, 2, "EDITAR","EDITAR", "S", "S");
/*A�ade operaci�n ELIMINAR para la pantalla de acci�n*/
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70001, 3, 3, "ELIMINAR","ELIMINAR", "S", "S");
								
								

/*Inserta los permisos para las operaciones utilizando la tabla de actividades para copiar el hash de la instalaci�n dando permisos de administrador por si acaso*/
								
select * from cmz_bookerzzia.d_acciones_permisos_tbl;

insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70001, 0, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;

insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70001, 1, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;
							
insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70001, 2, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;
							
insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70001, 3, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;

/*como estamos usando un superadmin ser� necesario darle permisos sobre las operaciones???*/
							
							
/*Inserta una opci�n y subopci�n en la barra de men� del back*/
select * from cmz_bookerzzia.config_menu_acciones_tbl cmat ;
insert into cmz_bookerzzia.config_menu_acciones_tbl (uid_menu, orden ,opcion, id_accion)
	values ('ADMINISTRACION', 54, 'Lenguajes\\Mantenimiento de Lenguajes', 70001);

