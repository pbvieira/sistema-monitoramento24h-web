package br.com.azindustria.azsim.domain.cliente.view;

import br.com.azindustria.azsim.domain.cliente.model.NaturezaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private Long id;

    @NotBlank
    @Size(max = 100)
    String unidade;

    @Size(max = 20)
    String habil;

    @Size(max = 20)
    String condor;

    NaturezaEnum natureza;

    @NotBlank
    @Size(max = 20)
    String documento;

    @Size(max = 20)
    String inscMunicipal;

    @NotBlank
    @Size(max = 255)
    //@Size(max = 255, message = "Nome: Erro de validação: o valor deve ter no máximo 255 caracteres")
    String nome;

    @Size(max = 255)
    String nomeFantasia;

    @Size(max = 255)
    String endereco;

    @Size(max = 100)
    String bairro;

    @Size(max = 100)
    String cidade;

    @Size(max = 2)
    String uf;

    @Size(max = 10)
    String cep;
}