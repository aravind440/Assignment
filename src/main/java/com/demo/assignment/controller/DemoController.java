package com.demo.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.assignment.dto.EntitiesDTO;
import com.demo.assignment.dto.EntitiesToCasesDTO;
import com.demo.assignment.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	DemoService demoService;

	// API to save the input data in ENTITIES table
	@PostMapping("/entities")
	public ResponseEntity<EntitiesDTO> saveEntity(@RequestBody EntitiesDTO entitiesDTO) {
		return new ResponseEntity<>(demoService.saveOrUpdate(entitiesDTO), HttpStatus.OK);
	}

	// API to save or update the input data in ENTITIES_TO_CASES table
	@PostMapping("/cases/{caseNumber}/entities")
	public ResponseEntity<String> modifyRelation(@RequestBody EntitiesToCasesDTO entitiesToCasesDTO,
			@PathVariable(value = "caseNumber") String caseNumber) {
		// Here not clear on using caseNumber in url, so adding some
		// validation to match url value and body value
		if (caseNumber.equals(entitiesToCasesDTO.getCaseNumber())) {
			demoService.modifyRelation(entitiesToCasesDTO);
			return new ResponseEntity<>(entitiesToCasesDTO.getCaseNumber(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("CaseNumber is not Matching", HttpStatus.BAD_REQUEST);
		}
	}

	// API to get the entity details based on input casenumber
	@GetMapping("/cases/{case_number}/entities")
	public ResponseEntity<Object> getEntityforCaseNumber(@PathVariable(value = "case_number") String caseNumber) {
		if (!demoService.getEntityforCaseNumber(caseNumber).isEmpty()) {
			return new ResponseEntity<>(demoService.getEntityforCaseNumber(caseNumber), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
}
