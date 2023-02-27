package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "estatus_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estatus_seq")
    @SequenceGenerator(name = "estatus_seq", sequenceName = "estatus_seq")
    private Integer id;

    @Column(length = 1)
    private String sts;

    @Column(length = 2)
    private String referencia1;

    @Column(length = 2)
    private String referencia2;

    @Column(length = 2)
    private String setor;

    @Column(length = 3)
    private String grupo;

    private Integer alarme;

    private Integer mensagem;

    private Integer monitor;

    private Integer identificacao;

    private Integer ocorrencia;

    @Column(length = 70)
    private String descricao;

    @Column(length = 10)
    private String cor;

}
