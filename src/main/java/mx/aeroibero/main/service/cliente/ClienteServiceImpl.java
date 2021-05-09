package mx.aeroibero.main.service.cliente;

import mx.aeroibero.main.entity.cliente.Cliente;
import mx.aeroibero.main.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Cliente findByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return repository.save(cliente);
    }
}
