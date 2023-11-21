package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;

import java.util.Date;

@Data
public class Contato {

    private String nome;

    private Date dataNascimento;

    private String senha;

    private String contraSenha;

    private String telefone;

    private String observacao;

    public void setTelefone(String telefone) {
        this.telefone = telefone.replaceAll("[^a-zA-Z0-9 ]", "");
    }
}
