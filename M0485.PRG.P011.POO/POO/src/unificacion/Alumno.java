package unificacion;

/* (Del Ejemplo 01)
 * esto son clases de procesos, xk tenemos metodos en ellas,
 * propiedades y demas variables
 * * Existen clases mas de tipo entidad que muestran unos datos estructurados
 * que tienen que ver con el dominio de la app
 * * El dominio en estos ejemplos son las clases como alumnos, profesores,
 * podriamos hacer una de asignatuars...
 */

// (Del Ejemplo 02)
// por defecto hereda de object
public class Alumno extends Persona {

	/* (Del Ejemplo 01)
	 * protegemos estas clases de que se le añada info de forma
	 * desestructurada
	 * Controlamos con getters y setters que datos entran
	 */
	
	// (Del Ejemplo 02 y 03)
	// Constructor por defecto
	// Aunque no esté escrito explícitamente
	public Alumno() {
		super(); // Llama a Persona
		System.out.println("Constructor alumno"); // (Del Ejemplo 03)
	}

	private float notaAcceso;

	public float getNotaAcceso() {
		return notaAcceso;
	}
	
	/* (Del Ejemplo 01)
	 * hacemos clic derecho, source, generate getters and setters
	 * toqueteamos las configs (select all y de momento no tocamos nada mas
	 */

	public void setNotaAcceso(float notaAcceso) {

		if (notaAcceso >= 0 && notaAcceso <= 10) {
			this.notaAcceso = notaAcceso;
		} else {
			System.err.println("El rango valido es de 0 a 10");
		}
	}

	@Override
	public String toString() {
		return "Alumno [getNotaAcceso()=" + getNotaAcceso() + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getApellido1()=" + getApellido1() + ", getApellido2()=" + getApellido2() + "]";
	}
}