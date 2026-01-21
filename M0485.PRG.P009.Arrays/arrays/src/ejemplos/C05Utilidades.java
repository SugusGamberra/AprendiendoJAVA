package ejemplos;

import java.util.Arrays;

public class C05Utilidades {

	public static void main(String[] args) {
		
		Object[] arrayObjetos = new Object[5];
		arrayObjetos[0] = "Holiwi";
		arrayObjetos[1] = 23;
		arrayObjetos[2] = true;
		arrayObjetos[3] = 10.2;
		arrayObjetos[4] = null;
		
		/* Si yo quiero mostrar ese array como tal se muestra solo la direccion de
		 * memoria
		 * Si le paso una clase llamada Arrays con el metodo .toString
		 * Veremos mas utilidades el sabado
		 */
		
		int[][] matriz = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		
		/* definimos un array de enteros para definir el orden
		 * 
		 */
		
		int[] arrayEnteros = {5, 2, 8, 1, 9, 3, 7, 15, 12, 4};
		
		String[] arrayCadenas = {"Patri", "Mario", "Borja", "Santiago", "Zagara", "Illidan", "María"};
		
		// caso01_arrayToString(arrayObjetos);
		// caso02_arrayToStringBiDimensional(matriz);
		// caso03_arrayOrdenacion(arrayEnteros);
		// caso03_arrayOrdenacion(arrayCadenas);
		// caso04_buscarIndicePorValor(arrayEnteros);
		// caso05_rellenarArrayConValorEspecifico();
		caso06_copiaArrays();
	}
	
	private static void caso01_arrayToString(Object[] arrayObjetos) {
		System.out.println(arrayObjetos);
		System.out.println(Arrays.toString(arrayObjetos));
	}
	
	private static void caso02_arrayToStringBiDimensional(Object[] matriz) {
		/* para conseguir que en casos bidimensionales funcione hay que poner otra
		 * instruccion diferente xk si no solo muestra espacio en memoria
		 */
		System.out.println(matriz);
		System.out.println(Arrays.toString(matriz));
		System.out.println(Arrays.deepToString(matriz));
	}
	
	private static void caso03_arrayOrdenacion(int[] arrayEnteros) {
		// devuelve el contenido tal cual esta definido
		System.out.println(Arrays.toString(arrayEnteros));
		
		// para ordenar solo una parte del array
		Arrays.sort(arrayEnteros, 1, 6);
		System.out.println(Arrays.toString(arrayEnteros));
		
		// devolverlo ordenado con sort todo el array
		Arrays.sort(arrayEnteros);
		System.out.println(Arrays.toString(arrayEnteros));
	}
	
	private static void caso03_arrayOrdenacion(String[] arrayElementos) {
		// devuelve el contenido tal cual esta definido
		System.out.println(Arrays.toString(arrayElementos));
		
		// para ordenar solo una parte del array
		Arrays.sort(arrayElementos, 1, 6);
		System.out.println(Arrays.toString(arrayElementos));
		
		// devolverlo ordenado con sort todo el array
		Arrays.sort(arrayElementos);
		System.out.println(Arrays.toString(arrayElementos));
	}
	
	private static void caso04_buscarIndicePorValor(int[] arrayEnteros) {
		/* le pasamos un valor y nos devuelve el indice (posicion) donde se encuentra
		 * si el array no esta ordenado d forma ascendente, te sale un indice que no
		 * aplica a la realidad!
		 * 
		 * IMPORTANTE: El algoritmo de búsqueda binaria asume que los elementos están ordenados
		 */
		Arrays.sort(arrayEnteros);
		System.out.println(Arrays.toString(arrayEnteros));
		int indice = Arrays.binarySearch(arrayEnteros, 7);
		System.out.println("Indice: " + indice);
		
		/* tambien podemos buscar un dato entre 2 indices
		 * asi vemos otra sobrecarga, entre el indice 2 y 6 el valor 7
		 * si se lo pido en el 5, que ya no esta digamos incluido, saca el numero engativo
		 */
		
		indice = Arrays.binarySearch(arrayEnteros, 2, 7, 7);
		System.out.println("Indice: " + indice);
		
		indice = Arrays.binarySearch(arrayEnteros, 2, 5, 7);
		System.out.println("Indice: " + indice);
		
	}
	
	private static void caso05_rellenarArrayConValorEspecifico() {
		int[] numeros = new int[20];
		System.out.println(Arrays.toString(numeros));
		/* con eso devuelve 0
		 * Si queremos asignar un 10 a todos los elementos de forma manual sería de la
		 * siguiente forma:
		 */
		
		numeros[0] = 10;
		numeros[1] = 10;
		System.out.println(Arrays.toString(numeros));
		// ...
		
		// rellenar desde un indice a otro solamente, del indice 3 al 7 concretamente
		Arrays.fill(numeros, 3, 8, 10);
		System.out.println(Arrays.toString(numeros));
		
		/* para añadir todo a 10 hay una instruccion concreta
		 * da igual el valor que haya previamente, esto lo machaca
		 */
		Arrays.fill(numeros, 10);
		System.out.println(Arrays.toString(numeros));
		
	}
	
