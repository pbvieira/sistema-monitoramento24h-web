package br.com.azindustria.azsim.service.impl;

import br.com.azindustria.azsim.entity.Central;
import br.com.azindustria.azsim.entity.Cliente;
import br.com.azindustria.azsim.entity.Codificador;
import br.com.azindustria.azsim.entity.CodificadorHistorico;
import br.com.azindustria.azsim.repository.ClienteRepository;
import br.com.azindustria.azsim.repository.CodificadorHistoricoRepository;
import br.com.azindustria.azsim.repository.CodificadorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@Data
public class ClienteServiceImpl implements br.com.azindustria.azsim.service.ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CodificadorRepository codificadorRepository;

    @Autowired
    private CodificadorHistoricoRepository codificadorHistoricoRepository;


    @Override
    public Cliente salvar(Cliente cliente) {
        try {
            cliente = clienteRepository.save(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente salvo com sucesso", null));
        } catch (Exception ex) {
            if (nonNull(ex.getMessage()) && ex.getMessage().contains("INDEX_CODIFICADOR_NUMERO")) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Codificador já está cadastrado para outro cliente", null));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
            }
        }

        return cliente;
    }

    @Override
    public void vincularCodificadorAoCliente(Long clienteId, Integer numeroCodificador) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Codificador codificador;
            CodificadorHistorico codificadorHistorico = new CodificadorHistorico();
            codificadorHistorico.setClientId(clienteId);
            codificadorHistorico.setNumero(numeroCodificador);
            codificadorHistorico.setDataCadastro(new Date());
            codificadorHistorico.setNome(cliente.getNome());
            codificadorHistorico.setCidade(cliente.getCidade());

            if (isNull(cliente.getCentral())) {
                cliente.setCentral(new Central());
            }

            Optional<Codificador> codificadorOptional = codificadorRepository.findByNumero(numeroCodificador);
            if (codificadorOptional.isPresent()) {
                codificador = codificadorOptional.get();
            } else {
                codificador = new Codificador();
                codificador.setNumero(numeroCodificador);
                codificador.setCentral(cliente.getCentral());
            }

            cliente.getCentral().setCodificador(codificador);
            clienteRepository.save(cliente);
            codificadorHistoricoRepository.save(codificadorHistorico);

            FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO,
                    String.format("Codificador %s vinculado com sucesso", numeroCodificador),null));
        }
    }

    @Override
    public Optional<Cliente> findByCentralCodificadorNumero(Integer codificador) {
        return clienteRepository.findByCentralCodificadorNumero(codificador);
    }

    @Override
    public List<Cliente> findByNomeContainingIgnoreCaseOrNomeFantasiaContainingIgnoreCase(String nome, String nomeFantasia) {
        return clienteRepository.findByNomeContainingIgnoreCaseOrNomeFantasiaContainingIgnoreCase(nome, nomeFantasia);
    }

}
