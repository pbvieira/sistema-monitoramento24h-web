package br.com.azindustria.azsim.core.port.in;


import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;

import java.util.List;

public interface GestaoClientePort {

    List<Cliente> findAll();

    Cliente findById(String id);

    List<Cliente> findByNomeOrNomeFantasia(String nome);

    Cliente save(Cliente cliente);

    Cliente findOneByCodificador(Integer codificador);
}
