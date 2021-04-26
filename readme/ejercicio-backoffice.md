Vamos a hacer el mantenimiento de comunidades autónomas. Para ello, hará falta ejecutar este script en nuestra base de datos:
```sql
CREATE TABLE X_COMUNIDADES_AUTONOMAS_TBL (
 UID_ACTIVIDAD VARCHAR(40) NOT NULL,
 CODIGO VARCHAR(3) NOT NULL,
 DESCRIPCION VARCHAR(40) NOT NULL,
 IDIOMA VARCHAR(10) NULL,
 PRIMARY KEY(UID_ACTIVIDAD, CODIGO)
);
```


Como todos los mantenimientos, nuestro mantenimiento estará compuesto por un formulario dónde podremos buscar por código y descripción y a partir del cuál accederemos al formulario de visualización o edición en el que podremos editar el resto de datos (excepto el UID_ACTIVIDAD).

Una vez finalizada la tarea, sube dos capturas de las pantallas (una del formulario de búsqueda y otra del formulario de edición).