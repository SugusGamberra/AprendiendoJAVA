package animales.especificos;

import animales.capacidades.IDesplazamientoAereo;
import animales.capacidades.IEntrenable;
import animales.familias.Ave;

public class Halcon extends Ave implements IDesplazamientoAereo, IEntrenable {

	@Override
	public String getSonido() {
		// TODO Auto-generated method stub
		return "Ñiiiii";
	}

	@Override
	public String getDieta() {
		// TODO Auto-generated method stub
		return "Carne";
	}

	@Override
	public int getPromedioVelocidadVuelo() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public int getPromedioAlturaVuelo() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getPeriodoIncubacion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getHabilidades() {
		// TODO Auto-generated method stub
		return "Buscar presas";
	}

	/* los 3 mamiferos que tenemos (ballena, murcielago y perro), desde
	 * el pov de su ambiente son distintos ya q una ballena es de agua,
	 * el perro es terrestre y el murcielago es aereo
	 * 
	 * Nos podria interesar saber su velocidad de desplazamiento
	 * segun su medio natural
	 * 
	 * En el caso del halcon es un ovipero, un ave, no tiene en comun
	 * con murcielago la forma de reproducirse pero si tendrian q tener
	 * una velocidad de vuelo o altura d vuelo, ambos tendrian esa
	 * caracteristica
	 * Si yo en mamifero defino un metodo
	 */
}
