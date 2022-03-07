package com.example.log.api.model.Output;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.example.log.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaOutput {
	
	private Long id;
	private ClienteOutput cliente;
	private DestinatarioOutput destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
