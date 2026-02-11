package unificacion;

// (Del Ejemplo 01 y 02)
// esto siguiente es lo q decia que java ponia como predeterminado si no le indicas
//public class Profesor extends Object {
public class Profesor extends Persona {

	private String titulacionHabilitante;
	
	public Profesor()
	{
		super();
		System.out.println("Constructor profe"); // (Del Ejemplo 03)
	}
	
	// (Del Ejemplo 02) - Sobrecarga de constructores
	public Profesor(String nombre)
	{
		setNombre(nombre);
	}
	
	public Profesor(String nombre, String apellido1)
	{
		setNombre(nombre);
		setApellido1(apellido1);
	}

	public String getTitulacionHabilitante() {
		return titulacionHabilitante;
	}

	public void setTitulacionHabilitante(String titulacionHabilitante) {
		this.titulacionHabilitante = titulacionHabilitante;
	}

	/* (Del Ejemplo 01)
	 * Source - Generate - toString()
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