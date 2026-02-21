package ejemplo01;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		
		//codigoNoProtegido();
		codigoProtegido();
		codigoObligatoriamenteProtegido();
		

	}

	private static void codigoNoProtegido() {
		
		int a = 10 / 2;
		System.out.println("Parte correcta que se ejecuta bien: " + a);
		
		// FileReader f = new FileReader("datos.txt"); // si no existe da error FileNotFoundException

		String s = null;
		System.out.println(s.length());

		int x = 10 / 0; // depende de que cosa este antes o despues, tratara el q 1º haya y sacara ese error

		int[] v = new int[3];
		System.out.println(v[5]); // ArrayIndexOutOfBoundsException

	}
	
	private static void codigoObligatoriamenteProtegido() {
		//algunas instrucciones x cojones las tienes q proteger
		//automaticamente con surround te lo pone si le apsas el raton en eclipse x encima a:
		//FileReader f = new FileReader("datos.txt");
		
		try {
			FileReader f = new FileReader("datos.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void codigoProtegido() {

		// manejamos errores con trycatch, protegemos codigo y con los catch vemos q
		// error sale y hacer tratamientos especificos segun el error q se produzca

		try {
			
			codigoNoProtegido();


		} catch (NullPointerException e) {
			System.err.println("Error -1: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println("Error 00: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error 01: " + e.getMessage());
		} catch (RuntimeException e) {
			System.err.println("Error 02: " + e.getMessage());
		} catch (Exception e) {
			// cualquier excepcion, a diferencia de las otras que son especificas
			System.err.println("Error 03: " + e.getMessage());
		} finally {
			System.out.println("Se ejecuta siempre haya o no errores");
		}

		System.out.println("Fin del programa");

	}

	// sin gestion del error saldria abruptamente del programa

}
