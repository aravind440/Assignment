package com.demo.assignment.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTITIES")
public class Entities {

	@Id
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String address;

	@Column
	private String email;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "is_company")
	private boolean isCompany;

	@Column(name = "created_at")
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

	public boolean isIsCompany() {
		return isCompany;
	}

	public void setIsCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Entities() {
		super();
	}

	public Entities(int id, String name, String address, String email, String companyName, boolean isCompany,
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

}
