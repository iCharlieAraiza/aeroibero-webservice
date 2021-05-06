package mx.aeroibero.main.bootstrap;

import mx.aeroibero.main.entity.Boleto;
import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.entity.aeropuerto.Ciudad;
import mx.aeroibero.main.entity.aeropuerto.Pais;
import mx.aeroibero.main.entity.cliente.Cliente;
import mx.aeroibero.main.repository.aeropuerto.CiudadRepository;
import mx.aeroibero.main.repository.aeropuerto.PaisRepository;
import mx.aeroibero.main.repository.viaje.ViajeRepository;
import mx.aeroibero.main.service.aeropuerto.AeropuertoService;
import mx.aeroibero.main.service.boleto.BoletoService;
import mx.aeroibero.main.service.cliente.ClienteService;
import mx.aeroibero.main.service.viaje.ViajeService;
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
    @Autowired
    private AeropuertoService aeropuertoService;
    @Autowired
    private ViajeService viajeService;
    @Autowired
    private BoletoService boletoService;
    @Autowired
    private ViajeRepository viajeRepository;

    @Override
    public void run(String... args) throws Exception {
        initCliente();
        initPais();
        initCiudad();
        initAeropuerto();
        initViaje();

        //createFlightTicket();
        showViajes();
        getAirport();

        FindViajeByAirports();
        findAirportByName();
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

    public void initAeropuerto(){
        List<Ciudad> ciudadList = (List<Ciudad>) ciudadRepository.findAll();
        List<Aeropuerto> aeropuertoList = new ArrayList<>();

        aeropuertoList.add( new Aeropuerto(1L, "Bilbo Bolsón", ciudadList.get(0) ) );
        aeropuertoList.add( new Aeropuerto(2L, "Altos Elfos", ciudadList.get(1) ) );
        aeropuertoList.add( new Aeropuerto(3L, "Caballo Verde", ciudadList.get(2) ) );
        aeropuertoList.add( new Aeropuerto(4L, "Elfos Silvanos", ciudadList.get(3) ) );
        aeropuertoList.add( new Aeropuerto(5L, "Durin", ciudadList.get(4) ) );
        aeropuertoList.add( new Aeropuerto(6L, "Isildur", ciudadList.get(5) ) );
        aeropuertoList.add( new Aeropuerto(7L, "Khazad Dum", ciudadList.get(6) ) );
        aeropuertoList.add( new Aeropuerto(8L, "Mago Blanco", ciudadList.get(7) ) );
        aeropuertoList.add( new Aeropuerto(9L, "Ojo de Sauron", ciudadList.get(8) ) );
        aeropuertoList.add( new Aeropuerto(10L, "León Real", ciudadList.get(9) ) );
        aeropuertoList.add( new Aeropuerto(11L, "Príncipe Caspian", ciudadList.get(10) ) );
        aeropuertoList.add( new Aeropuerto(12L, "Bruja Blanca", ciudadList.get(11) ) );
        aeropuertoList.add( new Aeropuerto(13L, "Mago de Oz", ciudadList.get(12) ) );
        aeropuertoList.add( new Aeropuerto(14L, "Bruja del Oeste", ciudadList.get(13) ) );
        aeropuertoList.add( new Aeropuerto(15L, "Dorita", ciudadList.get(14) ) );

        aeropuertoList.forEach(aeropuerto -> aeropuertoService.save(aeropuerto));
    }

    public void initViaje(){
        List<Aeropuerto> aeropuertoList = (List<Aeropuerto>) aeropuertoService.findAll();
        List<Viaje> viajeList = new ArrayList<>();

        viajeList.add(new Viaje(1L, aeropuertoList.get(0), aeropuertoList.get(1), 500L, 15L, 1550L) );
        viajeList.add(new Viaje(2L, aeropuertoList.get(1), aeropuertoList.get(0), 500L, 15L, 1850L) );
        viajeList.add(new Viaje(3L, aeropuertoList.get(1), aeropuertoList.get(3), 950L, 24L, 2400L) );
        viajeList.add(new Viaje(4L, aeropuertoList.get(1), aeropuertoList.get(2), 550L, 16L, 1975L) );
        viajeList.add(new Viaje(5L, aeropuertoList.get(1), aeropuertoList.get(10), 1100L, 52L, 3750L) );
        viajeList.add(new Viaje(6L, aeropuertoList.get(2), aeropuertoList.get(1), 550L, 16L, 1675L) );
        viajeList.add(new Viaje(7L, aeropuertoList.get(2), aeropuertoList.get(7), 400L, 13L, 1300L) );
        viajeList.add(new Viaje(8L, aeropuertoList.get(2), aeropuertoList.get(5), 600L, 17L, 1550L) );
        viajeList.add(new Viaje(9L, aeropuertoList.get(5), aeropuertoList.get(2), 600L, 17L, 2350L) );
        viajeList.add(new Viaje(10L, aeropuertoList.get(5), aeropuertoList.get(4), 1250L, 30L, 4225L) );
        viajeList.add(new Viaje(11L, aeropuertoList.get(5), aeropuertoList.get(8), 450L, 34L, 3125L) );
        viajeList.add(new Viaje(12L, aeropuertoList.get(5), aeropuertoList.get(9), 550L, 41L, 1975L) );
        viajeList.add(new Viaje(13L, aeropuertoList.get(5), aeropuertoList.get(12), 1100L, 52L, 4250L) );
        viajeList.add(new Viaje(14L, aeropuertoList.get(8), aeropuertoList.get(7), 550L, 16L, 1375L) );
        viajeList.add(new Viaje(15L, aeropuertoList.get(8), aeropuertoList.get(13), 600L, 32L, 1550L) );
        viajeList.add(new Viaje(16L, aeropuertoList.get(7), aeropuertoList.get(2), 400L, 13L, 1300L) );
        viajeList.add(new Viaje(17L, aeropuertoList.get(7), aeropuertoList.get(6), 400L, 13L, 1100L) );
        viajeList.add(new Viaje(18L, aeropuertoList.get(6), aeropuertoList.get(7), 400L, 13L, 1300L) );
        viajeList.add(new Viaje(19L, aeropuertoList.get(6), aeropuertoList.get(4), 900L, 23L, 2225L) );
        viajeList.add(new Viaje(20L, aeropuertoList.get(4), aeropuertoList.get(6), 900L, 23L, 2000L) );
        viajeList.add(new Viaje(21L, aeropuertoList.get(4), aeropuertoList.get(5), 1250L, 30L, 3525L) );
        viajeList.add(new Viaje(22L, aeropuertoList.get(3), aeropuertoList.get(4), 500L, 45L, 2450L) );
        viajeList.add(new Viaje(23L, aeropuertoList.get(3), aeropuertoList.get(1), 950L, 24L, 2100L) );
        viajeList.add(new Viaje(24L, aeropuertoList.get(9), aeropuertoList.get(10), 400L, 13L, 1800L) );
        viajeList.add(new Viaje(25L, aeropuertoList.get(9), aeropuertoList.get(11), 450L, 34L, 3125L) );
        viajeList.add(new Viaje(26L, aeropuertoList.get(9), aeropuertoList.get(5), 550L, 41L, 2875L) );
        viajeList.add(new Viaje(27L, aeropuertoList.get(9), aeropuertoList.get(12), 1300L, 56L, 4750L) );
        viajeList.add(new Viaje(28L, aeropuertoList.get(10), aeropuertoList.get(9), 400L, 13L, 1500L) );
        viajeList.add(new Viaje(29L, aeropuertoList.get(10), aeropuertoList.get(1), 1100L, 52L, 3750L) );
        viajeList.add(new Viaje(30L, aeropuertoList.get(11), aeropuertoList.get(9), 450L, 34L, 1225L) );
        viajeList.add(new Viaje(31L, aeropuertoList.get(11), aeropuertoList.get(13), 700L, 34L, 875L) );
        viajeList.add(new Viaje(32L, aeropuertoList.get(12), aeropuertoList.get(14), 200L, 9L, 1600L) );
        viajeList.add(new Viaje(33L, aeropuertoList.get(12), aeropuertoList.get(13), 300L, 31L, 2250L) );
        viajeList.add(new Viaje(34L, aeropuertoList.get(12), aeropuertoList.get(5), 1100L, 52L, 4250L) );
        viajeList.add(new Viaje(35L, aeropuertoList.get(12), aeropuertoList.get(9), 1300L, 56L, 4750L) );
        viajeList.add(new Viaje(36L, aeropuertoList.get(13), aeropuertoList.get(12), 300L, 21L, 1950L) );
        viajeList.add(new Viaje(37L, aeropuertoList.get(13), aeropuertoList.get(8), 600L, 32L, 750L) );
        viajeList.add(new Viaje(38L, aeropuertoList.get(13), aeropuertoList.get(11), 700L, 34L, 875L) );


        viajeList.forEach( viaje -> viajeService.save(viaje) );

    }

    public void createFlightTicket(){
        Boleto boleto = new Boleto(1L, clienteService.findByID(2L), viajeService.findById(1L), "CHECK", "2A");
        boletoService.save(boleto);
    }


    public void showViajes(){
        List<Viaje> viajeList = viajeService.findAll();

        viajeList.forEach(viaje -> System.out.println(viaje.getOrigen().getNombre()));
    }

    public void getAirport(){
        Aeropuerto aeropuerto = aeropuertoService.findById(2L);
        System.out.println("Aeropuerto 2L: " + aeropuerto.getNombre());
    }

    public void FindViajeByAirports(){
        Viaje viajes = viajeRepository.findByOrigenAndAndDestino(aeropuertoService.findById(6L),aeropuertoService.findById(3L));
        //viajes.forEach(e-> System.out.println("prueba: " + e.getDestino().getNombre()));
        System.out.println(viajes.toString());
    }

    public void findAirportByName(){
        Aeropuerto aeropuerto = aeropuertoService.findByNombre("Caballo Verde");
        System.out.println("Resultado!! " + aeropuerto.getNombre());
    }

}
