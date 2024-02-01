package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;

import java.util.Date;

@Data
public class Viagem {

    private String nomeContatoNotificacaoSaida;

    private String nomeContatoNotificacaoVolta;

    private Date dataSaida;

    private Date dataVolta;

    private Date dataEncerramento;

    private String observacao;

    private String procedimento;

    private String observacaoEncerramento;
}
