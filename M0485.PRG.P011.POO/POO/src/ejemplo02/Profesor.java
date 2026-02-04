package ejemplo02;

//public class Profesor extends Object {
public class Profesor extends Persona {

	
	public Profesor()
	{
		
	}
	public Profesor(String nombre)
	{
		setNombre(nombre);
	}
	
	public Profesor(String nombre, String apellido1)
	{
		setNombre(nombre);
		setApellido1(apellido1);
	}
	
	private String titulacionHabilitante;

	public String getTitulacionHabilitante() {
		return titulacionHabilitante;
	}

	public void setTitulacionHabilitante(String titulacionHabilitante) {
		this.titulacionHabilitante = titulacionHabilitante;
	}

	@Override
	public String toString() {
		return "Profesor [getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
				+ ", getApellido2()=" + getApellido2() + ", getTitulacionHabilitante()=" + getTitulacionHabilitante()
				+ "]";
	}

}
