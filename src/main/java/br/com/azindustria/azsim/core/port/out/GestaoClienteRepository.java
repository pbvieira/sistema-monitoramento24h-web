package br.com.azindustria.azsim.core.port.out;

import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;

import java.util.List;

public interface GestaoClienteRepository {

    List<Cliente> findAll();

    Cliente findById(String id);

    List<Cliente> findByNomeOrNomeFantasia(String nome, String nomeFantasia);

    Cliente findOneByCentralCodificadorNumero(Integer codificador);

    Cliente save(Cliente cliente);
}
