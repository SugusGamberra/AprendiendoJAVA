package bucles2;

public class test02ForBreak {

	public static void test(int limite) {

		System.out.println("Inicio del bucle for en break: ");

		for (int contador = 0; contador <= limite; contador++) {

			if (contador != 0 && contador % 5 == 0) {
				
				System.out.println("Para que veas bien, este número al dividirse entre 5 SÍ da 0: " + contador);

				break;
			}

			System.out.println("Valor contador, este cuando lo divides entre 5 NO da 0: " + contador);
		}

		System.out.println("Fin del bucle for.");
	}

}
