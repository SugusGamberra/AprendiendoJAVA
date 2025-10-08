package AreaTrianguloMetodo1;

public class AreaTrianguloMetodo1 {

	public static void main(String[] args) {
		// Vamos a calcular el area de un triángulo usando double
		// Para avanzar un poco te enseño el double, este es para números decimales
		// Recuerda, int es para números enteros
		// Para este ejemplo lo usaremos en el cálculo del área
		// Y para dividirlo, en vez de /2, lo hacemos /2.0 para los decimales
		//Triángulo 1:
		
		double base1 = 10.5;
		int altura1 = 5;
		double area1 = (base1 * altura1) / 2.0;
		
		System.out.println("Triángulo 1:");
		System.out.println("Base = " + base1);
		System.out.println("Altura = " + altura1);
		System.out.println("Área = " + area1);
		
		// Triángulo 2:
		
		int base2 = 8;
		double altura2 = 4.9;
		double area2 = (base2 * altura2) / 2.0;
		
		System.out.println("Triángulo 2:");
		System.out.println("Base = " + base2);
		System.out.println("Altura = " + altura2);
		System.out.println("Área = " + area2);

	}

}
