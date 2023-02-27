package br.com.azindustria.azsim.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoDto {

    private Integer ctx;

    private String tipoctx;

    private Integer portacom;

    private Long nrevento;

    private Integer equipamento;

    private String status;

    private String referencia;

    private Integer identificacao;

    private Date dataevento;

}