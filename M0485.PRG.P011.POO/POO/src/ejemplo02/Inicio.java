package ejemplo02;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {

		int valor1 = 12;
		Alumno pepe = new Alumno();
		pepe.setNotaAcceso(87);
		System.out.println(pepe.getNotaAcceso());
		pepe.setNotaAcceso(5.5f);
		System.out.println(pepe.getNotaAcceso());
		/* esto nos da problemas xk viene de alumnos y como lo hemos
		 * quitado y puesto en persona tenemos que extenderlo en
		 * alumno de persona, ahora si lo reconoceria
		 */
		pepe.setNombre("Pepe");
		System.out.println(pepe.getNombre());

		System.out.println(pepe.toString());
		
		System.out.println("\n");

		Profesor joan = new Profesor();
		joan.setNombre("Joan");
		joan.setApellido1("Gordi");
		joan.setTitulacionHabilitante("ADE");
		System.out.println(joan.toString());

		System.out.println("\n");

		pepe.setNombre("A");
		joan.setNombre("B");

		Administrativo manuel = new Administrativo();
		manuel.setNombre("C");

		Alumno maria = new Alumno();
		maria.setNombre("Maria");

		System.out.println("\n");
		System.out.println(pepe.getNombre());
		System.out.println(maria.getNombre());

//		pepe.setPropiedadComun("Este valor es común para todas las instancias");
//		System.out.println(pepe.getPropiedadComun());
//		System.out.println(maria.getPropiedadComun());
		/* aparece en consola en ambos "alumnos" la propiedad comun
		 * todas comparten la misma instancia
		 * esta seria la diferencia entre static y no static
		 */

		Alumno.setPropiedadComun("Este valor es común para todas las instancias");
		System.out.println(Alumno.getPropiedadComun());

		Profesor montse0 = new Profesor();
		Profesor montse1 = new Profesor("Montse");
		Profesor montse2 = new Profesor("Montse", "García");
		// Profesor montse3 = new Profesor("Montse", "García", "Fernández");

		// Scanner scanner = new Scanner(System.in);
	}

}