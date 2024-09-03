package br.com.azindustria.azsim.core.port.in;

import br.com.azindustria.azsim.adapter.repository.model.OcorrenciaDocument;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;

import java.util.List;

public interface OcorrenciaPort {

    Ocorrencia save(Ocorrencia ocorrencia);

    Ocorrencia findById(String id);

    List<Ocorrencia> findAll();

}
