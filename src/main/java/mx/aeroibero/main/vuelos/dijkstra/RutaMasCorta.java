package mx.aeroibero.main.vuelos.dijkstra;

import java.io.*;

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

}