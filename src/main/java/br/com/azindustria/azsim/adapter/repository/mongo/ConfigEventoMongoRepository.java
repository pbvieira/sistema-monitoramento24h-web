package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.ConfigEventoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigEventoMongoRepository extends MongoRepository<ConfigEventoDocument, String> {

    ConfigEventoDocument findByStsAndReferencia1(String status, String referencia1);
}
