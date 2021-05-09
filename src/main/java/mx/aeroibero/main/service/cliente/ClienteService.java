package mx.aeroibero.main.service.cliente;

import mx.aeroibero.main.entity.cliente.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll ();
    Cliente findByID(Long id);
    void delete(Long id);
    void save (Cliente cliente);
    Cliente saveCliente(Cliente cliente);
}
