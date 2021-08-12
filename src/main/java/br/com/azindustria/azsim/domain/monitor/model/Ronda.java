package br.com.azindustria.azsim.domain.monitor.model;

import br.com.azindustria.azsim.domain.cliente.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ronda_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ronda_seq")
    @SequenceGenerator(name = "ronda_seq", sequenceName = "ronda_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

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

    private String agendamento;
}
