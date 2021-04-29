package mx.aeroibero.main.entity.aeropuerto;

import javax.persistence.*;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_CiudadFK")
    private Ciudad idCiudadFK;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getIdCiudadFK() {
        return idCiudadFK;
    }

    public void setIdCiudadFK(Ciudad idCiudadFK) {
        this.idCiudadFK = idCiudadFK;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idCiudadFK=" + idCiudadFK +
                '}';
    }
}
