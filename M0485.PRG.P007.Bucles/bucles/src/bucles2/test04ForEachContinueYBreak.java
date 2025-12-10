package bucles2;

public class test04ForEachContinueYBreak {
	
	public static void test(int limite) {
		
		int valores[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		System.out.println("Inicio bucle foreach con continue: ");
		
		// en eeste ejemplo, x la necesidad del primer break
		// veremos tanto continue y break
		// total ya se le pilla la logica d esto jeje
		
		for(int elemento : valores) {
			
			if (elemento != 0 && elemento % 5 == 0) {
				System.out.println("Salimos del bucle xk " + elemento + " es divisible entre 5");
				break;
			}
			
			// ponemos esto para q no se nos pase del limite q le digamos en main
			
			if (elemento > limite) {
				System.out.println("Llegamos al limite establecido");
				break;
			}
			
			if (elemento % 2 != 0) {
				System.out.println("Impar: " + elemento);
				continue;
			}
			
			System.out.println("Par: " + elemento);
		}
		
		System.out.println("Fin bucle foreach.");
	}

}
