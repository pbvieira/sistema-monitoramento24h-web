package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Viagem implements Serializable {

    private String nomeContatoNotificacaoSaida;

    private String nomeContatoNotificacaoVolta;

    private Date dataSaida;

    private Date dataVolta;

    private Date dataEncerramento;

    private String observacao;

    private String procedimento;

    private String observacaoEncerramento;
}
