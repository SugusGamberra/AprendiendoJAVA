package aplicacion2;

public class main {

	public static void main(String[] args) {
		/* vamos a refactorizar un poco lo que hemos hecho en la aplicacion1!
		 * ahora tenemos la logica de lo que estamos haciendo habiendo movido las cosas a interfazUsuario
		 * nos quedamos ya por aqui, se continua el sabado!
		 */
		
		interfazUsuario.TIPO_INTERFAZ = "C";

		int opcion = 0;

		do {
			String menu = "\n"; // esto significa salto de linea \n
			menu = menu + " -- MENÚ CALCULADORA -- ";
			menu = menu + "\n";
			menu = menu + "-- 1. Sumar --";
			menu = menu + "\n";
			menu = menu + "-- 2. Restar --";
			menu = menu + "\n";
			menu = menu + "-- 3. Multiplicar --";
			menu = menu + "\n";
			menu = menu + "-- 4. Dividir --";
			menu = menu + "\n";
			menu = menu + "-- 5. Módulo (obtener resto) --";
			menu = menu + "\n";
			menu = menu + "-- 0. Salir --";
			menu = menu + "\n";
			
			interfazUsuario.muestraMensaje(menu);
			
//			interfazUsuario.muestraMensaje("-- MENÚ CALCULADORA --");
//			interfazUsuario.muestraMensaje("1. Sumar");
//			interfazUsuario.muestraMensaje("2. Restar");
//			interfazUsuario.muestraMensaje("3. Multiplicar");
//			interfazUsuario.muestraMensaje("4. Dividir");
//			interfazUsuario.muestraMensaje("5. Módulo (obtener resto)");
//			interfazUsuario.muestraMensaje("0. Salir");
			
			opcion = interfazUsuario.getValorEntero("Introduzca una opción:");

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
				interfazUsuario.muestraMensaje("Opción no disponible");
			}
		} while (opcion != 0);

	}

	

	private static void sumar() {
		interfazUsuario.muestraMensaje("-- SUMA --");
		double valor1 = interfazUsuario.getValorDouble("Valor 1:");
		double valor2 = interfazUsuario.getValorDouble("Valor 2:");
		double resultado = valor1 + valor2;

		interfazUsuario.muestraMensaje("Resultado: " + resultado);
	}

	private static void restar() {
		interfazUsuario.muestraMensaje("-- RESTA --");
		double valor1 = interfazUsuario.getValorDouble("Valor 1:");
		double valor2 = interfazUsuario.getValorDouble("Valor 2:");
		double resultado = valor1 - valor2;

		interfazUsuario.muestraMensaje("Resultado: " + resultado);
	}

	private static void multiplicar() {
		interfazUsuario.muestraMensaje("-- MULTIPLICACIÓN --");
		double valor1 = interfazUsuario.getValorDouble("Valor 1:");
		double valor2 = interfazUsuario.getValorDouble("Valor 2:");
		double resultado = valor1 * valor2;

		interfazUsuario.muestraMensaje("Resultado: " + resultado);
	}

	private static void dividir() {
		interfazUsuario.muestraMensaje("-- DIVISIÓN --");
		double valor1 = interfazUsuario.getValorDouble("Valor 1:");
		double valor2 = interfazUsuario.getValorDouble("Valor 2:");
		double resultado = valor1 / valor2;

		interfazUsuario.muestraMensaje("Resultado: " + resultado);
	}

	private static void modulo() {
		interfazUsuario.muestraMensaje("-- RESTO --");
		double valor1 = interfazUsuario.getValorDouble("Valor 1:");
		double valor2 = interfazUsuario.getValorDouble("Valor 2:");
		double resultado = valor1 % valor2;

		interfazUsuario.muestraMensaje("Resultado: " + resultado);
	}

}
