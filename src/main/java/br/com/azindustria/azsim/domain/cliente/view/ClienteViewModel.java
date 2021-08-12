package br.com.azindustria.azsim.domain.cliente.view;

import br.com.azindustria.azsim.domain.cliente.model.NaturezaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteViewModel {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String unidade;

    @Size(max = 20)
    private String habil;

    @Size(max = 20)
    private String condor;

    private NaturezaEnum natureza;

    @NotBlank
    @Size(max = 20)
    private String documento;

    @Size(max = 20)
    private String inscMunicipal;

    @NotBlank
    @Size(max = 255)
    private String nome;

    @Size(max = 255)
    private String nomeFantasia;

    @Size(max = 255)
    private String endereco;

    @Size(max = 100)
    private String bairro;

    @Size(max = 100)
    private String cidade;

    @Size(max = 2)
    private String uf;

    @Size(max = 10)
    private String cep;

    @Size(max = 600)
    private String observacao;

    private Long monitoramentoId;

    private Integer monitoramentoCodificador;

    @Size(max = 255)
    private String monitoramentoModeloCentral;

    @Size(max = 255)
    private String monitoramentoEndereco;

    @Size(max = 100)
    private String monitoramentoBairro;

    @Size(max = 100)
    private String monitoramentoCidade;

    @Size(max = 2)
    private String monitoramentoUf;

    @Size(max = 10)
    private String monitoramentoCep;

    @Size(max = 600)
    private String monitoramentoObservacao;
}