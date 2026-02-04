package ejemplo01;

/* esto son clases de procesos, xk tenemos metodos en ellas,
 * propiedades y demas variables
 * 
 * Existen clases mas de tipo entidad que muestran unos datos estructurados
 * que tienen que ver con el dominio de la app
 * 
 * El dominio en estos ejemplos son las clases como alumnos, profesores,
 * podriamos hacer una de asignatuars...
 */

public class Alumno {

	/* protegemos estas clases de que se le añada info de forma
	 * desestructurada
	 * Controlamos con getters y setters que datos entran
	 */
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private float notaAcceso;
	
	
	public String getDni() {
		return dni;
		
	/* hacemos clic derecho, source, generate getters and setters
	* toqueteamos las configs (select all y de momento no tocamos nada mas
	*/
		
	}
	
	// GETTERS Y SETTERS
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		if (nombre != null && !nombre.isEmpty() && nombre.length() >= 2) {
			
			this.nombre = nombre;
			
		} else {
			System.err.println("El nombre debe tener al menos 2 caracteres");
		}
		
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
	public float getNotaAcceso() {
		return notaAcceso;
	}
	public void setNotaAcceso(float notaAcceso) {
		if (notaAcceso >= 0 && notaAcceso <= 10) {
			this.notaAcceso = notaAcceso;
		} else {
			System.err.println("El rango valido es de 0 a 10");
		}
		this.notaAcceso = notaAcceso;
	}
	
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", notaAcceso=" + notaAcceso + "]";
	}
	
}
