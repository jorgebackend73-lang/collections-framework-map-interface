package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
    	
    	// cuando vas a declarar una varible usada en varias Map -> java.util 
    	// -> <K (clave), V (valor)> nombre mapa = m
    	// mapa usa metodo put para meter datos, hay que reservar memoria Hash > esto no permite ordenar
    	// por eso habrá que pasarlo a tree map para ordenalo. No hace falta pasar a HashMap los tipos
    	// de datos, ya se los pasmos y los puede inferir de Map<String, Integer>
    	
    	Map<String, Integer> m = new HashMap<>(); // Mapa declarado, pero vacio. 
    	
    	// Recorremos la lista de argumentos con for mejorado, iterdor, stream u operciones de agregado,
    	// para llenar nuestro Map. 
    	// Primer caso artesanal usando for mejorado.
    	
    	Integer frecuenciaOcurrencia = null;
    	
    	for (String nombre : listadoDeArgumentos) {
    		
    	// Primero preguntar si Rodrigo está en el Map m, como no está, saldrá null y se guardará como clave 
    	// dandole valor 1.
    	// Si lo vuelve a recibir, la clave no se modificará, pero si el valor a 2 (+1) y así sucesivamente y 
    	//	con cada valor diferente.
    		
    		frecuenciaOcurrencia = m.get(nombre);
    		
    		// agregamos clave y valor con put y al valor le metemos un 1 con operador ternario, 
    		// pero si ya está entonces incrementamos en 1 frecuenciadeOcurrencia con operador 
    		// de autoincremento (lo ponemos delante para asegurar q solo incrementa en uno cada vez).
    		
    		m.put(nombre, frecuenciaOcurrencia == null ? 1 : ++frecuenciaOcurrencia);
    
    	
    	}
    	
    	System.out.println("Mapa resultante: " + m);
    	
    }
}
