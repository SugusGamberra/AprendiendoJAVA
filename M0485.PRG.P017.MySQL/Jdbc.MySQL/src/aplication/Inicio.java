package aplication;

import java.util.ArrayList;
import java.util.Optional;

public class Inicio {

	private static String URL = "jdbc:mysql://localhost:3306/m0495_prg_p23";
	private static String USER = "root";
	private static String PASSWORD = "2810";
	
	public static void main(String[] args) {
		//crearCliente();
		//listaTodosLosClientes();
		//System.out.println("---");
		//buscarClientePorId();
		//buscarPorRazonSocial();
//		modificarCliente();
		listaTodosLosClientes();
		eliminarCliente();
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
		ClienteRepository clienteRepository = ClienteRepository.getInstance(URL, USER, PASSWORD);
		clienteRepository.create(cliente1);
		clienteRepository.create(cliente2);
	}
	
	private static void listaTodosLosClientes() {
		ClienteRepository clienteRepository = ClienteRepository.getInstance(URL, USER, PASSWORD);
		
		ArrayList<Cliente> clientes = clienteRepository.findAll();
		
		if (clientes != null && clientes.size() > 0) {
			for(Cliente c : clientes) {
				System.out.println(c.toString());
			}
		}
		
	}
	
	private static void buscarClientePorId() {
		int id = 1;
		ClienteRepository clienteRepository = ClienteRepository.getInstance(URL, USER, PASSWORD);
		Optional<Cliente> optCliente = clienteRepository.findById(id);
		
		if (optCliente.isPresent()) {
			Cliente cliente = optCliente.get();
			System.out.println(cliente.toString());
		} else {
			System.err.println("El cliente con id " + id + " no existe.");
		}
	}
	
	private static void buscarPorRazonSocial() {
		int id = 1;
		ClienteRepository clienteRepository = ClienteRepository.getInstance(URL, USER, PASSWORD);
		ArrayList<Cliente> clientes = clienteRepository.findByRazonSocial("1");
		
		if (clientes != null && clientes.size() > 0) {
			for (Cliente c : clientes) {
				System.out.println(c.toString());
			}
		}
	}
	
	private static void modificarCliente() {
		int id = 2;
		ClienteRepository clienteRepository = ClienteRepository.getInstance(URL, USER, PASSWORD);
		Optional<Cliente> optCliente = clienteRepository.findById(id);
		
		if (optCliente.isPresent()) {
			Cliente cliente = optCliente.get();
			cliente.setLimiteCredito(cliente.getLimiteCredito() + 100);
			cliente.setNombreComercial(cliente.getNombreComercial() + "X");
			cliente.setRazonSocial(cliente.getRazonSocial() + "X");
			
			clienteRepository.update(cliente);
			
			System.out.println("Cliente modificado");
		} else {
			System.err.println("El cliente con id " + id + " no existe.");
		}
	}
	
	private static void eliminarCliente() {
		int id = 2;
		ClienteRepository clienteRepository = ClienteRepository.getInstance(URL, USER, PASSWORD);
		clienteRepository.deleteById(id);
		
		System.out.println("Cliente eliminado");
	}

}
