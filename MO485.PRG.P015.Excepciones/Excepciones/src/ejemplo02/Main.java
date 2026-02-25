package ejemplo02;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		/* Como los metodos creados son no estaticos no se pueden
		 * llamar desde aqui, asi que creamos un objeto de tipo main
		 * ya que no son metodos de instancia
		 * En el main lo gestionamos con trycatch
		 */
		
		Main main = new Main();
		try {
			main.metodo01();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al acceder al fichero.");
		}

	}
	
	private void metodo01() throws FileNotFoundException {
		metodo02();
	}
	
	private void metodo02() throws FileNotFoundException {
		// lo volvemos a gestionar con throws poniendo q no queramos gestionarlo aki
		metodo03();
	}
	
	private void metodo03() throws FileNotFoundException {
		/* Cuando creamos esto nos va a dar 2 opciones, en el ejemplo01
		 * seleccionamos la de crearle un trycatch
		 * Aqui vamos a seleccionar el throw. Aqui no hay error pero en
		 * el metodo02 si aparece error
		 * Con el throw me permite que este metodo haga cosas y si
		 * lanza error lo lanza
		 */
		FileReader fileReader = new FileReader("data.txt");
	}

}
