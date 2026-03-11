package configuraciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class MiConfiguracion {
	
	/* lo ideal seria q durante toda la ejecucion es q solo hubiera 1 solo objeto en vez
	 * de varios
	 * 
	 * el proximo dia vamos a probar una optimizacion
	 */
	
	// PATRON SINGLETON!!!! Pasamos d public a private y...
	//public MiConfiguracion() {
	private MiConfiguracion() {
		// para no cargar properties cada vez q instancie clases 
		// creo un metodo d cargar propiedades y lo llamo aqui
		cargarPropiedades();
	}
	
	/* Ahora lo que hacemos es crear una variable privada de esta clase
	 * Luego creamos un metodo publico estatico para poderlo llamar sin pasar x la clase
	 * que devolvera una variable q llamaremos getInstance
	 * Dentro hacemos comprobaciones
	 */
	
	private static MiConfiguracion instance = null;
	
	public static MiConfiguracion getInstance() {
		if (instance == null) {
			instance = new MiConfiguracion();
		}
		
		return instance;
	}
	// fin patron singleton
	
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
	
	// para el salto de linea q no este hardcodeado
	public String getSaltoLinea() {
		return properties.getProperty("salto_linea", "\n");
	}

}
