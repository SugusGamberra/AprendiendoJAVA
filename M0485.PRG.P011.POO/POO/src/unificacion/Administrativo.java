package unificacion;

public class Administrativo extends Persona {
	
	/* (Del Ejemplo 02 y 03)
	 * esta clase hereda toooodo lo q exista en persona
	 * salvo q le queramos poner algo concreto, podria quedar asi
	 * * siempre hay un constructor sin parametros para esta clase
	 */
	
	public Administrativo() {
		super();
		System.out.println("Constructor administrativo");
	}
}