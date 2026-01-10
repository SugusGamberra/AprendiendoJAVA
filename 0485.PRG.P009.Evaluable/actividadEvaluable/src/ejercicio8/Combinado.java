package ejercicio8;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Clase que procesa entradas numéricas hasta recibir un valor de salida (-1)
 * Realiza una clasificacion estadistica (positivo-negativo-0) y contea resultados
 */

public class Combinado {

	public static void main(String[] args) {
		/*
		 * ejercicio 8 - combinado (condicionales y bucles) 
		 * Pide números por consola
		 * hasta que el usuario introduzca -1. Para cada número introducido: • Indica si
		 * es positivo, negativo o cero. Al finalizar, muestra cuántos números positivos
		 * se han introducido. Utiliza: • while • if • Entrada de datos por consola
		 * 
		 */
		
		int numero;
		int positivos = 0;
		
		System.out.println("Introduzca números enteros (-1 para salir): ");
		Scanner scanner = new Scanner(System.in);
		numero = scanner.nextInt();
		
		while (numero != -1) {
			if (numero > 0) {
				System.out.println("El número " + numero + " es positivo.");
				positivos++;
			} else if (numero < 0) {
				System.out.println("El número " + numero + " es negativo.");
			} else {
				System.out.println("El número introducido es 0.");
			}
			
			System.out.println("Introduzca otro número, por favor: ");
			numero = scanner.nextInt();
		}
		
		System.out.println("\n Fin del bucle y el condicional!");
		System.out.println("Total de números positivos introducidos: " + positivos);
		
		// me he dado cuenta al llegar a esta altura del ejercicio
		// que usted mismo decia que usaramos el .close() hahaha
		scanner.close();

	}
	
	/* Ando haciendo el calendario de adviento de js por cierto!
	 * Te lo paso porque esta divertido!! A mi me cuesta mucho rato pero seguro que tu los haces en 20 minutos :D
	 * https://adventjs.dev/es
	 * feliz navidad!!!
	 */

}
