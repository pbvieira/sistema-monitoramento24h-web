package br.com.azindustria.azsim.domain.cliente.view;

import java.util.Date;
import java.util.List;

public class ContatoDto {

    private Long id;
    String nome;
    Date dataNascimento;
    String senha;
    String contraSenha;
    String observacao;
    List<TelefoneDto> telefones;

}
