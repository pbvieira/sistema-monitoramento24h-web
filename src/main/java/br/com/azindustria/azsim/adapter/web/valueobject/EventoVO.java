package br.com.azindustria.azsim.adapter.web.valueobject;

import lombok.Data;

import java.util.Date;

@Data
public class EventoVO {

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
        return  alarme == 1;
    }
}
