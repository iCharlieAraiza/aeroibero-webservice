package mx.aeroibero.main.service.viaje;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;

import java.util.List;

public interface ViajeService {
    List<Viaje> findAll();
    void save(Viaje viaje);
    Viaje findById(Long id);
    Viaje findByOrigenAndDestino(Aeropuerto origen, Aeropuerto destino);
}
