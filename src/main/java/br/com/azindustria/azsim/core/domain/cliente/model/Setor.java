package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Setor implements Serializable {

    private Integer setor;

    private String localizacao;

    private String observacao;
}
