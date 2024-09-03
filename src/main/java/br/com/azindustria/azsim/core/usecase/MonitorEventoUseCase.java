package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.adapter.web.valueobject.OcorrenciaVO;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import br.com.azindustria.azsim.core.port.in.MonitorEventoPort;
import br.com.azindustria.azsim.core.port.out.GestaoClienteRepository;
import br.com.azindustria.azsim.core.port.out.GestaoConfigEventoRepository;
import br.com.azindustria.azsim.core.port.out.MonitorEventoRepository;
import br.com.azindustria.azsim.core.port.out.MonitorOcorrenciaRepository;
import br.com.azindustria.azsim.mapper.EventoMapper;
import br.com.azindustria.azsim.mapper.OcorrenciaMapper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MonitorEventoUseCase implements MonitorEventoPort {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private final MonitorEventoRepository monitorEventoRepository;
    private final MonitorOcorrenciaRepository monitorOcorrenciaRepository;
    private final GestaoClienteRepository gestaoClienteRepository;
    private final GestaoConfigEventoRepository gestaoConfigEventoRepository;

    public MonitorEventoUseCase(SimpMessagingTemplate simpMessagingTemplate, MonitorEventoRepository monitorEventoRepository,
                                MonitorOcorrenciaRepository monitorOcorrenciaRepository, GestaoClienteRepository gestaoClienteRepository,
                                GestaoConfigEventoRepository gestaoConfigEventoRepository) {

        this.simpMessagingTemplate = simpMessagingTemplate;
        this.monitorEventoRepository = monitorEventoRepository;
        this.monitorOcorrenciaRepository = monitorOcorrenciaRepository;
        this.gestaoClienteRepository = gestaoClienteRepository;
        this.gestaoConfigEventoRepository = gestaoConfigEventoRepository;
    }

    @Override
    public EventoVO save(EventoVO eventoRequest) {
        Evento evento = EventoMapper.INSTANCE.toEvento(eventoRequest);
        Cliente cliente = gestaoClienteRepository.findOneByCodificador(evento.getCodificador());
        ConfigEvento configEvento = gestaoConfigEventoRepository.findByStsAndReferencia1(evento.getStatus(), evento.getReferencia());
        evento.complementarDados(cliente, configEvento);
        evento = monitorEventoRepository.save(evento);

        EventoVO eventoResponse = EventoMapper.INSTANCE.toEventoVO(evento);
        this.simpMessagingTemplate.convertAndSend("/topic/eventos", eventoResponse);

        if (evento.isGeraOcorrencia()) {
            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setEvento(evento);
            ocorrencia.setDatacadastro(new Date());
            OcorrenciaVO ocorrenciaResponse = OcorrenciaMapper.INSTANCE.toOcorrenciaVO(monitorOcorrenciaRepository.save(ocorrencia));
            this.simpMessagingTemplate.convertAndSend("/topic/ocorrencias", ocorrenciaResponse);
        }

        return eventoResponse;
    }

    public List<Evento> findAll() {
        return monitorEventoRepository.findAll();
    }


}
