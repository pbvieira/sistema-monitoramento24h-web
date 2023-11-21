package br.com.azindustria.azsim.core.port.out;

import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;

public interface MonitorOcorrenciaRepository {

    Ocorrencia save(Ocorrencia ocorrencia);
}
