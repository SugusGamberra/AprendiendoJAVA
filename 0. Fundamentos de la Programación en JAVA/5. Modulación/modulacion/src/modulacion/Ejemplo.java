package modulacion;

public class Ejemplo {

	public static void main(String[] args) {
		
		saludarUser("sugus");
		
		int resultadoSuma = sumarNumeros(2, 3);
		System.out.println("Resultado : " + resultadoSuma);

	}
	
	public static void saludarUser(String nombre) {
		System.out.println("Hola " + nombre + "! Q tal?");
	}
	
	public static int sumarNumeros(int a, int b) {
		int suma = a + b;
		return suma;
	}

}
