package br.com.azindustria.azsim.adapter.web.cliente;

import br.com.azindustria.azsim.adapter.web.valueobject.ClienteVO;
import br.com.azindustria.azsim.core.domain.cliente.model.Cliente;
import br.com.azindustria.azsim.core.port.in.GestaoClientePort;
import br.com.azindustria.azsim.mapper.ClienteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173")
@RequestMapping("/cliente")
public class ClienteController {

    private final GestaoClientePort gestaoClientePort;

    public ClienteController(GestaoClientePort gestaoClientePort) {
        this.gestaoClientePort = gestaoClientePort;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping
    ResponseEntity<List<ClienteVO>> listar() {
        List<ClienteVO> clienteVOS = toClienteRequestList(gestaoClientePort.findAll());
        if (CollectionUtils.isEmpty(clienteVOS)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteVOS, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @GetMapping(params = {"nome"})
    ResponseEntity<List<ClienteVO>> buscarPorNome(@RequestParam String nome) {
        List<ClienteVO> clienteVOS = toClienteRequestList(gestaoClientePort.findByNomeOrNomeFantasia(nome));
        if (CollectionUtils.isEmpty(clienteVOS)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteVOS, HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<ClienteVO> buscarPorId(@PathVariable String id) {
        ClienteVO clienteVO = ClienteMapper.INSTANCE.toClienteVO(gestaoClientePort.findById(id));
        if (isNull(clienteVO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteVO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ClienteVO> salvar(@Validated @RequestBody ClienteVO clienteVO) {
        Cliente cliente = gestaoClientePort.save(ClienteMapper.INSTANCE.toCliente(clienteVO));
        return new ResponseEntity<>(ClienteMapper.INSTANCE.toClienteVO(cliente), HttpStatus.OK);
    }

    private List<ClienteVO> toClienteRequestList(List<Cliente> clientes) {
        return clientes.stream().map(ClienteMapper.INSTANCE::toClienteVO).collect(Collectors.toList());
    }

    @PutMapping("/{id}/desativar")
    public ResponseEntity<Void> desativarCliente(@PathVariable String id) {
        Cliente clienteExistente = gestaoClientePort.findById(id);

        if (clienteExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clienteExistente.setAtivo(false);

        Cliente clienteDesativado = gestaoClientePort.save(clienteExistente);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    ResponseEntity<ClienteVO> atualizar(@PathVariable String id, @Validated @RequestBody ClienteVO clienteVO) {
        Cliente clienteExistente = gestaoClientePort.findById(id);

        if (clienteExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clienteExistente.setUnidade(clienteVO.getUnidade());
        clienteExistente.setCodificador(clienteVO.getCodificador());
        clienteExistente.setCodHabil(clienteVO.getCodHabil());
        clienteExistente.setCodCondor(clienteVO.getCodCondor());
        clienteExistente.setNatureza(clienteVO.getNatureza());
        clienteExistente.setDocumento(clienteVO.getDocumento());
        clienteExistente.setInscMunicipal(clienteVO.getInscMunicipal());
        clienteExistente.setNome(clienteVO.getNome());
        clienteExistente.setNomeFantasia(clienteVO.getNomeFantasia());
        clienteExistente.setEndereco(clienteVO.getEndereco());
        clienteExistente.setBairro(clienteVO.getBairro());
        clienteExistente.setCidade(clienteVO.getCidade());
        clienteExistente.setUf(clienteVO.getUf());
        clienteExistente.setCep(clienteVO.getCep());
        clienteExistente.setObservacao(clienteVO.getObservacao());
        clienteExistente.setContatos(clienteVO.getContatos());
        clienteExistente.setSetores(clienteVO.getSetores());
        clienteExistente.setViagens(clienteVO.getViagens());


        Cliente clienteAtualizado = gestaoClientePort.save(clienteExistente);
        return new ResponseEntity<>(ClienteMapper.INSTANCE.toClienteVO(clienteAtualizado), HttpStatus.OK);
    }

}