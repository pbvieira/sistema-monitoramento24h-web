package br.com.azindustria.azsim.mapper;

import br.com.azindustria.azsim.adapter.repository.model.OcorrenciaDocument;
import br.com.azindustria.azsim.adapter.web.valueobject.OcorrenciaVO;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OcorrenciaMapper {

    OcorrenciaMapper INSTANCE = Mappers.getMapper(OcorrenciaMapper.class);

    OcorrenciaDocument toOcorrenciaDocument(Ocorrencia ocorrencia);

    Ocorrencia toOcorrencia(OcorrenciaDocument ocorrenciaDocument);

    Ocorrencia toOcorrencia(OcorrenciaVO ocorrenciaVO);

    OcorrenciaVO toOcorrenciaVO(Ocorrencia ocorrencia);
}
