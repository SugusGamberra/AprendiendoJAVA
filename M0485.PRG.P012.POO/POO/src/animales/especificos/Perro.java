package animales.especificos;

import animales.capacidades.IDesplazamientoTerrestre;
import animales.familias.Mamifero;

public class Perro extends Mamifero implements IDesplazamientoTerrestre {

	@Override
	public int getPeriodoLactancia() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getSonido() {
		// TODO Auto-generated method stub
		return "Guau";
	}

	@Override
	public String getDieta() {
		// TODO Auto-generated method stub
		return "Carne";
	}

	@Override
	public int getPromedioVelocidadCorriendo() {
		// TODO Auto-generated method stub
		return 50;
	}

	/* primero tenemos que importarlo
	 * y le damos a heredar y como vemos hereda todo y modificamos
	 * lo de dentro con valores por defecto
	 */
	
}
