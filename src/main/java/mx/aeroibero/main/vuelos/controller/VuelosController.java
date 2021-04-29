package mx.aeroibero.main.vuelos.controller;

import mx.aeroibero.main.vuelos.dijkstra.RutaMasCorta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VuelosController {
    @GetMapping("/prueba")
    List<String> routes() throws FileNotFoundException {
        File entrada = new File("ciudades.in");
        File salida = new File("rutaMasCorta.out");
        RutaMasCorta ruta = new RutaMasCorta(entrada, salida);

        return ruta.resolve();
    }

}
