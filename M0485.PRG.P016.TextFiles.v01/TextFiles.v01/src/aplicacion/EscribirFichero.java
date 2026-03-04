package aplicacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class EscribirFichero {

	void escribir(String rutaFichero, boolean sobreescribir, ArrayList<String> contenido) {
		
		try {
			
			//con true no sobreescribimos, se añade lo nuevo al fichero que ya existe
			//hardcodeado
//			FileWriter fileWriter = new FileWriter(rutaFichero, true);
			
			//sin hardcodear
			FileWriter fileWriter = new FileWriter(rutaFichero, sobreescribir);
			
			// clase q tira menos del disco
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			// creamos un bucle para el contenido del array
			for(String linea : contenido) {
//				fileWriter.write(linea);
//				fileWriter.write("\n");
				bufferedWriter.write(linea);
				bufferedWriter.write("\n");
			}
			
			// creamos el contenido y cerramos el fichero
			//fileWriter.write(contenido);
			//fileWriter.close();
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
