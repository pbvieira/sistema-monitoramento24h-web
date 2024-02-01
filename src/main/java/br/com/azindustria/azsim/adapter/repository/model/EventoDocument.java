package br.com.azindustria.azsim.adapter.repository.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "evento")
public class EventoDocument {

    @Id
    private String id;

    @Indexed
    private String unidade;

    private Integer ctx;

    private String tipoctx;

    private Integer portacom;

    private Long nrevento;

    @Indexed
    private Integer codificador;

    @Indexed
    private String status;

    @Indexed
    private String referencia;

    private String destatus;

    @Indexed
    private Date dataevento;

    @Indexed
    private String idcliente;

    private String nmcliente;

    private Integer numsetor;

    private String local;

    private String endereco;

    private String cidade;

    private Integer alarme = 0;

    public boolean isGeraOcorrencia() {
        return alarme == 1;
    }
}
