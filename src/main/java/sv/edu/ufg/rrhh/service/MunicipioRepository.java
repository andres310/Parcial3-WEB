package sv.edu.ufg.rrhh.service;

import org.springframework.stereotype.Service;
import sv.edu.ufg.rrhh.repository.IMunicipioRepository;

@Service
public class MunicipioRepository {

    private final IMunicipioRepository municipioRepository;

    public MunicipioRepository(IMunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }


}
