package br.com.azindustria.azsim.core.domain.cliente.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Contato implements Serializable {

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
