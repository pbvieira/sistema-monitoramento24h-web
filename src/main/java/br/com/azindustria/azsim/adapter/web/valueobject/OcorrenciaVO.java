package br.com.azindustria.azsim.adapter.web.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaVO {

    private String id;

    private String idocorrenciapai;

    private EventoVO evento;

    private Date datacadastro;

    private Date dataatendimento;

    private Date dataencerramento;

    private String idagente;

    private String agente;

    private String operador;

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

    private boolean deslocamento;

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
