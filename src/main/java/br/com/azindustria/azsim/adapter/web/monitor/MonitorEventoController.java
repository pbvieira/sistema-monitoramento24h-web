package br.com.azindustria.azsim.adapter.web.monitor;

import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;
import br.com.azindustria.azsim.core.port.in.MonitorEventoPort;
import br.com.azindustria.azsim.mapper.EventoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class MonitorEventoController {

    private final MonitorEventoPort monitorEventoPort;

    private final SimpMessagingTemplate simpMessagingTemplate;

    public MonitorEventoController(MonitorEventoPort monitorEventoPort, SimpMessagingTemplate simpMessagingTemplate) {
        this.monitorEventoPort = monitorEventoPort;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping
    ResponseEntity<EventoVO> salvar(@Validated @RequestBody EventoVO eventoRequest) {
        Evento evento = monitorEventoPort.save(EventoMapper.INSTANCE.toEvento(eventoRequest));
        EventoVO eventoResponse = EventoMapper.INSTANCE.toEventoVO(evento);
        this.simpMessagingTemplate.convertAndSend("/topic/eventos", eventoResponse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
