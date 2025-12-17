package scannerClose;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// ponemos aqui la peticion
		peticion1 = new Scanner(System.in);
		prueba1();
		prueba1();
		peticion1.close();
	}
	
	/* vamos a ver cómo cerrar scanner
	 * suele venir problemas cuando de alguna manera hago el scanner, lo cierro y luego
	 * vuelvo a instanciarlo (tipo lo llamo arriba 2 veces)
	 * Si quisiera hacer el scanner otra vez el truco es definir la variable a nivel de clase, FUERA
	 * del metodo, asi como cerrarlo fuera
	 * de esta forma no daría error
	 * El hecho de una variable que instancio y cierro dentro da error, el motivo es porque
	 * la peticion lee de System.in y la cierras
	 * System.in NO se puede volver a abrir porque ya está cerrado y estas bloqueando la consola
	 * Y claro nosotros queremos cerrar la variable pero no bloquear la consola
	 * Una opcion seria usar un scanner y nunca cerrarlo, hay que especificar el motivo claro
	 * en un comentario para avisarlo
	 * Podemos pasarlo como parámetro y reutilizarlo
	 */
	
	static Scanner peticion1;
	
	private static void prueba1() {
		// Scanner peticion1 = new Scanner(System.in);
		System.out.println("Valor 1: ");
		int valor1 = peticion1.nextInt();
		System.out.println("Valor 2: ");
		int valor2 = peticion1.nextInt();
		System.out.println("Valor 3: ");
		int valor3 = peticion1.nextInt();
		int resultado = valor1 + valor2 + valor3;
		System.out.println("La suma es " + resultado);
		// peticion1.close();
	}

}
