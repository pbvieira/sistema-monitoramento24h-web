package br.com.azindustria.azsim.adapter.repository;

import br.com.azindustria.azsim.adapter.repository.model.EventoDocument;
import br.com.azindustria.azsim.adapter.repository.mongo.EventoMongoRepository;
import br.com.azindustria.azsim.adapter.repository.mongo.OcorrenciaMongoRepository;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;
import br.com.azindustria.azsim.core.port.out.MonitorEventoRepository;
import br.com.azindustria.azsim.mapper.EventoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventoRepository implements MonitorEventoRepository {

    EventoMongoRepository eventoMongoRepository;

    public EventoRepository(EventoMongoRepository eventoMongoRepository) {
        this.eventoMongoRepository = eventoMongoRepository;
    }

    @Override
    public Evento save(Evento evento) {
        EventoDocument eventoDocument = EventoMapper.INSTANCE.toEventoDocument(evento);
        eventoDocument = eventoMongoRepository.save(eventoDocument);
        return EventoMapper.INSTANCE.toEvento(eventoDocument);
    }

    @Override
    public List<Evento> findAll() {
        List<EventoDocument> ocorrenciaDocuments = eventoMongoRepository.findAll();
        return ocorrenciaDocuments.stream().map(EventoMapper.INSTANCE::toEvento).collect(Collectors.toList());
    }



}
