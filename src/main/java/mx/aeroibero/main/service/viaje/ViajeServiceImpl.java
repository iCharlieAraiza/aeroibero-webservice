package mx.aeroibero.main.service.viaje;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.repository.ViajeRepository;
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
}
