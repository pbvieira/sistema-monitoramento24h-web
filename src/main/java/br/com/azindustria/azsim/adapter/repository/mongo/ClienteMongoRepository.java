package br.com.azindustria.azsim.adapter.repository.mongo;

import br.com.azindustria.azsim.adapter.repository.model.ClienteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteMongoRepository extends MongoRepository<ClienteDocument, String> {

    ClienteDocument findOneByCodificador(Integer codificador);

    ClienteDocument findByCodificador(String codificador);

    List<ClienteDocument> findByNomeLikeOrNomeFantasiaLike(String nome, String nomeFantasia);
}
