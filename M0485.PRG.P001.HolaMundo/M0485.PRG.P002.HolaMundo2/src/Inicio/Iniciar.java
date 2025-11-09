package Inicio;

import Calculo.areaRectangulo;

// Podemos usar un * arriba en vez de areaRectangulo para que importe TODO, quedando así:
// import Calculo.*;
// Pero es recomendable importa solo lo que neceistamos

public class Iniciar {

	public static void main(String[] args) {
		// Si queremos llamar lo del calculo lo podemos hacer llamándolo directamente:
		// calculo.AreaRectangulo.calculaArea(10, 50);
		// O arriba, debajo de package, lo importamos, que es tal cual vas a ver este código!
		
		// Empieza a calcular desde nuestro primer println, pasa por la importacion, y de ahi vuelve para el ultimo println!
		
		System.out.println("Inicio de la ejecución: ");
		areaRectangulo.calculaArea(10, 50);
		Calculo.areaTriangulo.calculaArea(10, 50);
		System.out.println("Fin de la ejecución.");
		
		// Con esta forma evitamos el código spaghetti, que es tener 20 mil cosas en un mismo código.
		// Evitamos redundancia y no repetirnos (DRY = Don't Repeat Yourself).

	}

}
