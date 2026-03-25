//ENTIDAD
package model.domain;

public class Cliente {
	
	//columnas de la taabla
	private int id;
	private String razonSocial;
	private String nombreComercial;
	private double limiteCredito;
	
	// constructores
	public Cliente() {
		
	}
	
	public Cliente(int id, String razonSocial, String nombreComercial, double limiteCredito) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.limiteCredito = limiteCredito;
	}
	
	//getters y setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	// metodo q nos permita devolver el contenido del cliente en forma d string
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", razonSocial=" + razonSocial + ", nombreComercial=" + nombreComercial
				+ ", limiteCredito=" + limiteCredito + ", getId()=" + getId() + ", getRazonSocial()=" + getRazonSocial()
				+ ", getNombreComercial()=" + getNombreComercial() + ", getLimiteCredito()=" + getLimiteCredito()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
