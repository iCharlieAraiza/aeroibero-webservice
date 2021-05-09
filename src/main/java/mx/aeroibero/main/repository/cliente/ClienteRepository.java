package mx.aeroibero.main.repository.cliente;

import mx.aeroibero.main.entity.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
