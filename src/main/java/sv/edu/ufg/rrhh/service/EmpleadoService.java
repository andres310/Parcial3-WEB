package sv.edu.ufg.rrhh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.dto.EmpleadoResponseDTO;
import sv.edu.ufg.rrhh.dto.EmpleadoSalarioDTO;
import sv.edu.ufg.rrhh.entity.Departamento;
import sv.edu.ufg.rrhh.entity.Empleado;
import sv.edu.ufg.rrhh.entity.Municipio;
import sv.edu.ufg.rrhh.repository.IDepartamentoRepository;
import sv.edu.ufg.rrhh.repository.IEmpleadoRepository;
import sv.edu.ufg.rrhh.repository.IMunicipioRepository;
import sv.edu.ufg.rrhh.utils.SalarioUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Autowired
    private IMunicipioRepository municipioRepository;

    public List<EmpleadoResponseDTO> listar(){
        /*return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoDTO::new)
                .collect(Collectors.toList());*/

        //return empleadoRepository.findAll();
        return empleadoRepository.findAll()
                .stream()
                .map(EmpleadoResponseDTO::new)
                .collect(Collectors.toList());

    }

    public EmpleadoResponseDTO save(EmpleadoDTO empleadoDTO){

        var empleado = new Empleado(empleadoDTO);

        Departamento departamento = departamentoRepository.getReferenceById(empleadoDTO.getDepartamento().getId());
        Municipio municipio = municipioRepository.getReferenceById(empleadoDTO.getMunicipio().getId());

        empleadoRepository.save(empleado);

        return new EmpleadoResponseDTO(empleado, departamento, municipio);

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

    public EmpleadoResponseDTO setSalario(EmpleadoSalarioDTO empleadoSalarioDTO) {

        Empleado empleado = this.empleadoRepository.findById(empleadoSalarioDTO.getId())
                .orElseThrow(() -> new NoSuchElementException(String.format("No se encontro el empleado por su id: %s", empleadoSalarioDTO.getId())));

        BigDecimal salarioLiquido = SalarioUtils.calcularSalarioLiquido(empleadoSalarioDTO.getSalario());
        empleado.setSalario(salarioLiquido);


        //return new EmpleadoDTO(empleadoRepository.save(empleado));
        return new EmpleadoResponseDTO(empleado);
    }

}
