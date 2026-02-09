package ejemplo03;

// por defecto hereda de object
public class Alumno extends Persona {

	// Constructor por defecto
	// Aunque no esté escrito explícitamente
	public Alumno() {
		System.out.println("Constructor alumno");
	}

	private float notaAcceso;

	public float getNotaAcceso() {
		return notaAcceso;
	}

	public void setNotaAcceso(float notaAcceso) {

		if (notaAcceso >= 0 && notaAcceso <= 10) {
			this.notaAcceso = notaAcceso;
		} else {
			System.err.println("El rango válido es de 0 a 10");
		}
	}

	@Override
	public String toString() {
		return "Alumno [getNotaAcceso()=" + getNotaAcceso() + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getApellido1()=" + getApellido1() + ", getApellido2()=" + getApellido2() + "]";
	}

}
