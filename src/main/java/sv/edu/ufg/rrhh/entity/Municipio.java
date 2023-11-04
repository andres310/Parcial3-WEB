package sv.edu.ufg.rrhh.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Municipio {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    private Departamento departamento;

    public Municipio() {}

    public Municipio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipio = (Municipio) o;
        return Objects.equals(id, municipio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
