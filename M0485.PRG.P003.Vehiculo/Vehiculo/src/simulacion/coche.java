package simulacion;

public class coche {

	public static void ponerEnMarcha()
	{
		// Insertamos la llave
		// Giramos la llave
		// Internamente ocurren los procesos internos que deban pasar para que el coche se active:
		// inicioElectronica()
		// inicioMecanico()
		
		encendidoElectronica();
		inicioMecanico();
	}
	
	public static void acelerar()
	
	{
		// aumentoCaudalGasolina()
		// actualizacionContadorVelocidad()
		
		aumentoCaudalGasolina();
		actualizacionContadorVelocidad();
	}
	
	public static void frenar()
	{
		// activacionElectronicaFrenos()
		// activacionMecanicaFrenado()
		
		activacionElectronicaFrenos();
		activacionMecanicaFrenado();
	}
	
	public static void detener()
	{
		// detencionSistemasElectronicos()
		// detencionSistemasMecanicos()
		
		detencionSistemasElectronicos();
		detencionSistemasMecanicos();
	}
	
	private static void encendidoElectronica()
	{
		System.out.println("Se inicia la electrónica.");
	}
	
	private static void inicioMecanico()
	{
		System.out.println("Se inicia la mecánica.");
	}
	
	private static void aumentoCaudalGasolina()
	{
		System.out.println("Aumento del caudal de gasolina");
	}
	
	private static void actualizacionContadorVelocidad()
	{
		System.out.println("Sube la aguja de velocidad.");
	}
	
	private static void activacionElectronicaFrenos()
	{
		System.out.println("Se activa la electrónica de los frenos");
	}
	
	private static void activacionMecanicaFrenado()
	{
		System.out.println("Se activa la mecánica de los frenos");
	}
	
	private static void detencionSistemasElectronicos()
	{
		System.out.println("Se detienen los sistemas electrónicos.");
	}
	
	private static void detencionSistemasMecanicos()
	{
		System.out.println("Se detienan los sistemas mecánicos");
	}

}
