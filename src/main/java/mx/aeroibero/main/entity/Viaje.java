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
    private Long distancia;
    private Long tiempo_Total;
    private Long Costo;

    public Viaje(){

    }

    public Viaje(Long id, Aeropuerto origen, Aeropuerto destino, Long distancia, Long tiempo_Total, Long costo) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempo_Total = tiempo_Total;
        Costo = costo;
    }

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

    public Long getDistancia() {
        return distancia;
    }

    public void setDistancia(Long distancia) {
        this.distancia = distancia;
    }

    public Long getTiempo_Total() {
        return tiempo_Total;
    }

    public void setTiempo_Total(Long tiempo_Total) {
        this.tiempo_Total = tiempo_Total;
    }

    public Long getCosto() {
        return Costo;
    }

    public void setCosto(Long costo) {
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
