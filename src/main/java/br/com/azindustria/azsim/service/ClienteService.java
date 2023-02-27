package br.com.azindustria.azsim.service;

import br.com.azindustria.azsim.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente salvar(Cliente cliente);

    void vincularCodificadorAoCliente(Long clienteId, Integer numeroCodificador);

    Optional<Cliente> findByCentralCodificadorNumero(Integer codificador);

    List<Cliente> findByNomeContainingIgnoreCaseOrNomeFantasiaContainingIgnoreCase(String nome, String nomeFantasia);
}
