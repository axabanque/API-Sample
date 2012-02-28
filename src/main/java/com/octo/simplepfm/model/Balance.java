package com.octo.simplepfm.model;

import java.math.BigDecimal;
import java.util.Date;

public class Balance {
	
	private Long id;

	private BigDecimal amount;
	private Date date;
	
	private String currency;

	private Long account;

	public Balance() {
	}

	public Balance(BigDecimal value, Date date, Long account) {
		this.amount = value;
		this.date = date;
		this.account = account;
	}

	protected String getResourceType() {
		return "balance";
	}	

	public void setPublicId(Long id) {
		// publicId mapped to Id
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	


	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
