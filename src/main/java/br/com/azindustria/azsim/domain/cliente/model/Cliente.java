package br.com.azindustria.azsim.domain.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "cliente_tbl")
@Builder
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
    String unidade;

    @Column(length = 20)
    String habil;

    @Column(length = 20)
    String condor;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    NaturezaEnum natureza;

    @NotBlank
    @Column(length = 20)
    String documento;

    @Column(length = 20)
    String inscMunicipal;

    @NotBlank
    @Column(length = 255)
    String nome;

    @Column(length = 255)
    String nomeFantasia;

    @Column(length = 255)
    String endereco;

    @Column(length = 100)
    String bairro;

    @Column(length = 100)
    String cidade;

    @Column(length = 2)
    String uf;

    @Column(length = 10)
    String cep;
}