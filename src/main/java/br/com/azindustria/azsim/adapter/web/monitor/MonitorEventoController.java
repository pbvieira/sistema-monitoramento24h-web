package br.com.azindustria.azsim.adapter.web.monitor;

import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.adapter.web.valueobject.OcorrenciaVO;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import br.com.azindustria.azsim.core.port.in.MonitorEventoPort;
import br.com.azindustria.azsim.mapper.EventoMapper;
import br.com.azindustria.azsim.mapper.OcorrenciaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evento")
public class MonitorEventoController {

    private final MonitorEventoPort monitorEventoPort;


    public MonitorEventoController(MonitorEventoPort monitorEventoPort) {
        this.monitorEventoPort = monitorEventoPort;
    }

    @PostMapping
    ResponseEntity<EventoVO> salvar(@Validated @RequestBody EventoVO eventoVO) {
        monitorEventoPort.save(eventoVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventoVO>> buscarTodosEventos() {


        List<Evento> todosEventos = monitorEventoPort.findAll();

        List<EventoVO> eventoVOs = todosEventos.stream()
                .map(evento -> EventoMapper.INSTANCE.toEventoVO(evento)) // Usa a instância injetada do mapper
                .collect(Collectors.toList());

        if (eventoVOs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(eventoVOs, HttpStatus.OK);
    }
    }


