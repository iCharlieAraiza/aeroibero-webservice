package mx.aeroibero.main.vuelos.dijkstra;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

@Data
public class CiudadesYRutas {
    private int cantCiudades;
    private int cantRutas;
    private final MatrizSimetrica grafo;
    private final ArrayList<String> ciudades;
    private final int[] longitudRutas;

    public CiudadesYRutas(File entrada) throws FileNotFoundException {
        FileReader file = new FileReader(entrada);
        //BufferedReader scan = new BufferedReader(file);
        Scanner scan = new Scanner(file);

        this.cantCiudades = 0;
        this.cantRutas = 0;
        this.ciudades = new ArrayList<>();

        int ciudadOne, ciudadTwo, distancia, indice;
        String c1, c2;
        Queue<Ruta> rutas = new LinkedList<>();

        while (scan.hasNextLine()) {
            c1 = scan.next();
            c2 = scan.next();
            distancia = scan.nextInt();

            rutas.offer(new Ruta(c1, c2, distancia));
            this.cantRutas++;

            if (!this.ciudades.contains(c1)) {
                this.ciudades.add(c1);
                this.cantCiudades++;
            }
            if (!this.ciudades.contains(c2)) {
                this.ciudades.add(c2);
                this.cantCiudades++;
            }
        }
        scan.close();

        this.grafo = new MatrizSimetrica(this.cantCiudades);
        int dimensionLongitudRutas = (this.cantCiudades * this.cantCiudades - this.cantCiudades) / 2;
        longitudRutas = new int[dimensionLongitudRutas];

        Ruta ruta;
        while (!rutas.isEmpty()) {
            ruta = rutas.poll();
            c1 = ruta.getCiudadOne();
            c2 = ruta.getCiudadTwo();
            distancia = ruta.getLongitud();

            ciudadOne = this.ciudades.indexOf(c1);
            ciudadTwo = this.ciudades.indexOf(c2);
            if (ciudadOne < ciudadTwo) {
                indice = this.grafo.getIndice(ciudadOne, ciudadTwo);
            } else {
                indice = this.grafo.getIndice(ciudadTwo, ciudadOne);
            }

            this.longitudRutas[indice] = distancia;
            this.grafo.ponerArista(indice);
        }
    }

    public int getCantNodos() {
        return cantCiudades;
    }

    public int getPesoArista(int indice) {
        return longitudRutas[indice];
    }

    public int getNumeroCiudad(String nombreCiudad) {
        return this.ciudades.indexOf(nombreCiudad);
    }

    public String getNombreCiudad(int numeroCiudad) {
        return this.ciudades.get(numeroCiudad);
    }
}