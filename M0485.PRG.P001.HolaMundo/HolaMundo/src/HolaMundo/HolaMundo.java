package HolaMundo;

// La nomenclatura de este proyecto es así para poder identificar lo que hacemos en clases de forma rápida.

public class HolaMundo {

	public static void main(String[] args) {
		
		// "Hello World!"
		
		// Con este punto de entrada le decimos a JAVA por dónde empezar a ejecutar (es una función/método).
		// El punto de entrada es "main", esto es en total un agrupador de código.
		// void identifica si nos devuelve o no un resultado, en este caso con void no devuelve resultado.
		// return""; sí devolvería datos.
		// Lo que está entre paréntesis son parámetros: String es de tipo alfanumérico. Los [] es que es una lista de strings.
		// Podemos llamar a main como main("Hola", "Qué tal", "adiós"), si no se le da nada no definimos.
		// Con args podemos leer nuestros parámetros.
		
		// Clases de tipos de consola:
		
		// En Java mostramos en la consola con System.out.println
		// Cada instrucción tiene que usar ";"
		
		System.out.println("Hola mundo!");
		System.out.println("Este es nuestro primer programa en JAVA!");
		
		// Aquí llamamos la funcion que hemos declarado abajo para que se muestre en consola
		
		otraFuncion();
		
		// Sigue el orden en cascada/ de forma secuencial!
		// Se pueden bifurcar las instrucciones, usar bucles, condicionales...
		// Todo programa empieza a ejecutarse por un punto, aquí en main por ejemplo.
		// Según las órdenes que le pongamos se irá ejecutando por donde sea que le indiques!
		
		System.out.println("Fin de la ejecución");
		
		otraFuncion2();

	}
	
	// Vamos a crear un 2º método:
	
	public static void otraFuncion() {
		
		// No se ejecutará salvo que lo llame arriba!
		// Hay ciertos lenguajes que para llamar una porción de código necesitas declararlo antes de llamarlo, aquí da igual :D
		
		System.out.println("Otra funcion");
	}
	
	public static void otraFuncion2() {
		
		// El código se agrupa en métodos/funciones para modularizar la info y tener un código limpio y bien estructurado!
		// Dentro de este método puedo llamar otra función declarada también!
		// Se pueden hacer llamadas y subllamadas como queramos/necesitemos!
		// Da igual el lenguaje o sintaxis que esto siempre se ejecuta, es la base de cualquier lenguaje!
		// Todo lo que hagamos tenemos que pensar en el órden del programa, no debe ser aleatorio.
		// Debe comenzar en un punto y que se ejecute de forma ordenada!
		
		System.out.println("Así vemos cómo funciona en cascada arribita ejecutando el código!");
		otraFuncion();
	}

	// Esta llavecita de abajo del todo, en sí las llaves {] indican dónde comienza y terminan los códigos.
	// La ejecución va en el orden que le indiquemos, no existe ningún stop!
	// Cuando veamos bucles CUIIIIIDAO! Estos sí necesitan su stop (breaks) para que no te reviente el pc xd
}