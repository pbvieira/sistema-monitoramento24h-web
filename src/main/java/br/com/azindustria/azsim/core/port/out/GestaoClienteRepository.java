package br.com.azindustria.azsim.core.port.out;

import br.com.azindustria.azsim.core.domain.cliente.exception.CodificadorEmUsoException;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;

import java.util.List;

public interface GestaoClienteRepository {


    List<Cliente> findByAtivoTrue();

    List<Cliente> findAll();

    Cliente findById(String id);

    List<Cliente> findByNomeOrNomeFantasia(String nome, String nomeFantasia);

    Cliente findOneByCodificador(Integer codificador);

    Cliente save(Cliente cliente) throws CodificadorEmUsoException;
}
