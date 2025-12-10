package aplicacion2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class interfazUsuario {
	
	/* aqui trasladamos todo lo que tenga que ver con la comunicacion con el usuario
	 * y lo de mostrar el mensaje para mostrar info
	 * asi centralizamos el uso de la consola
	 * con todo esto funcionando vamos a añadir lo siguiente
	 * y preveemos 2 valores:
	 * - C: Consola
	 * - D: Desktop
	 */
	
	public static String TIPO_INTERFAZ = "C";
	
	public static void muestraMensaje(String mensaje) {
		if (TIPO_INTERFAZ == "C") {
			System.out.println(mensaje);
		} else if (TIPO_INTERFAZ == "D") {
			// esto viene un poco mal xk hemos previsto el codigo para q sea en mensaje para el usuario
			// ahora vamos a mostrar un mensaje en una ventana (Desktop)
			// Se usa el metodo JOptionPane
			JOptionPane.showMessageDialog(null, mensaje, "Desktop", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	public static int getValorEntero(String mensaje) {
		int valor = 0;
		muestraMensaje(mensaje);
		Scanner scanner = new Scanner(System.in);
		valor = scanner.nextInt();

		return valor;
	}
	
	public static double getValorDouble(String mensaje) {
		double valor = 0;
		muestraMensaje(mensaje);
		Scanner scanner = new Scanner(System.in);
		valor = scanner.nextDouble();

		return valor;
	}

}
