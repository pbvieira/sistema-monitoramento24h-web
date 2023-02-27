package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "setor_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setor_seq")
    @SequenceGenerator(name = "setor_seq", sequenceName = "setor_seq")
    private Long id;

    private Integer setor;

    @Column(length = 100)
    private String localizacao;

    @Column(length = 400)
    private String observacao;
    
}
