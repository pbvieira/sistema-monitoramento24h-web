package br.com.azindustria.azsim.mbean;

import br.com.azindustria.azsim.core.lazy.CustomLazyDataModel;
import br.com.azindustria.azsim.entity.*;
import br.com.azindustria.azsim.repository.ClienteRepository;
import br.com.azindustria.azsim.service.ClienteService;
import br.com.azindustria.azsim.type.NaturezaEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@Data
@Component(value = "clienteMB")
@ViewScoped
public class ClienteMB implements Serializable {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CustomLazyDataModel<Cliente, Long, ClienteRepository> clienteLazyDataModel;

    private Cliente cliente;
    private String documentoMask = "999999999-99";
    private Setor selectedSetor;
    private Contato selectedContato;
    private Viagem selectedViagem;
    private List<Contato> selectedContatos;
    private List<Setor> selectedSetores;
    private List<Viagem> selectedViagens;
    private boolean viewOnly;

    @PostConstruct
    public void init() {
        log.info("Chamado método Construtor");
        if (isNull(cliente)) {
            novo();
        }
    }

    public void novo() {
        cliente = new Cliente();
        cliente.setUf("RS");
        cliente.setCentral(new Central());
        cliente.getCentral().setCodificador(new Codificador());
        viewOnly = false;
    }

    public void salvar() {
        cliente = clienteService.salvar(cliente);
    }

    public void changeMask() {
        if (nonNull(cliente.getNatureza()) && cliente.getNatureza().equals(NaturezaEnum.FISICA)) {
            documentoMask = "999999999-99";
        } else {
            documentoMask = "99.999.999/9999-99";
        }
    }

    // ------------------------------------------------------
    // CONTATOS
    // ------------------------------------------------------

    public void adicionarNovoContato() {
        if (isNull(cliente.getContatos())) {
            cliente.setContatos(new ArrayList<>());
        }
        selectedContato = new Contato();
    }

    public void salvarContato() {
        cliente.getContatos().add(selectedContato);
        PrimeFaces.current().executeScript("PF('cadastrarContatoDialog').hide()");
    }

    public String getDeleteContatoButtonMessage() {
        if (hasSelectedContatos()) {
            int size = this.selectedContatos.size();
            return size > 1 ? size + " contatos selecionados" : "1 contato selecionado";
        }
        return "Excluir";
    }

    public boolean hasSelectedContatos() {
        return this.selectedContatos != null && !this.selectedContatos.isEmpty();
    }

    public void deleteSelectedContatos() {
        cliente.getContatos().removeAll(this.selectedContatos);
        this.selectedContatos = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contato excluído com sucesso"));
    }

    // ------------------------------------------------------
    // SETORES
    // ------------------------------------------------------

    public void adicionarNovoSetor() {
        if (isNull(cliente.getCentral().getSetores())) {
            cliente.getCentral().setSetores(new ArrayList<>());
        }
        selectedSetor = new Setor();
    }

    public void salvarSetor() {
        cliente.getCentral().getSetores().add(selectedSetor);
        PrimeFaces.current().executeScript("PF('cadastrarSetorDialog').hide()");
    }

    public String getDeleteSetorButtonMessage() {
        if (hasSelectedSetores()) {
            int size = this.selectedSetores.size();
            return size > 1 ? size + " setores selecionados" : "1 setor selecionado";
        }
        return "Excluir";
    }

    public boolean hasSelectedSetores() {
        return this.selectedSetores != null && !this.selectedSetores.isEmpty();
    }

    public void deleteSelectedSetores() {
        cliente.getCentral().getSetores().removeAll(this.selectedSetores);
        this.selectedSetores = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setor excluído com sucesso"));
    }

    // ------------------------------------------------------
    // VIAGENS
    // ------------------------------------------------------

    public void adicionarNovaViagem() {
        if (isNull(cliente.getViagens())) {
            cliente.setViagens(new ArrayList<>());
        }
        selectedViagem = new Viagem();
    }

    public void salvarViagem() {
        cliente.getViagens().add(selectedViagem);
        PrimeFaces.current().executeScript("PF('cadastrarViagemDialog').hide()");
    }

    public String getDeleteViagemButtonMessage() {
        if (hasSelectedViagens()) {
            int size = this.selectedViagens.size();
            return size > 1 ? size + " viagens selecionadas" : "1 viagem selecionada";
        }
        return "Excluir";
    }

    public boolean hasSelectedViagens() {
        return this.selectedViagens != null && !this.selectedViagens.isEmpty();
    }

    public void deleteSelectedViagens() {
        cliente.getViagens().removeAll(this.selectedViagens);
        this.selectedViagens = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Viagem excluída com sucesso"));
    }

}