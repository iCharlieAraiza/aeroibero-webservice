package mx.aeroibero.main.entity.aeropuerto;

import javax.persistence.*;

@Entity
@Table(name = "tipociudad")
public class TipoCiudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoCiudad{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
