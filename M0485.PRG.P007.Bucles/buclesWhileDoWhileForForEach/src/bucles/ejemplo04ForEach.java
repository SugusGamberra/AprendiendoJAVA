package bucles;

public class ejemplo04ForEach {

	public static void test01() {
		/* for each
		a parte de variables unidimensionales me puedo crear array unidimensional aka matrices unidimensionales (como una lista de numeros)
		*/
		
		// array unidimensional
		// esta estructura la puedo recorrer iterativamente
		int numeros1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// podemos mostrar el valor q hay en el indice que elijamos dentro de lo que existe
		System.out.println(numeros1[0]);
		System.out.println(numeros1[3]);
		System.out.println(numeros1[9]);
		
		// int numeros2[] = new int[9];
		
		// para recorrer un array lo hacemos con un for each
		// que recorra el array y que me vaya devolviendo los elementos
		
		for( int elemento: numeros1) {
			System.out.println(elemento);
			System.out.println("Podemos operar con los elementos como elemento * 2: " + elemento*2);
		}
		
		// cuando aprendamos a sacar las BBDD, usaremos algo muy parecido para recorrerlas ;P

	}
	
	public static void test02() {
		
		String cadenas[] = {"Patri", "Jesús", "Joan", "Jessy", "Carlos" };
		
		for( String elemento: cadenas) {
			System.out.println(elemento);
		}
		
	}

}
