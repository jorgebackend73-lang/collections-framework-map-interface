package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
    	// de nuevo con los nombres en la clave y la cantidad de veces que aparecen
    	// en el valor.
    	// esta vez usamos el metodo collect para recoger los nombres que pasan por
    	// la tubería creada por stream. Collectors es la clase que implementa los
    	// metodos del metodo collect y el que no vale es el de groupingby para agrupar
    	// lo que va pasando por la tubería y meterlo en la calve del mapa, coge el nombre
    	// de la tubería y lo devuelve con la lambda y para contar otro collector con su
    	// metodo counting, pero esto devuelve un Long en vez de un Integer y ha que cambiarlo
    	// en el tipo de dato que ocupara la posición de valor de nuestro mapa.
    	
    	/* 
    	 * Esta resulta que es la variante # 2
    	Map<String, Long> m = listadoDeArgumentos.stream()
    			.collect(Collectors.groupingBy(nombre -> nombre,
    					Collectors.counting()));
    	
    	System.out.println("Mapa resultante: " + m);
    	*/
    	
    	Map<String, Long> m = null;
    	
    	// Variante #1 creacion Mapa lo recorremos por todos sus argumentos usando
    	// operaciones de agregado (tubería, metodos de la clase Stream, Lambda,
    	// metodos por referencia,... en fin Programación Funcional.
    	
    	// Clase collector te da la mayoría de los metodos. Al final de la tubería con los elementos
    	// que recibe te permite crear la coleccion que necesitas.
    	
    	// la palabra que llegue metela en el mapa con groupingBy e identity
    	// despues con counting cuenta lo que pasa por la tubería.
    	// Y todo ello asignado a m (nuestro Mapa) desde el principio.
    	    	
    	m = listadoDeArgumentos.stream()
    		.collect(Collectors.groupingBy(Function.identity(),
    				Collectors.counting()));
    	
    	System.out.println(m);
    	
    	// Sub variante #2 que es la que recomienda el profe.
    	
    	var m2 = listadoDeArgumentos.stream()
    			.collect(Collectors.groupingBy(nombre -> nombre, 
    					Collectors.counting()));
    	
    	System.out.println(m2);
    	
    	/* 
    	 * Creación de una lista de empleados
    	 * 
    	 * con = new ArrayList reservamos espacio en memoria para nuestros
    	 * empleados
    	 * */
    	
    	// List<Empleado> empleados = new ArrayList<Empleado>(); // En List<? extends Persona> para meter cualquier tipo de dato Persona, genericidad
    	// si usamos esa genericidad tendriamos que poner un filtro al stream para que deje pasar
    	// solo los tipos de datos, empleados en este caso que buscamos.
    	
    	// lista de cualquier cosa que herede de Persona. Super  para poder modificar, extends para inmutable.
    	List<? extends Persona> listadoGenerico = new ArrayList<>();
    	
    	// creamos los empleados (objetos)
    	Empleado emp1 = Empleado.builder()
    			.nombre("Jorge Francisco")
    			.primerApellido("Alborch")
    			.segundoApellido("Villar")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1973, Month.JULY, 23))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3500.50))
    			.fechaAlta(LocalDate.of(1990, Month.SEPTEMBER, 22))
    			.build();
    	Empleado emp2 = Empleado.builder()
    			.nombre("Andres")
    			.primerApellido("Alonso")
    			.segundoApellido("Pelaez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1983, Month.SEPTEMBER, 23))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3400.50))
    			.fechaAlta(LocalDate.of(1995, Month.SEPTEMBER, 22))
    			.build();
    	Empleado emp3 = Empleado.builder()
    			.nombre("Jeronimo")
    			.primerApellido("Arenal")
    			.segundoApellido("gomez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1968, Month.OCTOBER, 20))
    			.dpto(Dpto.CONTABILIDAD)
    			.salario(new BigDecimal(3600.50))
    			.fechaAlta(LocalDate.of(1977, Month.JANUARY, 4))
    			.build();
    	Empleado emp4 = Empleado.builder()
    			.nombre("Carolina")
    			.primerApellido("Garzon")
    			.segundoApellido("Becerra")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(2001, Month.JUNE, 7))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3700.50))
    			.fechaAlta(LocalDate.of(2020, Month.SEPTEMBER, 10))
    			.build();
    	Empleado emp5 = Empleado.builder()
    			.nombre("Mariana")
    			.primerApellido("Garzon")
    			.segundoApellido("Villar")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(2000, Month.AUGUST, 4))
    			.dpto(Dpto.FINANZAS)
    			.salario(new BigDecimal(3300.50))
    			.fechaAlta(LocalDate.of(2022, Month.SEPTEMBER, 25))
    			.build();
    	Empleado emp6 = Empleado.builder()
    			.nombre("Francisca")
    			.primerApellido("Alvarez")
    			.segundoApellido("Gonzalez")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(1995, Month.DECEMBER, 10))
    			.dpto(Dpto.RRHH)
    			.salario(new BigDecimal(2500.50))
    			.fechaAlta(LocalDate.of(2010, Month.SEPTEMBER, 5))
    			.build();
    	Empleado emp7 = Empleado.builder()
    			.nombre("Maricarmen")
    			.primerApellido("Becerra")
    			.segundoApellido("Martinez")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(2003, Month.FEBRUARY, 14))
    			.dpto(Dpto.FINANZAS)
    			.salario(new BigDecimal(2600.50))
    			.fechaAlta(LocalDate.of(2021, Month.SEPTEMBER, 8))
    			.build();
    	Empleado emp8 = Empleado.builder()
    			.nombre("Eva")
    			.primerApellido("Cornide")
    			.segundoApellido("Machado")
    			.genero(Genero.MUJER)
    			.fechaNacimiento(LocalDate.of(1990, Month.MAY, 18))
    			.dpto(Dpto.INFORMATICA)
    			.salario(new BigDecimal(3500.50))
    			.fechaAlta(LocalDate.of(2015, Month.SEPTEMBER, 22))
    			.build();
    	Empleado emp9 = Empleado.builder()
    			.nombre("Alberto")
    			.primerApellido("Gonzalez")
    			.segundoApellido("Sanchez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1990, Month.FEBRUARY, 14))
    			.dpto(Dpto.FINANZAS)
    			.salario(new BigDecimal(2600.50))
    			.fechaAlta(LocalDate.of(2008, Month.SEPTEMBER, 8))
    			.build();
    	Empleado emp10 = Empleado.builder()
    			.nombre("Javier")
    			.primerApellido("Gonzalez")
    			.segundoApellido("Sanchez")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1995, Month.MAY, 20))
    			.dpto(Dpto.RRHH)
    			.salario(new BigDecimal(3500.50))
    			.fechaAlta(LocalDate.of(2015, Month.SEPTEMBER, 22))
    			.build();
    	
    	Estudiante estudiante1 = Estudiante.builder()
    			.nombre("Alex Eduardo")
    			.primerApellido("Pilicita")
    			.segundoApellido("Changoluisa")
    			.genero(Genero.HOMBRE)
    			.fechaNacimiento(LocalDate.of(1991, Month.MAY, 25))
    			.facultad(Facultad.MEDICINA)
    			.fechaAltaFacultad(LocalDate.of(2020, Month.JANUARY, 6))
    			.build();
    	
    	
    	// creamos la lista de empleados, Luego listadoGenerico es lista creada inmutable
    	listadoGenerico = Arrays.asList(emp1,
    			emp2,
    			emp3,
    			emp4,
    			emp5,
    			emp6,
    			emp7,
    			emp8,
    			emp9,
    			emp10);
    	
    	// listadoGenerico.add(emp1); // esto seria si usamos super en vez de extends arriba.
    	
    	/* Crear una coleccion que agrupe (es un mapa, si agrupa = mapa) los emp por genero.
    	 * Si uno esta empezando darle un nombre al mapa, luego con var es suficiente.
    	 * Map java.util queremos agrupar por genero que será la clave y lo que almacenaremos en valor 
    	 * seran los empleados de ese genero, más correcto una lista de los empleados de ese genero.
    	 * recorremos los empleados creando un flujo con stream y los pillamos con collect, para agruparlos 
    	 * después por genero y pasarselo a la clave del mapa y empleado va a la lista de los de ese genero y
    	 * los del otro genero a otra lista. 
    	 * groupingBy al ser un metodo map le quita un trozo al elemento que fluye por la tuberia
    	 * es un metodo abstracto y necesita una lambda (metodo anonimo) para recibir lo que pasa por la tubería
    	 * la Lambda le pide al elemento en este caso que le de su genero y así meterlo en la lista correcta, 
    	 * la primera parte de la Lambda manda al empleado a la clave del mapa y la segunda coge el genero
    	 * y otro collectors lo mete en valor
    	 * 
    	 * */
    	
    	/* Map<Genero, List<Empleado>> empleadosPorGenero = empleados.stream()
    			.collect(Collectors.groupingBy(empleado -> empleado.getGenero(),
    					Collectors.toList())); */
    	
    	/* Cuando se recorre una lista que es del mismo tipo que los elementos del valor del mapa, no hay q hacer
    	 * absolutamente nada para que el elemento que circula por la tubería termine en la lista correspondiente 
    	 * al valor de la entrada del mapa.*/
    	
    	/*Map<Genero, List<Empleado>> empleadosPorGenero = empleados.stream()
    			.collect(Collectors.groupingBy(Persona::getGenero));
    	
    	
    	System.out.println("Empleados por Genero: " + empleadosPorGenero); */
    	
    	// Como lo de antes pero aplicando filtro, pues al permitir que pase cualquier mierda que herede
    	// de persona hay que filtrar a los empleados.
    	Map<Genero, List<Empleado>> empleadosPorGenero = listadoGenerico.stream()
    			.filter(obj -> obj instanceof Empleado) // hemos comprobado obj es una instancia de empleado y di pasa
    			.map(obj -> (Empleado) obj) // hay que mapear el elemento para y para decir que el obj e obj lo casteamos a empleado
    			.collect(Collectors.groupingBy(Persona::getGenero));
    	
    	
    	System.out.println("Empleados por Genero: " + empleadosPorGenero);
    	
    }
}
