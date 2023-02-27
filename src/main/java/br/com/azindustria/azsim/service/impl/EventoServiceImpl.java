package br.com.azindustria.azsim.service.impl;

import br.com.azindustria.azsim.controller.dto.EventoDto;
import br.com.azindustria.azsim.entity.Cliente;
import br.com.azindustria.azsim.entity.Status;
import br.com.azindustria.azsim.entity.Evento;
import br.com.azindustria.azsim.entity.Setor;
import br.com.azindustria.azsim.repository.ClienteRepository;
import br.com.azindustria.azsim.repository.StatusRepository;
import br.com.azindustria.azsim.repository.EventoRepository;
import br.com.azindustria.azsim.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Evento save(EventoDto eventoDto) {
        Optional<Status> statusOptional = this.statusRepository.findByStsAndReferencia1(eventoDto.getStatus(), eventoDto.getReferencia());
        Optional<Cliente> clienteOptional = this.clienteRepository.findByCentralCodificadorNumero(eventoDto.getEquipamento());

        Evento evento = new Evento();
        evento.setCtx(eventoDto.getCtx());
        evento.setTipoctx(eventoDto.getTipoctx());
        evento.setPortacom(eventoDto.getPortacom());
        evento.setNrevento(eventoDto.getNrevento());
        evento.setEquipamento(eventoDto.getEquipamento());
        evento.setStatus(eventoDto.getStatus());
        evento.setReferencia(eventoDto.getReferencia());
        evento.setDataevento(eventoDto.getDataevento());
        evento.setDestatus("Status não localizado");
        evento.setNmcliente(String.format("%s (codificador não localizado)", eventoDto.getEquipamento()));
        evento.setAlarme(0);

        if (statusOptional.isPresent()) {
            Status status = statusOptional.get();
            evento.setStatus(status.getSts());
            evento.setReferencia(status.getReferencia1());
            evento.setDestatus(status.getDescricao());
            evento.setAlarme(status.getAlarme());
            evento.setNumsetor(Integer.parseInt(status.getSetor(), 16));
        }

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            evento.setIdcliente(cliente.getId());
            evento.setNmcliente(cliente.getNome());
            evento.setEndereco(cliente.getEndereco());
            evento.setCidade(cliente.getCidade());

            if (nonNull(cliente.getCentral()) && nonNull(cliente.getCentral().getSetores())) {
                if (nonNull(evento.getNumsetor())) {
                    List<Setor> setor = cliente.getCentral().getSetores().stream()
                            .filter(s -> s.getSetor().equals(evento.getNumsetor())).collect(Collectors.toList());

                    if (!setor.isEmpty()) {
                        evento.setLocal(setor.get(0).getLocalizacao());
                    } else {
                        evento.setLocal("Setor não cadastrado");
                    }
                }
            }
        }

        return this.eventoRepository.save(evento);
    }

    @Override
    public List<Evento> findFirst250ByOrderByDataeventoDesc() {
        return eventoRepository.findFirst250ByOrderByDataeventoDesc();
    }
}
