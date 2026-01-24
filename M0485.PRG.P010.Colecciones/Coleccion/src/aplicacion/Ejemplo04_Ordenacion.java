package aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejemplo04_Ordenacion {

	public static void main(String[] args) {

		ArrayList<String> listaStrings = new ArrayList<String>();

		ArrayList<String> listaStrings2 = new ArrayList<String>(List.of("A", "B", "C", "D", "E", "F", "G", "H"));

		ArrayList<String> listaStrings3 = null;

		ArrayList<String> listaStrings4 = new ArrayList<String>();

		listaStrings.add("A");
		listaStrings2.add("I");

		// recorrer
		recorrerArrayListCadenas(listaStrings);
		recorrerArrayListCadenas(listaStrings2);
		recorrerArrayListCadenas(listaStrings3);
		recorrerArrayListCadenas(listaStrings4);

	}

	private static void recorrerArrayListCadenas(ArrayList<String> lista) {

		if (lista == null) {

			System.out.println("La lista es nula");

		} else if (lista.isEmpty()) {

			System.out.println("La lista está vacía");

		} else {

			Collections.sort(lista);
			
			System.out.println("---Lista ordenada ascendente----");

			for (String cadena : lista) {
				System.out.println(cadena);
			}
			
			Collections.reverse(lista);
			
			System.out.println("---Lista ordenada descendente----");

			for (String cadena : lista) {
				System.out.println(cadena);
			}
			
		}

	}

}