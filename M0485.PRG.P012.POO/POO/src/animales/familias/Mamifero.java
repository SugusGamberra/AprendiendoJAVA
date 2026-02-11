package animales.familias;

public abstract class Mamifero extends Animal {
	
	/* esta clase va a tener algun metodo mas y acabara heredando de
	 * Animal.java
	 * 
	 * Si lo extendemos con extends Animals sale error, tenemos 2
	 * opciones: añadir los metodos no implementados o q lo transforme
	 * a abstracta asi que de momento lo implementamos
	 * 
	 * con esto nos encontramos en la obligacion d q sea abstracto
	 */
	
//	@Override
//	public String getSonido() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getDieta() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/* a nivel d mamifero nos interesa tener mas cosas como el periodo
	 * de lactancia tienen aunque dependera d cada animal cada uno
	 * tendra su cosa, x lo q se recomienda q sea abstract
	 * 
	 * Asi que todo lo anterior lo quitamos y creamos esta clase
	 * como abstracta tb, asi que ya si aqui dentro tenemos exactamente
	 * lo mismo heredado de animal y a nivel de mamifero tenemos
	 * este otro dato
	 * 
	 * esto lo ponemos aqui porque tiene mas sentido que ponerlo en
	 * animal xk no tendria sentido x ejemplo la velocidad de correr
	 * para un pescao
	 */
	
	public abstract int getPeriodoLactancia();
	
//	public int getPromedioAlturaVuelo() {
//		return 0;
//	}
//	
//	public int getPromedioVelocidadVuelo() {
//		return 0;
//	}
//	
//	public int getPromedioVelocidadNado() {
//		return 0;
//	}
//
//	public int getPromedioProfundidadNado() {
//		return 0;
//	}
//
//	public int getPromedioVelocidadCorriendo() {
//		return 0;
//	}
//	
}
