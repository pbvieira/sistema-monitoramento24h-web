package br.com.azindustria.azsim.domain.cliente.view;

import br.com.azindustria.azsim.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.domain.monitor.model.Monitoramento;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ClienteMapper {

    public Cliente fromDto(ClienteViewModel clienteViewModel) {
        Cliente cliente = new Cliente(
                clienteViewModel.getId(),
                clienteViewModel.getUnidade(),
                clienteViewModel.getHabil(),
                clienteViewModel.getCondor(),
                clienteViewModel.getNatureza(),
                clienteViewModel.getDocumento(),
                clienteViewModel.getInscMunicipal(),
                clienteViewModel.getNome(),
                clienteViewModel.getNomeFantasia(),
                clienteViewModel.getEndereco(),
                clienteViewModel.getBairro(),
                clienteViewModel.getCidade(),
                clienteViewModel.getUf(),
                clienteViewModel.getCep(),
                clienteViewModel.getObservacao(),
                null,
                null
        );

        cliente.setMonitoramentos(Collections.singletonList(
                new Monitoramento(
                        clienteViewModel.getMonitoramentoId(),
                        cliente,
                        clienteViewModel.getMonitoramentoCodificador(),
                        clienteViewModel.getMonitoramentoModeloCentral(),
                        clienteViewModel.getMonitoramentoEndereco(),
                        clienteViewModel.getMonitoramentoBairro(),
                        clienteViewModel.getMonitoramentoCidade(),
                        clienteViewModel.getMonitoramentoUf(),
                        clienteViewModel.getMonitoramentoCep(),
                        clienteViewModel.getMonitoramentoObservacao()
                )
        ));

        return cliente;

    }

    public ClienteViewModel fromEntity(Cliente cliente) {
        return new ClienteViewModel(
                cliente.getId(),
                cliente.getUnidade(),
                cliente.getHabil(),
                cliente.getCondor(),
                cliente.getNatureza(),
                cliente.getDocumento(),
                cliente.getInscMunicipal(),
                cliente.getNome(),
                cliente.getNomeFantasia(),
                cliente.getEndereco(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getUf(),
                cliente.getCep(),
                cliente.getObservacao(),
                cliente.getMonitoramentos().get(0).getId(),
                cliente.getMonitoramentos().get(0).getCodificador(),
                cliente.getMonitoramentos().get(0).getModeloCentral(),
                cliente.getMonitoramentos().get(0).getEndereco(),
                cliente.getMonitoramentos().get(0).getBairro(),
                cliente.getMonitoramentos().get(0).getCidade(),
                cliente.getMonitoramentos().get(0).getCep(),
                cliente.getMonitoramentos().get(0).getUf(),
                cliente.getMonitoramentos().get(0).getObservacao()
        );
    }
}
