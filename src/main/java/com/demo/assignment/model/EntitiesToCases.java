package com.demo.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTITIES_TO_CASES")
public class EntitiesToCases {

	@Id
	@Column
	private int id;

	@Column(name = "case_number")
	private String caseNumber;

	@Column(name = "entity_id")
	private String entityId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public EntitiesToCases() {
		super();
	}

	public EntitiesToCases(int id, String caseNumber, String entityId) {
		super();
		this.id = id;
		this.caseNumber = caseNumber;
		this.entityId = entityId;
	}
}
