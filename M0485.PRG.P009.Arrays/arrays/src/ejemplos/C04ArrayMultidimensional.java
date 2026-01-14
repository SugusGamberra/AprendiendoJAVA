package ejemplos;

public class C04ArrayMultidimensional {
	
	public static void main(String[] args) {
		/* definimos un array bidimensional usando doble []
		 * con esto definimos una matriz de 3 filas y 4 columnas
		 * asignamos valores
		 */
		
		int[][] matriz = new int[3][4];
		// primera fila primera columna
		matriz[0][0] = 25;
		// ahora a la segunda columna
		matriz[0][1] = 26;
		
		/* otra forma de asignar valores quiza de forma mas visual
		 * en este caso definimos directamente los valores
		 */
		
		int[][] matriz2 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		
		// para ver x ejemplo la 2a fila y primera columna lo hacemos asi:
		System.out.println(matriz2[1][0]);
		
		System.out.println("\n");
		
		// recorremos la matriz
		
		System.out.println("Recorrido array multidimensional: ");
		
		for(int fila = 0; fila <= matriz.length -1 ; fila++ ) {
			
			for(int columna = 0; columna <= matriz[fila].length - 1 ; columna++) {
				System.out.println("Fila: " + fila + ", columna: " + columna + " -> " + matriz2[fila][columna]);
			}
		}
	}

}
