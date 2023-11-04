package sv.edu.ufg.rrhh.mapper;

import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.entity.Empleado;

import java.util.function.Function;


@Service
public class IEmpleadoDTOMapper implements Function<Empleado, EmpleadoDTO> {

    @Override
    public EmpleadoDTO apply(Empleado empleado) {
        return new EmpleadoDTO(
                empleado
        );
    }
}
