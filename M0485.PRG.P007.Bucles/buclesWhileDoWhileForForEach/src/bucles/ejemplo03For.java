package bucles;

public class ejemplo03For {

	public static void test01() {
		// un bucle for funciona de la siguiente forma
		// tiene 3 partes diferenciadas x un ;
		// en el centor se comprueba la condicion
		// en la inicial se indica o dota de valor a la variable q usamos
		// y en la derecha se hace incremento o decremento de variable
		
		for(int limite =0; limite <= 100; limite++) {
			System.out.println("Estamos en un bucle for, valor de la variable limite: " + limite);
		}
		System.out.println("Fin del bucle for");
	}
	
	public static void test02() {
		
		for(int limite =100; limite >= 0; limite--) {
			System.out.println("Estamos en un bucle for, valor de la variable limite: " + limite);
		}
		System.out.println("Fin del bucle for");
	}

}