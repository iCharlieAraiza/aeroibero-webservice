package mx.aeroibero.main.repository.viaje;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    List<Viaje> findByOrigen(Aeropuerto origen);
    Viaje findByOrigenAndAndDestino(Aeropuerto origen, Aeropuerto destino);
}
