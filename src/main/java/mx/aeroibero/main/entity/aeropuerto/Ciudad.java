package mx.aeroibero.main.entity.aeropuerto;

import org.hibernate.engine.spi.PersistentAttributeInterceptable;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_Tipo_CiudadFK")
    private TipoCiudad tipoCiudad;

    @OneToOne
    @JoinColumn(name = "id_PaisFK")
    private Pais pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public TipoCiudad getTipoCiudad() {
        return tipoCiudad;
    }

    public void setTipoCiudad(TipoCiudad tipoCiudad) {
        this.tipoCiudad = tipoCiudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoCiudad=" + tipoCiudad +
                ", pais=" + pais +
                '}';
    }
}



