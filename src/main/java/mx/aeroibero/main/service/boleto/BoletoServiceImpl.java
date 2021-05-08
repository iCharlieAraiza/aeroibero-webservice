package mx.aeroibero.main.service.boleto;

import mx.aeroibero.main.entity.Boleto;
import mx.aeroibero.main.repository.boleto.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletoServiceImpl implements BoletoService {

    @Autowired
    private BoletoRepository repository;

    @Override
    public Boleto findByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void dalete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Boleto boleto) {
        repository.save(boleto);
    }

    @Override
    public Boleto saveBoleto(Boleto boleto) {
        return repository.save(boleto);
    }
}
