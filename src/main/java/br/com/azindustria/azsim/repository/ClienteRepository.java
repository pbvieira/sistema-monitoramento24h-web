package br.com.azindustria.azsim.repository;

import br.com.azindustria.azsim.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

    Optional<Cliente> findByCentralCodificadorNumero(Integer codificador);

    List<Cliente> findByNomeContainingIgnoreCaseOrNomeFantasiaContainingIgnoreCase(String nome, String nomeFantasia);
}
