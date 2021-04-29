package mx.aeroibero.main.vuelos.dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RutaMasCorta extends Archivo {
    private final CiudadesYRutas ciudades;
    private final int cantCiudades;

    public RutaMasCorta(File entrada, File salida) throws FileNotFoundException {
        super(entrada, salida);
        this.ciudades = new CiudadesYRutas(this.entrada);
        this.cantCiudades = this.ciudades.getCantNodos();
    }

    @Override
    public void resolver() throws IOException {
        int nodoInicial, nodoFinal;
        String ciudadInicial, ciudadFinal;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("LA RUTA MAS CORTA");
        System.out.print("Ingrese la Ciudad Origen: ");
        ciudadInicial = br.readLine();

        System.out.print("\nIngrese la Ciudad Destino: ");
        ciudadFinal = br.readLine();
        br.close();

        nodoInicial = this.ciudades.getNumeroCiudad(ciudadInicial);
        nodoFinal = this.ciudades.getNumeroCiudad(ciudadFinal);

        if ((nodoInicial < 0 || nodoInicial > this.cantCiudades - 1)
                || (nodoFinal < 0 || nodoFinal > this.cantCiudades - 1)) {
            System.out.println("Al menos una de las ciudades especificadas no aparece en el archivo de entrada");
            //this.salida.delete();
            System.exit(0);
        }

        AlgoritmoDijsktra dijkstra = new AlgoritmoDijsktra(this.ciudades, nodoInicial);
        dijkstra.ejecutar();
        dijkstra.escribirSolucionEnConsola(nodoFinal);
        dijkstra.escribirSolucionEnArchivo(this.salida, nodoFinal);
    }

    public List<String> resolve(){
        int nodoInicial, nodoFinal;
        String ciudadInicial, ciudadFinal;
        List<String> route, flights = new ArrayList<>();

        ciudadInicial = "Mordor";
        ciudadFinal = "Rivendel";

        nodoInicial = this.ciudades.getNumeroCiudad(ciudadInicial);
        nodoFinal = this.ciudades.getNumeroCiudad(ciudadFinal);

        AlgoritmoDijsktra dijkstra = new AlgoritmoDijsktra(this.ciudades, nodoInicial);
        dijkstra.ejecutar();
        route = dijkstra.getRoute(nodoFinal);

        for(int i = 0; i< route.size(); i++){
            String flight;
            if(i>0){
                flight = route.get(i-1) + " - " + route.get(i);
                flights.add(flight);
            }
        }

        for(String flight : flights){
            System.out.println("Vuelo: "+flight);
        }

        return flights;
        //dijkstra.escribirSolucionEnConsola(nodoFinal);
        //dijkstra.escribirSolucionEnArchivo(this.salida, nodoFinal);
    }

    public List<String> resolve(String ciudadInicial, String ciudadFinal){
        int nodoInicial, nodoFinal;
        List<String> route, flights = new ArrayList<>();

        nodoInicial = this.ciudades.getNumeroCiudad(ciudadInicial);
        nodoFinal = this.ciudades.getNumeroCiudad(ciudadFinal);

        AlgoritmoDijsktra dijkstra = new AlgoritmoDijsktra(this.ciudades, nodoInicial);
        dijkstra.ejecutar();
        route = dijkstra.getRoute(nodoFinal);

        for(int i = 0; i< route.size(); i++){
            String flight;
            if(i>0){
                flight = route.get(i-1) + " - " + route.get(i);
                flights.add(flight);
            }
        }

        for(String flight : flights){
            System.out.println("Vuelo: "+flight);
        }

        return flights;
        //dijkstra.escribirSolucionEnConsola(nodoFinal);
        //dijkstra.escribirSolucionEnArchivo(this.salida, nodoFinal);
    }

}