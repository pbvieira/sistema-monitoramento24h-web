package br.com.azindustria.azsim.core.port.in;


import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;

import java.util.List;

public interface GestaoClientePort {

    List<Cliente> listar();

    Cliente buscarPorId(String id);

    List<Cliente> buscarPorNome(String nome);

    Cliente salvar(Cliente cliente);
}
