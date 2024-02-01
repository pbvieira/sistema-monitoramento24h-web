package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.AzsimApplicationTest;
import br.com.azindustria.azsim.container.MongoDbContainer;
import br.com.azindustria.azsim.core.domain.cliente.exception.CodificadorEmUsoException;
import br.com.azindustria.azsim.core.domain.cliente.model.*;
import br.com.azindustria.azsim.core.port.in.GestaoClientePort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.*;

class GestaoClienteUseCaseTest extends AzsimApplicationTest {

    public static final int CODIFICADOR = 98657898;

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
        Cliente clienteExistente = gestaoClientePort.findOneByCodificador(CODIFICADOR);

        if (nonNull(clienteExistente)) {
            cliente = clienteExistente;
        } else {
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
            contato.setNome("Pablo Santos");
            contato.setDataNascimento(new Date());
            contato.setSenha("senha");
            contato.setContraSenha("contra senha");
            contato.setTelefone("(48) 99999-9999");
            contato.setObservacao("observacao");
            cliente.setContatos(Collections.singletonList(contato));

            cliente.setModeloCentral("MTA980");
            cliente.setObservacaoCentral("observacao");
            cliente.setCodificador(CODIFICADOR);

            Setor setor = new Setor();
            setor.setSetor(2);
            setor.setLocalizacao("localizacao");
            setor.setObservacao("observacao");
            cliente.setSetores(Collections.singletonList(setor));

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
            cliente = gestaoClientePort.save(cliente);
        }
    }

    @Test
    void cadastroClienteTest() {
        assertNotNull(cliente.getId());
        assertNotNull(cliente.getContatos());
        assertNotNull(cliente.getViagens());
    }

    @Test
    void cadastroClienteCodificadorEmUsoTest() {
        Exception exception = assertThrows(CodificadorEmUsoException.class, () -> {
            cliente = gestaoClientePort.save(cliente);
        });

        String expectedMessage = "Codificador 98657898 já está em uso no cliente nome do cliente";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void buscarPorNomeTest() {
        List<Cliente> nomes = gestaoClientePort.findByNomeOrNomeFantasia("fantasia");
        assertTrue(nomes.size() > 0);
    }

    @Test
    void buscarPorIdTest() {
        Cliente buscarPorId = gestaoClientePort.findById(cliente.getId());
        assertNotNull(buscarPorId);
    }

    @Test
    void listarTest() {
        List<Cliente> nomes = gestaoClientePort.findAll();
        assertTrue(nomes.size() > 0);
    }

}
