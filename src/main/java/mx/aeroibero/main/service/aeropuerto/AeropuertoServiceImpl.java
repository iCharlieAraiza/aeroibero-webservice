package mx.aeroibero.main.service.aeropuerto;

import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.repository.aeropuerto.AeropuertoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoServiceImpl implements AeropuertoService{

    @Autowired
    private AeropuertoRespository respository;

    @Override
    public List<Aeropuerto> findAll() {
        return (List<Aeropuerto>) respository.findAll();
    }

    @Override
    public void save(Aeropuerto aeropuerto) {
        respository.save(aeropuerto);
    }


}
