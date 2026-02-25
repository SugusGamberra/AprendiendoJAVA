package ejemplo03.frontend.desktop;

import java.io.FileNotFoundException;
import java.util.Scanner;

import ejemplo03.backend.LeerFichero;
import ejemplo04.aplicacionBackend.Apellido1NoInformadoException;
import ejemplo04.aplicacionBackend.EdadInvalidaException;
import ejemplo04.aplicacionBackend.GestionaPersona;
import ejemplo04.aplicacionBackend.NombreNoInformadoException;
import ejemplo04.aplicacionBackend.Persona;

public class PersonaConsola {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nombre:");
		String nombre = scanner.next();
		System.out.println("Apellido 1:");
		String apellido1 = scanner.next();
		System.out.println("Apellido 2:");
		String apellido2 = scanner.next();
		System.out.println("Edad:");
		int edad = scanner.nextInt();
		
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellido1(apellido1);
		persona.setApellido2(apellido2);
		persona.setEdad(edad);
		
		GestionaPersona gestionaPersona = new GestionaPersona();
		// multicatch:
		try {
			gestionaPersona.validarPersona(persona);
		} catch (NombreNoInformadoException | Apellido1NoInformadoException | EdadInvalidaException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}

}
