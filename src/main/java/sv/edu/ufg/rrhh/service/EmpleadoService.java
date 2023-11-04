package sv.edu.ufg.rrhh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.entity.Empleado;
import sv.edu.ufg.rrhh.repository.IEmpleadoRepository;

import java.util.NoSuchElementException;

@Service
public class EmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;


    public EmpleadoDTO save(EmpleadoDTO empleadoDTO){

        var empleado = new Empleado(empleadoDTO);

        empleadoRepository.save(empleado);

        return new EmpleadoDTO(empleado);

    }

    public EmpleadoDTO desactivar(Integer id, String motivo) {
        Empleado empleado = this.empleadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No se encontro el empleado por su id: %s", id)));

        if (!empleado.getStatus())
            throw new IllegalStateException(String.format("El empleado %s ya esta desactivado", empleado.getNombre()));

        empleado.setStatus(false);
        empleado.setMotivoStatus(motivo);

        return new EmpleadoDTO(empleadoRepository.save(empleado));
    }
}
