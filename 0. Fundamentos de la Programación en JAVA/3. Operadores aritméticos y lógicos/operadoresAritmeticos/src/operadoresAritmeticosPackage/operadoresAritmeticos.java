package operadoresAritmeticosPackage;

public class operadoresAritmeticos {

	public static void main(String[] args) {
		// Operadores aritmeticoos
		
		int resultado = 7 / 2;
		System.out.println(resultado);
		
		double resultadoDecimales = 7.0 / 2.0;
		System.out.println(resultadoDecimales);
		
		// Concatenacion
		
		System.out.println("La edad es " + 25 + 5);
		
		// Suma con numeros antes del string
		
		System.out.println(25 + 5 + " es la edad!");
		
		// Suma mejor con parentesis
		
		System.out.println("La edad es " + (25+5));
		
		// Asignación aritmética
		
		int puntuacion = 100;
		
		System.out.println(puntuacion);
		
		puntuacion += 10;
		System.out.println(puntuacion);
		
		puntuacion -= 5;
		System.out.println(puntuacion);
		
		puntuacion *= 2;
		System.out.println(puntuacion);
		
		puntuacion /= 2;
		System.out.println(puntuacion);
		
		puntuacion %= 2;
		System.out.println(puntuacion);
		
		// Decremento
		
		int vidas = 3;
		vidas--;
		System.out.println(vidas);
		
		// Incremento
		
		vidas++;
		System.out.println(vidas);
		
		// Post-incremento
		
		int num1 = 5;
		int num2 = num1++; 
		// num2 coge el valor de num1, luego num1 se incrementa a 6, por lo que num1 es 6 y num2 es 5!
		System.out.println(num1);
		System.out.println(num2);
		
		// Pre-incremento
		
		int a = 5;
		int b = ++a;
		// a se incrementa a 6, luego b toma ese nuevo valor, por lo que a es 6 y b es 6!!
		System.out.println(a);
		System.out.println(b);
		
		// Prioridad de operadores
		
		int sumaSinPrioridad = 10 + 5 * 2;
		System.out.println(sumaSinPrioridad);
		
		int sumaConPrioridad = (10 + 5) * 2;
		System.out.println(sumaConPrioridad);
		

	}

}
