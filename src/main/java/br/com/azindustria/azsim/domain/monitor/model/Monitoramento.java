package br.com.azindustria.azsim.domain.monitor.model;

import br.com.azindustria.azsim.domain.cliente.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "monitoramento_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monitoramento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monitoramento_seq")
    @SequenceGenerator(name = "monitoramento_seq", sequenceName = "monitoramento_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(unique = true, nullable = false)
    private Integer codificador;

    @Column(length = 255)
    private String modeloCentral;

    @Column(length = 255)
    private String endereco;

    @Column(length = 100)
    private String bairro;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 10)
    private String cep;

    @Column(length = 600)
    private String observacao;

}
