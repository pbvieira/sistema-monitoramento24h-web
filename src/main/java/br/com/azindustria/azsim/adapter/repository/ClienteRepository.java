package br.com.azindustria.azsim.adapter.repository;

import br.com.azindustria.azsim.adapter.repository.model.ClienteDocument;
import br.com.azindustria.azsim.adapter.repository.mongo.ClienteMongoRepository;
import br.com.azindustria.azsim.core.domain.cliente.exception.CodificadorEmUsoException;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.port.out.GestaoClienteRepository;
import br.com.azindustria.azsim.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Repository
public class ClienteRepository implements GestaoClienteRepository {

    ClienteMongoRepository clienteMongoRepository;

    public ClienteRepository(ClienteMongoRepository clienteMongoRepository) {
        this.clienteMongoRepository = clienteMongoRepository;
    }

    @Override
    public List<Cliente> findAll() {
        List<ClienteDocument> clienteDocuments = clienteMongoRepository.findAll();
        return clienteDocuments.stream().map(ClienteMapper.INSTANCE::toCliente).collect(Collectors.toList());
    }

    @Override
    public Cliente findById(String id) {
        return ClienteMapper.INSTANCE.toCliente(clienteMongoRepository.findById(id).orElse(null));
    }

    @Override
    public List<Cliente> findByNomeOrNomeFantasia(String nome, String nomeFantasia) {
        List<ClienteDocument> clienteDocuments = clienteMongoRepository.findByNomeLikeOrNomeFantasiaLike(nome, nomeFantasia);
        return clienteDocuments.stream().map(ClienteMapper.INSTANCE::toCliente).collect(Collectors.toList());
    }

    @Override
    public Cliente findOneByCodificador(Integer codificador) {
        return ClienteMapper.INSTANCE.toCliente(clienteMongoRepository.findOneByCodificador(codificador));
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteDocument clienteDocument = ClienteMapper.INSTANCE.toClienteDocument(cliente);
        ClienteDocument clienteExistente = clienteMongoRepository.findOneByCodificador(clienteDocument.getCodificador());
        if (nonNull(clienteExistente)) {
            throw new CodificadorEmUsoException(String.format("Codificador %s já está em uso no cliente %s", clienteExistente.getCodificador(), clienteExistente.getNome()));
        }

        clienteDocument = clienteMongoRepository.save(clienteDocument);
        return ClienteMapper.INSTANCE.toCliente(clienteDocument);
    }
}
