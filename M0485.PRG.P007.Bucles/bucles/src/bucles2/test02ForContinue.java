package bucles2;

public class test02ForContinue {
	
	public static void test(int limite) {
		
		System.out.println("Inicio del bucle for en continue: ");
		
		for (int contador =0 ; contador <= limite ; contador++ ) {
			
			if (contador % 2 != 0) {
				
				System.out.println("Para que veas, este es el número impar: " + contador);
				continue;
			}
			
			System.out.println("Valor contador: " + contador);
		}
		
		System.out.println("Fin del bucle for.");
	}

}
