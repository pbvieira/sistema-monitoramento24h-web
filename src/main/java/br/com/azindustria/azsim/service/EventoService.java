package br.com.azindustria.azsim.service;

import br.com.azindustria.azsim.controller.dto.EventoDto;
import br.com.azindustria.azsim.entity.Evento;

import java.util.List;

public interface EventoService {

    Evento save(EventoDto eventoDto);

    List<Evento> findFirst250ByOrderByDataeventoDesc();
}
