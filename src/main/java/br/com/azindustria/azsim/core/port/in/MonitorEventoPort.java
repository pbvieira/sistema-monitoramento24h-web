package br.com.azindustria.azsim.core.port.in;

import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;

public interface MonitorEventoPort {

    Evento save(Evento evento);

}
