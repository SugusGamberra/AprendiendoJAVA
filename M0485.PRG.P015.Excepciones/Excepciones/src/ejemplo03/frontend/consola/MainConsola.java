package ejemplo03.frontend.consola;

import java.io.FileNotFoundException;

import ejemplo03.backend.LeerFichero;

public class MainConsola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeerFichero leerFichero = new LeerFichero();
		try {
			leerFichero.leer("datos.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Error acceso a fichero");
		}
	}

}
