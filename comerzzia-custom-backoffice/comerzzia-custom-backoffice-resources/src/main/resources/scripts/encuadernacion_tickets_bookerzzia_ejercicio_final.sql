/*Ejercicio final*/

/* Nivel 1*/

/*creacion de tabla custom*/
DROP TABLE cmz_bookerzzia.x_encuadernacion_tbl ;
/*Esta tabla recogerá los datos que extraeré de procesadores de documentos personalizados*/
CREATE TABLE CMZ_BOOKERZZIA.X_ENCUADERNACION_TBL (
 UID_ACTIVIDAD VARCHAR(40) NOT NULL,
 CODALM VARCHAR(4) NOT NULL,
 ID_CLIE_ALBARAN BIGINT (10) NOT NULL,
 LINEA int(5) NOT NULL,
 TAPA VARCHAR(10) NOT NULL,
 SUBTITULO VARCHAR(30) NULL,
 DEDICATORIA VARCHAR(60) NULL,
 HECHO VARCHAR(1) NULL,
 PRIMARY KEY(UID_ACTIVIDAD, CODALM, ID_CLIE_ALBARAN, LINEA)
);

/*Modifica la tabla de tipos de documentos para que el backoffice admin use nuestra customizada para procesar los tickets de venta de factura simplificada*/
UPDATE cmz_bookerzzia.d_tipos_documentos tipo
SET tipo.CLASE_PROCESAMIENTO = 'com.comerzzia.bookerzzia.backoffice.services.procesamiento.ventas.albaranes.encuadernaciones.CustomProcesadorAlabaranVenta'
WHERE tipo.ID_TIPO_DOCUMENTO = 1;



/* INFORMACIÓN EXTRA*/


/*Modificación de procesamiento de documentos en el backoffice*/
/*Tablas*/
select * from cmz_bookerzzia.d_tipos_documentos_tbl dtdt ; -- clases procesadoras de documentos
select * from cmz_bookerzzia.d_tickets_tbl dtt ; -- todos los documentos, incluyendo tickets
select * from czzposs_bookerzzia.d_tickets_tbl dtt ; -- documentos tienda
select * from cmz_bookerzzia.d_clie_albaranes_det_tbl ; -- albaranes datos cabecera
SELECT * FROM CMZ_BOOKERZZIA.d_clie_albaranes_cab_tbl; -- albaranes datos 

SELECT * FROM cmz_bookerzzia.x_encuadernacion_tbl xet ;

/*Ciclo pruebas*/
select * from czzposs_bookerzzia.d_tickets_tbl dtt ORDER BY dtt.id_ticket desc; -- documentos tienda
select * from cmz_bookerzzia.d_tickets_tbl dtt ORDER BY dtt.id_ticket desc; -- documentos tienda

SELECT * FROM CMZ_BOOKERZZIA.d_clie_albaranes_cab_tbl ORDER BY id_clie_albaran desc ; -- albaranes standard datos 
select * from cmz_bookerzzia.d_clie_albaranes_det_tbl ORDER BY id_clie_albaran desc; -- albaranes standard detalle

SELECT * FROM cmz_bookerzzia.x_encuadernacion_tbl xet; -- albarán personalizado compra (debería ser como el de detalle)






