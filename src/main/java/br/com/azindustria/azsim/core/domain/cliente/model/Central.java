package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;

import java.util.List;

@Data
public class Central {

    private String modeloCentral;

    private String observacao;

    private Integer codificador;

    private List<Setor> setores;
}
