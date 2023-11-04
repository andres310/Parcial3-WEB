package sv.edu.ufg.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.ufg.rrhh.entity.Departamento;
import sv.edu.ufg.rrhh.entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
