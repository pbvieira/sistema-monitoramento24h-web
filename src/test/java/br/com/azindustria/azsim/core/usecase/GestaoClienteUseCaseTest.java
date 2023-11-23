package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.AdapterRepositoryMongoConfig;
import br.com.azindustria.azsim.core.domain.cliente.model.*;
import br.com.azindustria.azsim.core.port.in.GestaoClientePort;
import br.com.azindustria.container.MongoDbContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GestaoClienteUseCaseTest extends AdapterRepositoryMongoConfig {

    @Autowired
    GestaoClientePort gestaoClientePort;

    Cliente cliente;

    @BeforeAll
    static void startContainerAndPublicPortIsAvailable() {
        mongoDbContainer = new MongoDbContainer();
        mongoDbContainer.start();
    }

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setUnidade("montenegro");
        cliente.setCodCondor("codHabil");
        cliente.setCodHabil("codHabil");
        cliente.setNatureza(NaturezaEnum.JURIDICA);
        cliente.setDocumento("documento");
        cliente.setInscMunicipal("insc municipal");
        cliente.setNome("nome do cliente");
        cliente.setNomeFantasia("nome fantasia");
        cliente.setEndereco("endereco");
        cliente.setBairro("bairro");
        cliente.setCidade("cidade");
        cliente.setUf("uf");
        cliente.setCep("cep");
        cliente.setObservacao("observacao");
        cliente.setProcedimento("procedimento");
        cliente.setProcedimentoPolicial("procedimento policial");

        Contato contato = new Contato();
        contato.setNome("nome contato");
        contato.setDataNascimento(new Date());
        contato.setSenha("senha");
        contato.setContraSenha("contra senha");
        contato.setTelefone("(48) 99999-9999");
        contato.setObservacao("observacao");
        cliente.setContatos(Collections.singletonList(contato));

        Central central = new Central();
        central.setModeloCentral("MTA980");
        central.setObservacao("observacao");
        central.setCodificador(98657898);

        Setor setor = new Setor();
        setor.setSetor(1);
        setor.setLocalizacao("localizacao");
        setor.setObservacao("observacao");

        central.setSetores(Collections.singletonList(setor));

        cliente.setCentral(central);

        Viagem viagem = new Viagem();
        viagem.setNomeContatoNotificacaoSaida("NomeContatoNotificacaoSaida");
        viagem.setNomeContatoNotificacaoVolta("NomeContatoNotificacaoVolta");
        viagem.setDataSaida(new Date());
        viagem.setDataVolta(new Date());
        viagem.setDataEncerramento(new Date());
        viagem.setObservacao("Observacao");
        viagem.setProcedimento("Procedimento");
        viagem.setObservacaoEncerramento("ObservacaoEncerramento");

        cliente.setViagens(Collections.singletonList(viagem));
    }

    @Test
    void cadastroClienteTest() {
        cliente = gestaoClientePort.save(cliente);
        assertNotNull(cliente.getId());
        assertNotNull(cliente.getContatos());
        assertNotNull(cliente.getCentral());
        assertNotNull(cliente.getViagens());
    }

    @Test
    void buscarPorNomeTest() {
        cliente = gestaoClientePort.save(cliente);
        List<Cliente> nomes = gestaoClientePort.findByNomeOrNomeFantasia("nome");
        assertTrue(nomes.size() > 0);
    }

    @Test
    void buscarPorIdTest() {
        cliente = gestaoClientePort.save(cliente);
        Cliente buscarPorId = gestaoClientePort.findById(cliente.getId());
        assertNotNull(buscarPorId);
    }

    @Test
    void listarTest() {
        cliente = gestaoClientePort.save(cliente);
        List<Cliente> nomes = gestaoClientePort.findAll();
        assertTrue(nomes.size() > 0);
    }

}
