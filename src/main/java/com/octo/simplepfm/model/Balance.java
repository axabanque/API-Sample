package com.octo.simplepfm.model;

import java.math.BigDecimal;
import java.util.Date;

public class Balance {
	
	private Long id;

	private BigDecimal value;
	private Date date;

	private Account account;

	public Balance() {
	}

	public Balance(BigDecimal value, Date date, Account account) {
		this.value = value;
		this.date = date;
		this.account = account;
	}

	protected String getResourceType() {
		return "balance";
	}	

	public void setPublicId(Long id) {
		// publicId mapped to Id
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getCurrency() {
		return account.getCurrency();
	}	

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
