package mx.aeroibero.main.entity;

import mx.aeroibero.main.entity.aeropuerto.Aeropuerto;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "origen")
    private Aeropuerto origen;

    @OneToOne
    @JoinColumn(name = "destino")
    private Aeropuerto destino;

    private String tipo_Viaje;
    private Double distancia;
    private Time tiempo_Total;
    private Double Costo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public String getTipo_Viaje() {
        return tipo_Viaje;
    }

    public void setTipo_Viaje(String tipo_Viaje) {
        this.tipo_Viaje = tipo_Viaje;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Time getTiempo_Total() {
        return tiempo_Total;
    }

    public void setTiempo_Total(Time tiempo_Total) {
        this.tiempo_Total = tiempo_Total;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", origen=" + origen +
                ", destino=" + destino +
                ", tipo_Viaje='" + tipo_Viaje + '\'' +
                ", distancia=" + distancia +
                ", tiempo_Total=" + tiempo_Total +
                ", Costo=" + Costo +
                '}';
    }
}
