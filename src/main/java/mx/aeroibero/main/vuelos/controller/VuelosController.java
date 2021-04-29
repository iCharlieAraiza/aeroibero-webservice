package mx.aeroibero.main.vuelos.controller;

import mx.aeroibero.main.vuelos.dijkstra.RutaMasCorta;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
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
        File entrada = new File("ciudades.in");
        File salida = new File("rutaMasCorta.out");
        RutaMasCorta ruta = new RutaMasCorta(entrada, salida);

        return ruta.resolve(from, to);
    }

}
