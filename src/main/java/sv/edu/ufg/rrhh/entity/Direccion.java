package sv.edu.ufg.rrhh.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@Getter //Genera Getters Lombok
@NoArgsConstructor //Genera Constructor Vacio Lombok
@AllArgsConstructor //Genera Construtor con Parametros Lombok
public class Direccion {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Municipio municipio;
    private String complemento;
}
