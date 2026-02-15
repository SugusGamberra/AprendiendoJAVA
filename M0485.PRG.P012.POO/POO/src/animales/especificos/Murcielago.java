package animales.especificos;

import animales.capacidades.IDesplazamientoAereo;
import animales.familias.Mamifero;

public class Murcielago extends Mamifero implements IDesplazamientoAereo {

	@Override
	public int getPeriodoLactancia() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getSonido() {
		// TODO Auto-generated method stub
		return "Tii-tii-tii";
	}

	@Override
	public String getDieta() {
		// TODO Auto-generated method stub
		return "Insectos-Carne";
	}

	@Override
	public int getPromedioVelocidadVuelo() {
		// TODO Auto-generated method stub
		return 90;
	}

	@Override
	public int getPromedioAlturaVuelo() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	/* digamos q en comun ballena murcielago perro todos emiten sonido
	 * tienen codigo identificativo (como su nombre en latin( o el
	 * periodo de lactancia
	 */
	
	

}
