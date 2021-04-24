/*Scripts el tutorial de creaci�n de pantalla del backoffice*/
/*prueba*/


/*Tablas modificadas*/
select * from cmz_bookerzzia.config_menu_acciones_tbl cmat ; -- menu
select * from  cmz_bookerzzia.config_acciones_tbl cat ; -- acciones
select  * from cmz_bookerzzia.config_acciones_operacione_tbl; -- operaciones
select * from cmz_bookerzzia.d_acciones_permisos_tbl dapt ;  -- permisos 


/*Para copiar los valores únicos de la instalación*/
select * from cmz_bookerzzia.D_ACTIVIDADES_TBL;

/*tabla a consultar en la pantalla*/
select * from cmz_bookerzzia.x_comunidades_autonomas_tbl xcat;


/*Creación de tabla de comunidades autónomas en la base de datos del backoffice*/
CREATE table cmz_bookerzzia.X_COMUNIDADES_AUTONOMAS_TBL (
 UID_ACTIVIDAD VARCHAR(40) NOT NULL,
 CODIGO VARCHAR(3) NOT NULL,
 DESCRIPCION VARCHAR(40) NOT NULL,
 IDIOMA VARCHAR(10) NULL,
 PRIMARY KEY(UID_ACTIVIDAD, CODIGO)
);

/*Algunas comunidades*/

insert into cmz_bookerzzia.x_comunidades_autonomas_tbl (UID_ACTIVIDAD,CODIGO,DESCRIPCION,IDIOMA) values ('d604d26e-fe16-4d21-9089-7a8efbcfd296', 'AND', 'Andalucía', 'Dalú');
insert into cmz_bookerzzia.x_comunidades_autonomas_tbl (UID_ACTIVIDAD,CODIGO,DESCRIPCION,IDIOMA) values ('d604d26e-fe16-4d21-9089-7a8efbcfd296', 'EXT', 'Extremadura', 'Extremo');
insert into cmz_bookerzzia.x_comunidades_autonomas_tbl (UID_ACTIVIDAD,CODIGO,DESCRIPCION,IDIOMA) values ('d604d26e-fe16-4d21-9089-7a8efbcfd296', 'GAL', 'Galicia', 'Portugués');
insert into cmz_bookerzzia.x_comunidades_autonomas_tbl (UID_ACTIVIDAD,CODIGO,DESCRIPCION,IDIOMA) values ('d604d26e-fe16-4d21-9089-7a8efbcfd296', 'MDZ', 'Madriz', 'Dridense');

/*Añade acción al backoffice de lenguajes */
select * from  cmz_bookerzzia.config_acciones_tbl;
insert into cmz_bookerzzia.config_acciones_tbl (id_accion , accion , tipo_accion ,ejecucion ,descripcion ,titulo ,icono ,activo )
							values (70002, "com.comerzzia.bookerzzia.backoffice.web.comunidades.ComunidadesServlet", "URL", "comunidades","Menú de Mantenimiento de Comunidades Autónomas", "Menú de Mantenimiento de Comunidades Autónomas","comun/images/menu/pagina.png","S" );
						
						
						
/*Añade operación EJECUTAR para la pantalla de acción*/
select * from cmz_bookerzzia.config_acciones_operacione_tbl caot where id_accion = 70002;

insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70002, 0, 0, "EJECUTAR","EJECUTAR", "S", "S");
/*Añade operación AÑADIR para la pantalla de acción*/
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70002, 1, 1, "AÑADIR","AÑADIR", "S", "S");
/*Añade operación EDITAR para la pantalla de acción*/
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70002, 2, 2, "EDITAR","EDITAR", "S", "S");
/*Añade operación ELIMINAR para la pantalla de acción*/
insert into cmz_bookerzzia.config_acciones_operacione_tbl (id_accion ,id_operacion , orden ,desoperacion ,ejecucion ,activo ,visible )
									values (70002, 3, 3, "ELIMINAR","ELIMINAR", "S", "S");
								
								

/*Inserta los permisos para las operaciones utilizando la tabla de actividades para copiar el hash de la instalaci�n dando permisos de administrador por si acaso*/
								
select * from cmz_bookerzzia.d_acciones_permisos_tbl where id_accion = 70002;

insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70002, 0, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;

insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70002, 1, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;
							
insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70002, 2, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;
							
insert into cmz_bookerzzia.d_acciones_permisos_tbl (UID_INSTANCIA, UID_ACTIVIDAD, ID_ACCION , ID_OPERACION, ID_USUARIO, ID_PERFIL , ACCESO)
								select UID_ACTIVIDAD, UID_INSTANCIA, 70002, 3, -1, 0, 2
								from cmz_bookerzzia.d_actividades_tbl;

							
							
/*Inserta una opción y subopción en la barra de menú del backoffice en el apartado de administración*/
select * from cmz_bookerzzia.config_menu_acciones_tbl cmat ;
insert into cmz_bookerzzia.config_menu_acciones_tbl (uid_menu, orden ,opcion, id_accion)
	values ('ADMINISTRACION', 55, 'Comunidades Autónomas\Mantenimiento de Comunidades Autónomas', 70002);

