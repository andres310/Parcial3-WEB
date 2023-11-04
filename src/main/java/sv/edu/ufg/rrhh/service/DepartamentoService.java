package sv.edu.ufg.rrhh.service;

import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.projection.IDeptoProjection;
import sv.edu.ufg.rrhh.repository.IDepartamentoRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartamentoService {

    private final IDepartamentoRepository departamentoRepository;

    public DepartamentoService(IDepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<IDeptoProjection> getAll() {
        return this.departamentoRepository.findAllView();
    }

    public IDeptoProjection getOneById(Integer id) {
        return this.departamentoRepository.getOneById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No se encontro el departamento por su id", id)));
    }

    public IDeptoProjection getOneByNombre(String nombre) {
        return this.departamentoRepository.getOneByNombre(nombre)
                .orElseThrow(() -> new NoSuchElementException(String.format("No se encontro el depto con nombre: ", nombre)));
    }
}
