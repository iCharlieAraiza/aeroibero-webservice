package mx.aeroibero.main.service.aeropuerto;

import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;

import java.util.List;

public interface AeropuertoService {
    List<Aeropuerto> findAll ();
    void save(Aeropuerto aeropuerto);
    Aeropuerto findById(Long id);
    Aeropuerto findByNombre(String name);
}
