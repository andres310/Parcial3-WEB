package sv.edu.ufg.rrhh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.entity.Empleado;
import sv.edu.ufg.rrhh.repository.IEmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;


    public EmpleadoDTO save(EmpleadoDTO empleadoDTO){

        var empleado = new Empleado(empleadoDTO);

        empleadoRepository.save(empleado);

        return new EmpleadoDTO(empleado);

    }
}
