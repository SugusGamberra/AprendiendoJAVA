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
			JOptionPane.showMessageDialog(null, mensaje, "Calculadora", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	// A partir de un mensaje nos devuelve un valor entero
	public static int getValorEntero(String mensaje) {
		int valor = 0;
		/* vamos a cambiar esto un poco
		 * aqui haremos la comprobacion de que si es consola o si es desktop
		 * cuando sea desktop haremos algo similar al JOptionPane
		 */
		
		if (TIPO_INTERFAZ == "C") {
			muestraMensaje(mensaje);
			Scanner scanner = new Scanner(System.in);
			valor = scanner.nextInt();
			// scanner.close();
		} else if (TIPO_INTERFAZ == "D") {
			// lo que el user ponga aqui me lo devuelve en forma de String!!!
			// tengo que transformar este valorDevuelto a una de tipo int para poder operar!!
			String valorDevuelto = JOptionPane.showInputDialog(null, mensaje, "Calculadora", JOptionPane.QUESTION_MESSAGE);
			// tenemos una opcion para transformar una cadena (siempre que tenga numeros)
			// parseInt es un metodo q recibe como parametro una cadena y me la devuelve como valor numerico!
			
			valor = Integer.parseInt(valorDevuelto);
		}

		return valor;
	}
	
	// nos devuelve un double
	public static double getValorDouble(String mensaje) {
		double valor = 0;

		if (TIPO_INTERFAZ == "C") {
			muestraMensaje(mensaje);
			Scanner scanner = new Scanner(System.in);
			valor = scanner.nextDouble();
			// scanner.close();
		} else if (TIPO_INTERFAZ == "D") {
			String valorDevuelto = JOptionPane.showInputDialog(null, mensaje, "Calculadora", JOptionPane.QUESTION_MESSAGE);
			valor = Double.parseDouble(valorDevuelto);
		}

		return valor;
	}

}
