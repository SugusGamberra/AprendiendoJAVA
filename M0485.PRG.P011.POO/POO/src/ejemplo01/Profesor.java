package ejemplo01;

//public class Profesor extends Object {
public class Profesor {

	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String titulacionHabilitante;

	
	// Source - Generate - Getters and Setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTitulacionHabilitante() {
		return titulacionHabilitante;
	}

	public void setTitulacionHabilitante(String titulacionHabilitante) {
		this.titulacionHabilitante = titulacionHabilitante;
	}

	/* Source - Generate - toString()
	 * Nos recomienda marcar Methods
	 * Los inherited methods no se marca, pero nos explica que
	 * @Override es que damos contenido a un metodo que existe en
	 * una clase de la cual heredamos (extends Object)
	 * Todos los metodos publicos es como si formaran parte de la
	 * clase profesor aunque no esten definidos
	 */
	
	@Override
	public String toString() {
		return "Profesor [getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
				+ ", getApellido2()=" + getApellido2() + ", getTitulacionHabilitante()=" + getTitulacionHabilitante()
				+ "]";
	}

}
