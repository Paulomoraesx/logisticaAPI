package com.example.log.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.log.api.model.Output.OcorrenciaOutput;
import com.example.log.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
	
	private ModelMapper modelMapper;
	
	public OcorrenciaOutput toModel (Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaOutput.class);
	}
	public List<OcorrenciaOutput> toCollectionModel(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	

}
