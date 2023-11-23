package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;
import br.com.azindustria.azsim.core.port.in.GestaoConfigEventoPort;
import br.com.azindustria.azsim.core.port.out.GestaoConfigEventoRepository;
import org.springframework.stereotype.Service;

@Service
public class GestaoConfigEventoUseCase implements GestaoConfigEventoPort {

    GestaoConfigEventoRepository gestaoConfigEventoRepository;

    @Override
    public ConfigEvento save(ConfigEvento configEvento) {
        return null;
    }
}
