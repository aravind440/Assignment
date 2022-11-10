package com.demo.assignment.dto;

public class EntitiesToCasesDTO {

	private int id;
	private String caseNumber;
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

	public EntitiesToCasesDTO(int id, String caseNumber, String entityId) {
		super();
		this.id = id;
		this.caseNumber = caseNumber;
		this.entityId = entityId;
	}

	public EntitiesToCasesDTO() {
		super();
	}

}
