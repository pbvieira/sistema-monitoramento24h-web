package br.com.azindustria.azsim.core.domain.monitoramento.model;

import lombok.Data;

@Data
public class ConfigEvento {

    private String id;

    private String sts;

    private String referencia1;

    private String referencia2;

    private String setor;

    private String grupo;

    private Integer alarme;

    private Integer mensagem;

    private Integer monitor;

    private Integer identificacao;

    private Integer ocorrencia;

    private String descricao;

    private String cor;

}
