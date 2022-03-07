package com.example.log.api.model.Output;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaOutput {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;

}