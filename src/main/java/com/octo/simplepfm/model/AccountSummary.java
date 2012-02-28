package com.octo.simplepfm.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountSummary implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long account;
	
	private String label;
	
	private BigDecimal amount;

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
