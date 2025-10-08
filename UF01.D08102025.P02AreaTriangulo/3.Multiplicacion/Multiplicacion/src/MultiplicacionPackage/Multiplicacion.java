package MultiplicacionPackage;

public class Multiplicacion {

	public static int multiplicar(int v1, int v2) {
		// Este método es reutilizable para multiplicar 2 int
		// Si te fijas el public static lo he cambiado ;3
		
		return v1 * v2;

	}

	// Ahora sí lo ponemos como siempre
	// String[] args significa que es una variable de memoria, y es un computo de cadenas 
	// String saludo = "Hola" se parece a lo anterior
	// Si string tiene [] significa conjunto de cadenas, en ese espacio lo que hay es un array: 
	// String array = ["Hola", "Adiós"] 
	// String baseAlfanumerica = "10 hola qué tal"
	
	public static void main(String[] args) {
		// Ahora usamos la multiplicacions
		
		int valorCalculado1 = multiplicar(20,30);
		int valorCalculado2 = multiplicar(20,59);
		
		System.out.println("Multiplicaciones: ");
		System.out.println("20 * 30 = " + valorCalculado1);
		// Concepto: Cuando ves que imprimimos en consola usamos:
		// "Texto" + variable
		// El "+" es el acto de concatenar
		// Es una forma de mostrar en 1 sola línea varias variables o strings
		System.out.println("20 * 59 = " + valorCalculado2);
		
		// También puedes usar el método con variables
		
		int a = 7;
		int b = 6;
		System.out.println (a + " * " + b + " = " + multiplicar(a, b));
	}
	
}
