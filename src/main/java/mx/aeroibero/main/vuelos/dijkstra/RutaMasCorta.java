package mx.aeroibero.main.vuelos.dijkstra;

import mx.aeroibero.main.entity.Viaje;
import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;
import mx.aeroibero.main.service.aeropuerto.AeropuertoService;
import mx.aeroibero.main.service.viaje.ViajeService;
import mx.aeroibero.main.vuelos.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class RutaMasCorta extends Archivo {
    @Autowired
    private AeropuertoService aeropuertoService;

    private CiudadesYRutas ciudades;
    private  int cantCiudades = 0;

    public RutaMasCorta(){ }

    public RutaMasCorta(File entrada, File salida) throws FileNotFoundException {
        super(entrada, salida);
        this.ciudades = new CiudadesYRutas(this.entrada);
        this.cantCiudades = this.ciudades.getCantNodos();
    }


    public RutaMasCorta(List<Viaje> viajeList){
        this.ciudades = new CiudadesYRutas(viajeList);
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


    public List<String> resolve(int idFrom, int idTo){
        int nodoInicial, nodoFinal;
        List<String> route, flights = new ArrayList<>();

        String ciudadInicial, ciudadFinal;

        ciudadInicial = aeropuertoService.findById(1L).getNombre();
        ciudadFinal = aeropuertoService.findById(5L).getNombre();

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

    public List<Viaje> resolve(String ciudadInicial, String ciudadFinal, ViajeService service, AeropuertoService aeropuertoService){
        int nodoInicial, nodoFinal;
        List<String> route, flights = new ArrayList<>();
        List<Viaje> viajeList = new ArrayList<>();

        nodoInicial = this.ciudades.getNumeroCiudad(ciudadInicial);
        nodoFinal = this.ciudades.getNumeroCiudad(ciudadFinal);

        AlgoritmoDijsktra dijkstra = new AlgoritmoDijsktra(this.ciudades, nodoInicial);
        dijkstra.ejecutar();
        route = dijkstra.getRoute(nodoFinal);

        for(int i = 0; i< route.size(); i++){
            Aeropuerto origen, destino;
            if(i>0){

                origen = aeropuertoService.findByNombre(route.get(i-1) );
                destino = aeropuertoService.findByNombre(route.get(i) );
                viajeList.add( service.findByOrigenAndDestino(origen, destino) );
                //flight = service.findByOrigenAndDestino();
                //flight = route.get(i-1) + " - " + route.get(i);

                //flights.add(flight);
            }
        }


        return viajeList;
    }

}