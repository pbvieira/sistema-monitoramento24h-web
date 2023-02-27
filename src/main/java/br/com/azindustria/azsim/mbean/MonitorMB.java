package br.com.azindustria.azsim.mbean;

import br.com.azindustria.azsim.controller.monitor.EventoBuffer;
import br.com.azindustria.azsim.entity.Cliente;
import br.com.azindustria.azsim.entity.Evento;
import br.com.azindustria.azsim.service.ClienteService;
import br.com.azindustria.azsim.service.EventoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Data
@Component(value = "monitorMB")
@ViewScoped
public class MonitorMB implements Serializable {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EventoBuffer eventoBuffer;

    private List<SortMeta> sortBy;

    private Long idClienteSelecionado;

    private Integer codificadorSelecionado;


    @PostConstruct
    public void init() {
        sortBy = new ArrayList<>();
        sortBy.add(SortMeta.builder()
                .field("dataevento")
                .order(SortOrder.DESCENDING)
                .build());

        List<Evento> eventos = eventoService.findFirst250ByOrderByDataeventoDesc();
        if (!eventos.isEmpty()) {
            eventoBuffer.setEventos(eventos);
        }
    }

    public List<Cliente> buscarClienteParaVincularCodificador(String nome) {
        return clienteService.findByNomeContainingIgnoreCaseOrNomeFantasiaContainingIgnoreCase(nome, nome);
    }

    public void vincularCodificadorAoCliente() {
        try {
            Optional<Cliente> cliente = clienteService.findByCentralCodificadorNumero(codificadorSelecionado);
            if (cliente.isPresent()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        String.format("Codificador %s já está vinculado ao cliente %s", codificadorSelecionado, cliente.get().getNome()), null));
            } else {
                clienteService.vincularCodificadorAoCliente(idClienteSelecionado, codificadorSelecionado);
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Ocorreu um erro inesperado, necessário informar o suporte: (", e.getMessage() + " )"));
            log.error(e.getMessage());
        }

        idClienteSelecionado = null;
        codificadorSelecionado = null;
    }

    public void selecionarCodificarParaVinculoAoCliente(Integer codificadorSelecionado) {
        this.codificadorSelecionado = codificadorSelecionado;
    }
}