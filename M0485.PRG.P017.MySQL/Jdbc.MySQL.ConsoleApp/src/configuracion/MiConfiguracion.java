package configuracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class MiConfiguracion {

	private static Properties properties = null;

	private static MiConfiguracion instance = null;

	private MiConfiguracion() {
		cargarPropiedades();
	}

	public static MiConfiguracion getInstance() {
		if (instance == null) {
			instance = new MiConfiguracion();
		}
		return instance;
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

	public String getUrl() {
		return properties.getProperty("url", "Falta URL");
	}

	public String getUser() {
		return properties.getProperty("user", "Falta User");
	}

	public String getPassword() {
		return properties.getProperty("password", "Falta Password");
	}

}