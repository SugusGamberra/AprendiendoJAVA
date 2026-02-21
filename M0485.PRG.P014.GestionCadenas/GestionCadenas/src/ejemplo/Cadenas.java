package ejemplo;

import java.time.Duration;
import java.time.LocalDateTime;

/* esto es algo que se hara habitualmente x ej para importar ficheros, discos, etc
 * existe un metodo q optimizara esto muchisimo
 */

public class Cadenas {

	public static void main(String[] args) {
		// Se puede poner un _ en el numero, lo sigue interpretando como 100000

		cadenasString(200_000);
		cadenasStringBuilder(200_000);
	}
	
	private static void cadenasString(int numeroConcatenaciones) {
		
		// para medir lo que tardamos usamos:
		LocalDateTime inicio = LocalDateTime.now();
		
		String cadena = "";
		
		/* la cadena en cada vuelta le ponemos lo que habia mas lo
		 * que vaya sumando
		 */
		for(int i = 0; i <= numeroConcatenaciones; i++) {
			
			cadena = cadena + i + ",";
		}
		
		// proceso finalizado
		LocalDateTime fin = LocalDateTime.now();
		
		//restar las fechas para ver lo que tarda
		long segundos = Duration.between(inicio, fin).getSeconds();
		//System.out.println(cadena);
		System.out.println("Cadena (segundos): " + segundos);
		
	}
	
	private static void cadenasStringBuilder(int numeroConcatenaciones) {
		
		// esto es un constructor de cadenas
			
		/* a nivel de codigo es basicamente lo mismo pero se tarda mucho menos en
		* concatenar
		* Es mejor usar string builder si no sabemos cuantos elementos vamos a concatenar
		* Esto en C# pasa lo mismo por el diseño que tienen JAVa y C#
		*/
			
		LocalDateTime inicio = LocalDateTime.now();
		
		StringBuilder cadena = new StringBuilder();
		cadena.append("");
		
		for(int i = 0; i <= numeroConcatenaciones; i++) {
			
			cadena.append(i + ",");
		}
		
		// proceso finalizado
		LocalDateTime fin = LocalDateTime.now();
		
		// se puede hacer tb en nanosegundos
		long nano = Duration.between(inicio, fin).getNano();
		//System.out.println(cadena.toString()); esto peta y hace q desaparezcan logs asi q comentado
		System.out.println("Cadena SB (nano-segundos): " + nano);
		
	}

}
