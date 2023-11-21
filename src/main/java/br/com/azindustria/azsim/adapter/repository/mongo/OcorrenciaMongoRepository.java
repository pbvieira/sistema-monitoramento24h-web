package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.OcorrenciaDocument;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("!test")
@Repository
public interface OcorrenciaMongoRepository extends MongoRepository<OcorrenciaDocument, String> {

}
