package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "codificador_tbl", indexes={@Index(columnList="numero", name="index_codificador_numero", unique = true)})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Codificador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codificador_seq")
    @SequenceGenerator(name = "codificador_seq", sequenceName = "codificador_seq")
    private Long id;

    private Integer numero;

    @OneToOne(mappedBy = "codificador")
    private Central central;

}
