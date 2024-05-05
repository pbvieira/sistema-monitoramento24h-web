package br.com.azindustria.azsim.core.domain.monitoramento.model;

import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.domain.cliente.model.Setor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    private String unidade;

    private Integer ctx;

    private String tipoctx;

    private Integer portacom;

    private Long nrevento;

    private Integer codificador;

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

    public boolean isGeraOcorrencia() {
        return alarme > 0 && nonNull(idcliente);
    }

    public void complementarDados(Cliente cliente, ConfigEvento configEvento) {
        this.destatus = "Status não localizado";
        this.nmcliente = String.format("%s (codificador não localizado)", this.codificador);
        this.alarme = 0;
        Integer numeroSetor = null;

        if (nonNull(configEvento)) {
            if (nonNull(configEvento.getSetor())) {
                numeroSetor = Integer.parseInt(configEvento.getSetor(), 16);
            }
            this.destatus = configEvento.getDescricao();
        }

        if (nonNull(cliente)) {
            this.idcliente = cliente.getId();
            this.nmcliente = cliente.getNome();
            this.endereco = cliente.getEndereco();
            this.cidade = cliente.getCidade();
            if (nonNull(configEvento)) {
                this.alarme = configEvento.getAlarme();
            }

            if (nonNull(cliente.getSetores()) && nonNull(numeroSetor)) {
                Integer finalNumeroSetor = numeroSetor;
                Setor setor = cliente.getSetores().stream()
                        .filter(s -> s.getSetor().equals(finalNumeroSetor))
                        .findFirst().orElse(null);

                if (nonNull(setor)) {
                    this.numsetor = numeroSetor;
                    this.local = setor.getLocalizacao();
                } else {
                    this.local = "Setor não cadastrado";
                }
            }
        }
    }
}
