package br.com.azindustria.azsim.controller.monitor;

import br.com.azindustria.azsim.entity.Evento;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Scope("singleton")
public class EventoBuffer {

    @Getter
    @Setter
    private List<Evento> eventos;

    public EventoBuffer() {
        this.eventos = new ArrayList<>();
    }

    public synchronized void add(Evento evento) {
        if (this.eventos.size() > 250) {
            this.eventos.remove(this.eventos.size() - 1);
        }
        this.eventos.add(evento);
    }

}
