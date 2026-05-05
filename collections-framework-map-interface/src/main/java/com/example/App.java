package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class App {
    public static void main(String[] args) {
        
    	/* Map Interface: (o mapa) es una coleccion aunq no hereda de la interfaz collection, pero 
    	 * se puede tratar como tal utilizando las Collection Views. 
    	 * 
    	 * Concretamente un mapa es una coleccion, tb denominada objeto, q relaciona claves con valores,
    	 * lo q antiguamente se llamaba una estrcutura hash (clave (key) y valor (value)), donde las clave
    	 * no pueden repetirse.
    	 * 
    	 * Los metodos de ordenamiento y busqueda q son aplicables a las interfaces q heredan de Collection
    	 * no son aplicables a los mapas. Pj. el metodo sort no se le puede aplicar a un mapa.
    	 * 
    	 * En resumen una interface map, mapea claves con valor en un contenedor, que se puede crear de
    	 * varias formas y recorrer de varias formas tb. */
    	
    	// forma cahpucera de crar un Map Interface:
    	
    	/* A modo de ejemplo vamos a crear una colección Map Interface q almacene la frecuencia de 
    	 * repetición/ocurrencia de un array de palabras que se reciben como parametros en el metodo
    	 * main, cuando se lanza la aplicación. */
    	
    	// Preimero: Comprovar si estamos recivbiendo el array de nombres en la var argument cuando se 
    	// se lanza la aplicación.
    	
    	List<String> listadoDeArgumentos = Arrays.asList(args);
    	
    	
    	
    	listadoDeArgumentos.forEach(System.out::println);
    	
    	// Creacion del mapa a partir del listado de argumentos:
    	
    	// este mapa se obtiene de recorrer el mapa usando el flujo stream
    	// objetivo obtener nuevo valor o nueva coleccion(mapa) como en este caso
    	// de nuevo con los nombes en la clave y la cantidad de veces que aparecen
    	// en el valor.
    	// esta vez usamos el metodo collect para recoger los nombres que pasan por
    	// la tubería creada por stream. Collectors es la clase que implementa los
    	// metodos del metodo collect y el que no vale es el de groupingby para agrupar
    	// lo que va pasando por la tubería y meterlo en la calve del mapa, coge el nombre
    	// de la tubería y lo devuelve con la lambda y para contar otro collector con su
    	// metodo counting, pero esto devuelve un Long en vez de un Integer y ha que cambiarlo
    	// en el tipo de dato que ocupara la posición de valor de nuestro mapa.
    	
    	Map<String, Long> m = listadoDeArgumentos.stream()
    			.collect(Collectors.groupingBy(nombre -> nombre,
    					Collectors.counting()));
    	
    }
}
