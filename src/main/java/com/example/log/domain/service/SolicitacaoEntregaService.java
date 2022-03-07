package com.example.log.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.log.domain.model.Cliente;
import com.example.log.domain.model.Entrega;
import com.example.log.domain.model.StatusEntrega;
import com.example.log.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private CatalogoClienteService clienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);	
	}

}
