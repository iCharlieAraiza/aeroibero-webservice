package mx.aeroibero.main.vuelos.controller;

import mx.aeroibero.main.vuelos.dijkstra.RutaMasCorta;
import mx.aeroibero.main.vuelos.domain.Flight;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VuelosController {
    @GetMapping("/prueba")
    public List<String> routes() throws FileNotFoundException {
        File entrada = new File("ciudades.in");
        File salida = new File("rutaMasCorta.out");
        RutaMasCorta ruta = new RutaMasCorta(entrada, salida);

        return ruta.resolve("Rivendel","Mordor");
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

        List<String> flights = new ArrayList<>();
        return  flights;
    }

}
