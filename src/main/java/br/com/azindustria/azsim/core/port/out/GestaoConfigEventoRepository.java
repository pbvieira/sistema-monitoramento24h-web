package br.com.azindustria.azsim.core.port.out;

import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;

import java.util.List;

public interface GestaoConfigEventoRepository {

    ConfigEvento findByStsAndReferencia1(String status, String referencia1);

    List<ConfigEvento> findAll();

    ConfigEvento findById(String id);

    ConfigEvento save(ConfigEvento configEvento);

}
