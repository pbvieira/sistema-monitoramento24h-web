package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.AzsimApplicationTest;
import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.container.MongoDbContainer;
import br.com.azindustria.azsim.core.domain.cliente.model.*;
import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;
import br.com.azindustria.azsim.core.port.in.GestaoClientePort;
import br.com.azindustria.azsim.core.port.in.MonitorEventoPort;
import br.com.azindustria.azsim.core.port.out.GestaoConfigEventoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.junit.jupiter.api.Assertions.*;

class MonitorEventoUseCaseTest extends AzsimApplicationTest {

    public static final int CODIFICADOR = 98657898;

    @Autowired
    GestaoClientePort gestaoClientePort;

    @Autowired
    GestaoConfigEventoRepository gestaoConfigEventoRepository;

    @Autowired
    MonitorEventoPort monitorEventoPort;

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
            contato.setNome("nome contato");
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

        ConfigEvento configEvento1 = new ConfigEvento();
        configEvento1.setSts("2");
        configEvento1.setReferencia1("02");
        configEvento1.setReferencia2("");
        configEvento1.setSetor("02");
        configEvento1.setGrupo("ALR");
        configEvento1.setAlarme(1);
        configEvento1.setMensagem(0);
        configEvento1.setMonitor(0);
        configEvento1.setIdentificacao(0);
        configEvento1.setOcorrencia(2);
        configEvento1.setDescricao("INVASAO SETOR");
        configEvento1.setCor("255");

        ConfigEvento stsAndReferencia1 = gestaoConfigEventoRepository.findByStsAndReferencia1(configEvento1.getSts(), configEvento1.getReferencia1());
        if (isNull(stsAndReferencia1)) {
            gestaoConfigEventoRepository.save(configEvento1);
        }

        ConfigEvento configEvento2 = new ConfigEvento();
        configEvento2.setSts("2");
        configEvento2.setReferencia1("03");
        configEvento2.setReferencia2("");
        configEvento2.setSetor("03");
        configEvento2.setGrupo("ALR");
        configEvento2.setAlarme(1);
        configEvento2.setMensagem(0);
        configEvento2.setMonitor(0);
        configEvento2.setIdentificacao(0);
        configEvento2.setOcorrencia(2);
        configEvento2.setDescricao("INVASAO SETOR");
        configEvento2.setCor("255");

