package aplicacion;

import animales.capacidades.IDesplazamientoAereo;
import animales.especificos.Halcon;
import animales.especificos.Murcielago;
import animales.especificos.Perro;
import animales.familias.Animal;
import animales.familias.Mamifero;

public class Inicio {

	public static void main(String[] args) {
		// esto no podriamos hacerlo

//		Animal animal1 = new Animal();
//		Mamifero mamifero1 = new Mamifero();
		
		// esto si podemos
		Perro perro1 = new Perro();
		
		Murcielago murcielago1 = new Murcielago();
		Halcon halcon1 = new Halcon();
		
		// vuela(perro1) no deja xk obv no vuela
		vuela(murcielago1);
		vuela(halcon1);
		
	}

	private static void vuela(IDesplazamientoAereo volador) {
		volador.getPromedioAlturaVuelo();
		volador.getPromedioVelocidadVuelo();
	}
}
