package ejercicio3;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Verificacion de paridad
 * Clase que determina si un numero es par o impar 
 * Usando exclusivamente el operador ternario para la toma de decisiones
 */
public class operadorTernario {

	public static void main(String[] args) {
		// ejercicio 3: Operador ternario
		/*
		 * Solicita un número entero por consola e indica si es par o impar utilizando
		 * exclusivamente el operador ternario. No se permite el uso de if.
		 */
		
		System.out.println("Introduzca un numero entero por favor:"); 
		Scanner scanner = new Scanner(System.in); 
		int num = scanner.nextInt();
		
		String resultado = (num % 2 == 0) ? "Es par." : "Es impar.";
		System.out.println(resultado);
		
		scanner.close();

	}

}
