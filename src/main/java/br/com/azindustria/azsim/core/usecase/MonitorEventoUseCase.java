package br.com.azindustria.azsim.core.usecase;

import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.domain.monitoramento.model.ConfigEvento;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Evento;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import br.com.azindustria.azsim.core.port.in.MonitorEventoPort;
import br.com.azindustria.azsim.core.port.out.GestaoClienteRepository;
import br.com.azindustria.azsim.core.port.out.GestaoConfigEventoRepository;
import br.com.azindustria.azsim.core.port.out.MonitorEventoRepository;
import br.com.azindustria.azsim.core.port.out.MonitorOcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MonitorEventoUseCase implements MonitorEventoPort {

    MonitorEventoRepository monitorEventoRepository;
    MonitorOcorrenciaRepository monitorOcorrenciaRepository;
    GestaoClienteRepository gestaoClienteRepository;
    GestaoConfigEventoRepository gestaoConfigEventoRepository;

    public MonitorEventoUseCase(MonitorEventoRepository monitorEventoRepository, MonitorOcorrenciaRepository monitorOcorrenciaRepository, GestaoClienteRepository gestaoClienteRepository, GestaoConfigEventoRepository gestaoConfigEventoRepository) {
        this.monitorEventoRepository = monitorEventoRepository;
        this.monitorOcorrenciaRepository = monitorOcorrenciaRepository;
        this.gestaoClienteRepository = gestaoClienteRepository;
        this.gestaoConfigEventoRepository = gestaoConfigEventoRepository;
    }

    @Override
    public Evento save(Evento evento) {
        Cliente cliente = gestaoClienteRepository.findOneByCodificador(evento.getCodificador());
        ConfigEvento configEvento = gestaoConfigEventoRepository.findByStsAndReferencia1(evento.getStatus(), evento.getReferencia());
        evento.complementarDados(cliente, configEvento);
        evento = monitorEventoRepository.save(evento);

        if (evento.isGeraOcorrencia()) {
            Ocorrencia ocorrencia = new Ocorrencia(evento);
            ocorrencia.setDatacadastro(new Date());
            evento.setOcorrencia(monitorOcorrenciaRepository.save(ocorrencia));
        }
        return evento;
    }
}
