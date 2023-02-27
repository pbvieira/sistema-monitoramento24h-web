package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "codificador_historico_tbl", indexes={
        @Index(columnList="numero", name="index_codificador_hist_numero"),
        @Index(columnList="clientId", name="index_codificador_hist_clientId")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodificadorHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "codificador_hist_seq")
    @SequenceGenerator(name = "codificador_hist_seq", sequenceName = "codificador_hist_seq")
    private Long id;

    private Integer numero;

    private Long clientId;

    private Date dataCadastro;

    private String nome;

    private String cidade;
}
