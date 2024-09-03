package br.com.azindustria.azsim.adapter.web.valueobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import br.com.azindustria.azsim.config.CustomTimeDeserializer;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date datacadastro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date dataatendimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date dataencerramento;

    private String idagente;

    private String agente;

    private String operador;

    private String idoperadorabertura;

    private String idoperadorfechamento;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    private Date horasaidaemp;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    private Date horasaidacliente;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    private Date horaaberturalacre;

    private Integer kmsaida;

    private Integer kmretorno;

    private Integer kmtotalpercorrido;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
    private Date horachegadaemp;

    @JsonDeserialize(using = CustomTimeDeserializer.class)
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

    private boolean aberta = true;

}
