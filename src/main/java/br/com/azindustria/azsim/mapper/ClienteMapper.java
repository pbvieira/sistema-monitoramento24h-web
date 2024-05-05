package br.com.azindustria.azsim.mapper;

import br.com.azindustria.azsim.adapter.repository.model.ClienteDocument;
import br.com.azindustria.azsim.adapter.web.valueobject.ClienteVO;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDocument toClienteDocument(Cliente cliente);

    Cliente toCliente(ClienteDocument clienteDocument);

    Cliente toCliente(ClienteVO clienteVO);

    ClienteVO toClienteVO(Cliente cliente);

    List<ClienteVO> toClienteVOList(List<Cliente> clientes);
}
