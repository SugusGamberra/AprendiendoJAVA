package Calculo;

public class areaTriangulo {
	
	public static void calculaArea(int base, int altura)
	
	{
		int area = calculaAreaBasica(base, altura);
		System.out.println("El área del triángulo es " + area);
	}
	
	// Para ver las diferencias entre public y private: 
	
	// Aquí lo declaramos directamente con int para que retorne algo, porque con void recordemos que no retorna nada
	// Por ende necesitamos usar el método return para que nos devuelva algo!!
	
	// Puedo llamar desde otros lados las clases públicas pero NO las privadas.
	// Sin embargo desde aquí si podemos usar la privada en la pública, y llamando la pública si nos devuelve el resultado 
	
	private static int calculaAreaBasica (int base, int altura)
	{
		int area = (base * altura) / 2;
		return area;
	}

}
