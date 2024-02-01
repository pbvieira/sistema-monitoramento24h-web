package br.com.azindustria.azsim.adapter.repository.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "config_evento")
public class ConfigEventoDocument {

    @Id
    private String id;

    @Indexed
    private String sts;

    @Indexed
    private String referencia1;

    @Indexed
    private String referencia2;

    private String setor;

    private String grupo;

    private Integer alarme;

    private Integer mensagem;

    private Integer monitor;

    private Integer identificacao;

    private Integer ocorrencia;

    private String descricao;

    private String cor;

}
