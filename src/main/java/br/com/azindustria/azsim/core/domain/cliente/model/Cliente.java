package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Data
public class Cliente {

    @Setter
    private boolean ativo;

    private String id;

    private String unidade;

    private String codHabil;

    private String codCondor;

    private NaturezaEnum natureza;

    private String documento;

    private String inscMunicipal;

    private String nome;

    private String nomeFantasia;

    private String endereco;

    private String bairro;

    private String cidade;

    private String uf;

    private String cep;

    private String observacao;

    private String procedimento;

    private String procedimentoPolicial;

    private List<Contato> contatos;

    private String modeloCentral;

    private String observacaoCentral;

    private Integer codificador;

    private List<Setor> setores;

    private List<Viagem> viagens;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) && Objects.equals(getUnidade(), cliente.getUnidade()) && Objects.equals(getCodHabil(), cliente.getCodHabil()) && Objects.equals(getCodCondor(), cliente.getCodCondor()) && getNatureza() == cliente.getNatureza() && Objects.equals(getDocumento(), cliente.getDocumento()) && Objects.equals(getInscMunicipal(), cliente.getInscMunicipal()) && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getNomeFantasia(), cliente.getNomeFantasia()) && Objects.equals(getEndereco(), cliente.getEndereco()) && Objects.equals(getBairro(), cliente.getBairro()) && Objects.equals(getCidade(), cliente.getCidade()) && Objects.equals(getUf(), cliente.getUf()) && Objects.equals(getCep(), cliente.getCep()) && Objects.equals(getObservacao(), cliente.getObservacao()) && Objects.equals(getProcedimento(), cliente.getProcedimento()) && Objects.equals(getProcedimentoPolicial(), cliente.getProcedimentoPolicial()) && Objects.equals(getModeloCentral(), cliente.getModeloCentral()) && Objects.equals(getObservacaoCentral(), cliente.getObservacaoCentral()) && Objects.equals(getCodificador(), cliente.getCodificador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUnidade(), getCodHabil(), getCodCondor(), getNatureza(), getDocumento(), getInscMunicipal(), getNome(), getNomeFantasia(), getEndereco(), getBairro(), getCidade(), getUf(), getCep(), getObservacao(), getProcedimento(), getProcedimentoPolicial(), getModeloCentral(), getObservacaoCentral(), getCodificador());
    }
}
