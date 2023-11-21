package br.com.azindustria.azsim.mapper;

import br.com.azindustria.azsim.adapter.repository.model.ClienteDocument;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.domain.cliente.model.Contato;
import br.com.azindustria.azsim.core.domain.cliente.model.NaturezaEnum;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ClienteMapperTest {

    @Test
    void convertClientToClienteDocumentTest() {
        Cliente cliente = new Cliente();
        cliente.setId("id");
        cliente.setUnidade("montenegro");
        cliente.setCodCondor("codHabil");
        cliente.setCodHabil("codHabil");
        cliente.setNatureza(NaturezaEnum.JURIDICA);
        cliente.setDocumento("documento");
        cliente.setInscMunicipal("insc municipal");
        cliente.setNome("nome");
        cliente.setNomeFantasia("nome fantasia");
        cliente.setEndereco("endereco");
        cliente.setBairro("bairro");
        cliente.setCidade("cidade");
        cliente.setUf("uf");
        cliente.setCep("cep");
        cliente.setObservacao("observacao");
        cliente.setProcedimento("procedimento");
        cliente.setProcedimentoPolicial("procedimento policial");

        Contato contato = new Contato();
        contato.setNome("nome contato");
        contato.setDataNascimento(new Date());
        contato.setSenha("senha");
        contato.setContraSenha("contra senha");
        contato.setTelefone("(48) 99999-9999");
        contato.setObservacao("observacao");
        cliente.setContatos(Collections.singletonList(contato));

        ClienteDocument clienteDocument = ClienteMapper.INSTANCE.toClienteDocument(cliente);

        assertEquals(clienteDocument.hashCode(), cliente.hashCode());
    }
}
