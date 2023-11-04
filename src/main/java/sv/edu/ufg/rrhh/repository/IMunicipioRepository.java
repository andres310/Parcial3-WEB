package sv.edu.ufg.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.ufg.rrhh.entity.Municipio;

public interface IMunicipioRepository extends JpaRepository<Municipio, Integer> {
}
