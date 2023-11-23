package br.com.azindustria.azsim.core.port.in;

import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;

public interface GestaoConfigEventoPort {

    ConfigEvento save(ConfigEvento configEvento);

}
