package br.com.azindustria.azsim.repository;

import br.com.azindustria.azsim.entity.Status;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public interface StatusRepository extends PagingAndSortingRepository<Status, Long> {

    Optional<Status> findByStsAndReferencia1(String status, String referencia1);
}
