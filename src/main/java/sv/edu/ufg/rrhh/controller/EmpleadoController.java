package sv.edu.ufg.rrhh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sv.edu.ufg.rrhh.dto.DesactivarEmpleadoDTO;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.dto.EmpleadoResponseDTO;
import sv.edu.ufg.rrhh.dto.EmpleadoSalarioDTO;
import sv.edu.ufg.rrhh.entity.Empleado;
import sv.edu.ufg.rrhh.service.EmpleadoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;


    @GetMapping
    public List<EmpleadoResponseDTO> listar(){
        // Traemos el Listado de Medicos
        // Luego lo mapeamos utilizando el DTO DatosListadoMedico (Requiere constructor en el DTO para Mapearlo)
        // y lo hacemos una lista
        return empleadoService.listar();
    }

    @GetMapping("/{id}")
    public EmpleadoResponseDTO obtenerPorId(@PathVariable Integer id) {
        return empleadoService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> registrar(@RequestBody @Valid EmpleadoDTO empleadoDTO,
                                                         UriComponentsBuilder uriComponentsBuilder){

        var response = empleadoService.save(empleadoDTO);

        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(response.getId()).toUri(); // Creamos URI dinamicamente.
        return ResponseEntity.created(url).body(response); // HTTP Status 201 - Created With URI

    }

    @PutMapping ("/{id}")
    public EmpleadoResponseDTO actualizar(@RequestBody @Valid EmpleadoDTO empleadoDTO) {
        return empleadoService.actualizar(empleadoDTO);
    }

    @PutMapping("/salario")
    public ResponseEntity<EmpleadoResponseDTO> salario(@RequestBody @Valid EmpleadoSalarioDTO empleadoSalarioDTO,
                                                         UriComponentsBuilder uriComponentsBuilder){

        var response = empleadoService.setSalario(empleadoSalarioDTO);

        return ResponseEntity.ok(response);


    }

    @PostMapping("/desactivar")
    public EmpleadoDTO desactivar(@RequestBody DesactivarEmpleadoDTO dto) {
        return this.empleadoService.desactivar(dto.getId(), dto.getMotivo());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        empleadoService.eliminarPorId(id);
        return ResponseEntity.ok("Registro eliminado");
    }
}
