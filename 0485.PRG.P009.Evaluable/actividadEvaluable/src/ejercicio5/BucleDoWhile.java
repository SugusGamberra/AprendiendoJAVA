package ejercicio5;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Menú con 3 opciones que invocan un mensaje o sale del menú
 * Implementa un sistema de navegacion por menu en consola
 * Uso de bucle post condicional para garantizar que las opciones se muestren al menos una vez antes de evaluar la salida
 */


public class BucleDoWhile {

	public static void main(String[] args) {
		/*
		 * enunciado ejercicio 5 - do..while 
		 * Muestra un menú que se repita hasta que el
		 * usuario decida salir. Opciones: 1. Mostrar un saludo 2. Mostrar un mensaje
		 * informativo 3. Salir • Si la opción no es válida, muestra un mensaje de
		 * error. • El programa debe ejecutarse al menos una vez. Utiliza do-while.
		 */
		
		Scanner scanner = new Scanner(System.in);
		int opcion;
		
		do {
			// hago uso del salto de parrafo q enseñaste, el \n!!
			System.out.println("\n ---Menú principal---");
			System.out.println("1. Mostrar saludo");
			System.out.println("2. Mostrar mensaje informativo");
			System.out.println("3. Salir");
			
			opcion = scanner.nextInt();
			
			// ya sabe que me gusta usar switch jeje y en esta ocasion creo que es lo mas limpio para procesar la opcion elegida
			switch (opcion) {
				case 1:
					System.out.println("Hola! Cómo estás? Ten lindo día!");
					break;
				case 2:
					System.out.println("Info valiosa: Esperón es un cantante cuyas letras son muy profundas y tiene una voz preciosa!");
					break;
				case 3:
					System.out.println("Ha solicitado salir.");
					break;
				default:
					System.out.println("Error: Ups, tecla incorrecta, inténtalo de nuevo!");
			}
		} while (opcion != 3);
		
		scanner.close();
		
	}

}