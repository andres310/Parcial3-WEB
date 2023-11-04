package sv.edu.ufg.rrhh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.entity.Departamento;
import sv.edu.ufg.rrhh.entity.Empleado;
import sv.edu.ufg.rrhh.repository.IDepartamentoRepository;
import sv.edu.ufg.rrhh.repository.IEmpleadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    public List<EmpleadoDTO> listar(){
        return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoDTO::new)
                .collect(Collectors.toList());

    }

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO){

        var empleado = new Empleado(empleadoDTO);

        Departamento departamento = departamentoRepository.getReferenceById(empleadoDTO.getDepartamento().getId());

        empleadoRepository.save(empleado);

        return new EmpleadoDTO(empleado);

    }
}
