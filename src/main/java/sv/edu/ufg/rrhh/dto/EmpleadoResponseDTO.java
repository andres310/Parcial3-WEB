package sv.edu.ufg.rrhh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sv.edu.ufg.rrhh.entity.Departamento;
import sv.edu.ufg.rrhh.entity.Empleado;
import sv.edu.ufg.rrhh.entity.Municipio;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadoResponseDTO {
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

    private Boolean status;
    private String motivoStatus;

    private Integer departamento_id;
    private String departamento_name;
    private Integer municipio_id;
    private String municipio_name;
    private String complemento;

    public EmpleadoResponseDTO(Empleado empleado, Departamento departamento, Municipio municipio) {

        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.genero = empleado.getGenero();
        this.telefono = empleado.getTelefono();
        this.status = empleado.getStatus();
        this.motivoStatus = empleado.getMotivoStatus();

        this.departamento_id = empleado.getDepartamento().getId();
        this.municipio_id = empleado.getMunicipio().getId();

        this.departamento_name = departamento.getNombre();
        this.municipio_name = municipio.getNombre();

        this.complemento = empleado.getComplemento();

    }

    public EmpleadoResponseDTO(Empleado empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getNombre();
        this.apellido = empleado.getApellido();
        this.genero = empleado.getGenero();
        this.telefono = empleado.getTelefono();
        this.status = empleado.getStatus();
        this.motivoStatus = empleado.getMotivoStatus();

        this.departamento_id = empleado.getDepartamento().getId();
        this.municipio_id = empleado.getMunicipio().getId();

        this.departamento_name = empleado.getDepartamento().getNombre();
        this.municipio_name = empleado.getMunicipio().getNombre();

        this.complemento = empleado.getComplemento();
    }
}
