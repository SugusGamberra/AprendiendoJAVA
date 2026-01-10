package ejercicio2;

import java.util.Scanner;


/**
 * @author SugusGamberra
 * @version 1.0
 * Metodo principal de ejecucion
 * Solicita dato numérico y ejecuta la selección del día
 */

public class CondicionalSwitch {

	public static void main(String[] args) {
		/*
		 * Enunciado ejercicio 2: Condicional Switch Pide al usuario un número del 1 al
		 * 7 y muestra el día de la semana correspondiente. • 1 → Lunes • 2 → Martes • 3
		 * → Miércoles • 4 → Jueves • 5 → Viernes • 6 → Sábado • 7 → Domingo Si el
		 * número no es válido, muestra un mensaje de error. Utiliza switch.
		 */

		System.out.println("Por favor, introduzca un número del 1 al 7: ");

		Scanner peticion = new Scanner(System.in);
		int dia = peticion.nextInt();
		
		switch (dia) {
		case 1:
			System.out.println("Lunes");
			break;
		case 2:
			System.out.println("Martes");
			break;
		case 3:
			System.out.println("Miércoles");
			break;
		case 4:
			System.out.println("Jueves");
			break;
		case 5:
			System.out.println("Viernes");
			break;
		case 6:
			System.out.println("Sábado");
			break;
		case 7:
			System.out.println("Domingo");
			break;
		default:
			System.out.println("Error: Dia no estipulado");
		}

		peticion.close();
	}

}
