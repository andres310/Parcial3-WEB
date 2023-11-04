package sv.edu.ufg.rrhh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sv.edu.ufg.rrhh.entity.Departamento;
import sv.edu.ufg.rrhh.entity.Municipio;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpleadoDireccionDTO {

    private Departamento departamento;

    private Municipio municipio;
    private String complemento;
}
