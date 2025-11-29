package bucles;

public class ejemplo02DoWhile {

	public static void test01() {
		// nuestro limite es 101
		int limite = 101;

		do {
			System.out.println("Estoy en un dowhile, valor de la variable: " + limite);
			limite++; // aqui se incrementa (102)
		}

		while (limite <= 100); // 102 es menor o igual a 100? no, el bucle se para
		System.out.println("hemos salido del bucle dowhile");
	}
	
	public static void test02() {
		// limite es 0
		int limite = 0;

		do {
			System.out.println("Estoy en un dowhile, valor de la variable: " + limite);
			limite++; // aqui se incrementa
		}

		while (limite <= 100); // hasta que no llegue a 100 no para
		System.out.println("hemos salido del bucle dowhile");
	}


}
