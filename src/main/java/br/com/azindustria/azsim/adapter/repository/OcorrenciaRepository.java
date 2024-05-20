package br.com.azindustria.azsim.adapter.repository;

import br.com.azindustria.azsim.adapter.repository.model.OcorrenciaDocument;
import br.com.azindustria.azsim.adapter.repository.mongo.OcorrenciaMongoRepository;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import br.com.azindustria.azsim.core.port.out.MonitorOcorrenciaRepository;
import br.com.azindustria.azsim.mapper.OcorrenciaMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OcorrenciaRepository implements MonitorOcorrenciaRepository {

    OcorrenciaMongoRepository ocorrenciaMongoRepository;

    public OcorrenciaRepository(OcorrenciaMongoRepository ocorrenciaMongoRepository) {
        this.ocorrenciaMongoRepository = ocorrenciaMongoRepository;
    }

    @Override
    public Ocorrencia save(Ocorrencia ocorrencia) {
        OcorrenciaDocument ocorrenciaDocument = OcorrenciaMapper.INSTANCE.toOcorrenciaDocument(ocorrencia);
        ocorrenciaDocument = ocorrenciaMongoRepository.save(ocorrenciaDocument);
        return OcorrenciaMapper.INSTANCE.toOcorrencia(ocorrenciaDocument);
    }

    @Override
    public Ocorrencia findById(String id) {
        return OcorrenciaMapper.INSTANCE.toOcorrencia(ocorrenciaMongoRepository.findById(id).orElse(null));
    }

}
