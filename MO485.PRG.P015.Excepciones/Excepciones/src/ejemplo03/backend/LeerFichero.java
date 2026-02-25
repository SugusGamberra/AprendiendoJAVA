package ejemplo03.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LeerFichero {
	
	public void leer(String rutaFichero) throws FileNotFoundException {
		FileReader fileReader = new FileReader(rutaFichero);
	}

}
