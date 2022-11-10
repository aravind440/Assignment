package com.demo.assignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.assignment.model.Cases;

public interface CaseRepository extends CrudRepository<Cases, Integer> {

}
