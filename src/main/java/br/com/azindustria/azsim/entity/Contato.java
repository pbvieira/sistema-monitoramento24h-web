package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contato_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_seq")
    @SequenceGenerator(name = "contato_seq", sequenceName = "contato_seq")
    private Long id;

    @Column(length = 255)
    private String nome;

    @Column(length = 10)
    private String dataNascimento;

    @Column(length = 100)
    private String senha;

    @Column(length = 100)
    private String contraSenha;

    @Column(length = 14)
    private String telefone;

    @Column(length = 100)
    private String observacao;

}
