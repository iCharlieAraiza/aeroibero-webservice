import uia.dappii.dijkstra.RutaMasCorta;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
            File entrada = new File("ciudades.in");
            File salida = new File("rutaMasCorta.out");

            RutaMasCorta ruta = new RutaMasCorta(entrada, salida);
            ruta.resolver();
    }
}

