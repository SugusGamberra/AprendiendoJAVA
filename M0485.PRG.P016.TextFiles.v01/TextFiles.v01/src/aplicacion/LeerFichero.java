package aplicacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
	
	String leer(String rutaFichero) {
		String contenido = null;
		
		try {
			
			FileReader fileReader = new FileReader(rutaFichero);
			
			// para que sea mas rapido:
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String linea;
			StringBuilder sb = new StringBuilder();
			
			do {
				linea = bufferedReader.readLine();
				
				if (linea != null) {
					sb.append(linea);
					sb.append("\n");
				}
			} while(linea != null);
			
			contenido = sb.toString();
			
			fileReader.close();
			bufferedReader.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return contenido;
	}

}
