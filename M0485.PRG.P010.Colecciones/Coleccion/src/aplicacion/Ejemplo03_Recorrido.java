package aplicacion;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo03_Recorrido {

	public static void main(String[] args) {

		// añadir elementos

		ArrayList<String> listaStrings = new ArrayList<String>();
		ArrayList<Integer> listaEnteros = new ArrayList<Integer>();

		ArrayList<String> listaStrings2 = new ArrayList<String>(List.of("A", "B", "C", "D", "E", "F", "G", "H"));
		ArrayList<Integer> listaEnteros2 = new ArrayList<Integer>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

		/*
		 * a la hora de contar elementos, intentar sacarlo de una lista no inicializada
		 * saca error REcordemos que null es ausencia de valor
		 */
		ArrayList<String> listaStrings3 = null;

		ArrayList<String> listaStrings4 = new ArrayList<String>();

		listaStrings.add("A");
		listaStrings2.add("I");
		listaEnteros.add(1);
		listaEnteros2.add(10);

		// contar elementos
		listaStrings.size();
		System.out.println("Lista Enteros 1: " + listaEnteros.size());
		// System.out.println("LS3: " + listaStrings3.size()); esto daria error
		if (listaStrings3 != null) {
			System.out.println("LS3 : " + listaStrings3.size());
		}

		// recorrer
		recorrerArrayListCadenas(listaStrings);
		recorrerArrayListCadenas(listaStrings2);
		recorrerArrayListCadenas(listaStrings3);
		recorrerArrayListCadenas(listaStrings4);
		recorrerArrayListEnteros(listaEnteros2);

	}

	private static void recorrerArrayListCadenas(ArrayList<String> lista) {

		if (lista == null) {

			System.out.println("La lista es nula");

		} else if (lista.isEmpty()) {

			System.out.println("La lista está vacía");

		} else {

			System.out.println("---Foreach----");

			for (String cadena : lista) {
				System.out.println(cadena);
			}

			System.out.println("---For----");

			for (int posicion = 0; posicion < lista.size(); posicion++) {
				System.out.println(posicion + ": " + lista.get(posicion));
			}

			System.out.println("---While----");

			int posicion = 0;

			while (posicion < lista.size()) {
				System.out.println(posicion + ": " + lista.get(posicion));
				posicion++;
			}
		}

	}

	private static void recorrerArrayListEnteros(ArrayList<Integer> lista) {

		if (lista == null) {

			System.out.println("La lista es nula");

		} else if (lista.isEmpty()) {

			System.out.println("La lista está vacía");

		} else {

			System.out.println("---Foreach----");

			for (int numero : lista) {
				System.out.println(numero);
			}

			System.out.println("---For----");

			for (int posicion = 0; posicion < lista.size(); posicion++) {
				System.out.println(posicion + ": " + lista.get(posicion));
			}

			System.out.println("---While----");

			int posicion = 0;

			while (posicion < lista.size()) {
				System.out.println(posicion + ": " + lista.get(posicion));
				posicion++;
			}

		}

	}

}
