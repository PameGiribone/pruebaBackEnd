package com.backend.mesa;

import org.apache.log4j.Logger;

import java.util.List;

public class Ejercicio {


    public static class Main {
        private static final Logger log = Logger.getLogger(Main.class);

        public static void main(String[] args) {
            List<Integer> listaEntero = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            validate(listaEntero);
            masDe5Elementos(listaEntero);
            masDe10Elementos(listaEntero);
            promedio(listaEntero);
        }
        private static void masDe5Elementos(List<Integer> listaEntero) {
            if (listaEntero.size() > 5 && listaEntero.size() <= 10){
                log.info("La lista tiene mas de 5 elementos");
            }
        }
        private static void masDe10Elementos(List<Integer> listaEntero) {
            if (listaEntero.size() > 10){
                log.info("La lista tiene mas de 10 elementos");
            }
        }
        private static void promedio(List<Integer> listaEntero) {
            double promedio = listaEntero.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            log.info("El promedio de la lista es: " + promedio);
        }

        private static void validate(List<Integer> integerList) {
            if (integerList == null || integerList.isEmpty()) {
                log.error("The list is empty or null");
            }
        }
    }
}
