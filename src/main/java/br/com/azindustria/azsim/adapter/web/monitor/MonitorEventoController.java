package br.com.azindustria.azsim.adapter.web.monitor;

import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.core.port.in.MonitorEventoPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
