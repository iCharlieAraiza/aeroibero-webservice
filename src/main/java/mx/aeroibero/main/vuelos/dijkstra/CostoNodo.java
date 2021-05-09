package mx.aeroibero.main.vuelos.dijkstra;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CostoNodo implements Comparable<CostoNodo>{
    private int nodo;
    private int costoMinimo;
    private ArrayList<Integer> caminoMasCorto;

    public CostoNodo(int nodo, int costoMinimo) {
        this.nodo = nodo;
        this.costoMinimo = costoMinimo;
        this.caminoMasCorto = new ArrayList<>();
    }

    public void agregarNodoAlCamino(int nodo) {
        this.caminoMasCorto.add(nodo);
    }

    @Override
    public int compareTo(CostoNodo nodo) {
        return this.costoMinimo - nodo.getCostoMinimo();
    }
}

