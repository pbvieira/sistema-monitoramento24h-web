package br.com.azindustria.azsim.domain.cliente.view;

import br.com.azindustria.azsim.domain.cliente.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente fromDto(ClienteDto clienteDto) {
        return Cliente.builder()
                .id(clienteDto.getId())
                .unidade(clienteDto.getUnidade())
                .habil(clienteDto.getHabil())
                .condor(clienteDto.getCondor())
                .natureza(clienteDto.getNatureza())
                .documento(clienteDto.getDocumento())
                .inscMunicipal(clienteDto.getInscMunicipal())
                .nome(clienteDto.getNome())
                .nomeFantasia(clienteDto.getNomeFantasia())
                .endereco(clienteDto.getEndereco())
                .bairro(clienteDto.getBairro())
                .cidade(clienteDto.getCidade())
                .uf(clienteDto.getUf())
                .cep(clienteDto.getCep())
                .build();
    }

    public ClienteDto fromEntity(Cliente cliente) {
        return ClienteDto.builder()
                .id(cliente.getId())
                .unidade(cliente.getUnidade())
                .habil(cliente.getHabil())
                .condor(cliente.getCondor())
                .natureza(cliente.getNatureza())
                .documento(cliente.getDocumento())
                .inscMunicipal(cliente.getInscMunicipal())
                .nome(cliente.getNome())
                .nomeFantasia(cliente.getNomeFantasia())
                .endereco(cliente.getEndereco())
                .bairro(cliente.getBairro())
                .cidade(cliente.getCidade())
                .uf(cliente.getUf())
                .cep(cliente.getCep())
                .build();
    }
}
