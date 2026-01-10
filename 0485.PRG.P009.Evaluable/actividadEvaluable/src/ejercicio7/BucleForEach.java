package ejercicio7;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Clase que recibe una frase y la divide en palabras individuales
 * Las recorre mediante un bucle for each
 */

public class BucleForEach {

	public static void main(String[] args) {
		// Enunciado ejercicio 7 - Bucle ForEach:
		/*
		 * Solicita al usuario una frase por consola. Muestra cada palabra de la frase
		 * por separado utilizando un foreach. Nota: Puedes obtener las palabras
		 * separando la frase mediante split(" ") y recorrer el resultado con foreach.
		 */
		
		System.out.println("Introduzca una frase: ");
		Scanner scanner = new Scanner(System.in);
		String frase = scanner.nextLine();
		
		/* he seguido su enunciado, pero aqui se podria poner "\\s+" ?
		 * por si pones muchos espacios que no lo cuente el split?
		 * se lo dejo comentado para testeo el de \\s+
		 */
		String[] palabras = frase.split(" ");
		//String[] palabras = frase.split("\\s+");
		
		System.out.println("\n Desglosando su frase...");
		
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		
		scanner.close();

	}

}
