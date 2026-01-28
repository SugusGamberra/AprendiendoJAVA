package aplicacion;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejemplo05_CRUD {

	// Create Read Update Delete

	public static void main(String[] args) {
		// ahora entendemos que String[] args es un array, podriamos trabajar asi:

		/*
		 * if (args != null && args.length > 0) {
		 * 
		 * }
		 */

		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();

		agregarElementos(listaNumeros);
		recorrerLista(listaNumeros);

		modificarElementos(listaNumeros);
		// recorrerLista(listaNumeros);

//		buscarElementosPorIndice(listaNumeros);
//		recorrerLista(listaNumeros);
//		
		// alterarListaMientrasRecorremos(listaNumeros);
		solucionAlterarListaMientrasRecorremos(listaNumeros);
		recorrerLista(listaNumeros);

//		eliminarElementos(listaNumeros);
//		recorrerLista(listaNumeros);

	}

	// añadir elementos

	private static void agregarElementos(ArrayList<Integer> listaNumeros) {

		System.out.println("---Agregar elementos---");

		if (listaNumeros != null) {
			// agregarlos consecutivamente
			listaNumeros.add(-10);
			listaNumeros.add(1);
			listaNumeros.add(2);
			listaNumeros.add(3);
			listaNumeros.add(4);
			listaNumeros.add(5);

			// insertar elementos por indice
			listaNumeros.add(1, 11); // en posicion 1 se inserta elemento con valor 11
			// el resto d elementos a partir de esta posicion se desplaza hacia delante

			/*
			 * En un array esto seria mas laborioso Un array tiene una dimension fija Si
			 * quisieramos añadir un elemento en la pos 1 y directamente añado como vemos
			 * 
			 * int[] arrayNumeros = {-11, 1, 2, 3, 4, 5}; int [1] = -10;
			 * 
			 * el resultado seria que el 1 desaparece y sustituye viendose asi: -11 -10 2 3
			 * 4 5
			 * 
			 * Si quiero insertar, conque la dimension es fija tendre que crear otro array
			 * con un elemento mas e insertar en la pos 1 el -10
			 */
		}

		System.out.println("\n");
	}

	// obtener un elemento

	private static void buscarElementosPorIndice(ArrayList<Integer> listaNumeros) {

		if (listaNumeros != null) {
			int elemento1 = listaNumeros.get(1);
			int elementoPrimero = listaNumeros.getFirst();
			int elementoUltimo = listaNumeros.getLast();

			System.out.println("---Buscar elementos por indice---");
			System.out.println(elemento1);
			System.out.println(elementoPrimero);
			System.out.println(elementoUltimo);
			System.out.println("\n");
		}

	}

	// recorrer lista

	private static void recorrerLista(ArrayList<Integer> listaNumeros) {
		// opcion 1: if (listaNumeros != null && listaNumeros.size() > 0)
		// opcion2:
		if (listaNumeros != null && !listaNumeros.isEmpty()) {

			System.out.println("---Recorrer la lista---");

			for (int i : listaNumeros) {
				System.out.println(i);
			}

			System.out.println("\n");
		}
	}

	// modificar elementos
	private static void modificarElementos(ArrayList<Integer> listaNumeros) {

		System.out.println("---Modificar elementos---");

		if (listaNumeros != null) {
			/*
			 * si quisieramos modificar el elemento de la posicion 4... sustituimos el valor
			 * que hubiera x un 44
			 */

			listaNumeros.set(4, 44);
		}

		System.out.println("\n");
	}

	// eliminar elementos

	private static void eliminarElementos(ArrayList<Integer> listaNumeros) {

		System.out.println("---Eliminar elementos---");

		if (listaNumeros != null) {

			// eliminamos el elemento de la pos 1
			listaNumeros.remove(1);

			// elimina el primer elemento de la lista
			// listaNumeros.remove(listaNumeros);
			listaNumeros.removeFirst();

			// eliminar el ultimo elemento d la lista
			listaNumeros.removeLast();
		}

		System.out.println("\n");
	}

	// agregar elementos mientras se recorre una lista
	private static void alterarListaMientrasRecorremos(ArrayList<Integer> listaNumeros) {

		if (listaNumeros != null && !listaNumeros.isEmpty()) {

			System.out.println("---Alterar la lista mientras la recorremos---");

			int posicion = 0;

			for (int valor : listaNumeros) {
				System.out.println("Posicion: " + posicion + ", valor: " + valor);

				if (valor == 44) {
					listaNumeros.set(posicion, 444);
					/*
					 * en este caso se puede modificar pero no se puede eliminar elementos porque se
					 * rompe, obtendremos un concurrent modification excepction
					 */
				}

//				if (valor == 2) {
//					listaNumeros.remove(posicion);
//					/* vemos en el log que a partir de aqui un error
//					 * no se puede eliminar de forma concurrente
//					 */
//				}

				posicion++;
			}

			System.out.println("\n");
		}
	}

	// solucion a alterar la lista mientras se recorre
	private static void solucionAlterarListaMientrasRecorremos(ArrayList<Integer> listaNumeros) {

		if (listaNumeros != null && !listaNumeros.isEmpty()) {

			System.out.println("---Solucion a alterar la lista mientras la recorremos---");

			/* la clave de esto es usar un iterador
			 * es la referencia para alterar la lista mientras se recorre
			 * en lugar de recorrer la lista directamente vamos a recorrer el iterador
			 */
			
			Iterator<Integer> iterador = listaNumeros.iterator();
			
			int posicion = 0;

			while(iterador.hasNext()) {
				int valor = iterador.next();
				System.out.println("Posicion: " + posicion + ", valor: " + valor);
				
				if (valor == 44) {
					listaNumeros.set(posicion, 444);
				}
				
				if (valor == 2) {
					/* aqui eliminamos sobre el ITERADOR
					 * no es necesario pasarle la posicion ya que con el if te estas
					 * posicionando sobre el elemento que quieres borrar
					 */
					iterador.remove();
				}
				
				posicion++;
			}

			System.out.println("\n");
		}
	}
}
