package ejemplo03;

/* como alumno y profesor tienen cosas en comun hemos creado esta clase
 * para que alumno y profe hereden de esta
 */

public class Persona {
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	// tenemos aqui el constructor de persona
	
	public Persona() {
		System.out.println("Constructor de persona");
		contarNuevaPersonaCreada();
	}
	
	// los hacemos estaticos para llamar la variable a nivel d clase de persona
	private static int contadorPersonasCreadas = 0;
	
	public static void contarNuevaPersonaCreada() {
		contadorPersonasCreadas++;
	}
	
	public static int getContadorPersonasCreadas() {
		return contadorPersonasCreadas;
	}
	
	

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
		if (nombre != null && !nombre.isEmpty() && nombre.length() >= 2) {
			this.nombre = nombre;
		} else {
			System.err.println("El nombre debe tener almenos dos caracteres");
		}

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

}