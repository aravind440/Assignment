package com.demo.assignment.dtoconverter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.assignment.dto.EntitiesDTO;
import com.demo.assignment.model.Entities;

@Component
public class EntitiesDTOConverter {

	public EntitiesDTO convertEntityToDto(Entities entities) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entities, EntitiesDTO.class);
	}

	public Entities convertDtoToEntity(EntitiesDTO entitiesDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entitiesDTO, Entities.class);
	}
}
