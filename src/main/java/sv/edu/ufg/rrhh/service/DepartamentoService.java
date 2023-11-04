package sv.edu.ufg.rrhh.service;

import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.repository.IDepartamentoRepository;

@Service
public class DepartamentoService {

    private final IDepartamentoRepository departamentoRepository;

    public DepartamentoService(IDepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }


}
