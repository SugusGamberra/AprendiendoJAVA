package bucles2;

public class test03DoWhileBreak {

	public static void test(int limite) {

		int contador = 0;

		System.out.println("Inicio del bucle dowhile en break: ");

		do {

			if (contador != 0 && contador % 5 == 0) {

				System.out.println("Salimos del bucle");
				contador++;
				break;
			}

			System.out.println("Valor contador: " + contador);
			contador++;

		} while (contador <= limite);

		System.out.println("Fin del bucle dowhile.");
	}

}
