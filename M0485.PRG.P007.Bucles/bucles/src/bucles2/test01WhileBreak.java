package bucles2;

public class test01WhileBreak {

	// BREAK:
	public static void test(int limite) {
			
		int contador = 0;
		
		System.out.println("Inicio del bucle:");	
		while(contador <= limite) {
			if (contador != 0 && contador % 5 == 0) {
				// para q ignore el 0, si el contador no es 0 y es divisible entre 5 que salga del bucle
				/* asi salimos incondicionalmente del bucle
				Me interesa salir si el contador sea divisible entre 5
				que salga */
				
				System.out.println("Salimos del bucle incondicionalmente");
				break;
			}
				
			System.out.println("Valor contador: " + contador);
			contador++;
		}
		
		System.out.println("Fin del bucle.");
	}

}