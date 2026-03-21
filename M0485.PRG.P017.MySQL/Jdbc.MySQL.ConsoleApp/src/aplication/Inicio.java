package aplication;

import configuracion.MiConfiguracion;
import view.ClienteConsoleUI;

public class Inicio {

	private static String URL = MiConfiguracion.getInstance().getUrl();
	private static String USER = MiConfiguracion.getInstance().getUser();
	private static String PASSWORD = MiConfiguracion.getInstance().getPassword();

	public static void main(String[] args) {

		System.out.println(URL);
		System.out.println(USER);
		System.out.println(PASSWORD);

		ClienteService clienteService = ClienteService.getInstance(URL, USER, PASSWORD);
		ClienteConsoleUI.getInstance(clienteService).iniciar();
	}
}