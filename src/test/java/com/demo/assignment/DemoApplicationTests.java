package com.demo.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.assignment.dto.EntitiesDTO;
import com.demo.assignment.dto.EntitiesToCasesDTO;
import com.demo.assignment.dtoconverter.EntitiesDTOConverter;
import com.demo.assignment.dtoconverter.EntitiesToCasesDTOConverter;
import com.demo.assignment.model.Entities;
import com.demo.assignment.model.EntitiesToCases;
import com.demo.assignment.repository.EntityCaseRepository;
import com.demo.assignment.repository.EntityRepository;
import com.demo.assignment.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private DemoService service;

	@MockBean
	private EntityCaseRepository entityCaseRepository;

	@MockBean
	private EntityRepository entityRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	EntitiesDTOConverter entitiesDTOConverter;

	@Autowired
	EntitiesToCasesDTOConverter entitiesToCasesDTOConverter;

	// Test method to match the unique id for @PostMapping("/entities")
	@Test
	public void saveEntityTest() {

		// getting the system date
		Date date = new Date();
		// Converting Date to Timestamp
		Timestamp ts = new Timestamp(date.getTime());

		EntitiesDTO entitydto = new EntitiesDTO(125, "Aravind", "Hyderabad", "aravind@infosys.com", "infosys", true,
				ts);
		when(entityRepository.save(any(Entities.class))).thenReturn(entitiesDTOConverter.convertDtoToEntity(entitydto));
		assertEquals(125, service.saveOrUpdate(entitydto).getId());
	}

	// Test method to match the unique id for
	// @PostMapping("/cases/{caseNumber}/entities")
	@Test
	public void modifyRelationTest() {
		EntitiesToCasesDTO entitytoCasesDTO = new EntitiesToCasesDTO(1, "ZA-2022-2487-ZAD-SPP-HCA", "ABC");
		when(entityCaseRepository.save(any(EntitiesToCases.class)))
				.thenReturn(entitiesToCasesDTOConverter.convertDtoToEntity(entitytoCasesDTO));
		assertEquals(1, service.modifyRelation(entitytoCasesDTO).getId());
	}

	// Test method to match the count for
	// @GetMapping("/cases/{case_number}/entities")
	@Test
	public void getEntityTest() {
		String caseNumber = "123";
		when(entityCaseRepository.findByCaseNumber(caseNumber))
				.thenReturn(Stream
						.of(new EntitiesToCases(1, "ZA-2022-2362-CUB", "ABC"),
								new EntitiesToCases(2, "ZA-2022-2487-ZAD-SPP-HCA", "XYZ"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getEntityforCaseNumber(caseNumber).size());
	}
}
