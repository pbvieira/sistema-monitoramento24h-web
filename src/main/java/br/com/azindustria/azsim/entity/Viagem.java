package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "viagem_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viagem_seq")
    @SequenceGenerator(name = "viagem_seq", sequenceName = "viagem_seq")
    private Long id;

    @NotBlank
    @Column(length = 255)
    private String nomeContatoNotificacaoSaida;

    @Column(length = 255)
    private String nomeContatoNotificacaoVolta;

    private Date dataSaida;

    private Date dataVolta;

    private Date dataEncerramento;

    @Column(length = 4000)
    private String observacao;

    @Column(length = 4000)
    private String procedimento;

    @Column(length = 4000)
    private String observacaoEncerramento;

}
