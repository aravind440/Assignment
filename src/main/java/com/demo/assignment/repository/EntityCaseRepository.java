package com.demo.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.assignment.model.EntitiesToCases;

public interface EntityCaseRepository extends JpaRepository<EntitiesToCases, String> {
	List<EntitiesToCases> findByCaseNumber(String caseNumber);
}
