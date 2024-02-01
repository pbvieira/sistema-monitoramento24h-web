package br.com.azindustria.azsim.mapper;

import br.com.azindustria.azsim.adapter.repository.model.ConfigEventoDocument;
import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConfigEventoMapper {

    ConfigEventoMapper INSTANCE = Mappers.getMapper(ConfigEventoMapper.class);

    ConfigEventoDocument toConfigEventoDocument(ConfigEvento configEvento);

    ConfigEvento toConfigEvento(ConfigEventoDocument configEventoDocument);

}
