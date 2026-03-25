package controller;

import model.configuration.MiConfiguracion;
import model.service.ClienteService;
import view.ClienteConsoleUI;
import view.ClienteDesktopUI;

public class Inicio {

	private static String URL = MiConfiguracion.getInstance().getUrl();
	private static String USER = MiConfiguracion.getInstance().getUser();
	private static String PASSWORD = MiConfiguracion.getInstance().getPassword();
	private static String UI = MiConfiguracion.getInstance().getUI();

	public static void main(String[] args) {

		System.out.println(URL);
		System.out.println(USER);
		System.out.println(PASSWORD);
		System.out.println(UI);

		ClienteService clienteService = ClienteService.getInstance(URL, USER, PASSWORD);
		
		if (UI.equals("console")) {
			ClienteConsoleUI.getInstance(clienteService).iniciar();
			
		} else if (UI.equals("desktop")) {
			ClienteDesktopUI.getInstance(clienteService).iniciar();
		}
		
	}
}