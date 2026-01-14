package ejemplos;

import java.util.Arrays;

public class C05Utilidades {

	public static void main(String[] args) {
		
		Object[] arrayObjetos = new Object[5];
		arrayObjetos[0] = "Holiwi";
		arrayObjetos[1] = 23;
		arrayObjetos[2] = true;
		arrayObjetos[3] = 10.2;
		arrayObjetos[4] = null;
		
		/* Si yo quiero mostrar ese array como tal se muestra solo la direccion de
		 * memoria
		 * Si le paso una clase llamada Arrays con el metodo .toString
		 * Veremos mas utilidades el sabado
		 */
		
		System.out.println(arrayObjetos);
		System.out.println(Arrays.toString(arrayObjetos));
	}
}
