package mx.aeroibero.main.service.viaje;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.repository.viaje.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeServiceImpl implements ViajeService{
    @Autowired
    private ViajeRepository repository;

    @Override
    public List<Viaje> findAll() {
        return (List<Viaje>) repository.findAll();
    }

    @Override
    public void save(Viaje viaje) {
        repository.save(viaje);
    }

    @Override
    public Viaje findById(Long id) {
        Viaje viaje = repository.findById(id).get();
        return viaje;
    }


}
