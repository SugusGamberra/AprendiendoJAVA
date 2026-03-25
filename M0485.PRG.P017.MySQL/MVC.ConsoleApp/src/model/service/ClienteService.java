//CLASE DE SERVICIO, CONTIENE LA LOGICA DE LA APP
/* Por ejemplo para las validaciones lo ahcemos aqui
 * Tenemos que tener una llamada para todos los metodos de clienteRepository
 */
package model.service;

import java.util.ArrayList;
import java.util.Optional;

import model.domain.Cliente;
import model.repository.ClienteRepository;

public class ClienteService {

    private static ClienteService instance = null;
    private ClienteRepository clienteRepository;

    private ClienteService(String url, String user, String password) {
        this.clienteRepository = ClienteRepository.getInstance(url, user, password);
    }

    public static ClienteService getInstance(String url, String user, String password) {
        if (instance == null) {
            instance = new ClienteService(url, user, password);
        }
        return instance;
    }

    //Validacion

    private void validarCliente(Cliente cliente) {
        if (cliente.getRazonSocial() == null || cliente.getRazonSocial().isBlank()) {
            throw new IllegalArgumentException("La razón social no puede estar en blanco.");
        }
        if (cliente.getNombreComercial() == null || cliente.getNombreComercial().isBlank()) {
            throw new IllegalArgumentException("El nombre comercial no puede estar en blanco.");
        }
        if (cliente.getLimiteCredito() < 0) {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo.");
        }
    }

    //metodos publicos

    public void create(Cliente cliente) {
        validarCliente(cliente);
        clienteRepository.create(cliente);
    }

    public void update(Cliente cliente) {
        validarCliente(cliente);
        clienteRepository.update(cliente);
    }

    public ArrayList<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(int id) {
        return clienteRepository.findById(id);
    }

    public ArrayList<Cliente> findByRazonSocial(String razonSocial) {
        return clienteRepository.findByRazonSocial(razonSocial);
    }

    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }
}