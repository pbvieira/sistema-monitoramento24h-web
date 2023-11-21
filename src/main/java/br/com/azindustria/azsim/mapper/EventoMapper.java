package br.com.azindustria.azsim.mapper;

import br.com.azindustria.azsim.adapter.repository.model.EventoDocument;
import br.com.azindustria.azsim.adapter.web.valueobject.EventoVO;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventoMapper {

    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    EventoDocument toEventoDocument(Evento evento);

    Evento toEvento(EventoDocument eventoDocument);

    Evento toEvento(EventoVO eventoVO);

    EventoVO toEventoVO(Evento evento);
}
