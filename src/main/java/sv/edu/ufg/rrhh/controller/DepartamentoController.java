package sv.edu.ufg.rrhh.controller;

import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.rrhh.projection.IDeptoProjection;
import sv.edu.ufg.rrhh.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/deptos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<IDeptoProjection> getAll() {
        return this.departamentoService.getAll();
    }

    @GetMapping("/{id}")
    public IDeptoProjection getById(@PathVariable Integer id) {
        if (id == null)
            throw new RuntimeException("Id del depto proporcionado no puede estar vacio");

        return this.departamentoService.getOneById(id);
    }

    @GetMapping("/busqueda")
    public IDeptoProjection getByNombre(@RequestParam String nombre) {
        if (nombre == null)
            throw new RuntimeException("El nombre del depto no puede estar vacio");

        return this.departamentoService.getOneByNombre(nombre);
    }
}
