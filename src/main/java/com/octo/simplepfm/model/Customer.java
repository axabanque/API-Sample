package com.octo.simplepfm.model;

import java.util.List;


public class Customer {

	/** technical unique identifier for the resource */
	private Long id;

	private Long publicId;
	
	private String lastName;
	
	private String firstName;

	private List<AccountSummary> accounts;

	public Customer() {
	}

	protected String getResourceType() {
		return "customer";
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getPublicId() {
		return publicId;
	}

	public void setPublicId(Long id) {
		this.publicId = id;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public List<AccountSummary> getAccountSummaries() {
		return accounts;
	}
	
	public void setAccounts(List<AccountSummary> accounts) {
		this.accounts = accounts;
	}

	public String getLastName() {
		return lastName;
	}

	public List<AccountSummary> getAccounts() {
		return accounts;
	}
	
	
}
