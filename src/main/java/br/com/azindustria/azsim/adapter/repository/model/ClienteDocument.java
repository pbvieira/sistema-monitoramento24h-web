package br.com.azindustria.azsim.adapter.repository.model;

import br.com.azindustria.azsim.core.domain.cliente.model.Contato;
import br.com.azindustria.azsim.core.domain.cliente.model.NaturezaEnum;
import br.com.azindustria.azsim.core.domain.cliente.model.Setor;
import br.com.azindustria.azsim.core.domain.cliente.model.Viagem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "cliente")
public class ClienteDocument {

    @Id
    private String id;

    @Indexed
    private String unidade;

    private String codHabil;

    private String codCondor;

    private NaturezaEnum natureza;

    @Field("ativo")
    private boolean ativo = true;


    @Indexed
    private String documento;

    private String inscMunicipal;

    @TextIndexed
    private String nome;

    @TextIndexed
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

    @Indexed(unique = true)
    private Integer codificador;

    private List<Setor> setores;

    private List<Viagem> viagens;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDocument that = (ClienteDocument) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUnidade(), that.getUnidade()) && Objects.equals(getCodHabil(), that.getCodHabil()) && Objects.equals(getCodCondor(), that.getCodCondor()) && getNatureza() == that.getNatureza() && Objects.equals(getDocumento(), that.getDocumento()) && Objects.equals(getInscMunicipal(), that.getInscMunicipal()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getNomeFantasia(), that.getNomeFantasia()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getBairro(), that.getBairro()) && Objects.equals(getCidade(), that.getCidade()) && Objects.equals(getUf(), that.getUf()) && Objects.equals(getCep(), that.getCep()) && Objects.equals(getObservacao(), that.getObservacao()) && Objects.equals(getProcedimento(), that.getProcedimento()) && Objects.equals(getProcedimentoPolicial(), that.getProcedimentoPolicial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUnidade(), getCodHabil(), getCodCondor(), getNatureza(), getDocumento(), getInscMunicipal(), getNome(), getNomeFantasia(), getEndereco(), getBairro(), getCidade(), getUf(), getCep(), getObservacao(), getProcedimento(), getProcedimentoPolicial(), getModeloCentral(), getObservacaoCentral(), getCodificador());
    }
}
