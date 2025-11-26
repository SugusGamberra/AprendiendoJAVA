package app;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		// IMPORTANTE!! DESCOMENTA LO QUE NECESITES PARA PROBARLO
		// COMENTA LO QUE NO NECESITES  PARA Q NO INTERFIERA!!
		
		//switch1A();
		//switch1B();
		//switch2();
		//switch3A();
		//switch3B();
		//switch3C();
		switch4A();
		switch4B();

	}

	private static void switch1A() {

		// Haremos una peticion de un dato y lo trataremos con el switch
		// instanciar = asignar un espacio de memoria

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca un número entero: ");
		int dia = scanner.nextInt();

		// el switch sirve para comparar una variable con multiples valores exactos
		// Y PARA EVITAR EL MAL USO DEL IF INFINITO Y ANIDADO 80MILLONES DE VECES :3
		// el default es como el "else"
		// puesto asi lo que ocurre es que si introduces un numero como el 4
		// no te va a mostrar del 1 al 3, te muestra el 4 y en adelante
		// esto puede ser util!
		// a partir de un caso valido el resto es valido
		// para que funcione como un if hay que ponerle un break

		switch (dia) {
		case 1:
			System.out.println("Lunes");
		case 2:
			System.out.println("Martes");
		case 3:
			System.out.println("Miércoles");
		case 4:
			System.out.println("Jueves");
		case 5:
			System.out.println("Viernes");
		case 6:
			System.out.println("Sábado");
		case 7:
			System.out.println("Domingo");
		default:
			System.out.println("Día no estipulado");
		}
	}

	private static void switch1B() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca un número entero para el ejemplo de Break: ");
		int dia = scanner.nextInt();

		// Switch con break
		switch (dia) {
		case 1:
			System.out.println("Lunes Break");
			break;
		case 2:
			System.out.println("Martes Break");
			break;
		case 3:
			System.out.println("Miércoles Break");
			break;
		case 4:
			System.out.println("Jueves Break");
			break;
		case 5:
			System.out.println("Viernes Break");
			break;
		case 6:
			System.out.println("Sábado Break");
			break;
		case 7:
			System.out.println("Domingo Break");
			break;
		default:
			System.out.println("Día no estipulado: Break");
		}
	}

	private static void switch2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca un color: ");
		String color = scanner.next();
		System.out.println("Valor original: " + color);
		color = color.toLowerCase();
		System.out.println("Valor transformado a minusculas: " + color);

		// es sensible al uppercase!
		// para no ahcer mil casos para contemplar cada variante
		// siempre validamos en minusculas y le aplicamos un metodo
		// que seria variable.toLowerCase()
		// esto hace que da igual como lo escribas que lo convierte
		// lo q escribas a minuscula!
		// existen muchisimos metodos super utiles ;P cuestion d echarles un vistacito
		// :P
		// tengo pensado hablarlo en cursos mas adelante asi que paciencia :3
		switch (color) {
		case "rojo":
			System.out.println("red");
			break;
		case "azul":
			System.out.println("blue");
			break;
		case "verde":
			System.out.println("green");
			break;
		case "amarillo":
			System.out.println("yellow");
			break;
		default:
			System.out.println("Color no previsto!");
		}
	}

	private static void switch3A() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el valor 1: ");
		float num1 = scanner.nextFloat();
		System.out.println("Introduzca el valor 2:");
		float num2 = scanner.nextFloat();
		System.out.println("Introduzca la operación a realizar: ");
		String operacion = scanner.next();
		float resultado;

		switch (operacion) {
		case "+":
			resultado = num1 + num2;
			System.out.println("Suma: " + resultado);
			break;
		case "-":
			resultado = num1 - num2;
			System.out.println("Resta: " + resultado);
			break;
		case "*":
			resultado = num1 * num2;
			System.out.println("Multiplicacion: " + resultado);
			break;
		case "/":
			resultado = num1 / num2;
			System.out.println("Division: " + resultado);
			break;
		case "%":
			resultado = num1 % num2;
			System.out.println("Modulo: " + resultado);
			break;
		default:
			System.out.println("Operacion no prevista!");
		}
	}

	// como hariamos el codigo anterior mas corto??

	private static void switch3B() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el valor 1: ");
		float num1 = scanner.nextFloat();
		System.out.println("Introduzca el valor 2:");
		float num2 = scanner.nextFloat();
		System.out.println("Introduzca la operación a realizar: ");
		String operacion = scanner.next();

		switch (operacion) {
		case "+":
			// Forma 1: prescindir de la variable resultado y operar directamente en el log
			System.out.println("Suma: " + (num1 + num2));
			break;
		case "-":
			System.out.println("Resta: " + (num1 - num2));
			break;
		case "*":
			System.out.println("Multiplicacion: " + (num1 * num2));
			break;
		case "/":
			System.out.println("Division: " + (num1 / num2));
			break;
		case "%":
			System.out.println("Modulo: " + (num1 % num2));
			break;
		default:
			System.out.println("Operacion no prevista!");
		}
	}

	private static void switch3C() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca el valor 1: ");
		float num1 = scanner.nextFloat();
		System.out.println("Introduzca el valor 2:");
		float num2 = scanner.nextFloat();
		System.out.println("Introduzca la operación a realizar: ");
		String operacion = scanner.next();
		float resultado = 0;

		switch (operacion) {
		case "+":
			// quitamos aqui el sop y lo ponemos justo debajo del todo que lo saque d un
			// solo log
			resultado = num1 + num2;
			break;
		case "-":
			resultado = num1 - num2;
			break;
		case "*":
			resultado = num1 * num2;
			break;
		case "/":
			resultado = num1 / num2;
			break;
		case "%":
			resultado = num1 % num2;
			break;
		default:
			System.out.println("Operacion no prevista!");
		}

		System.out.println(num1 + operacion + num2 + "= " + resultado);
	}
	
	private static void switch4A() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca un número entero: ");
		int dia = scanner.nextInt();

		switch (dia) {
		case 1:
			System.out.println("Día laborable!");
			System.out.println("A trabajar/estudiar!");
			break;
		case 2:
			System.out.println("Día laborable!");
			System.out.println("A trabajar/estudiar!");
			break;
		case 3:
			System.out.println("Día laborable!");
			System.out.println("A trabajar/estudiar!");
			break;
		case 4:
			System.out.println("Día laborable!");
			System.out.println("A trabajar/estudiar!");
			break;
		case 5:
			System.out.println("Día laborable!");
			System.out.println("A trabajar/estudiar!");
			break;
		case 6:
			System.out.println("Día festivo!");
			System.out.println("A descansar!");
			break;
		case 7:
			System.out.println("Día festivo!");
			System.out.println("A descansar!");
			break;
		default:
			System.out.println("Día no estipulado");
		}
	}
	
	private static void switch4B() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduzca un número entero: ");
		int dia = scanner.nextInt();
		
		// Otra forma de disminuir el codigo tomando el ejemplo anterior:

		switch (dia) {
		case 1, 2, 3, 4, 5:
			System.out.println("Día laborable!");
			System.out.println("A trabajar/estudiar!");
			break;
		case 6, 7:
			System.out.println("Día festivo!");
			System.out.println("A descansar!");
			break;
		default:
			System.out.println("Día no estipulado");
		}
	}
}
