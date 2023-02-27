package br.com.azindustria.azsim.repository;

import br.com.azindustria.azsim.entity.Codificador;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface CodificadorRepository extends PagingAndSortingRepository<Codificador, Long> {

    Optional<Codificador> findByNumero(Integer codificador);

}
