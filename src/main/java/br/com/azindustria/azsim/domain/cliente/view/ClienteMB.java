package br.com.azindustria.azsim.domain.cliente.view;

import br.com.azindustria.azsim.core.lazy.CustomLazyDataModel;
import br.com.azindustria.azsim.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.domain.cliente.model.ClienteRepository;
import br.com.azindustria.azsim.domain.cliente.model.NaturezaEnum;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;

import static java.util.Objects.nonNull;

@Data
@Component
@RequestScope
public class ClienteMB implements Serializable {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    private String documentoMask = "999999999-99";

    @Autowired
    private CustomLazyDataModel<Cliente, Long, ClienteRepository> clienteLazyDataModel;

    private ClienteDto cliente;

    @PostConstruct
    public void init() {
        this.cliente = new ClienteDto();
    }

    public void salvar() {
        this.cliente = clienteMapper.fromEntity(
                this.clienteRepository.save(clienteMapper.fromDto(this.cliente)));

        PrimeFaces.current().ajax().update("clientesForm:clientesDataTable");
    }

    public void novo() {
        this.cliente = new ClienteDto();
        PrimeFaces.current().ajax().update("clienteForm");
    }

    public void changeMask() {
        if (nonNull(this.cliente.getNatureza()) && this.cliente.getNatureza().equals(NaturezaEnum.FISICA)) {
            this.documentoMask = "999999999-99";
        } else {
            documentoMask = "99.999.999/9999-99";
        }
    }
}