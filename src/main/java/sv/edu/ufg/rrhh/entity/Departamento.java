package sv.edu.ufg.rrhh.entity;

import sv.edu.ufg.rrhh.dto.DepartamentoDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToMany(mappedBy = "departamento")
    private List<Municipio> municipios;

    public Departamento() {}


    public Departamento(Integer id) {
        this.id = id;
    }

    public Departamento(Integer id, String nombre, List<Municipio> municipios) {
        this.id = id;
        this.nombre = nombre;
        this.municipios = municipios;
    }

    public Departamento(DepartamentoDTO departamento) {
        this.id = departamento.getId();
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

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", municipios=" + municipios +
                '}';
    }
}
