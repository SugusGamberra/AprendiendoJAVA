package aplicacion2;

public class logica {

	public static void inicio() {
		// crearemos una aplicacion que de una opcion al user y a partir de esa opcion
		// haga una cosa u otra
		// haremos una calculadora, vamos a definir una variable

		int opcion = 0;

		// usamos dowhile porque buscamos si o si que se ejecute la primera vez
		do {
			String menu = configuraMenu();

			// interfazUsuario.muestraMensaje(menu);
			
			// este menu se podria eliminar, yo lo dejo xk es parte de clases
//			interfazUsuario.muestraMensaje("-- MENÚ CALCULADORA --");
//			interfazUsuario.muestraMensaje("1. Sumar");
//			interfazUsuario.muestraMensaje("2. Restar");
//			interfazUsuario.muestraMensaje("3. Multiplicar");
//			interfazUsuario.muestraMensaje("4. Dividir");
//			interfazUsuario.muestraMensaje("5. Módulo (obtener resto)");
//			interfazUsuario.muestraMensaje("0. Salir");
			
			opcion = interfazUsuario.getValorEntero(menu);

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

	private static String configuraMenu() {
		String menu = "\n";
		menu = menu + "-- MENÚ CALCULADORA --";
		menu = menu + "\n";
		menu = menu + "1. Sumar";
		menu = menu + "\n";
		menu = menu + "2. Restar";
		menu = menu + "\n";
		menu = menu + "3. Multiplicar";
		menu = menu + "\n";
		menu = menu + "4. Dividir";
		menu = menu + "\n";
		menu = menu + "5. Módulo (obtener resto)";
		menu = menu + "\n";
		menu = menu + "0. Salir";
		menu = menu + "\n";
		
		return menu;
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
