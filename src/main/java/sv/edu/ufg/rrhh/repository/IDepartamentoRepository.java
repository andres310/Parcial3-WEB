package sv.edu.ufg.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.ufg.rrhh.entity.Departamento;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
