package bucles2;

public class test01WhileContinue {

	// CONTINUE:
	public static void test(int limite) {
			
		int contador = 0;
		
		System.out.println("Inicio del bucle:");	
		while(contador <= limite) {
			if (contador % 2 != 0) {
				// se cuimple si el resto es distinto a 0:
				/* operacion módulo q devuelve el resto de dividir contador entre 2
				si dividimos un numero entre 2 y da 0 es que es par
				si contador entre 2 es diferente a 0 es que es impar
				con continue aborta la iteracion y vuelve a validar q el contador este dentro del limite
				y vuelve a dar una siguiente vuelta */
				
				contador++; // poniendo los contadorees aqui nos aseguramos q el 0 siempre sea tratado
				continue;
			}
				
			System.out.println("Valor contador: " + contador);
			contador++;
		}
		
		System.out.println("Fin del bucle.");
	}

}
