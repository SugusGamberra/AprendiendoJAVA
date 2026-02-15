package animales.familias;

public abstract class Animal {
	
	/* imaginemos que son animales que tenemos en un zoo y ahi
	 * catalogamos los animales
	 * todos los animales tendran 2 propiedades
	 * Una sera el nombre y para identificarlos un codigo
	 * identificativo
	 * 
	 * ESto son 2 propiedades (codigoIdentificativo y nombre)
	 */
	
	private int codigoIdentificativo;
	private String nombre;
	
	// generamos getters y setters con source - generate getters adn setters
	public int getCodigoIdentificativo() {
		return codigoIdentificativo;
	}
	public void setCodigoIdentificativo(int codigoIdentificativo) {
		this.codigoIdentificativo = codigoIdentificativo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* Los animales emiten ciertos sonidos y cada cual tiene su
	 * alimentacion
	 * La clase animal es muy generica y poco concreta para saber
	 * el sonido o saber q come, hay q concretar mas
	 * 
	 * podriamos retornar un nulo, pero como buena practica lo que
	 * haremos que estos sean abstractos
	 * 
	 * Una clase abstracta implica que de ella no podremos crear
	 * objetos xk no puede hacer new porque tiene partes no concretadas
	 * ni implementadas y java no sabria que ejecutar si llamaramos a
	 * getSonido. Es un nivel bastante inconcreto.
	 * 
	 * Estos metodos se definen aqui a nivel de animal para que consten y
	 * se ponen como abstractos, nos obliga a definir la clase como
	 * abstracta. Si intentara crear un objeto de animal y llamara al
	 * metodo getSonido java no sabria que hacer xk no hay implementacion
	 * del metodo
	 */
	
	public abstract String getSonido();
	
	public abstract String getDieta();
	
//	public int getPromedioAlturaVuelo() {
//		return 0;
//	}
	
	/* con esto me aparecen errores xk lo hemos puesto d ultimas
	 * x definirlo despues, asi q toca implementarlo en todos lados
	 * pero claro, con esto muchas cosas no tendrian sentido para
	 * otro tipo de familia o de animales
	 */
//	public abstract int getPromedioVelocidadVuelo();
//	
//	public abstract int getPromedioVelocidadNado();
//
//	public abstract int getPromedioProfundidadNado();
//
//	public abstract int getPromedioVelocidadCorriendo();
	
}
