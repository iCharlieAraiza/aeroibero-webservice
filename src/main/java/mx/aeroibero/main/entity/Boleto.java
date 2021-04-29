package mx.aeroibero.main.entity;

import mx.aeroibero.main.entity.cliente.Cliente;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_ClienteFK")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_ViajeFK")
    private Viaje viaje;

    private String status;
    private String asiento;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    private Date fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", viaje=" + viaje +
                ", status='" + status + '\'' +
                ", asiento='" + asiento + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
