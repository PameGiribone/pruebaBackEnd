package com.backend.mesa;

import org.apache.log4j.Logger;

import java.util.List;

/**Les pedimos crear una aplicación que calcule el promedio de valores, el máximo y el mínimo en una lista de enteros:
 * List<Integer> listaEnteros
 Deben loguear:
 Cuando la lista tiene más de 5 elementos.
 Cuando la lista tiene más de 10 elementos.
 El promedio.
 Arrojar un error si la lista no tiene elementos, y registrarlo en los logs.
 Luego, deben crear una clase main, donde creamos una lista para cada uno de los ítems y chequear que los logs existan.**/
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        List <Integer> listaEnteros = List.of(1,2,3,4,5,6,7,8,9,10,11);
        cantidadDeElementos(listaEnteros);
        promedioDeElementos(listaEnteros);
    }

    private static void cantidadDeElementos(List<Integer>listaEntero){
        if (listaEntero.size()>5 && listaEntero.size() <=10 ){
            logger.info("La lista tiene mas de 5 elementos");
        }else if (listaEntero.size()>10){
            logger.info("La lista tiene mas de 10 elementos");
        }else if (listaEntero.isEmpty()){
            logger.error("La lista esta vacia");
        }
    }

    private static void promedioDeElementos(List<Integer>listaEntero){
        double promedio = listaEntero.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        logger.info("El promedio de la lista es: "+promedio);
    }

}
/**Prueba repo**/