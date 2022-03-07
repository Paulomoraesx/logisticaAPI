package com.example.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.log.api.mapper.EntregaMapper;
import com.example.log.api.model.Input.EntregaInput;
import com.example.log.api.model.Output.EntregaOutput;
import com.example.log.domain.model.Entrega;
import com.example.log.domain.repository.EntregaRepository;
import com.example.log.domain.service.FinalizacaoEntregaService;
import com.example.log.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	private EntregaMapper entregaMapper;
	

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public EntregaOutput criar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		return entregaMapper.toModel(entregaSolicitada);
	}

	@GetMapping
	public List<EntregaOutput> listar(){
		return entregaMapper.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaOutput> buscar(@PathVariable Long entregaId){
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
}
