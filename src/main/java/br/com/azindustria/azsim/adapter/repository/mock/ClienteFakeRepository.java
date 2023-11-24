package br.com.azindustria.azsim.adapter.repository.mock;

import br.com.azindustria.azsim.adapter.repository.model.ClienteDocument;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.port.out.GestaoClienteRepository;
import br.com.azindustria.azsim.mapper.ClienteMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Profile("test")
@Repository
public class ClienteFakeRepository implements GestaoClienteRepository {

    private final Map<String, ClienteDocument> banco = new HashMap<>();

    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public Cliente findById(String id) {
        return null;
    }

    @Override
    public List<Cliente> findByNomeOrNomeFantasia(String nome, String nomeFantasia) {
        return null;
    }

    @Override
    public Cliente findOneByCodificador(Integer codificador) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteDocument clienteDocument = ClienteMapper.INSTANCE.toClienteDocument(cliente);
        clienteDocument.setId(UUID.randomUUID().toString());
        banco.put(clienteDocument.getId(), clienteDocument);
        return ClienteMapper.INSTANCE.toCliente(banco.get(clienteDocument.getId()));
    }
}
