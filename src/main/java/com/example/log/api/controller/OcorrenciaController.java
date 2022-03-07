package com.example.log.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.log.api.mapper.OcorrenciaMapper;
import com.example.log.api.model.Input.OcorrenciaInput;
import com.example.log.api.model.Output.OcorrenciaOutput;
import com.example.log.domain.model.Entrega;
import com.example.log.domain.model.Ocorrencia;
import com.example.log.domain.service.BuscaEntregaService;
import com.example.log.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private BuscaEntregaService buscaEntregaService;
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaMapper ocorrenciaMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaOutput registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaOutput> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
	}
	
	

}
