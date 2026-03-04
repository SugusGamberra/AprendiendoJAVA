package configuraciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class MiConfiguracion {
	
	/* Para acceder a config.properties si que hay que hardcodearlo
	 * aqui pero vamos, se llama desde aqui
	 * 
	 * Para leer un archivo d propiedades creamos un metodo q m
	 * devuelva un string con la ruta
	 * 
	 * Esta clase solo la uso para buscar estos 2 valores
	 * 
	 * Para leer los archivos definimos un objeto properties, importando
	 * un paquete q almacena en pares d clave y valor
	 * 
	 * Ahora definimos los metodos
	 */
	
	public MiConfiguracion() {
		// para no cargar properties cada vez q instancie clases 
		// creo un metodo d cargar propiedades y lo llamo aqui
		cargarPropiedades();
	}
	
	private void cargarPropiedades() {
		if (properties == null) {
			
			Path ruta = Path.of("config.properties");
			
			try {
				BufferedReader bufferedReader = Files.newBufferedReader(ruta);
				
				properties = new Properties();
				properties.load(bufferedReader);
				
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private Properties properties = null;
	
	//llamada d argumentos
	public String getRutaFichero() {
		return properties.getProperty("ruta", "C:/inexistente.txt");
	}
	
	public boolean getAgregar() {
		String agregar = properties.getProperty("agregar", "0");
		
		if (agregar == "1") {
			return true;
		} else {
			return false;
		}
	}

}
