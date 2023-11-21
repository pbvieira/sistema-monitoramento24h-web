package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.EventoDocument;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("!test")
@Repository
public interface EventoMongoRepository extends MongoRepository<EventoDocument, String> {

    List<EventoDocument> findFirst250ByOrderByDataeventoDesc();
}
