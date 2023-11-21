package br.com.azindustria.azsim.core.port.in;

import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;

public interface MonitorOcorrenciaPort {

    Ocorrencia salvar(Ocorrencia ocorrencia);

}
