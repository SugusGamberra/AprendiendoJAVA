package ejemplo04.aplicacionBackend;

public class GestionaPersona {
	
	public void validarPersona(Persona persona) throws NombreNoInformadoException, Apellido1NoInformadoException, EdadInvalidaException {
		if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
			throw new NombreNoInformadoException("Nombre incompleto");
		}
		
		if (persona.getApellido1() == null || persona.getApellido1().isEmpty()) {
			throw new Apellido1NoInformadoException("Apellido 1 incompleto");
		}
		
		if (persona.getEdad() < 0 || persona.getEdad() > 120) {
			throw new EdadInvalidaException("Edad no debe ser inf a 0 ni sup a 120");
		}
	}

}
