package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "central_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Central {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "central_seq")
    @SequenceGenerator(name = "central_seq", sequenceName = "central_seq")
    private Long id;

    @OneToOne(mappedBy = "central")
    private Cliente cliente;

    @Column(length = 255)
    private String modeloCentral;

    @Column(length = 600)
    private String observacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codificador_id", referencedColumnName = "id")
    private Codificador codificador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "central_id")
    private List<Setor> setores;

}
