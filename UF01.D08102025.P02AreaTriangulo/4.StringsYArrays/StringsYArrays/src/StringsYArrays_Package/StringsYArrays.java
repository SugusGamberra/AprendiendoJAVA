package StringsYArrays_Package;

public class StringsYArrays {

	public static void main(String[] args) {
		// Ejemplo de String y Array de Strings
		
		String saludo = "Holiii";
		String[] saludos = {"Hola", "Deuu", "que tal?"};
		
		// String con contenido alfanumérico
		
		String baseAlfanumerica = "10 saluditos para usté";
		
		System.out.println("Ejemplo Strings:");
		System.out.println("Saludo = " + saludo);
		System.out.println("Alfanumérico = " + baseAlfanumerica);
		
		// Para leer todos los elementos del array...
		// Hay que recorrerlos con un bucle
		// en este caso usaremos for
		
		System.out.println("Array:");
		for (int i=0; i < saludos.length; i++) {
			System.out.println("saludos[" + i + "] = " + saludos[i]);
		}
		

	}

}
