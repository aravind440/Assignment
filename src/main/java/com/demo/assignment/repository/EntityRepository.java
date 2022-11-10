package com.demo.assignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.assignment.model.Entities;

public interface EntityRepository extends CrudRepository<Entities, Integer> {

}
