package br.com.azindustria.azsim.controller.monitor;

import br.com.azindustria.azsim.entity.Ocorrencia;
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
public class OcorrenciaBuffer {

    @Getter
    @Setter
    private List<Ocorrencia> ocorrencias;

    public OcorrenciaBuffer() {
        this.ocorrencias = new ArrayList<>();
    }

    public synchronized void add(Ocorrencia ocorrencia) {
        this.ocorrencias.add(ocorrencia);
    }

    public synchronized void remove(Ocorrencia ocorrencia) {
        this.ocorrencias.remove(ocorrencia);
    }
}
