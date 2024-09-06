package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import br.com.azindustria.azsim.core.port.in.OcorrenciaPort;
import br.com.azindustria.azsim.core.port.out.MonitorOcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaUseCase implements OcorrenciaPort {

    MonitorOcorrenciaRepository monitorOcorrenciaRepository;

    public OcorrenciaUseCase(MonitorOcorrenciaRepository monitorOcorrenciaRepository) {
        this.monitorOcorrenciaRepository = monitorOcorrenciaRepository;
    }

    @Override
    public Ocorrencia findById(String id) {
        return monitorOcorrenciaRepository.findById(id);
    }

    public List<Ocorrencia> findTop50ByOrderByDatacadastroDesc() {
        return monitorOcorrenciaRepository.findTop50ByOrderByDatacadastroDesc();
    }

    @Override
    public Ocorrencia save(Ocorrencia ocorrencia) {
        return monitorOcorrenciaRepository.save(ocorrencia);
    }
}
