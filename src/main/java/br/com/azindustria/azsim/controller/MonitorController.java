package br.com.azindustria.azsim.controller;

import br.com.azindustria.azsim.controller.dto.EventoDto;
import br.com.azindustria.azsim.controller.monitor.EventoBuffer;
import br.com.azindustria.azsim.controller.monitor.OcorrenciaBuffer;
import br.com.azindustria.azsim.entity.Evento;
import br.com.azindustria.azsim.entity.Ocorrencia;
import br.com.azindustria.azsim.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;

@RestController
public class MonitorController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private EventoBuffer eventoBuffer;

    @Autowired
    private OcorrenciaBuffer ocorrenciaBuffer;

    @GetMapping("/monitor/{unidade}")
    public String get(@PathVariable(value = "unidade") String unidade) {
        return "EVENTO-TESTE DESENVOLVIMENTO:" + unidade;
    }

    @PostMapping("/monitor/{unidade}")
    public String add(@PathVariable(value = "unidade") String unidade, @RequestBody EventoDto eventoDto) {
        Evento evento = eventoService.save(eventoDto);
        eventoBuffer.add(evento);

        if (evento.getAlarme() > 0 && nonNull(evento.getIdcliente())) {
            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrenciaBuffer.add(ocorrencia);
            this.simpMessagingTemplate.convertAndSend("/topic/ocorrencias", "");
        }

        this.simpMessagingTemplate.convertAndSend("/topic/eventos", "");
        return "EVENTO-RECEBIDO-SUCESSO";
    }
}
