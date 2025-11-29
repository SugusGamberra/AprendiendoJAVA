package bucles;

public class ejemplo01While {

	// Este bucle evalua una condicion antes de ejecutar el bloque de codigo
	// si la condicion es true, ejecuta el bloque y vuelve a evaluar
	// si es false desde el inicio, el bloque nunca se ejecuta
	public static void test01() {
		int limite = 0;
		while (limite <= 100) {
			System.out.println("Estoy en un while, valor de la variable limite: " + limite);
			limite = limite + 2;
		}
		System.out.println("Hemos salido del bucle while");

	}

	// cuenta atras
	public static void test02() {
		int limite = 100;
		while (limite >= 0) {
			System.out.println("Estoy en un while tipo cuenta atrás, valor de la variable limite: " + limite);
			limite--; // equivale a liomite = limite - 1
		}
		System.out.println("Hemos salido del bucle while (cuenta atrás)");

	}

}
