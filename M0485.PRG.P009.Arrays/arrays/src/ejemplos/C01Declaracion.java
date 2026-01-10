package ejemplos;

public class C01Declaracion {

	/* Qué es un array?
	 * Es una estructura de datos q almacena una coleccion d
	 * elementos del mismo tipo en posiciones d memoria contiguas
	 * 
	 * Cada elemento se accede mediante un indice numerico q
	 * comienza en 0
	 * 
	 * Caracteristicas principales:
	 * - Tamaño fijo: Una vez creado no puede cambiar d tamaño, si
	 * creamos uno de 10 elementos y necesitamos 11 tenemos q crear
	 * uno nuevo
	 * - Tipo homogeneo: Todos los elementos deben ser del mismo
	 * tipo (x ejemplo de tipo int, todos son int, no vale poner
	 * booleans o strings)
	 * - Indexacion: Los indices van de 0 a longitud -1, si tenemos
	 * un array de 3 posiciones la primera es 0, la segunda 1 y la 
	 * tercera 2.
	 * - Objetos: En java los arrays son objetos xk hay una serie
	 * d elementos y de datos primitivos como enteros, booleans...
	 * Los arrays se consideran objetos
	 * 
	 * Declaramos el array asi:
	 */
	
	private static int valor; // no es un array, almacena 1 valor
	
	// Arrays:
	
	/* Aqui almacenamos un unico tipo de dato, para crear una posicion
	 * d memoria o coger una porcion d la misma para crear varios
	 * valores d un mismo tipo
	 * Si a un tipo de dato ponemos [] indicamos q esta posicion
	 * almacena un conjunto de elementos
	 */
	
	private static int[] arrayInt;
	private static double[] arrayDoubles;
	private static boolean[] arrayBooleans;
	
	/* una segunda forma de declarar arrays q es menos comun
	 * seria poner los corchetes al final, lo mas comun es como lo d
	 * arriba
	 */
	
	private static int arrayEnteros[];
	private static String arrayCadenas[];
	
	/* lo proximo que veremos sera POO, como aun no lo vemos x eso
	 * ponemos todo con static
	 */
}
