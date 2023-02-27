package br.com.azindustria.azsim.repository;

import br.com.azindustria.azsim.entity.Evento;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EventoRepository extends PagingAndSortingRepository<Evento, Long> {

    List<Evento> findFirst250ByOrderByDataeventoDesc();

}
