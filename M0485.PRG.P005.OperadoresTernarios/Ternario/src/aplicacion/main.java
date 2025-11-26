package aplicacion;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Hemos visto el if, ahora se verá el equivalente
		// Operador ternario!!
		// Primero pedimos q se introduzcan los datos x consola:

		System.out.println("Introduzca su edad!");
		Scanner scanner = new Scanner(System.in);
		byte edad = scanner.nextByte();

		// Creamos una variable que almacene la expresión que quiero validar y un ?
		// Se valida si es mayor igual a 18
		// Si cumple eso sale "Mayor de edad"
		// En caso contrario (:) sale "Menor de edad"

		String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
		System.out.println(resultado);

		// Obtenemos el mismo resultado que en if pero con una estructura más pequeña
		// Si quisiera usar más casuísticas, no podría usar el operador ternario
		// Ya que este solo valida una condicion
		// podriamos prescindir incluso de lo de arriba;

		System.out.println("El resultado de la otra forma: " + ((edad >= 18) ? "Mayor de edad" : "Menor de edad"));

		// Esto me dará el mismo resultado que la forma anterior

		// En Source - Format, formatea nuestro código, tipo las posiciones de las
		// llaves y tal para que ocupe menos sitio

		// vamos a lanzar lo del private
		operadoresMatematicos(edad);

	}

// Operadores matemáticos

	private static void operadoresMatematicos(byte edad) {
		// sumar
		short resultado = (short) (edad + (short) 2);
		System.out.println("+" + resultado);
		// restar
		resultado = (short) (edad - (short) 2);
		System.out.println("-" + resultado);
		// multiplicar
		resultado = (short) (edad * (short) 2);
		System.out.println("*" + resultado);
		// dividir, obtenemos cociente
		resultado = (short) (edad / (short) 2.0f);
		System.out.println("/" + resultado);
		// resto
		resultado = (short) (edad % (short) 2.0f);
		System.out.println("%" + resultado);

		// Módulo para saber si un número es par o impar
		// si hacemos el módulo de la edad y el resto es 0...

		String tipoNumero;

		if (edad % 2.0f == 0) {
			tipoNumero = "par";
		} else {
			tipoNumero = "impar";
		}

		System.out.println("La edad es " + tipoNumero);

		// para pasarlo al operador ternario seria:

		String tipoNumero2 = (edad % 2.0f == 0) ? "Edad es par!" : "Edad es impar!";
		System.out.println("Operador ternario: " + tipoNumero2);

	}

// ternario anidado

	private static void anidamientos(byte edad) {
		String franjaEdad = (edad >= 90) ? "Muy mayor uwu" :
							(edad >= 80) ? "Octogenario" :
								(edad >= 70) ? "Septuagenario" :
									"Aún un yogurin ñ.ñ";
	}
}
