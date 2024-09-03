package br.com.azindustria.azsim.core.port.in;

import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;

import java.util.List;

public interface MonitorEventoPort {

    EventoVO save(EventoVO eventoVO);

    List<Evento> findAll();

}
