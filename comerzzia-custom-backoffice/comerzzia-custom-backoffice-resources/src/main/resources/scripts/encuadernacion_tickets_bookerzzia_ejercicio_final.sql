/*Ejercicio final*/

/*Modificación de procesamiento de documentos en el backoffice*/
/*Tablas*/
select * from cmz_bookerzzia.d_tipos_documentos_tbl dtdt ; -- clases procesadoras de documentos
select * from cmz_bookerzzia.d_tickets_tbl dtt ; -- todos los documentos, incluyendo tickets
select * from czzposs_bookerzzia.d_tickets_tbl dtt ; -- documentos tienda
select * from cmz_bookerzzia.d_clie_albaranes_det_tbl ; -- albaranes datos cabecera
SELECT * FROM CMZ_BOOKERZZIA.d_clie_albaranes_cab_tbl; -- albaranes datos 

/*Procesamiento de documentos*/

select * from cmz_bookerzzia.d_tickets_tbl dtt ORDER BY ID_TICKET desc; -- documentos (y tickets) central
select * from czzposs_bookerzzia.d_tickets_tbl order by id_ticket desc ; -- documentos (y tickets) pos

/*Albares*/
select * from cmz_bookerzzia.d_clie_albaranes_det_tbl aldet ORDER BY aldet.id_clie_albaran desc; -- albaranes datos cabecera
SELECT * FROM CMZ_BOOKERZZIA.d_clie_albaranes_cab_tbl alcab ORDER BY alcab.id_clie_albaran desc; -- albaranes datos 

/*Mi tabla personalizada de la central*/
SELECT * FROM X_ENCUADERNACION_TBL XET;

/*creacion de tabla custom*/
/*Esta tabla recogerá los datos que extraeré de procesadores de documentos personalizados*/
CREATE TABLE CMZ_BOOKERZZIA.X_ENCUADERNACION_TBL (
 UID_ACTIVIDAD VARCHAR(40) NOT NULL,
 CODALM VARCHAR(4) NOT NULL,
 ID_CLIE_ALBARAN BIGINT (10) NOT NULL, 
 TAPA VARCHAR(10) NOT NULL,
 SUBTITULO VARCHAR(30) NULL,
 DEDICATORIA VARCHAR(60) NULL,
 HECHO VARCHAR(1) NOT NULL,
 PRIMARY KEY(UID_ACTIVIDAD, CODALM, ID_CLIE_ALBARAN)
);

/*SCRIPTS POR HACER*/
-- update de cambiar las clases procesadoras en las tablas de tipos de documentos
-- com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones.CustomProcesadorAlabaranVenta

-- com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones.CustomProcesadorAlabaranVenta


/* Ciclo de Pruebas  CENTRAL*/
SELECT * FROM czzposs_bookerzzia.d_tickets dt ORDER BY FECHA desc;

SELECT * FROM cmz_bookerzzia.d_tickets_tbl dtt ORDER BY fecha DESC;

SELECT * FROM cmz_bookerzzia.X_ENCUADERNACION_TBL XET; -- mi tabla personalizada

SELECT * FROM d_clie_albaranes_cab_tbl dcact ORDER BY id_clie_albaran desc;
SELECT * FROM d_clie_albaranes_det_tbl dcact ORDER BY id_clie_albaran desc;