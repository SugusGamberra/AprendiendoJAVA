package ejemplo01;

public class Inicio {

	public static void main(String[] args) {
		// alumno es una clase
		/* si quiero definir una varaiable sobre la clase alumno
		 * al igual q con scanner, como es un elemento complejo
		 * le metemos new
		 * 
		 * Estos son datos estructurados, no datos primitivos como
		 * el de int valor 1 = 12;
		 */
		
		int valor1 = 12;
		
		Alumno pepe = new Alumno();
		
		pepe.setNotaAcceso(87);
		System.out.println(pepe.getNotaAcceso());
		pepe.setNotaAcceso(5.5f);
		System.out.println(pepe.getNotaAcceso());
		
		pepe.setNombre("Pepe");
		System.out.println(pepe.getNombre());
		
		System.out.println(pepe.toString());
		
		Profesor joan = new Profesor();
		
		joan.setNombre("Joan");
		
		joan.setApellido1("Gordi");
		
		joan.setTitulacionHabilitante("ADE");
		
		System.out.println(joan.toString());

	}

}
