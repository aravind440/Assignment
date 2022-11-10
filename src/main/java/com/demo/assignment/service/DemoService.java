package com.demo.assignment.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.assignment.dto.EntitiesDTO;
import com.demo.assignment.dto.EntitiesToCasesDTO;
import com.demo.assignment.dtoconverter.EntitiesDTOConverter;
import com.demo.assignment.dtoconverter.EntitiesToCasesDTOConverter;
import com.demo.assignment.model.Entities;
import com.demo.assignment.model.EntitiesToCases;
import com.demo.assignment.repository.CaseRepository;
import com.demo.assignment.repository.EntityCaseRepository;
import com.demo.assignment.repository.EntityRepository;

@Service
public class DemoService {

	@Autowired
	EntityRepository entityRepository;

	@Autowired
	CaseRepository caseRepository;

	@Autowired
	EntityCaseRepository entityCaseRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	EntitiesDTOConverter entitiesDTOConverter;

	@Autowired
	EntitiesToCasesDTOConverter entitiesToCasesDTOConverter;

	public EntitiesDTO saveOrUpdate(EntitiesDTO entitiesDTO) {
		Entities entities = entitiesDTOConverter.convertDtoToEntity(entitiesDTO);
		entities = entityRepository.save(entities);
		return entitiesDTOConverter.convertEntityToDto(entities);
	}

	public EntitiesToCasesDTO modifyRelation(EntitiesToCasesDTO entitiesToCasesDTO) {
		EntitiesToCases entitiesToCases = entitiesToCasesDTOConverter.convertDtoToEntity(entitiesToCasesDTO);
		entitiesToCases = entityCaseRepository.save(entitiesToCases);
		return entitiesToCasesDTOConverter.convertEntityToDto(entitiesToCases);

	}

	public List<EntitiesToCases> getEntityforCaseNumber(String caseNumber) {
		return entityCaseRepository.findByCaseNumber(caseNumber);
	}

}
