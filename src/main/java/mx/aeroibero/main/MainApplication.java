package mx.aeroibero.main;

import mx.aeroibero.main.vuelos.dijkstra.RutaMasCorta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);

        File entrada = new File("ciudades.in");
        File salida = new File("rutaMasCorta.out");

        RutaMasCorta ruta = new RutaMasCorta(entrada, salida);
        //ruta.resolver();
        ruta.resolve();
    }

}
