package sv.edu.ufg.rrhh.entity;

import lombok.*;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;

import javax.persistence.*;

@Table(name = "empleados")
@Entity(name = "Empleado")
@Getter //Genera Getters Lombok
@Setter
@NoArgsConstructor //Genera Constructor Vacio Lombok
@AllArgsConstructor //Genera Construtor con Parametros Lombok
@EqualsAndHashCode(of = "id") // Para comparaciones entre medicos Lombok
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;
    private String nombre;

    private String apellido;
    private String genero;
    private String telefono;

    private Boolean status;
    private String motivoStatus;

    //@Embedded
    //private Direccion direccion;

    public Empleado(EmpleadoDTO empleadoDTO) {

        this.nombre = empleadoDTO.getNombre();
        this.apellido = empleadoDTO.getApellido();
        this.genero = empleadoDTO.getGenero();
        this.telefono = empleadoDTO.getTelefono();

        //this.direccion = empleadoDTO.getDireccion();

    }
}

