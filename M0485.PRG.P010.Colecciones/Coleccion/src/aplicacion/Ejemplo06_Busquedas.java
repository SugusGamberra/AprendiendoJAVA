package aplicacion;

import java.util.ArrayList;
import java.util.Collections;

public class Ejemplo06_Busquedas {
	
	public static void main(String[] args) {
		
		// busquedas
		
		ArrayList<String> ciudades = new ArrayList<String>();
		ciudades.add("Sevilla");
		ciudades.add("Cancun");
		ciudades.add("Londres");
		ciudades.add("Venceia");
		ciudades.add("Berlín");
		
		BuscarCiudades(ciudades);
		
		Collections.sort(ciudades);
		BuscarCiudades(ciudades);
		
		Collections.reverse(ciudades);
		BuscarCiudades(ciudades);
		
	}
	
	private static void BuscarCiudades(ArrayList<String> ciudades) {
		
		if (ciudades != null) {
			
			System.out.println("\n");
			
			/*Para comprobar si hay un elemento en una lista lo hacemos con .contains
			 * Esto nos devuelve un boolean
			 * Tambien nos puede interesar ver en que posicion se encunentra una ciudad
			 * Usamos -indexOf, esto me devuelve un valor entero
			 * Cuando no encuentra un elemento, .indexOf devuelve -1
			 */
			
			// comprobar si existe un elemento en la lista
					boolean existeCiudad = ciudades.contains("Sevilla");
					System.out.println(existeCiudad);
					existeCiudad = ciudades.contains("Barna");
					System.out.println(existeCiudad);
					
					// comprobar posicion de un elemento en la lista
					int posicionCiudad = ciudades.indexOf("Cancun");
					System.out.println(posicionCiudad);
					posicionCiudad = ciudades.indexOf("Pekin");
					System.out.println(posicionCiudad);
					
		}
		
		for(String c : ciudades) {
			
			System.out.println(c);
			
		}
		
	}

}
