package sv.edu.ufg.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sv.edu.ufg.rrhh.entity.Departamento;
import sv.edu.ufg.rrhh.projection.IDeptoProjection;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {

    @Query("SELECT d FROM Departamento d")
    List<IDeptoProjection> findAllView();

    @Query("SELECT d FROM Departamento d WHERE d.id = :id")
    Optional<IDeptoProjection> getOneById(Integer id);

    @Query("SELECT d FROM Departamento d WHERE d.nombre like %:nombre%")
    Optional<IDeptoProjection> getOneByNombre(String nombre);
}
