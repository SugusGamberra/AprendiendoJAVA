package ejercicio4;

import java.util.Scanner;

/**
 * @author SugusGamberra
 * @version 1.0
 * Clase que procesa una secuencia indefinida de numeros hasta encontrar el 0
 * Calcula la suma total y la cantidad de entradas
 */

public class BucleWhile {

	public static void main(String[] args) {
		/*
		 * Enunciado ejercio 4: bucle while Pide números enteros por consola hasta que
		 * el usuario introduzca un 0. Al finalizar, muestra: • El total de números
		 * introducidos (sin contar el 0). • La suma de todos los números introducidos.
		 * Utiliza un bucle while.
		 */

		/*
		 * voy a hacer las variables con los contadores a 0, una para la suma y otra del
		 * contador y debajo voy a poner el scanner con la variable que va almacenando
		 * los numeros
		 */

		int suma = 0;
		int contador = 0;

		System.out.println("Por favor, introduzca números enteros a continuación (0 para terminar): ");
		Scanner peticion = new Scanner(System.in);
		int numero = peticion.nextInt();

		// mientras sea el numero diferente a 0:
		while (numero != 0) {
			// hace la operacion, incremento el contador y voy pidiendo mas numeros al usuario
			suma = suma + numero;
			contador++;

			System.out.println("Introduzca otro número por favor: ");
			numero = peticion.nextInt();
		}

		System.out.println("Ha pulsado 0, fin del programa.");
		System.out.println("La suma de todos sus números introducidos: " + suma);
		System.out.println("Ha introducido un total de " + contador + " números!");

		// como hemos aprendido esto y lo puedo usar aqui, pues jeje
		peticion.close();

	}

}
