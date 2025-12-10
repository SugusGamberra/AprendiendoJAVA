package aplicacion1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// crearemos una aplicacion que de una opcion al user y a partir de esa opcion
		// haga una cosa u otra
		// haremos una calculadora, vamos a definir una variable

		int opcion = 0;

		// usamos dowhile porque buscamos si o si que se ejecute la primera vez
		do {
			muestraMensaje("-- MENÚ CALCULADORA --");
			muestraMensaje("1. Sumar");
			muestraMensaje("2. Restar");
			muestraMensaje("3. Multiplicar");
			muestraMensaje("4. Dividir");
			muestraMensaje("5. Módulo (obtener resto)");
			muestraMensaje("0. Salir");
			opcion = getValorEntero("Introduzca una opción:");

			switch (opcion) {
			case 1:
				sumar();
				break;
			case 2:
				restar();
				break;
			case 3:
				multiplicar();
				break;
			case 4:
				dividir();
				break;
			case 5:
				modulo();
				break;
			case 0:
				break;
			default:
				muestraMensaje("Opción no disponible");
			}
		} while (opcion != 0);

	}

	private static void muestraMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static int getValorEntero(String mensaje) {
		int valor = 0;
		System.out.println(mensaje);
		Scanner scanner = new Scanner(System.in);
		valor = scanner.nextInt();

		return valor;
	}

	private static void sumar() {
		muestraMensaje("-- SUMA --");
		double valor1 = getValorDouble("Valor 1:");
		double valor2 = getValorDouble("Valor 2:");
		double resultado = valor1 + valor2;

		muestraMensaje("Resultado: " + resultado);
	}

	private static void restar() {
		muestraMensaje("-- RESTA --");
		double valor1 = getValorDouble("Valor 1:");
		double valor2 = getValorDouble("Valor 2:");
		double resultado = valor1 - valor2;

		muestraMensaje("Resultado: " + resultado);
	}

	private static void multiplicar() {
		muestraMensaje("-- MULTIPLICACIÓN --");
		double valor1 = getValorDouble("Valor 1:");
		double valor2 = getValorDouble("Valor 2:");
		double resultado = valor1 * valor2;

		muestraMensaje("Resultado: " + resultado);
	}

	private static void dividir() {
		muestraMensaje("-- DIVISIÓN --");
		double valor1 = getValorDouble("Valor 1:");
		double valor2 = getValorDouble("Valor 2:");
		double resultado = valor1 / valor2;

		muestraMensaje("Resultado: " + resultado);
	}

	private static void modulo() {
		muestraMensaje("-- RESTO --");
		double valor1 = getValorDouble("Valor 1:");
		double valor2 = getValorDouble("Valor 2:");
		double resultado = valor1 % valor2;

		muestraMensaje("Resultado: " + resultado);
	}

	private static double getValorDouble(String mensaje) {
		double valor = 0;
		System.out.println(mensaje);
		Scanner scanner = new Scanner(System.in);
		valor = scanner.nextDouble();

		return valor;
	}

}
