package aplicacion;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo02_Inicializacion {

	public static void main(String[] args) {
		
		// inicializacion arrayList
		
		ArrayList<String> listaStrings = new ArrayList<String> ();
		ArrayList<Integer> listaEnteros = new ArrayList<Integer> ();

		ArrayList<String> listaStrings2 = new ArrayList<String> (
				List.of("A", "B", "C", "D", "E", "F", "G", "H"));
		ArrayList<Integer> listaEnteros2 = new ArrayList<Integer> (
				List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	}
	
}
