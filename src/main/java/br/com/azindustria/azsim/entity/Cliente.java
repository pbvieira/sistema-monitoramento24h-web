package br.com.azindustria.azsim.entity;

import br.com.azindustria.azsim.type.NaturezaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "cliente_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq")
    private Long id;

    @NotBlank
    @Column(length = 100)
    private String unidade;

    @Column(length = 20)
    private String habil;

    @Column(length = 20)
    private String condor;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private NaturezaEnum natureza;

    @NotBlank
    @Column(length = 20)
    private String documento;

    @Column(length = 20)
    private String inscMunicipal;

    @NotBlank
    @Column(length = 255)
    private String nome;

    @Column(length = 255)
    private String nomeFantasia;

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

    @Column(length = 4000)
    private String procedimento;

    @Column(length = 4000)
    private String procedimentoPolicial;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Contato> contatos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "central_id", referencedColumnName = "id")
    private Central central;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Viagem> viagens;

}