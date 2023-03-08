# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2021/22)
Autor/a: José Coronil   uvus:FKR9503


## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.word**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **urban_dictionary.csv**: Archivo csv que contiene datos de definiciones de Urban Dictionary.
    
## Estructura del *dataset*
* **Word**: de tipo string. Palabra o concepto que se va a definir.
* **Definition**: de tipo string. Definicion de la palabra.
* **Author**: de tipo string. Autor de la definicion.
* **Tags**: de tipo lista de strings. Indica etiquetas relacionadas con la palabra.
* **Up**: de tipo int. Indica los votos positivos que ha recibido la definicion.
* **Down**: de tipo int. Indica los votos negativos que ha recibido la definicion.
* **Date**: de tipo LocalDate. Fecha de la publicacion.



## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Partida
Representa una definicion.
**Propiedades**:

* **Word**: de tipo _String_. Palabra o concepto que se va a definir.
* **Definition**: de tipo _String_. Definicion de la palabra.
* **Author**: de tipo _String_. Autor de la definicion.
* **Tags**: de tipo _lista de Strings_. Indica etiquetas relacionadas con la palabra.
* **Votes**: de tipo _Votes_. Indica los votos que ha recibido la definicion.
* **Date**: de tipo _LocalDate_. Fecha de la publicacion.
* **Positive proportion**: de tipo _Float_. Proporcion de votos positivos sobre el total.
* **Calification**: de tipo _PosNeg_. Clasificacion segun los votos.
* **PositiveOverNegative**: de tipo _Boolean_. Indica si la diferencia de los votos es mayor o igual que 0


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Word``` a partir de los siguientes parámetros: ```String word, String definicion,```.

**Restricciones**:
 
- R1: Los votos no pueden ser negativos
- R2: La palabra no puede ser un string vacio

***Criterio de igualdad**: Dos palabras son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: Por proporcion de votos



#### Tipos auxiliares

- PosNeg, enumerado. Puede tomar los valores VERY_NEGATIVE, NEGATIVE, NEUTRAL, POSITIVE, VERY_POSITIVE.
- Votes, clase. Clase que almacena los votos positivos y negativos.

