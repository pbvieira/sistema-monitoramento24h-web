package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.EventoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoMongoRepository extends MongoRepository<EventoDocument, String> {

    List<EventoDocument> findFirst250ByOrderByDataeventoDesc();
}
