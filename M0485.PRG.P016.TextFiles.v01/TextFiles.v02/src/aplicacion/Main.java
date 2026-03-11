package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

import configuraciones.MiConfiguracion;

public class Main {

	// ruta fichero no hardcodeada:
	private static String RUTA1 = null;
	private static boolean AGREGAR = false;
		
	public static void main(String[] args) {

		/* Por el patron Singleton, aqui en lugar de
		MiConfiguracion mc = new MiConfiguracion();
		Ponemos
		*/
		MiConfiguracion mc = MiConfiguracion.getInstance();		
		/* Como es la primera vez q la llamamos pasa x null, por ende se instancia y se
		 * pone el objeto en memoria y la devolvemos
		 * 
		 * Si ahora intentamos poner
		 * MiConfiguracion mc2 = MiConfiguracion.getInstance();
		 * Ya no pasa por null, existe en memoria, x lo q devuelve la q esta en memoria
		 */
		
		RUTA1 = mc.getRutaFichero();
		AGREGAR = mc.getAgregar();
		
		System.out.println(RUTA1 + " " + AGREGAR);
		
		escribir();
		//testEscribir();
		testLeer();

	}

	// ruta fichero hardcodeada
	//private static final String RUTA1 = "C:\\Users\\sugus\\Documents\\GitHub\\AprendiendoJAVA\\M0485.PRG.P016.TextFiles.v01\\fichero1.txt";
	private static final String RUTA = "C:\\Users\\sugus\\Documents\\GitHub\\AprendiendoJAVA\\M0485.PRG.P016.TextFiles.v01\\fichero.txt";
	
	private static void escribir() {
		EscribirFichero escribirFichero = new EscribirFichero();
		
		ArrayList<String> lineas = new ArrayList<String>();
		lineas.add("Hola");
		
		//para que el user meta cosas tb
		Scanner scanner = new Scanner(System.in);
		System.out.println("Como estas?");
		lineas.add(scanner.nextLine());
		System.out.println("Que testeo es este?");
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
