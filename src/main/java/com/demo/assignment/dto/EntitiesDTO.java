package com.demo.assignment.dto;

import java.sql.Timestamp;

public class EntitiesDTO {

	private int id;
	private String name;
	private String address;
	private String email;
	private String companyName;
	private boolean isCompany;
	private Timestamp createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean isCompany() {
		return isCompany;
	}

	public void setCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public EntitiesDTO(int id, String name, String address, String email, String companyName, boolean isCompany,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.companyName = companyName;
		this.isCompany = isCompany;
		this.createdAt = createdAt;
	}

	public EntitiesDTO() {
		super();
	}

}
