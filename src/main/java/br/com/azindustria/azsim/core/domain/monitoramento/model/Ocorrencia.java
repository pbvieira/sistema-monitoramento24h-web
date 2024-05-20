package br.com.azindustria.azsim.core.domain.monitoramento.model;

import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ocorrencia {

    private String id;

    private String idocorrenciapai;

    private Cliente cliente;

    private Evento evento;

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
