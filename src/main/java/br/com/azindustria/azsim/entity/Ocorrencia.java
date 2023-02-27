package br.com.azindustria.azsim.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ocorrencia_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocorrencia_seq")
    @SequenceGenerator(name = "ocorrencia_seq", sequenceName = "ocorrencia_seq")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private Evento evento;
}
