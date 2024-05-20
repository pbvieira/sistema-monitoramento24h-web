package br.com.azindustria.azsim.core.domain.monitoramento.model;

import br.com.azindustria.azsim.core.domain.cliente.model.Contato;
import br.com.azindustria.azsim.core.domain.cliente.model.Setor;
import br.com.azindustria.azsim.core.domain.cliente.model.Viagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigEvento {

    private String id;

    private String sts;

    private String referencia1;

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

    private List<Setor> setores;

    private List<Viagem> viagens;

    private List<Contato> contato;


}
