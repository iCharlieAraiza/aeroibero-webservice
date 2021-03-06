package mx.aeroibero.main.vuelos.controller;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.service.aeropuerto.AeropuertoService;
import mx.aeroibero.main.service.viaje.ViajeService;
import mx.aeroibero.main.vuelos.dijkstra.RutaMasCorta;
import mx.aeroibero.main.vuelos.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VuelosController {
    @Autowired
    public AeropuertoService aeropuertoService;

    private ViajeService viajeService;

    public VuelosController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping("/prueba")
    public List<String> routes() throws FileNotFoundException {
        File entrada = new File("ciudades.in");
        File salida = new File("rutaMasCorta.out");
        RutaMasCorta ruta = new RutaMasCorta(entrada, salida);

        return ruta.resolve("Moria","Charn");
    }

    @GetMapping("/prueba/{from}/{to}")
    public List<String> routesByName(@PathVariable( value = "from") String from,@PathVariable( value = "to") String to , Model model) throws FileNotFoundException {
        /*
        File entrada = new File("ciudades.in");
        File salida = new File("rutaMasCorta.out");
        RutaMasCorta ruta = new RutaMasCorta(entrada, salida);
        */

        /*
        List<Flight> flights = new ArrayList<>();

        flights.add( new Flight("La Comarca", "Rivendel", "N", 500L, 15,1550L ));
        flights.add( new Flight("Rivendel", "La Comarca", "N", 500L, 15,1550L ));
        flights.add( new Flight("Rivendel", "Reino del Bosque", "N", 500L, 15,1550L ));
        flights.add( new Flight("Rivendel", "Rohan", "N", 500L, 15,1550L ));
        flights.add( new Flight("Rivendel", "Telmar", "N", 500L, 15,1550L ));
        flights.add( new Flight("Rohan", "Rivendel", "N", 500L, 15,1550L ));

        RutaMasCorta ruta = new RutaMasCorta(flights);


        return ruta.resolve(from, to);

         */

        List<Viaje> flights;
        flights = viajeService.findAll();

        RutaMasCorta ruta = new RutaMasCorta(flights);
        return ruta.resolve(from, to);
    }

    @CrossOrigin
    @GetMapping("/prueba/id/{from}/{to}")
    public List<Viaje> routesById(@PathVariable( value = "from") Integer from,@PathVariable( value = "to") Integer to , Model model) {

        //System.out.println(from);
        List<Viaje> flights;
        flights = viajeService.findAll();

        RutaMasCorta ruta = new RutaMasCorta(flights);

        Aeropuerto aeropuertoTo = aeropuertoService.findById((long) to);
        Aeropuerto aeropuertoFrom = aeropuertoService.findById((long) from);

        return ruta.resolve( aeropuertoFrom.getNombre(), aeropuertoTo.getNombre(),viajeService, aeropuertoService);
        //return null;
    }

}
