package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "evento_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
    @SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq")
    private Long id;

    private Integer ctx;

    @Column(length = 3)
    private String tipoctx;

    private Integer portacom;

    private Long nrevento;

    private Integer equipamento;

    @Column(length = 1)
    private String status;

    @Column(length = 2)
    private String referencia;

    @Column(length = 70)
    private String destatus;

    private Date dataevento;

    private Long idcliente;

    @Column(length = 255)
    private String nmcliente;

    private Integer numsetor;

    @Column(length = 100)
    private String local;

    @Column(length = 100)
    private String endereco;

    @Column(length = 100)
    private String cidade;

    private Integer alarme = 0;

}
