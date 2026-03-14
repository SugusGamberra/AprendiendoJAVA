package aplication;

import java.util.ArrayList;

public class Inicio {

	private static String URL = "jdbc:mysql://localhost:3306/m0495_prg_p23";
	private static String USER = "root";
	private static String PASSWORD = "2810";
	
	public static void main(String[] args) {
		//crearCliente();
		listaTodosLosClientes();

	}
	
	private static void crearCliente() {
		Cliente cliente1 = new Cliente();
		cliente1.setRazonSocial("Cliente RS 1");
		cliente1.setNombreComercial("Cliente NC 1");
		cliente1.setLimiteCredito(1000);
		
		Cliente cliente2 = new Cliente();
		cliente2.setRazonSocial("Cliente RS 2");
		cliente2.setNombreComercial("Cliente NC 2");
		cliente2.setLimiteCredito(2000);
		
		//instanciar
		ClienteRepository clienteRepository = new ClienteRepository(URL, USER, PASSWORD);
		clienteRepository.create(cliente1);
		clienteRepository.create(cliente2);
	}
	
	private static void listaTodosLosClientes() {
		ClienteRepository clienteRepository = new ClienteRepository(URL, USER, PASSWORD);
		
		ArrayList<Cliente> clientes = clienteRepository.findAll();
		
		if (clientes != null && clientes.size() > 0) {
			for(Cliente c : clientes) {
				System.out.println(c.toString());
			}
		}
		
	}

}
