package br.com.azindustria.azsim.core.port.out;

import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;

import java.util.List;

public interface MonitorOcorrenciaRepository {

    Ocorrencia save(Ocorrencia ocorrencia);

    Ocorrencia findById(String id);

    List<Ocorrencia> findTop50ByOrderByDatacadastroDesc();


}
