package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.OcorrenciaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcorrenciaMongoRepository extends MongoRepository<OcorrenciaDocument, String> {

    List<OcorrenciaDocument> findTop50ByOrderByDatacadastroDesc();
}
