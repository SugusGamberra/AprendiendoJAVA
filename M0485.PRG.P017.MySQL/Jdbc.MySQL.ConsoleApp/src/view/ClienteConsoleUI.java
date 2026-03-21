package view;

import aplication.Cliente;
import aplication.ClienteService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ClienteConsoleUI {

	// codigos ansi
	private static final String RESET = "\u001B[0m";
	private static final String BOLD = "\u001B[1m";
	private static final String WHITE = "\u001B[37m";
	private static final String SKY_BLUE = "\u001B[36m";
	private static final String PINK = "\u001B[35m";
	private static final String SOFT_BLUE = "\u001B[34m";
	private static final String SUCCESS_MINT = "\u001B[32m"; 
	private static final String WARN_PEACH = "\u001B[33m";

	//patron singleton
	private static ClienteConsoleUI instance = null;
	private final ClienteService clienteService;
	private final Scanner scanner;

	private ClienteConsoleUI(ClienteService clienteService) {
		this.clienteService = clienteService;
		this.scanner = new Scanner(System.in);
	}

	public static ClienteConsoleUI getInstance(ClienteService clienteService) {
		if (instance == null) {
			instance = new ClienteConsoleUI(clienteService);
		}
		return instance;
	}

	//metodo principal
	public void iniciar() {
		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			int opcion = leerEntero(" ✨ Elige una opción: ");
			System.out.println();
			switch (opcion) {
				case 1 -> listarTodos();
				case 2 -> buscarPorId();
				case 3 -> buscarPorRazonSocial();
				case 4 -> crearCliente();
				case 5 -> actualizarCliente();
				case 6 -> eliminarCliente();
				case 0 -> salir = confirmarSalida();
				default -> printWarning("Esa opción no existe, intenta otra vez... ☁️");
			}
			if (!salir) pausar();
		}
		System.out.println(PINK + "\n  ( •‿•)  ¡Bye bye! ¡Ten un buen día!" + RESET);
		scanner.close();
	}

	//menu
	private void mostrarMenu() {
		System.out.println("\n" + SKY_BLUE + "   . ☁️  .  .  💙  .  .  ☁️  ." + RESET);
		System.out.println(SOFT_BLUE + "  ╭──────────────────────────────────╮" + RESET);
		System.out.println(SOFT_BLUE + "  │ " + WHITE + BOLD + "   ☁️  Gestión de Clientes  ☁️  " + SOFT_BLUE + " │" + RESET);
		System.out.println(SOFT_BLUE + "  ├──────────────────────────────────┤" + RESET);
		System.out.println(SKY_BLUE + "    1." + RESET + " Listar mis clientes ✨");
		System.out.println(SKY_BLUE + "    2." + RESET + " Buscar por ID 🔍");
		System.out.println(SKY_BLUE + "    3." + RESET + " Buscar por Razón Social 📖");
		System.out.println(SKY_BLUE + "    4." + RESET + " Dar de alta 🎀");
		System.out.println(SKY_BLUE + "    5." + RESET + " Actualizar datos 📝");
		System.out.println(SKY_BLUE + "    6." + RESET + " Eliminar cliente 🌸");
		System.out.println(PINK + "    0." + RESET + " Salir 🌙");
		System.out.println(SOFT_BLUE + "  ╰──────────────────────────────────╯" + RESET);
	}

	//opciones menu
	private void listarTodos() {
		printTitulo("LISTADO DE CLIENTES");
		ArrayList<Cliente> clientes = clienteService.findAll();
		if (clientes.isEmpty()) {
			printWarning("Aún no tienes clientes registrados.");
		} else {
			clientes.forEach(this::printCliente);
			printInfo("¡Tienes " + clientes.size() + " clientes registrados! 🎈");
		}
	}

	private void buscarPorId() {
		printTitulo("BUSCAR POR ID");
		int id = leerEntero(" 🔑 ID del cliente: ");
		clienteService.findById(id).ifPresentOrElse(
				this::printCliente,
				() -> printWarning("Ups, no encontré a nadie con el ID " + id + " 🍬")
		);
	}

	private void buscarPorRazonSocial() {
		printTitulo("BUSCAR POR NOMBRE");
		String razon = leerTexto(" 🎀 Razón social: ");
		ArrayList<Cliente> clientes = clienteService.findByRazonSocial(razon);
		if (clientes.isEmpty()) {
			printWarning("No hay coincidencias... ☁️");
		} else {
			clientes.forEach(this::printCliente);
		}
	}

	private void crearCliente() {
		printTitulo("NUEVO CLIENTE");
		Cliente c = pedirDatosCliente(new Cliente());
		try {
			clienteService.create(c);
			printExito("¡Cliente creado correctamente! ✨");
		} catch (Exception e) {
			printError("Algo salió mal: " + e.getMessage());
		}
	}

	private void actualizarCliente() {
		printTitulo("EDITAR CLIENTE");
		int id = leerEntero(" 📝 ID a modificar: ");
		clienteService.findById(id).ifPresentOrElse(c -> {
			pedirDatosCliente(c);
			c.setId(id);
			clienteService.update(c);
			printExito("¡Datos actualizados! 🍬");
		}, () -> printWarning("No existe ese ID... 🌸"));
	}

	private void eliminarCliente() {
		printTitulo("BORRAR CLIENTE");
		int id = leerEntero(" 🗑️ ID a eliminar: ");
		if (clienteService.findById(id).isPresent()) {
			System.out.print(WARN_PEACH + " ¿Seguro que quieres decirle adiós? (s/n): " + RESET);
			if (scanner.nextLine().equalsIgnoreCase("s")) {
				clienteService.deleteById(id);
				printExito("¡Cliente borrado! 🕊️");
			}
		} else {
			printWarning("No encontré ese cliente.");
		}
	}

	private boolean confirmarSalida() {
		System.out.print(PINK + " ¿Quieres salir? (s/n): " + RESET);
		return scanner.nextLine().trim().equalsIgnoreCase("s");
	}

	//helpers de entrada
	//pide datos al cl, recibe objeto a rellenar (nuevo o existente), devuelve null si usuario cancela
	private Cliente pedirDatosCliente(Cliente cliente) {
		cliente.setRazonSocial(leerTexto(" ☁️ Razón Social: "));
		cliente.setNombreComercial(leerTexto(" 🍬 Nombre Comercial: "));
		cliente.setLimiteCredito(leerDouble(" 💰 Límite de Crédito: "));
		return cliente;
	}

	private String leerTexto(String prompt) {
		System.out.print(SKY_BLUE + prompt + RESET);
		return scanner.nextLine().trim();
	}

	private int leerEntero(String prompt) {
		while (true) {
			try {
				System.out.print(SKY_BLUE + prompt + RESET);
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) { printError("¡Escribe un número válido! ✨"); }
		}
	}

	private double leerDouble(String prompt) {
		while (true) {
			try {
				System.out.print(SKY_BLUE + prompt + RESET);
				return Double.parseDouble(scanner.nextLine().replace(",", "."));
			} catch (Exception e) { printError("¡Usa un formato decimal, plis! ✨"); }
		}
	}

	private void pausar() {
		System.out.println(WHITE + "\n (◡‿◡✿) Pulsa ENTER para seguir..." + RESET);
		scanner.nextLine();
	}

	private void printCliente(Cliente c) {
		System.out.println(SKY_BLUE + "  ⭐ " + RESET + BOLD + "#" + c.getId() + RESET + " - " + 
						   WHITE + c.getRazonSocial() + RESET + " (" + PINK + c.getNombreComercial() + RESET + ") " +
						   BOLD + SUCCESS_MINT + String.format("%.2f€", c.getLimiteCredito()) + RESET);
	}

	private void printTitulo(String t) {
		System.out.println("\n" + SOFT_BLUE + "─── ✨ " + WHITE + BOLD + t + SOFT_BLUE + " ───" + RESET);
	}

	private void printExito(String m) { System.out.println(SUCCESS_MINT + "  (っ＾▿＾)💨 " + m + RESET); }
	private void printWarning(String m) { System.out.println(WARN_PEACH + "  (◕︿◕✿) " + m + RESET); }
	private void printError(String m) { System.out.println(PINK + "  (╯°□°）╯ " + m + RESET); }
	private void printInfo(String m) { System.out.println(SKY_BLUE + "  ℹ️ " + m + RESET); }
}