	private static void caso06_copiaArrays() {
		/* recorremos que int son valores primitivos
		 * si lo muestro x consola muestra dos valores 10, si a valor 1 le pongo 15
		 * y vuelvo a mostrar el contenido, valor 1 tendra valor 15 y el valor2 tendra 10
		 * 
		 */
		int valor1 = 10;
		int valor2 = valor1;
		
		System.out.println("Valor 1: " + valor1);
		System.out.println("Valor 2: " + valor2);
		
		valor1 = 15;
		System.out.println("Valor 1: " + valor1);
		System.out.println("Valor 2: " + valor2);
		
		/* definimos 2 arrays
		 * si los mostramos x consola, en ambos enteros salen los mismos valores
		 * si cambiamos el indice 1 y reproducimos en la consola vemos que tambien
		 * influye al array2 ese cambio, a diferencia de los valores primitovs
		 */
		int[] enteros1 = {1, 2, 3, 5, 7};
		int[] enteros2 = enteros1;
		
		System.out.println("Enteros 1: " + Arrays.toString(enteros1));
		System.out.println("Enteros 2: " + Arrays.toString(enteros2));
		
		enteros1[1] = 22;
		System.out.println("\nEnteros 1: " + Arrays.toString(enteros1));
		System.out.println("Enteros 2: " + Arrays.toString(enteros2));
		
		/* si ahora preguntamos si enteros1 es igual a 2 dira que si
		 * esto compara el espacio en memoria no el contenido
		 */
		
		if (enteros1 == enteros2) {
			System.out.println("Dirección de memoria iguales");
		} else {
			System.err.println("Dirección de memoria distinta");
		}
		
		/* para comprobar el contenido
		 * Va a dar lo mismo porque sigue apuntando a la misma direccion de memoria
		 */
		
		if (Arrays.equals(enteros1, enteros2)) {
			System.out.println("Mismo contenido");
		} else {
			System.err.println("Distinto contenido");
		}
		
		System.out.println("\n");
		
		/* vamos a crear otro array de enteros3 y enteeros4
		 * estos no comparten direccion de memoria
		 * vamos a comprobarlo
		 * teóricamente enteros3 y 4 estan en distintas direcciones de memoria
		 * pero el contenido es igual
		 */
		
		int enteros3[] = {1, 2, 3, 4};
		int enteros4[] = {1, 2, 3, 4};
		
		// ver memoria
		
		if (enteros3 == enteros4) {
			System.out.println("Dirección de memoria iguales");
		} else {
			System.err.println("Dirección de memoria distinta");
		}
		
		// ver contenido
		
		if (Arrays.equals(enteros3, enteros4)) {
			System.out.println("Mismo contenido");
		} else {
			System.err.println("Distinto contenido");
		}
		
		System.out.println("\n");
		
		/* copiar un array con destino independiente y que no apunte a la misma
		 * direccion de memoria del origen con Arrays.copy
		 */
		
		int[] enteros5 = {1, 2, 3, 4, 5, 6, 7};
		// enteros6 apunta a la misma direccion de memoria:
		// int[] enteros6 = enteros5;
		
		// enteros6 esta en una direccion de memoria distinta:
		int[] enteros6 = Arrays.copyOf(enteros5, enteros5.length); 
		
		// ver memoria
		
		if (enteros5 == enteros6) {
			System.out.println("Dirección de memoria iguales");
		} else {
			System.err.println("Dirección de memoria distinta");
		}

		// ver contenido

		if (Arrays.equals(enteros5, enteros6)) {
			System.out.println("Mismo contenido");
		} else {
			System.err.println("Distinto contenido");
		}

		System.out.println("\n");
		
		// el copy of equivale a:
		int posicionActual = 0;
		int[] enteros7 = new int[enteros5.length];
		
		while (posicionActual < enteros5.length) {
			enteros7[posicionActual] = enteros5[posicionActual];
			posicionActual++;
		}
		
		// ver memoria

		if (enteros5 == enteros7) {
			System.out.println("Dirección de memoria iguales");
		} else {
			System.err.println("Dirección de memoria distinta");
		}

		// ver contenido

		if (Arrays.equals(enteros5, enteros7)) {
			System.out.println("Mismo contenido");
		} else {
			System.err.println("Distinto contenido");
		}
	}
}
