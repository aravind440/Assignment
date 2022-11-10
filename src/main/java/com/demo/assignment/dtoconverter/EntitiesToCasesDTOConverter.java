package com.demo.assignment.dtoconverter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demo.assignment.dto.EntitiesToCasesDTO;
import com.demo.assignment.model.EntitiesToCases;

@Component
public class EntitiesToCasesDTOConverter {

	public EntitiesToCasesDTO convertEntityToDto(EntitiesToCases entitiesToCases) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entitiesToCases, EntitiesToCasesDTO.class);
	}

	public EntitiesToCases convertDtoToEntity(EntitiesToCasesDTO entitiesToCasesDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(entitiesToCasesDTO, EntitiesToCases.class);
	}
}
