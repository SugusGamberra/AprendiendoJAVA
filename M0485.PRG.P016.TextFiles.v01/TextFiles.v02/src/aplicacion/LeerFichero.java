package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import configuraciones.MiConfiguracion;

public class LeerFichero {
	
	// Quitamos esto x el patron singleton
//	MiConfiguracion mc = new MiConfiguracion();
	MiConfiguracion mc = MiConfiguracion.getInstance();
	
	String saltoLinea = mc.getSaltoLinea();
	
	String leer(String rutaFichero) {
		/* sera bastante similar al de escritura
		 * Primero esto nos devuelve un string y vamos a crear un contenido
		 */
		String contenido = null;
		
		try {
			
			Path path = Paths.get(rutaFichero);
			
			//usaremos bufferedReader aqui
			BufferedReader bufferedReader = Files.newBufferedReader(
					path,
					StandardCharsets.UTF_8);
			
			String linea = null;
			StringBuilder sb = new StringBuilder();
			
			while((linea = bufferedReader.readLine()) != null) {
				sb.append(linea);
				/* esto es hardcodeado, en windows funciona pero igual en otro lao no
				 * es mejor añadirlo a config properties y rescatarlo de la clase
				 * MiConfiguracion
				 */
				//sb.append("\n");
				sb.append(saltoLinea);
			}
			
			contenido = sb.toString();
				
			bufferedReader.close();
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
		return contenido;
	}

}
