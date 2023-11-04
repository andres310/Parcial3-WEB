package sv.edu.ufg.rrhh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sv.edu.ufg.rrhh.dto.EmpleadoDTO;
import sv.edu.ufg.rrhh.service.EmpleadoService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;



    @PostMapping
    public ResponseEntity<EmpleadoDTO> registrar(@RequestBody @Valid EmpleadoDTO empleadoDTO,
                                                       UriComponentsBuilder uriComponentsBuilder){

        var response = empleadoService.save(empleadoDTO);

        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(response.getId()).toUri(); // Creamos URI dinamicamente.
        return ResponseEntity.created(url).body(response); // HTTP Status 201 - Created With URI

    }

}
