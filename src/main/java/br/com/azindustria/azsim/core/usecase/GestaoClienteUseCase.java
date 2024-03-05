package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.port.in.GestaoClientePort;
import br.com.azindustria.azsim.core.port.out.GestaoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GestaoClienteUseCase implements GestaoClientePort {

    GestaoClienteRepository gestaoClienteRepository;

    // Construtor

    @Override
    public List<Cliente> listarClientesAtivos() {
        return gestaoClienteRepository.findByAtivoTrue();
    }

    @Autowired
    public GestaoClienteUseCase(GestaoClienteRepository gestaoClienteRepository) {
        this.gestaoClienteRepository = gestaoClienteRepository;
    }


    public void toggleAtivo(String id, boolean ativo) {
        Cliente cliente = gestaoClienteRepository.findById(id);
        if (cliente != null) {
            cliente.setAtivo(ativo);
            gestaoClienteRepository.save(cliente);
        }
    }

    @Override
    public List<Cliente> findAll() {
        return gestaoClienteRepository.findAll();
    }

    @Override
    public Cliente findById(String id) {
        return gestaoClienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findByNomeOrNomeFantasia(String nome) {
        return gestaoClienteRepository.findByNomeOrNomeFantasia(nome, nome);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return gestaoClienteRepository.save(cliente);
    }

    @Override
    public Cliente findOneByCodificador(Integer codificador) {
        return gestaoClienteRepository.findOneByCodificador(codificador);
    }
}
