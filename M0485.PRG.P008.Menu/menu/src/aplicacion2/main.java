package aplicacion2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		interfazUsuario.TIPO_INTERFAZ = "D";
		logica.inicio();
		
		/* si quisieramos hacer esta app en web gracias a la refactorizacion la parte de logica
		 * NO habria que tocarla, vendriamos a interfazUsuario y añadir un 3er tipo de interfaz
		 * asi tenemos un codigo mantenible
		 * en un proyecto pequeñito como esta la logica es el backend
		 * y la interfazUsuario el frontend
		 */
		
	}

}
