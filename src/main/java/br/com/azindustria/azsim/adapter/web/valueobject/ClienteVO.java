package br.com.azindustria.azsim.adapter.web.valueobject;

import br.com.azindustria.azsim.core.domain.cliente.model.Contato;
import br.com.azindustria.azsim.core.domain.cliente.model.NaturezaEnum;
import br.com.azindustria.azsim.core.domain.cliente.model.Setor;
import br.com.azindustria.azsim.core.domain.cliente.model.Viagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteVO {

    private String id;

    @NotNull(message = "Unidade deve ser preechida")
    private String unidade;

    private String codHabil;

    private String codCondor;

    @NotNull(message = "Natureza deve ser preechida")
    private NaturezaEnum natureza;

    @NotNull(message = "Documento deve ser preechido")
    private String documento;

    private String inscMunicipal;

    @NotNull(message = "Nome deve ser preechido")
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

    private String modeloCentral;

    private String observacaoCentral;

    private Integer codificador;

    private List<Contato> contatos;

    private List<Setor> setores;

    private List<Viagem> viagens;

    private boolean ativo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteVO clienteVO = (ClienteVO) o;
        return Objects.equals(getId(), clienteVO.getId()) && Objects.equals(getUnidade(), clienteVO.getUnidade()) && Objects.equals(getCodHabil(), clienteVO.getCodHabil()) && Objects.equals(getCodCondor(), clienteVO.getCodCondor()) && getNatureza() == clienteVO.getNatureza() && Objects.equals(getDocumento(), clienteVO.getDocumento()) && Objects.equals(getInscMunicipal(), clienteVO.getInscMunicipal()) && Objects.equals(getNome(), clienteVO.getNome()) && Objects.equals(getNomeFantasia(), clienteVO.getNomeFantasia()) && Objects.equals(getEndereco(), clienteVO.getEndereco()) && Objects.equals(getBairro(), clienteVO.getBairro()) && Objects.equals(getCidade(), clienteVO.getCidade()) && Objects.equals(getUf(), clienteVO.getUf()) && Objects.equals(getCep(), clienteVO.getCep()) && Objects.equals(getObservacao(), clienteVO.getObservacao()) && Objects.equals(getProcedimento(), clienteVO.getProcedimento()) && Objects.equals(getProcedimentoPolicial(), clienteVO.getProcedimentoPolicial()) && Objects.equals(getModeloCentral(), clienteVO.getModeloCentral()) && Objects.equals(getObservacaoCentral(), clienteVO.getObservacaoCentral()) && Objects.equals(getCodificador(), clienteVO.getCodificador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUnidade(), getCodHabil(), getCodCondor(), getNatureza(), getDocumento(), getInscMunicipal(), getNome(), getNomeFantasia(), getEndereco(), getBairro(), getCidade(), getUf(), getCep(), getObservacao(), getProcedimento(), getProcedimentoPolicial(), getModeloCentral(), getObservacaoCentral(), getCodificador());
    }
}
