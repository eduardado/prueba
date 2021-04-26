[[comerzzia]]

Nuestro cliente quiere añadir la posibilidad de encuadernar de forma especial `los libros` si el cliente lo solicita. 
El objetivo de este ejercicio es implementar esto, atravesando los distintos niveles que se explicarán a continuación:
## Nivel 1
POS
- [x] Añadir un botón
  -  en la `pantalla de ventas` que permita indicar que a 
  -  la `línea` seleccionada se le -> uf la línea seleccionada? cómo sé cual es la línea seleccionada
     -  añadirá una `encuadernación` (Binding)
- Al pulsar sobre dicho botón, se tendrá que abrir una `pantalla modal` donde se puedan indicar los siguientes datos:
     - `Tipo de encuadernación`:   (Obligatorio)
       - tapa dura
       - piel 
       - tela 
   - `Subtítulo` en portada: 
     - se permitirá añadir un texto que aparezca en la portada bajo el título. (Opcional).
   - `Dedicatoria` interior: 
     - se permitirá añadir en las primeras hojas del libro una dedicatoria. (Opcional).

- Al aceptar en esta pantalla modal, los datos indicados se deberán guardar en el `XML del ticket`. 

BACKOFFICE 
- Posteriormente, `en el backoffice`, estos datos se guardarán en una `tabla nueva` en la base de datos en la que, 
  - Además de los datos indicados anteriormente, 
    - `tipo de encuadernación`
    - `subtítulo`
    - `dedicatoria`
  - Se deberán guardar las siguientes columnas:
    - `ID_CLIE_ALBARAN`: Identificador del albarán generado por la venta.
    - `CODALM`: Identificador de la tienda de la venta.
    - `HECHO`: booleano (con valor S o N) que indica si la encuadernación se ha hecho ya.

## Nivel 2

Hacer el mantenimiento en el backoffice, de forma que se puedan buscar las encuadernaciones por los parámetros ID_CLIE_ALBARAN, CODALM y HECHO. Al acceder a una encuadernación, el único campo que se podrá modificar será la dedicatoria interior (por si hubiese faltas de ortografía). Además, la pantalla permitirá marcar como hecho una encuadernación.
## Nivel 3

La empresa quiere empezar a cobrar por estas encuadernaciones. Modificar el proceso en el POS para que, al añadir una encuadernación a una línea, se inserte una línea nueva con un artículo fijo (a elección del programador), de forma que se aumente el total del ticket.
## Nivel 4

Tipificar el campo de tipo de encuadernación en el POS. Se tiene que crear una tabla en la base de datos del POS que asocie para un tipo de identificación un código de artículo determinado, de forma que para cada tipo de encuadernación se pueda cobrar un importe distinto. Habrá que cambiar el campo de texto libre del tipo de encuadernación por un combo en el que solo salgan los tipos de encuadernación de la tabla.

No es necesario completar todos los niveles si no te da tiempo. Cuando termines el ejercicio, sube las imágenes que creas oportunas para mostrar tu trabajo.