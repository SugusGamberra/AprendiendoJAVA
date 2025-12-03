package bucles2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// pedimos un valor
		
		System.out.println("Introduzca un valor límite: ");
		Scanner peticion = new Scanner(System.in);
		int valorEntrada = peticion.nextInt();
		
		// test01WhileContinue.test(valorEntrada);
		// test01WhileBreak.test(valorEntrada);
		// test02ForContinue.test(valorEntrada);
		// test02ForBreak.test(valorEntrada);
		// test03DoWhileContinue.test(valorEntrada);
		// test03DoWhileBreak.test(valorEntrada);
		test04ForEachContinueYBreak.test(valorEntrada);

	}

}
