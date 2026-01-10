package ejercicio6;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Clase que solicita un numero entero positivo y genera su tabla de multiplicar (1 a 10)
 * Usa un bucle for con validación de entrada para descartar numeros negativos
 */

public class BucleFor {

	public static void main(String[] args) {
		/*
		 * Enunciado ejercicio 6 - Bucle for: 
		 * Solicita al usuario un número entero
		 * positivo y muestra su tabla de multiplicar del 1 al 10. Ejemplo: 5 x 1 = 5 5
		 * x 2 = 10 Utiliza un bucle for
		 */

		System.out.println("Introduzca un número entero y positivo para ver su tabla de multiplicar por favor: ");
		Scanner scanner = new Scanner(System.in);
		int numero = scanner.nextInt();
		
		if (numero > 0) {

			System.out.println("Tabla del " + numero + ":");
			
			for (int i = 1; i <= 10; i++) {
				int resultado = numero * i;
				System.out.println(numero + " x " + i + " = " + resultado);
			}
		} else {
			System.out.println("Has introducido un número negativo! Vuelve a introducir un número positiov por favor!");
		}
		
		scanner.close();
		
	}

}
