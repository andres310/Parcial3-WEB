package sv.edu.ufg.rrhh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sv.edu.ufg.rrhh.entity.Direccion;
import sv.edu.ufg.rrhh.entity.Empleado;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadoDTO {

    private Integer id;
    @NotEmpty
    @Size(min = 3, message = "{nombre.size}")
    private String nombre;
    @NotEmpty
    @Size(min = 3, message = "{apellido.size}")
    private String apellido;
    @NotEmpty
    @Size(min = 3, message = "{genero.size}")
    private String genero;
    @NotEmpty
    @Size(min = 3, message = "{telefono.size}")
    private String telefono;

    //private Direccion direccion;

    public EmpleadoDTO(Empleado empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.genero = empleado.getGenero();
        this.telefono = empleado.getTelefono();
        //this.direccion = empleado.getDireccion();
    }
}
