package com.octo.simplepfm.model;

public class Account {
	private Long id;
	
	private Long customer;

	private String label;
	
	private String currency;
	
	private String type;
	
	private String[] iban;
	
	private String bic;

	
	public Account() {
	}

	protected String getResourceType() {
		return "account";
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setIban(String[] iban) {
		this.iban = iban;
	}

	public String[] getIban() {
		return iban;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBic() {
		return bic;
	}
	
	
}
