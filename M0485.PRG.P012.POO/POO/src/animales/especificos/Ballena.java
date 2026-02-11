package animales.especificos;

import animales.capacidades.IDesplazamientoAcuatico;
import animales.familias.Mamifero;

public class Ballena extends Mamifero implements IDesplazamientoAcuatico {

	@Override
	public int getPeriodoLactancia() {
		// TODO Auto-generated method stub
		return 24;
	}

	@Override
	public String getSonido() {
		// TODO Auto-generated method stub
		return "uuuuu";
	}

	@Override
	public String getDieta() {
		// TODO Auto-generated method stub
		return "Plancton";
	}

	@Override
	public int getPromedioProfundidadNado() {
		// TODO Auto-generated method stub
		return 3000;
	}

	@Override
	public int getPromedioVelocidadNado() {
		// TODO Auto-generated method stub
		return 200;
	}

}
