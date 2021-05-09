package mx.aeroibero.main.repository.aeropuerto;

import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.entity.aeropuerto.Pais;
import org.springframework.data.repository.CrudRepository;

public interface PaisRepository extends CrudRepository<Pais, Long> {
}
