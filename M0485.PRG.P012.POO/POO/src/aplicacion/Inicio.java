package aplicacion;

import java.util.ArrayList;

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
		perro1.setNombre("Zagara");
		perro1.setCodigoIdentificativo(1);
		perro1.getCodigoIdentificativo();
		perro1.getDieta();
		perro1.getHabilidades();
		perro1.getNombre();
		perro1.getPeriodoLactancia();
		perro1.getPromedioVelocidadCorriendo();
		
		Murcielago murcielago1 = new Murcielago();
		murcielago1.setCodigoIdentificativo(2);
		murcielago1.setNombre("Bobby");
		Halcon halcon1 = new Halcon();
		halcon1.setCodigoIdentificativo(12);
		halcon1.setNombre("Lady Halcon");
		
		// vuela(perro1) no deja xk obv no vuela
		System.out.println("Murciélago");
		vuela(murcielago1);
		System.out.println("Halcón");
		vuela(halcon1);
		
		ArrayList<Animal> animales = new ArrayList<Animal>();
		animales.add(perro1);
		animales.add(murcielago1);
		animales.add(halcon1);
		listaAnimales(animales);
		
	}

	private static void vuela(IDesplazamientoAereo volador) {
		System.out.println(volador.getPromedioAlturaVuelo());
		System.out.println(volador.getPromedioVelocidadVuelo());
	}
	
	private static void listaAnimales(ArrayList<Animal> lista) {
		
		for (Animal animal : lista) {
			
			System.out.println(animal.getCodigoIdentificativo() + " " + animal.getNombre());
		}
	}
}
