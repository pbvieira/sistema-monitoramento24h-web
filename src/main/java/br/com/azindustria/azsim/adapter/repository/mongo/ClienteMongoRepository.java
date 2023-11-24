package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.ClienteDocument;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("!test")
@Repository
public interface ClienteMongoRepository extends MongoRepository<ClienteDocument, String> {

    ClienteDocument findOneByCodificador(Integer codificador);

    List<ClienteDocument> findByNomeLikeOrNomeFantasiaLike(String nome, String nomeFantasia);
}
