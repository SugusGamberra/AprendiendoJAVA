package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

import configuraciones.MiConfiguracion;

public class Main {

	// ruta fichero no hardcodeada:
	private static String RUTA1 = null;
	private static boolean AGREGAR = false;
		
	public static void main(String[] args) {

		MiConfiguracion mc = new MiConfiguracion();
		RUTA1 = mc.getRutaFichero();
		AGREGAR = mc.getAgregar();
		
		System.out.println(RUTA1 + " " + AGREGAR);
		
		//escribir();
		//testEscribir();
		testLeer();

	}

	// ruta fichero hardcodeada
	//private static final String RUTA1 = "C:\\Users\\sugus\\Documents\\GitHub\\AprendiendoJAVA\\M0485.PRG.P016.TextFiles.v01\\fichero1.txt";
	private static final String RUTA = "C:\\Users\\sugus\\Documents\\GitHub\\AprendiendoJAVA\\M0485.PRG.P016.TextFiles.v01\\fichero.txt";
	
	private static void escribir() {
		EscribirFichero escribirFichero = new EscribirFichero();
		
		ArrayList<String> lineas = new ArrayList<String>();
		lineas.add("Empieza el ranteo");
		lineas.add("\nÉrase una vez unos compañeros tan maleducados con el tiempo ajeno");
		lineas.add(", que además de no asistir a las clases");
		lineas.add(", cuando asistían era para preguntar lo que ya se ha explicado 40 millones de veces pero como no asisten pues jaja salu2");
		lineas.add("\nLa historia concluye con que:");
		lineas.add("\nSi respiras la lio parda la proxima vez :3");
		
		//para que el user meta cosas tb
		Scanner scanner = new Scanner(System.in);
		System.out.println("Has respirado?");
		lineas.add(scanner.nextLine());
		System.out.println("Tu que opinas?");
		lineas.add(scanner.nextLine());
		
		// llamamos al metodo y le pasamos la ruta y el contenido
		escribirFichero.escribir(RUTA1, AGREGAR, lineas);
	}
	
	private static void testEscribir() {
		
		EscribirFichero escribirFichero = new EscribirFichero();
		
		ArrayList<String> lineas = new ArrayList<String>();
		lineas.add("Testeo");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Escribe algo: ");
		lineas.add(scanner.nextLine());
		System.out.println("Cual es tu comida fav?");
		lineas.add(scanner.nextLine());
		
		escribirFichero.escribir(RUTA, true, lineas);
	}
	
	private static void testLeer() {
		LeerFichero leerFichero = new LeerFichero();
		String contenido = leerFichero.leer(RUTA);
		
		String contenido1 = leerFichero.leer(RUTA1);
		
		System.out.println(contenido);
		System.out.println(contenido1);
	}

}