        ConfigEvento stsAndReferencia2 = gestaoConfigEventoRepository.findByStsAndReferencia1(configEvento2.getSts(), configEvento2.getReferencia1());
        if (isNull(stsAndReferencia2)) {
            gestaoConfigEventoRepository.save(configEvento2);
        }
    }

    @Test
    void cadastroEventoInvasaoSetorTest() {
        EventoVO evento = new EventoVO();
        evento.setUnidade("MONTENEGRO");
        evento.setCtx(1001);
        evento.setTipoctx("CTA");
        evento.setPortacom(5);
        evento.setNrevento(1L);
        evento.setCodificador(CODIFICADOR);
        evento.setStatus("2");
        evento.setReferencia("02");
        evento.setDestatus("INVASAO SETOR");
        evento.setDataevento(new Date());

        evento = monitorEventoPort.save(evento);

        assertEquals("MONTENEGRO", evento.getUnidade());
        assertEquals(1001, evento.getCtx());
        assertEquals("CTA", evento.getTipoctx());
        assertEquals(5, evento.getPortacom());
        assertEquals(1l, evento.getNrevento());
        assertEquals(CODIFICADOR, evento.getCodificador());
        assertEquals("2", evento.getStatus());
        assertEquals("02", evento.getReferencia());
        assertEquals("INVASAO SETOR", evento.getDestatus());
        assertNotNull(evento.getDataevento());
        assertEquals(cliente.getId(), evento.getIdcliente());
        assertEquals(cliente.getNome(), evento.getNmcliente());
        assertEquals(2, evento.getNumsetor());
        assertEquals("localizacao", evento.getLocal());
        assertEquals(cliente.getEndereco(), evento.getEndereco());
        assertEquals(cliente.getCidade(), evento.getCidade());
        assertEquals(1, evento.getAlarme());
    }

    @Test
    void cadastroEventoStatusDesconhecidoTest() {
        EventoVO evento = new EventoVO();
        evento.setUnidade("MONTENEGRO");
        evento.setCtx(1001);
        evento.setTipoctx("CTA");
        evento.setPortacom(5);
        evento.setNrevento(1L);
        evento.setCodificador(CODIFICADOR);
        evento.setStatus("2");
        evento.setReferencia("04");
        evento.setDestatus("INVASAO SETOR");
        evento.setDataevento(new Date());

        evento = monitorEventoPort.save(evento);

        assertEquals("MONTENEGRO", evento.getUnidade());
        assertEquals(1001, evento.getCtx());
        assertEquals("CTA", evento.getTipoctx());
        assertEquals(5, evento.getPortacom());
        assertEquals(1l, evento.getNrevento());
        assertEquals(CODIFICADOR, evento.getCodificador());
        assertEquals("2", evento.getStatus());
        assertEquals("04", evento.getReferencia());
        assertEquals("Status não localizado", evento.getDestatus());
        assertNotNull(evento.getDataevento());
        assertEquals(cliente.getId(), evento.getIdcliente());
        assertEquals(cliente.getNome(), evento.getNmcliente());
        assertNull(evento.getNumsetor());
        assertNull(evento.getLocal());
        assertEquals(cliente.getEndereco(), evento.getEndereco());
        assertEquals(cliente.getCidade(), evento.getCidade());
        assertEquals(0, evento.getAlarme());
    }

    @Test
    void cadastroEventoInvasaoSetorNaoCadastradoTest() {
        EventoVO evento = new EventoVO();
        evento.setUnidade("MONTENEGRO");
        evento.setCtx(1001);
        evento.setTipoctx("CTA");
        evento.setPortacom(5);
        evento.setNrevento(1L);
        evento.setCodificador(CODIFICADOR);
        evento.setStatus("2");
        evento.setReferencia("03");
        evento.setDestatus("INVASAO SETOR");
        evento.setDataevento(new Date());

        evento = monitorEventoPort.save(evento);

        assertEquals("MONTENEGRO", evento.getUnidade());
        assertEquals(1001, evento.getCtx());
        assertEquals("CTA", evento.getTipoctx());
        assertEquals(5, evento.getPortacom());
        assertEquals(1l, evento.getNrevento());
        assertEquals(CODIFICADOR, evento.getCodificador());
        assertEquals("2", evento.getStatus());
        assertEquals("03", evento.getReferencia());
        assertEquals("INVASAO SETOR", evento.getDestatus());
        assertNotNull(evento.getDataevento());
        assertEquals(cliente.getId(), evento.getIdcliente());
        assertEquals(cliente.getNome(), evento.getNmcliente());
        assertNull(evento.getNumsetor());
        assertEquals("Setor não cadastrado", evento.getLocal());
        assertEquals(cliente.getEndereco(), evento.getEndereco());
        assertEquals(cliente.getCidade(), evento.getCidade());
        assertEquals(1, evento.getAlarme());
    }

    @Test
    void cadastroEventoInvasaoSetorClienteNaoCadastradoTest() {
        EventoVO evento = new EventoVO();
        evento.setUnidade("MONTENEGRO");
        evento.setCtx(1001);
        evento.setTipoctx("CTA");
        evento.setPortacom(5);
        evento.setNrevento(1L);
        evento.setCodificador(12345689);
        evento.setStatus("2");
        evento.setReferencia("03");
        evento.setDestatus("INVASAO SETOR");
        evento.setDataevento(new Date());

        evento = monitorEventoPort.save(evento);

        assertEquals("MONTENEGRO", evento.getUnidade());
        assertEquals(1001, evento.getCtx());
        assertEquals("CTA", evento.getTipoctx());
        assertEquals(5, evento.getPortacom());
        assertEquals(1l, evento.getNrevento());
        assertEquals(12345689, evento.getCodificador());
        assertEquals("2", evento.getStatus());
        assertEquals("03", evento.getReferencia());
        assertEquals("INVASAO SETOR", evento.getDestatus());
        assertNotNull(evento.getDataevento());
        assertNull(evento.getIdcliente());
        assertEquals("12345689 (codificador não localizado)", evento.getNmcliente());
        assertNull(evento.getNumsetor());
        assertNull(evento.getLocal());
        assertNull(evento.getEndereco());
        assertNull(evento.getCidade());
        assertEquals(0, evento.getAlarme());
    }
}
