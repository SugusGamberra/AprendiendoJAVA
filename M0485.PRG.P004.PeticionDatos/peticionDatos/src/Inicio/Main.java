package Inicio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Imaginemos que tenemos que crear una variable, un espacio en memoria, para indicar el número d aula en la que estamos (int)
		// Si tenemos 25 aulas en el centro y defino:
		byte numAulas1 = 25;
		// estamos reservando un espacio de memoria de valores desde -128 a 128
		// si quisiéramos guardarlo así:
		short numAulas2 = 25;
		// no pasa nada porque cabe, lo mismo pasa con:
		int numAulas3 = 25;
		long numAulas4 = 25;
		// Todas estas creaciones son correctas, si lo mostramos x consola:
		
		System.out.println(numAulas1);
		System.out.println(numAulas2);
		System.out.println(numAulas3);
		System.out.println(numAulas4);
		
		/* aunque no pasa nada la mejor opcion de todas para este ejemplo seria byte
		El motivo es que ocupa menos espacio en ese trocito de memoria en el que se guarda la variable!!
		Es más eficiente por consumo de memoria ;Dç
		En un entorno local da igual usar el que sea aunque consuma mas memoria de la q necesitamos
		Tengamos en cuenta q hoy dia la mayoria de apps se ejecutan en la nube
		Lo q significa que muchaas apps se estan ejecutando a la vez...
		al contratar un server se paga x las características de esa app
		a más memoria más coste, x ende hay que optimizar lo máximo posible el consumo de memoria!
		la austeridad en este sentido es lo mejor */
		
		// PEDIR DATOS POR CONSOLA
		pedirDatos();
		
	}
	
	private static void pedirDatos() {
		/* importamos arribita esto para que funcione, xk de otra no funca
		Para poder trabajar con scanner le tengo q decir d que fuente obtengo los datos
		le diremos q sea la fuente de system.in
		aunque podemos ponerle en la fuelte cualquier tipo de archivo :3 */
		Scanner peticion = new Scanner(System.in);
		/* en peticion imaginemos q queremos pedir una palabra
		definimos una variable (peticion) de tipo scanner, que sirve para pedir datos y que la CPU trabaje con la memoria
		ponemos new (palabra reservada de java), scanner y darle el parametro de la consola del sistema
		muestro x consola el mensaje: */
		System.out.println("Dame un nombre: ");
		// ahora le digo que se quede parada hasta que alguien ponga algo a nivel de consola y le den a enter, que lo almacene en la variable nombre y que lo muestre en consola
		String nombre = peticion.next();
		System.out.println ("Bienvenide " + nombre);
		// sigamos haciendo mas peticiones
		System.out.println("Cual es tu edad?");
		byte edad = peticion.nextByte();
		System.out.println("La edad de " + nombre + " es de " + edad + " años!");
		
		// CONDICIONALES (ya se han visto en fundamentos de la programacion e.e no m repito con explicaciones, mamalo uwu)
		if (edad <= 16) {
			System.out.println("Debes estudiar!!");
		}
		
		else if(edad > 16 && edad <= 65 ) {
			System.out.println("Puedes estudiar o trabajar!");
		}
		else {
			System.out.println("Puedes jubilarte!");
		}
		
	}

	// el ejemplo siguiente de joan es muy lioso
	// respondia la pregunta de "se pueden usar todos los if que queramos dentro de otro if?"
	// long story short: si
	// cuidao al modularizar dsps HAHAHAH
	// como estoy resfriada me da perecita ponerlo todo asi que :P mas facil asi para todos ;D
}
