package mx.aeroibero.main.bootstrap;

import mx.aeroibero.main.entity.aeropuerto.Ciudad;
import mx.aeroibero.main.entity.aeropuerto.Pais;
import mx.aeroibero.main.entity.cliente.Cliente;
import mx.aeroibero.main.repository.aeropuerto.CiudadRepository;
import mx.aeroibero.main.repository.aeropuerto.PaisRepository;
import mx.aeroibero.main.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public void run(String... args) throws Exception {
        initCliente();
        initPais();
        initCiudad();
    }

    public void initCliente(){
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add( new Cliente(1L, "Carlos", "Mendez", "1990-07-07") );
        clienteList.add( new Cliente(2L, "Fernanda", "Perez", "1990-07-07") );
        clienteList.add( new Cliente(3L, "Ximena", "Franco", "1990-07-07") );
        clienteList.add( new Cliente(4L, "Bertha", "Garcia", "1990-07-07") );
        clienteList.add( new Cliente(5L, "Enrique", "Lopez", "1990-07-07") );

        clienteList.forEach( cliente->clienteService.save(cliente));

    }

    public void initPais(){
        List<Pais> paisList = new ArrayList<>();
        paisList.add(new Pais(1L,"Tierra Media"));
        paisList.add(new Pais(2L, "Narnia"));
        paisList.add(new Pais(3L,"Oz"));

        paisList.forEach(pais->paisRepository.save(pais));
    }

    public void initCiudad(){
        List<Pais> paisList = (List<Pais>) paisRepository.findAll();
        List<Ciudad> ciudadList = new ArrayList<>();

        ciudadList.add( new Ciudad(1L, "La Comarca", paisList.get(0)));
        ciudadList.add( new Ciudad(2L, "Rivendel", paisList.get(0)));
        ciudadList.add( new Ciudad(3L, "Rohan", paisList.get(0)));
        ciudadList.add( new Ciudad(4L, "Reino del Bosque", paisList.get(0)));
        ciudadList.add( new Ciudad(5L, "Erebor", paisList.get(0)));
        ciudadList.add( new Ciudad(6L, "Gondor", paisList.get(0)));
        ciudadList.add( new Ciudad(7L, "Moria", paisList.get(0)));
        ciudadList.add( new Ciudad(8L, "Isengard", paisList.get(0)));
        ciudadList.add( new Ciudad(9L, "Mordor", paisList.get(0)));
        ciudadList.add( new Ciudad(10L, "Narnia", paisList.get(1)));
        ciudadList.add( new Ciudad(11L, "Telmar", paisList.get(1)));
        ciudadList.add( new Ciudad(12L, "Charn", paisList.get(1)));
        ciudadList.add( new Ciudad(13L, "Ciudad Esmeralda", paisList.get(2)));
        ciudadList.add( new Ciudad(14L, "Winkie", paisList.get(2)));
        ciudadList.add( new Ciudad(15L, "Munchkin", paisList.get(2)));

        ciudadList.forEach(ciudad -> ciudadRepository.save(ciudad));

    }



}
