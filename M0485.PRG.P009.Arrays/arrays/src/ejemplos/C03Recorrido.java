package ejemplos;

public class C03Recorrido {

	public static void main(String[] args) {

		Object[] arrayObjetos = new Object[5];
		arrayObjetos[0] = "Holiwi";
		arrayObjetos[1] = 23;
		arrayObjetos[2] = true;
		arrayObjetos[3] = 10.2;
		arrayObjetos[4] = null;

		// recorridoWhile(arrayObjetos);
		// recorridoForTradicional(arrayObjetos);
		recorridoForEach(arrayObjetos);

		/*
		 * Vamos a ver como recorrre un array Imaginemos q tiene mogollones d elementos
		 * en vez de esto Lo ideal seria recorrer este array
		 */

	}

	private static void recorridoWhile(Object[] arrayObjetos) {
		// while:

		/*
		 * Imaginemos q no sabemos la posicion Creamos un limite Si no sabemos la
		 * dimension concreta usamos el .length-1
		 */

		int ultimoIndice = arrayObjetos.length - 1;

		int indiceActual = 0;

		// recorrido hacia delante
		System.out.println("Recorrido hacia delante: ");

		while (indiceActual <= ultimoIndice) {
			System.out.println(arrayObjetos[indiceActual]);
			indiceActual++;
			// una vez lo muestra, incrementamos el indiceActual del array
		}

		System.out.println("\n");

		// recorrido hacia atras

		ultimoIndice = 0;
		indiceActual = arrayObjetos.length - 1;

		System.out.println("Recorrido hacia atrás: ");

		while (indiceActual >= ultimoIndice) {
			System.out.println(arrayObjetos[indiceActual]);
			indiceActual--;
		}

		System.out.println("\n");

	}

	private static void recorridoForTradicional(Object[] arrayObjetos) {
		// for (se usa mas este xk no creamos el indice fuera y tal)

		// for hacia delante

		System.out.println("Recorrido for tradicional hacia adelante: ");

		for (int indiceActual = 0; indiceActual <= arrayObjetos.length - 1; indiceActual++) {
			System.out.println(arrayObjetos[indiceActual]);
		}

		System.out.println("\n");

		// for hacia atras

		System.out.println("Recorrido for tradi hacia atras");

		for (int indiceActual = arrayObjetos.length - 1; indiceActual >= 0; indiceActual--) {
			System.out.println(arrayObjetos[indiceActual]);
		}

		System.out.println("\n");
	}

	private static void recorridoForEach(Object[] arrayObjetos) {
		// con este bucle si no necesitaramos saber la posicion y solo
		// kieres sacar los datos y fin con un foreach se puede

		// foreach hacia delante:

		System.out.println("Recorrido foreach hacia delante: ");
		
		for (Object elemento : arrayObjetos) {
			System.out.println(elemento);
		}
		
		System.out.println("\n");
	}
}
