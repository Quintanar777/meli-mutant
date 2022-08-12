
# Meli Mutant

Libreria con el metodo _isMutant(String[]_ dna) solicitado en el Nivel 1, del reto tecnico de Mercado Libre.


En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.

**Ejemplo (Caso mutante):**

String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

En este caso el llamado a la función isMutant(dna) devuelve “true”.


## Instalar localmente

`mvn clean install`

## Probar localmente

La forma mas simple de probar el funcionamiento de forma individual, es a travez de las pruebas unitarias.

La clase para probar es _MutantManagerTest.java_

## Ejecutar todos los test

Si bien se puede ejecutar mediante Maven:

`mvn test`

Se podria usar usar un IDE, en este caso se verifico el code coverge con IntelliJ Idea.
