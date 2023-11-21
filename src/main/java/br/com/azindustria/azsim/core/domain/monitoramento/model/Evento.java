package br.com.azindustria.azsim.core.domain.monitoramento.model;

import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.domain.cliente.model.Setor;
import lombok.Data;

import java.util.Date;

import static java.util.Objects.nonNull;

@Data
public class Evento {

    private String id;

    private String unidade;

    private Integer ctx;

    private String tipoctx;

    private Integer portacom;

    private Long nrevento;

    private Integer equipamento;

    private String status;

    private String referencia;

    private String destatus;

    private Date dataevento;

    private String idcliente;

    private String nmcliente;

    private Integer numsetor;

    private String local;

    private String endereco;

    private String cidade;

    private Integer alarme = 0;

    private Ocorrencia ocorrencia;

    public boolean isGeraOcorrencia() {
        return alarme > 0 && nonNull(idcliente);
    }

    public void complementarDados(Cliente cliente, ConfigEvento configEvento) {
        this.destatus = "Status não localizado";
        this.nmcliente = String.format("%s (codificador não localizado)", this.equipamento);
        this.alarme = 0;

        if (nonNull(cliente)) {
            this.idcliente = cliente.getId();
            this.nmcliente = cliente.getNome();

            if (nonNull(cliente.getCentral()) && nonNull(cliente.getCentral().getSetores()) && nonNull(this.numsetor)) {
                Setor setor = cliente.getCentral().getSetores().stream()
                        .filter(s -> s.getSetor().equals(this.numsetor))
                        .findFirst().orElse(null);

                if (nonNull(setor)) {
                    this.local = setor.getLocalizacao();
                } else {
                    this.local = "Setor não cadastrado";
                }
            }
        }

        if (nonNull(configEvento)) {
            this.status = configEvento.getSts();
            this.referencia = configEvento.getReferencia1();
            this.destatus = configEvento.getDescricao();
            this.alarme = configEvento.getAlarme();
            this.numsetor = Integer.parseInt(configEvento.getSetor(), 16);
        }
    }
}
