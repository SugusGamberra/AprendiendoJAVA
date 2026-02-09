package unificacion;

public class Inicio {

	public static void main(String[] args) {
		
		System.out.println("--- EJEMPLO 01 (Básico) ---");
		// alumno es una clase
		/* (Del Ejemplo 01)
		 * si quiero definir una varaiable sobre la clase alumno
		 * al igual q con scanner, como es un elemento complejo
		 * le metemos new
		 * * Estos son datos estructurados, no datos primitivos como
		 * el de int valor 1 = 12;
		 */
		
		int valor1 = 12;
		
		// Al hacer new Alumno, saltarán los mensajes de los constructores del Ej03
		Alumno pepe = new Alumno(); 
		
		pepe.setNotaAcceso(87);
		System.out.println(pepe.getNotaAcceso());
		pepe.setNotaAcceso(5.5f);
		System.out.println(pepe.getNotaAcceso());
		
		pepe.setNombre("Pepe");
		System.out.println(pepe.getNombre());
		
		System.out.println(pepe.toString());
		
		
		System.out.println("\n--- EJEMPLO 02 (Herencia y Static) ---");
		/* (Del Ejemplo 02)
		 * esto nos da problemas xk viene de alumnos y como lo hemos
		 * quitado y puesto en persona tenemos que extenderlo en
		 * alumno de persona, ahora si lo reconoceria
		 */
		
		// Probamos la propiedad común estática (Del Ejemplo 02)
		// pepe.setPropiedadComun("Este valor es común para todas las instancias");
		/* aparece en consola en ambos "alumnos" la propiedad comun
		 * todas comparten la misma instancia
		 * esta seria la diferencia entre static y no static
		 */
		Alumno.setPropiedadComun("Este valor es común para todas las instancias");
		System.out.println("Propiedad común: " + Alumno.getPropiedadComun());

		Profesor montse0 = new Profesor();
		Profesor montse1 = new Profesor("Montse");
		Profesor montse2 = new Profesor("Montse", "García");
		
		// para sacar ambas cosas en un mismo print concatenamos
		System.out.println(montse2.getNombre() + " " + montse2.getApellido2());
		

		System.out.println("\n--- EJEMPLO 03 (Constructores y Contadores) ---");
		// (Del Ejemplo 03)
		// estos 3 heredan de persona
		
		System.out.println("--> Creando Alumno a1:");
		Alumno a1 = new Alumno();
		
		System.out.println("--> Creando Profesor p1:");
		Profesor p1 = new Profesor();
		
		System.out.println("--> Creando Administrativo ad1:");
		Administrativo ad1 = new Administrativo();
		
		// Verificamos el contador del Ejemplo 03
		System.out.println("\nTotal personas creadas (static): " + Persona.getContadorPersonasCreadas());
	}
}