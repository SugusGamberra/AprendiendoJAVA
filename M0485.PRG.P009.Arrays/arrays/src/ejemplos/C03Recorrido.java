package ejemplos;

public class C03Recorrido {
	
	public static void main(String[] args) {
		
		Object[] arrayObjetos = new Object[5];
		arrayObjetos[0] = "Holiwi";
		arrayObjetos[1] = 23;
		arrayObjetos[2] = true;
		arrayObjetos[3] = 10.2;
		arrayObjetos[4] = null;
		
		/* Vamos a ver como recorrre un array
		 * Imaginemos q tiene mogollones d elementos en vez de esto
		 * Lo ideal seria recorrer este array
		 */
		
		// while:
		
		/* Imaginemos q no sabemos la posicion
		 * Creamos un limite
		 * Si no sabemos la dimension concreta usamos el .length-1
		 */
		
		int ultimoIndice = arrayObjetos.length-1;
		
		int indiceActual = 0;
		
		while(indiceActual <= ultimoIndice) {
			System.out.println(arrayObjetos[indiceActual]);
			indiceActual++;
			// una vez lo muestra, incrementamos el indiceActual del array
		}
		
		System.out.println("\n");
		
		// for (se usa mas este xk no creamos el indice fuera y tal)
		for (int i = 0; i < arrayObjetos.length; i++) {
			System.out.println(arrayObjetos[i]);
		}
		
		System.out.println("\n");
		
		// con este bucle si no necesitaramos saber la posicion y solo
		// kieres sacar los datos y fin con un foreach se puede
		
		// foreach:
		
		for (Object elemento : arrayObjetos) {
		    System.out.println(elemento);
		}
	}

}
