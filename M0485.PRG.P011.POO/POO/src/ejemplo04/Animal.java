package ejemplo04;

public abstract class Animal {
	
	private String nombre;
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



//	public String sonidoEmitido() {
//		return "????";
//	}
	
	public abstract String sonidoEmitido();

}
