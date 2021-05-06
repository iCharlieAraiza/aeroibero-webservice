package mx.aeroibero.main.service.viaje;

import mx.aeroibero.main.entity.Viaje;

import java.util.List;

public interface ViajeService {
    List<Viaje> findAll();
    void save(Viaje viaje);
    Viaje findById(Long id);
}
