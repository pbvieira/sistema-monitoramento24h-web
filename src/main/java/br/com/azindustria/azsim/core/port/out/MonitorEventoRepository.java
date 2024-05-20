package br.com.azindustria.azsim.core.port.out;

import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;

public interface MonitorEventoRepository {

    Evento save(Evento evento);

}
