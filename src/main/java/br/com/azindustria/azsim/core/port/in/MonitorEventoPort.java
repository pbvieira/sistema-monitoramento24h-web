package br.com.azindustria.azsim.core.port.in;

import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;

public interface MonitorEventoPort {

    EventoVO save(EventoVO eventoVO);

}
