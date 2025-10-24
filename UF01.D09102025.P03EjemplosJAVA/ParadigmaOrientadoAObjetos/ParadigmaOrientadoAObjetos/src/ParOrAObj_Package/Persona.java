package ParOrAObj_Package;

public class Persona {

	public static void main(String[] args) {
		// Voy a crear a una persona con nombre y edad
		// Y quiero que esta persona me salude
		
		Persona p = new Persona("Sahoro", 22);
		p.saludo();

	}

	String nombre;
	int edad;
	
	Persona(String nombre, int edad){
		this.nombre = nombre;
		this.edad = edad;
		
	}
	
	void saludo() {
		System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
		
	}
}