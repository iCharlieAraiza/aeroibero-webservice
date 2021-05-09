package mx.aeroibero.main.repository.aeropuerto;

import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import org.springframework.data.repository.CrudRepository;

public interface AeropuertoRespository extends CrudRepository<Aeropuerto, Long> {
    Aeropuerto findByNombre(String nombre);
}
