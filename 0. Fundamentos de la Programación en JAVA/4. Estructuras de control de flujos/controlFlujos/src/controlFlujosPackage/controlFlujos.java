package controlFlujosPackage;

public class controlFlujos {

	public static void main(String[] args) {
		// ESTRUCTURAS DE CONTROL DE FLUJOS!!
		
		// If-else
		
		int edad = 20;

		if (edad >= 18) {
		    System.out.println("Eres mayor de edad!!");
		} else {
		    System.out.println("tas chikito uwu no puedes pasar!!!");
		}
		
		// Else if
		
		int nota = 7;

		if (nota == 10) {
		    System.out.println("boh, fieroteeee!!");
		} else if (nota >= 6) {
		    System.out.println("not bad");
		} else if (nota == 5) {
		    System.out.println("por los pelosssss");
		} else {
		    System.out.println("palmaste colega :c");
		}
		
		// Switch
		
		String comando = "atacar";

		switch (comando) {
		    case "atacar":
		        System.out.println("Has lanzado un ataque");
		        break;
		    case "defender":
		        System.out.println("Te has defendido!");
		        break;
		    case "usarItem":
		        System.out.println("Abres la mochila...");
		        break;
		    default:
		        System.out.println("No se reconoce este comando");
		}
		
		// Enhanced switch
		
		comando = "defender";

		switch (comando) {
		    case "atacar" -> System.out.println("Has lanzado un ataque");
		    case "defender" -> System.out.println("Te has defendido!");
		    case "usarItem" -> System.out.println("Abres la mochila...");
		    default -> System.out.println("No se reconoce este comando");
		}
		
		// While
		
		int contador = 1;

		while (contador <= 5) {
		    System.out.println("El contador vale: " + contador);
		    contador++;
		}

		System.out.println("El bucle while ha terminado!");
		
		// Do...while
		
		contador = 100;

		do {
		    System.out.println("El contador vale: " + contador);
		    contador++;
		} while (contador <= 5);

		System.out.println("El bucle do-while ha terminado! El contador vale: " + contador);
		
		// For
		
		for (int i = 0; i < 5; i++) {
		    System.out.println("Repeticion del numero " + i);
		}
		
		// For each
		
		String[] lstInvitados = {"Sahoro", "Gemma", "Anastasio", "Alisa Melano"};

		for (String nombre : lstInvitados) {
		    System.out.println("Bienvenide mi estimade " + nombre);
		}

		System.out.println("Lista finalizada");

	}

}
