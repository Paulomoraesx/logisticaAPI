package com.example.log.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.log.api.model.Input.EntregaInput;
import com.example.log.api.model.Output.EntregaOutput;
import com.example.log.domain.model.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {
	
	private ModelMapper modelMapper;
	
	public EntregaOutput toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaOutput.class);
	}
	
	public List<EntregaOutput> toCollectionModel (List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}

}
