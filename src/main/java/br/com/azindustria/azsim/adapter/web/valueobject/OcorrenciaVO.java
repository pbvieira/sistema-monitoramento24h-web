package br.com.azindustria.azsim.adapter.web.valueobject;

import lombok.Data;

import java.util.Date;

@Data
public class OcorrenciaVO {

    private String id;

    private String idocorrenciapai;

    private EventoVO evento;

    private Date datacadastro;

    private Date dataatendimento;

    private Date dataencerramento;

    private String idagente;

    private String idoperadorabertura;

    private String idoperadorfechamento;

    private Date horasaidaemp;

    private Date horasaidacliente;

    private Date horaaberturalacre;

    private Integer kmsaida;

    private Integer kmretorno;

    private Integer kmtotalpercorrido;

    private Date horachegadaemp;

    private Date horachegadacliente;

    private Date tempodeslocamento;

    private Date temporetorno;

    private Date tempoatendimento;

    private String lacre;

    private String resumo;

    private String tipoocorrencia;

    private String subtipoocorrencia;

    private boolean ocorrenciapolicial;

    private String ocorrenciapolicialresumo;

    private String idordemservico;

}
