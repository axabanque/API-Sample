package com.octo.simplepfm.model;

import java.io.Serializable;

/**
 * Exposes a summary view of the enclosing AccountEntity instance.
 */
public class AccountSummary implements Serializable {
	
	private Long account;
	
	private String label;

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
	
	
	
}
