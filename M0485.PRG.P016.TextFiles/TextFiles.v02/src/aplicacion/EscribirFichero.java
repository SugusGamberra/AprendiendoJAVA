package aplicacion;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribirFichero {
	
	//metodo
	void escribir(String rutaFichero, boolean agregar, ArrayList<String> contenido) {
		
		/* en vez de filereader usamos path
		 * este paquete esta en nio, es la nueva version de la parte d entrada y salida
		 * de ficheros
		 * 
		 * Este path es el equivalente NIO a FileReader/Writer
		 * Representa la ruta del fichero en disco de forma más moderna y flexible
		 * 
		 * importamos el buffered writter xk es optima para esto
		 */
		
		
		
		Path path = Paths.get(rutaFichero);
		
		StandardOpenOption modoApertura = null;
		
		if (agregar) {
			modoApertura = StandardOpenOption.APPEND;
		} else {
			modoApertura = StandardOpenOption.TRUNCATE_EXISTING;
		}
		
		/* instanciamos el bufferedWriter con un metodo estatico d la clase files y le
		 * pasamos los parametros del path, la codificacion d caracteres con las q trabajamos
		 * y una serie d opciones para crear este fichero
		 * 
		 * Este Files.newBufferedWriter crea un BufferedWriter de forma directa, sin 
		 * FileWriter como en IO clásico
		 * 
		 * El StandardCharset UTF_8 indica el encoding, los caracteres que vamos a lanzar
		 * Así estandarizamos los caracteres. Si intento leer el fichero con una codificacion
		 * ANSI en vez de leer una a lee un 8, por la codificacion y la falta de estandar
		 * Especificamos el encoding explicitamente (BUENA PRACTICA!!!)
		 * 
		 * El StandardOpenOption.CREATE crea el fichero si NO existe
		 * 
		 * El StandardOpenOption.APPEND le decimos que añada, no que trunque ni sobreescriba
		 * nada. Vamos a definir arriba una variable y su lógica con condicional. En el caso
		 * de que exista el archivo que agregue (append) al archivo si no truncate el archivo
		 * 
		 * El modoApertura depende del parámetro agregar
		 */
		
		try {
			BufferedWriter bufferedWriter = Files.newBufferedWriter(
					path, 
					StandardCharsets.UTF_8, 
					StandardOpenOption.CREATE,
					modoApertura);
			
			/* comprobamos q el contenido no sea nulo
			 * bufferedWriter en vez de salto de linea con \n existe bufferedWriter.newLine();
			 */
			
			if (contenido != null && contenido.size() > 0) {
				for(String linea : contenido) {
					bufferedWriter.write(linea);
					bufferedWriter.newLine();
				}
			}
			
			//liberamos la memoria
			bufferedWriter.close();
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
