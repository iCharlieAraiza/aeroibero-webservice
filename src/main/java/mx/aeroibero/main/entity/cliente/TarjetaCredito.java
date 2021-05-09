package mx.aeroibero.main.entity.cliente;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tarjetacredito")
public class TarjetaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String numero_Tarjeta;
    @DateTimeFormat(pattern = "MM-yy")
    private Date caducidad;
    private String nip;

    @OneToOne
    @JoinColumn(name = "id_ClienteFK")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_Tarjeta() {
        return numero_Tarjeta;
    }

    public void setNumero_Tarjeta(String numero_Tarjeta) {
        this.numero_Tarjeta = numero_Tarjeta;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "id=" + id +
                ", numero_Tarjeta='" + numero_Tarjeta + '\'' +
                ", caducidad=" + caducidad +
                ", nip='" + nip + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
