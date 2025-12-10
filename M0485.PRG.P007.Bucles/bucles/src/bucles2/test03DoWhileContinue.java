package bucles2;

public class test03DoWhileContinue {

	public static void test(int limite) {
		
		int contador = 0;

		System.out.println("Inicio del bucle dowhile en continue: ");

		do {
			
			if (contador % 2 != 0) {
				
				System.out.println("Número impar: " + contador);
				contador++;
				continue;
			}
			
			System.out.println("Valor par: " + contador);
			contador++;
			
		} while (contador <= limite);
		
		System.out.println("Fin del bucle dowhile.");
	}

}
