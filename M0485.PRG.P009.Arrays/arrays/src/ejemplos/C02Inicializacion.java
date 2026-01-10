package ejemplos;

public class C02Inicializacion {

	public static void main(String[] args) {
		// Ahora vamos a inicializar los arrays
		/*
		 * Tenemos la declaracion de las clases: Para inicializarla...
		 */

		// Declaracion d arrays
		int[] arrayInt;

		/*
		 * Bien se puede hacer del tiron o declarandola y luego asignarle valor Los
		 * objetos requieren de la clausula new Declaramos con una posicion fija, ya lo
		 * tenemos en memoria con 5 posiciones
		 */

		// Inicializacion de arrays con 5 pos
		arrayInt = new int[5];

		// Tambien lo podemos hacer asi que seria declarandolo a la vez:

		int[] arrayEnteros = new int[5];

		/*
		 * Para ver el valor d cada posicion definimos una variable de tipo int De esta
		 * posicion le digo q me devuelva el valor de la primera posicion Puedo hacer lo
		 * mismo para cada posicion
		 */

		int valorPosicion0 = arrayEnteros[0];
		int valorPosicion1 = arrayEnteros[1];
		int valorPosicion2 = arrayEnteros[2];
		int valorPosicion3 = arrayEnteros[3];
		int valorPosicion4 = arrayEnteros[4];

		System.out.println(valorPosicion0);
		System.out.println(valorPosicion1);
		System.out.println(valorPosicion2);
		System.out.println(valorPosicion3);
		System.out.println(valorPosicion4);

		// todos tienen el valor 0 en consola

		/*
		 * Para asignar un valor en la posicion n lo hacemos igual q para ver el valor
		 */

		arrayEnteros[2] = 25;

		System.out.println("\n -------");
		System.out.println(arrayEnteros[2]);

		/*
		 * si yo intento consultar o setear un valor a una posicion fuera del array Como
		 * no existe nos dara un error (array index out of bounds exception) ya que no
		 * existe un sexto elemento
		 */

		System.out.println("\n");
		// System.out.println(arrayEnteros[5]);

		/*
		 * hay una segunda forma de inicializarlos indicandole ya directamente los
		 * elementos q tendra
		 */

		int arrayEnteros1[] = new int[] { 10, 23, 43, 32, 8 };
		System.out.println(arrayEnteros1[0]);
		System.out.println(arrayEnteros1[1]);
		System.out.println(arrayEnteros1[2]);
		System.out.println(arrayEnteros1[3]);
		System.out.println(arrayEnteros1[4]);

		// Declaro e inicializo array d doubles d 10 pos
		double[] arrayDoubles = new double[10];
		System.out.println("\n");
		System.out.println(arrayDoubles[0]);
		System.out.println(arrayDoubles[1]);
		System.out.println(arrayDoubles[2]);
		System.out.println(arrayDoubles[3]);
		System.out.println(arrayDoubles[4]);
		System.out.println(arrayDoubles[5]);
		System.out.println(arrayDoubles[6]);
		System.out.println(arrayDoubles[7]);
		System.out.println(arrayDoubles[8]);
		System.out.println(arrayDoubles[9]);

		// ahora uno d booleans de 6 pos (por defecto es false)
		boolean[] arrayBooleans = new boolean[6];
		
		// para cambiar un valor:

		arrayBooleans[3] = true;
		
		System.out.println("\n");
		System.out.println(arrayBooleans[0]);
		System.out.println(arrayBooleans[1]);
		System.out.println(arrayBooleans[2]);
		System.out.println(arrayBooleans[3]);
		System.out.println(arrayBooleans[4]);
		System.out.println(arrayBooleans[5]);

		// definimos un array d strings
		// x defecto el string tiene valor null
		
		String arrayCadenas[] = new String[4];
		arrayCadenas[2] = "Holi";
		
		System.out.println("\n");
		System.out.println(arrayCadenas[0]);
		System.out.println(arrayCadenas[1]);
		System.out.println(arrayCadenas[2]);
		System.out.println(arrayCadenas[3]);
		
		/* Si defino un array de tipo object
		 * Cuando veamos POO veremos un concepto de herencia
		 * X ejemplo cuando definiamos una variable tipo scanner,
		 * esta x herencia es de tipo object (es java.lang.Object)
		 * Esto significa que extiende/hereda de object aun siendo
		 * scanner tambien
		 * 
		 * X ejemplo, dentro d una escuela estan los alumnos, profes,
		 * etc, todos tenemos un rol, pero seamos lo q seamos somos
		 * personas, mamiferos, seres vivos, etc.
		 * En esta analogia alumno o docente es una especializacion
		 * de persona, igual q persona es una especializacion de
		 * mamifero, y este a su vez es de ser vivo
		 * 
		 * Object seria como el ser vivo
		 * 
		 * Los valores booleanos int etc son de tipo object
		 * 
		 * En los de object, como cualquier cosa es un objeto,
		 * serían homogeneos xk son de tipo object, podriamos
		 * asignar ints, cadenas, etc
		 */
		
		Object[] arrayObjetos = new Object[5];
		arrayObjetos[0] = "Holiwi";
		arrayObjetos[1] = 23;
		arrayObjetos[2] = true;
		arrayObjetos[3] = 10.2;
		arrayObjetos[4] = null;
		
		System.out.println("\n");
		System.out.println(arrayObjetos[0]);
		System.out.println(arrayObjetos[1]);
		System.out.println(arrayObjetos[2]);
		System.out.println(arrayObjetos[3]);
		System.out.println(arrayObjetos[4]);
	}

}
