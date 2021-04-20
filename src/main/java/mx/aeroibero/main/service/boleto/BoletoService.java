package mx.aeroibero.main.service.boleto;

import mx.aeroibero.main.entity.Boleto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoletoService {

    Boleto findByID (Long id);
    void dalete (Long id);
    void save (Boleto boleto);
}
