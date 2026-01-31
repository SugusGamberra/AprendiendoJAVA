package aplicacion;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejemplo07_Conversiones {

	public static void main(String[] args) {

		ArrayList<String> listaCiudades = new ArrayList<String>();
		listaCiudades.add("Sevilla");
		listaCiudades.add("Cancun");
		listaCiudades.add("Londres");
		listaCiudades.add("Venceia");
		listaCiudades.add("Berlín");

		/*
		 * si quisieramos pasar esto a un array podriamos pasarlo de forma manual pero
		 * es mas laborioso
		 */

		// DE ARRAY LIST A ARRAY
		// forma manual
		String[] arrayCiudades = convertirColeccionesEnArraysManualmente(listaCiudades);
		if (arrayCiudades != null) {

			System.out.println("Forma manual de array list a array:");

			for (String c : arrayCiudades) {

				System.out.println(c);

			}

			System.out.println("\n");
		}

		// forma con .toArray
		String[] arrayCiudades1 = listaCiudades.toArray(new String[listaCiudades.size()]);
		if (arrayCiudades1 != null) {

			System.out.println("Forma con .toArray de array list a array:");

			for (String c : arrayCiudades1) {

				System.out.println(c);
			}

			System.out.println("\n");
		}

		// DE ARRAY A ARRAY LIST
		ArrayList<String> listaCiudades2 = new ArrayList<String>(Arrays.asList(arrayCiudades));

		if (listaCiudades2 != null) {

			System.out.println("De array a array list:");

			for (String c : listaCiudades2) {

				System.out.println(c);
			}

			System.out.println("\n");
		}

	}

	private static String[] convertirColeccionesEnArraysManualmente(ArrayList<String> listaCiudades) {

		String[] arrayCiudades = null;

		if (listaCiudades != null) {

			// saber numero d elementos d la lista e iniciar array con los elementos q necesitare
			int elementosLista = listaCiudades.size();
			arrayCiudades = new String[elementosLista];

			// pasar cada elemento d la lista con un for

			int posicionActual = 0;

			for (String c : listaCiudades) {

				arrayCiudades[posicionActual] = c;
				posicionActual++;

			}

		}

		return arrayCiudades;

	}

}
