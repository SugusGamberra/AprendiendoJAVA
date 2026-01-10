package ejercicio1;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Metodo principal de ejecucion
 * Gestiona la entrada de datos y la logica de clasificación
 */

public class CondicionalIf {
	/*
	 * Enunciado Ejercicio 1 - Condicional if Solicita al usuario su edad por
	 * consola. • Si es menor de 18, muestra: “Eres menor de edad”. • Si tiene entre
	 * 18 y 64, muestra: “Eres adulto”. • Si tiene 65 o más, muestra: “Eres
	 * jubilado”. Utiliza una estructura if – else if – else.
	 */
	
	public static void main(String[] args) {
		System.out.println("Por favor, introduzca su edad: ");
		
		Scanner peticion = new Scanner(System.in);
		byte edad = peticion.nextByte();
		
		if (edad < 18) {
		    System.out.println("Eres menor de edad.");
		}
		else if (edad <= 64) {
		    System.out.println("Eres adulto.");
		}
		else {
		    System.out.println("Eres jubilado");
		}
		
		peticion.close();

	}
}