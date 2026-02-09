package ejemplo04;

public class Inicio {

	public static void main(String[] args) {
		
//		Animal animal = new Animal();
//		System.out.println(animal.sonidoEmitido());
		
		Gato gato = new Gato();
		System.out.println(gato.sonidoEmitido());
		Perro perro = new Perro();
		System.out.println(perro.sonidoEmitido());
		Pajaro pajaro = new Pajaro();
		System.out.println(pajaro.sonidoEmitido());
		Loro loro = new Loro();
		System.out.println(loro.sonidoEmitido());
		
	}
}
