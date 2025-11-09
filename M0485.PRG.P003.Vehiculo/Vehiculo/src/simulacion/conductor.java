package simulacion;

public class conductor {
	
	public static void main(String[] args)
	{
		// Como vemos no se pueden llamar clases privadas, pero públicas sí! Aunque estas públicas trabajen con privadas.
		
		coche.ponerEnMarcha();
		coche.acelerar();
		coche.acelerar();
		coche.acelerar();
		coche.acelerar();
		coche.frenar();
		coche.detener();
	}

}
