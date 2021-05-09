package mx.aeroibero.main.vuelos.dijkstra;

import java.io.File;
import java.io.IOException;

public abstract class Archivo {
    protected File entrada;
    protected File salida;

    public Archivo(File entrada, File salida) {
        this.entrada = entrada;
        this.salida = salida;
    }

    public Archivo(){}

    public abstract void resolver() throws IOException;
}
