package sv.edu.ufg.rrhh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class DesactivarEmpleadoDTO {
    //@NotEmpty(message = "EL id del empleado no puede estar vacio")
    private Integer id;
    private String motivo;
}
