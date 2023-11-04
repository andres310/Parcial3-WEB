package sv.edu.ufg.rrhh.projection;

import java.util.List;

public interface IDeptoProjection {
    Integer getId();
    String getNombre();
    List<IMunicipioProjection> getMunicipios();
}
