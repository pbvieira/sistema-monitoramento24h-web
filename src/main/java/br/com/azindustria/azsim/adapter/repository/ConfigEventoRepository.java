package br.com.azindustria.azsim.adapter.repository;

import br.com.azindustria.azsim.adapter.repository.model.ConfigEventoDocument;
import br.com.azindustria.azsim.adapter.repository.mongo.ConfigEventoMongoRepository;
import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;
import br.com.azindustria.azsim.core.port.out.GestaoConfigEventoRepository;
import br.com.azindustria.azsim.mapper.ConfigEventoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConfigEventoRepository implements GestaoConfigEventoRepository {

    ConfigEventoMongoRepository configEventoMongoRepository;

    public ConfigEventoRepository(ConfigEventoMongoRepository configEventoMongoRepository) {
        this.configEventoMongoRepository = configEventoMongoRepository;
    }

    @Override
    public ConfigEvento findByStsAndReferencia1(String status, String referencia1) {
        return ConfigEventoMapper.INSTANCE.toConfigEvento(configEventoMongoRepository.findByStsAndReferencia1(status, referencia1));
    }

    @Override
    public List<ConfigEvento> findAll() {
        return null;
    }

    @Override
    public ConfigEvento findById(String id) {
        return null;
    }

    @Override
    public ConfigEvento save(ConfigEvento configEvento) {
        ConfigEventoDocument configEventoDocument = ConfigEventoMapper.INSTANCE.toConfigEventoDocument(configEvento);
        configEventoDocument = configEventoMongoRepository.save(configEventoDocument);
        return ConfigEventoMapper.INSTANCE.toConfigEvento(configEventoDocument);
    }
}
