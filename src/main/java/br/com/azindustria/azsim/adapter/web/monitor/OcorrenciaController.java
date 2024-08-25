package br.com.azindustria.azsim.adapter.web.monitor;

import br.com.azindustria.azsim.adapter.web.valueobject.OcorrenciaVO;
import br.com.azindustria.azsim.core.domain.monitoramento.model.Ocorrencia;
import br.com.azindustria.azsim.core.port.in.OcorrenciaPort;
import br.com.azindustria.azsim.mapper.OcorrenciaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    private final OcorrenciaPort ocorrenciaPort;

    public OcorrenciaController(OcorrenciaPort ocorrenciaPort) {
        this.ocorrenciaPort = ocorrenciaPort;
    }

    @PostMapping
    ResponseEntity<OcorrenciaVO> salvar(@Validated @RequestBody OcorrenciaVO ocorrenciaRequest) {
        Ocorrencia ocorrencia = ocorrenciaPort.save(OcorrenciaMapper.INSTANCE.toOcorrencia(ocorrenciaRequest));
        OcorrenciaVO ocorrenciaResponse = OcorrenciaMapper.INSTANCE.toOcorrenciaVO(ocorrencia);
        return new ResponseEntity<>(ocorrenciaResponse, HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<OcorrenciaVO> buscarPorId(@PathVariable String id) {
        OcorrenciaVO ocorrenciaVO = OcorrenciaMapper.INSTANCE.toOcorrenciaVO(ocorrenciaPort.findById(id));
        if (isNull(ocorrenciaVO)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ocorrenciaVO, HttpStatus.OK);
    }
}
